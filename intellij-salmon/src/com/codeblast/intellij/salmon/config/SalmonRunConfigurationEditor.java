package com.codeblast.intellij.salmon.config;

import com.intellij.execution.configuration.EnvironmentVariablesTextFieldWithBrowseButton;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SalmonRunConfigurationEditor extends SettingsEditor<SalmonRunConfiguration> {

    @NotNull
    private final JComponent rootComponent;

    public SalmonRunConfigurationEditor(@NotNull Project project) {
        JBTextField text = new JBTextField();
        text.getEmptyText().setText("Sample text");
        rootComponent = new FormBuilder()
                .setAlignLabelOnRight(false)
                .addLabeledComponent("HELLO!!", text)
                .addComponent(new JSeparator(), 8)
                .addLabeledComponent("Bla bla", new EnvironmentVariablesTextFieldWithBrowseButton())
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(SalmonRunConfiguration salmonRunConfiguration) {

    }

    @Override
    protected void applyEditorTo(SalmonRunConfiguration salmonRunConfiguration) throws ConfigurationException {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return rootComponent;
    }
}
