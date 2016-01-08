package com.codeblast.plugin1;

import com.intellij.openapi.components.*;
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemLocalSettings;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "FooLocalSettings", storages = {@Storage(file = StoragePathMacros.WORKSPACE_FILE)})
public class FooLocalSettings extends AbstractExternalSystemLocalSettings
        implements PersistentStateComponent<AbstractExternalSystemLocalSettings.State> {

    public FooLocalSettings(@NotNull Project project) {
        super(FooConstants.SYSTEM_ID, project);
    }

    @Nullable
    @Override
    public State getState() {
        final State state = new State();
        fillState(state);
        return state;
    }

    @NotNull
    public static FooLocalSettings getInstance(Project project) {
        return ServiceManager.getService(project, FooLocalSettings.class);
    }
}
