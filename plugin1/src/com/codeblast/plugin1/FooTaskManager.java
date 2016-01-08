package com.codeblast.plugin1;

import com.intellij.openapi.externalSystem.model.ExternalSystemException;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener;
import com.intellij.openapi.externalSystem.task.AbstractExternalSystemTaskManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FooTaskManager extends AbstractExternalSystemTaskManager<FooExecutionSettings> {
    @Override
    public void executeTasks(@NotNull ExternalSystemTaskId externalSystemTaskId, @NotNull List<String> tasks,
                             @NotNull String path, @Nullable FooExecutionSettings settings,
                             @NotNull List<String> options, @NotNull List<String> args,
                             @Nullable String debug,
                             @NotNull ExternalSystemTaskNotificationListener externalSystemTaskNotificationListener)
            throws ExternalSystemException {
        externalSystemTaskNotificationListener.onTaskOutput(externalSystemTaskId, "executeTasks", true);
        // TODO: more steps needed here...
    }

    @Override
    public boolean cancelTask(@NotNull ExternalSystemTaskId externalSystemTaskId,
                              @NotNull ExternalSystemTaskNotificationListener externalSystemTaskNotificationListener)
            throws ExternalSystemException {
        externalSystemTaskNotificationListener.onTaskOutput(externalSystemTaskId, "cancelTask.", true);
        return false;
    }
}
