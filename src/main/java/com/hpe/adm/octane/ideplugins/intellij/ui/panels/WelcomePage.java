package com.hpe.adm.octane.ideplugins.intellij.ui.panels;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by savencu on 11/10/2016.
 */
public class WelcomePage implements ToolWindowFactory{
    private ToolWindow welcomeRootWindow;
    private JPanel welcomeRootPanel;
    private JLabel welcomeScreeMessage;
    private JLabel octaneLogo;
    private JLabel hpeLogo;
    private JLabel settingsLink;

    private void createUIComponents() {
        Icon hpeIcon = IconLoader.findIcon("/images/hpeLogo.png");
        hpeLogo.setIcon(hpeIcon);
        hpeLogo.setText("");

        welcomeScreeMessage.setText("Welcome to ALM Octane plugin");
        settingsLink.setText("Before you start please go to settings and connect to Octane");
        octaneLogo.setIcon(IconLoader.findIcon("/images/alm-octane-logo.png"));
        octaneLogo.setText("");
        octaneLogo.setSize(120,30);

    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        welcomeRootWindow = toolWindow;
        this.createUIComponents();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(welcomeRootPanel, "", false);
        welcomeRootWindow.getContentManager().addContent(content);
    }
}
