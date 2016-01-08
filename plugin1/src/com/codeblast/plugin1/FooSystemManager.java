package com.codeblast.plugin1;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.SimpleJavaParameters;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.externalSystem.ExternalSystemManager;
import com.intellij.openapi.externalSystem.model.ProjectSystemId;
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver;
import com.intellij.openapi.externalSystem.task.ExternalSystemTaskManager;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Function;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.List;

public class FooSystemManager implements ExternalSystemManager<
        FooProjectSettings,
        FooSettingsListener,
        FooSettings,
        FooLocalSettings,
        FooExecutionSettings> {
    private static final Logger LOG = Logger.getInstance(FooSystemManager.class);

    @NotNull
    @Override
    public ProjectSystemId getSystemId() {
        return FooConstants.SYSTEM_ID;
    }

    @NotNull
    @Override
    public Function<Project, FooSettings> getSettingsProvider() {
        return new Function<Project, FooSettings>() {
            @Override
            public FooSettings fun(Project project) {
                LOG.info("getSettingsProvider.fun()");
                return FooSettings.getInstance(project);
            }
        };
    }

    @NotNull
    @Override
    public Function<Project, FooLocalSettings> getLocalSettingsProvider() {
        return new Function<Project, FooLocalSettings>() {
            @Override
            public FooLocalSettings fun(Project project) {
                LOG.info("getLocalSettingsProvider.fun()");
                return FooLocalSettings.getInstance(project);
            }
        };
    }

    @NotNull
    @Override
    public Function<Pair<Project, String>, FooExecutionSettings> getExecutionSettingsProvider() {
        return new Function<Pair<Project, String>, FooExecutionSettings>() {
            @Override
            public FooExecutionSettings fun(Pair<Project, String> projectStringPair) {
                LOG.info("getExecutionSettingsProvider.fun()");
                final Project project = projectStringPair.getFirst();
                final String path = projectStringPair.getSecond();
                return new FooExecutionSettings();
            }
        };
    }

    @NotNull
    @Override
    public Class<? extends ExternalSystemProjectResolver<FooExecutionSettings>> getProjectResolverClass() {
        return FooSystemProjectResolver.class;
    }

    @Override
    public Class<? extends ExternalSystemTaskManager<FooExecutionSettings>> getTaskManagerClass() {
        return FooTaskManager.class;
    }

    @NotNull
    @Override
    public FileChooserDescriptor getExternalProjectDescriptor() {
        return new FileChooserDescriptor(true, true, false, false, false, false) {
            @Override
            public boolean isFileSelectable(VirtualFile file) {
                return true;
            }
        };
    }

    @Override
    public void enhanceRemoteProcessing(@NotNull SimpleJavaParameters simpleJavaParameters) throws ExecutionException {

    }

    @Override
    public void enhanceLocalProcessing(@NotNull List<URL> list) {

    }
}
