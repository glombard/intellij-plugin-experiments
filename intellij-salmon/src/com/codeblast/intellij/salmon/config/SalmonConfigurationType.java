package com.codeblast.intellij.salmon.config;

import com.codeblast.intellij.salmon.icons.SalmonIcons;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class SalmonConfigurationType extends ConfigurationTypeBase {
    protected SalmonConfigurationType() {
        super("SalmonTestResultsReporter", "Salmon", "Salmon Test Results Reporter", SalmonIcons.SALMON_ICON);
        addFactory(new MyConfigurationFactory(this));
    }

    private static class MyConfigurationFactory extends ConfigurationFactory {
        protected MyConfigurationFactory(@NotNull ConfigurationType type) {
            super(type);
        }

        @NotNull
        @Override
        public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
            return new SalmonRunConfiguration(project, this, "Salmon");
        }

        @Override
        public boolean isConfigurationSingletonByDefault() {
            return true;
        }

        @Override
        public boolean canConfigurationBeSingleton() {
            return false;
        }
    }
}
