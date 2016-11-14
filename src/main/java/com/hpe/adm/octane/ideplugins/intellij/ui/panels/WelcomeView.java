package com.hpe.adm.octane.ideplugins.intellij.ui.panels;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class WelcomeView implements ToolWindowFactory{

    private ToolWindow rootToolWindow;
    private JPanel rootPanel;

    private JLabel welcomeScreenMessage;
    private JLabel settingsLink;

    private void createUIComponents() {
        welcomeScreenMessage.setText("Welcome to ALM Octane plugin");
        settingsLink.setText("Before you start please go to settings and connect to Octane");
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        rootToolWindow = toolWindow;
        this.createUIComponents();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(rootPanel, "", false);
        rootToolWindow.getContentManager().addContent(content);
    }
}
