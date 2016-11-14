package com.hpe.adm.octane.ideplugins.intellij.ui.panels;

import javax.swing.*;

public class ConnectionSettingsView {

    private JPanel rootPanel;

    private JLabel lblServerUrl;
    private JTextField txtFieldServerUrl;

    private JLabel lblWorkspace;

    private JLabel lblUserName;
    private JTextField txtFieldUserName;

    private JLabel lblPassword;
    private JPasswordField passField;

    private JButton btnTest;
    private JTextField txtFieldWorkspace;

    public JPanel getRootPanel(){
        return rootPanel;
    }

    public boolean isPasswordModified(){
        return false;
    }

}
