package com.hpe.adm.octane.ideplugins.intellij;

import com.hpe.adm.octane.ideplugins.intellij.ui.panels.ConnectionSettingsView;
import com.hpe.adm.octane.ideplugins.services.ConnectionSettings;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jdom.Element;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ConnectionSettingsConfigurable implements SearchableConfigurable {

    public static final String NAME = "Octane";
    private ConnectionSettingsWrapper connectionSettingsWrapper;
    private Logger pluginLogger;
    private ConnectionSettingsView connectionSettingsView;
    private ConnectionSettings connectionSettings = ConnectionSettings.getInstance();

    @NotNull
    @Override
    public String getId() {
        return null;
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return NAME;
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return "settings.octane";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (connectionSettingsView == null) {
//            connectionSettingsView = PluginModuleManager.getInstance(ConnectionSettingsView.class);
            connectionSettingsView = new ConnectionSettingsView();
        }
        return connectionSettingsView.getRootPanel();
    }

    @Override
    public boolean isModified() {
//        return connectionSettingsView != null
//                && (!Comparing.equal(connectionSettings.getUserName(), connectionSettingsView.getUserName())
//                || isPasswordModified())
//                || !Comparing.equal(connectionSettings.getBaseUrl(), connectionSettingsView.getBaseUrl());
        return false;
    }

    private boolean isPasswordModified() {
        return connectionSettingsView.isPasswordModified();
    }

    @Override
    public void apply() throws ConfigurationException {

    }

    @Override
    public void reset() {

    }

    @Override
    public void disposeUIResources() {
        connectionSettingsView = null;
    }

    @State(
            name = "ConnectionSettings",
            storages = {
                    @Storage(
                            file = StoragePathMacros.APP_CONFIG + "/octane_connection_settings.xml"
                    )}
    )
    private class ConnectionSettingsWrapper implements PersistentStateComponent<Element> {
        private static final String CONNECTION_SETTINGS_TAG = "ConnectionSettings";
        private static final String URL_TAG = "Url";
        private static final String SHARED_SPACE_TAG = "SharedSpace";
        private static final String WORKSPACE_TAG = "WorkSpace";
        private static final String USER_TAG = "User";
        private static final String PASSWORD_TAG = "Password";

        @Nullable
        @Override
        public Element getState() {
            final Element element = new Element(CONNECTION_SETTINGS_TAG);

            element.setAttribute(URL_TAG, connectionSettings.getBaseUrl());
            element.setAttribute(SHARED_SPACE_TAG, String.valueOf(connectionSettings.getSharedSpaceId()));
            element.setAttribute(WORKSPACE_TAG, String.valueOf(connectionSettings.getWorkspaceId()));
            element.setAttribute(USER_TAG, connectionSettings.getUserName());
            element.setAttribute(PASSWORD_TAG, connectionSettings.getPassword());

            return element;
        }

        @Override
        public void loadState(Element state) {
            try {
                connectionSettings = ConnectionSettings.init(
                        state.getAttributeValue(URL_TAG),
                        Long.valueOf(state.getAttributeValue(SHARED_SPACE_TAG)),
                        Long.valueOf(state.getAttributeValue(WORKSPACE_TAG)),
                        state.getAttributeValue(USER_TAG),
                        state.getAttributeValue(PASSWORD_TAG));
            } catch (Exception e) {
                pluginLogger.error("Error while trying to load the connection settings");
            }
        }
    }
}
