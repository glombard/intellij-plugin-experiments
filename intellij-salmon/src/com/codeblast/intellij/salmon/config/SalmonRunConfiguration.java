package com.codeblast.intellij.salmon.config;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.LocatableConfigurationBase;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SalmonRunConfiguration extends LocatableConfigurationBase {
    private static final Logger LOG = Logger.getInstance(SalmonRunConfiguration.class);
    @NotNull
    private final Project project;

    @NotNull
    private SalmonRunSettings runSettings = SalmonRunSettings.NONE;

    protected SalmonRunConfiguration(@NotNull Project project, @NotNull ConfigurationFactory configurationFactory, @NotNull String name) {
        super(project, configurationFactory, name);
        this.project = project;
    }

    @NotNull
    @Override
    public SalmonRunConfigurationEditor getConfigurationEditor() {
        return new SalmonRunConfigurationEditor(project);
    }

    @Nullable
    @Override
    public SalmonRunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException {
        return new SalmonRunProfileState(getProject(), this, executionEnvironment);
    }
}
