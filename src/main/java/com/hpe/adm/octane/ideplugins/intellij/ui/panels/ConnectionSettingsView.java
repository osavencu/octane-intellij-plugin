package com.hpe.adm.octane.ideplugins.intellij.ui.panels;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ConnectionSettingsView {
    private JPanel panelSetting;
    private JButton testButton;
    private JTextField userName;
    private JPasswordField password;
    private JTextField serverUrl;
    private JTextField workspaceName;
    private JLabel passwordLabel;
    private JLabel userNameLabel;
    private JLabel baseUrlLabel;
    private JLabel workspaceLabel;
    private JLabel testResult;

    private boolean passwordModified;

    public ConnectionSettingsView() {
        password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                passwordModified = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                passwordModified = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                passwordModified = true;
            }
        });
    }

    public boolean isPasswordModified() {
        return passwordModified;
    }

    public JPanel getPanelSetting() {
        return panelSetting;
    }

    public JTextField getUserName() {
        return userName;
    }

    public JTextField getPassword() {
        return password;
    }

    public JTextField getBaseUrl() {
        return serverUrl;
    }

    public JTextField getWorkspaceName() {
        return workspaceName;
    }
}
