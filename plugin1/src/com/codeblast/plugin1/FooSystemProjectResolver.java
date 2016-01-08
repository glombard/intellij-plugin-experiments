package com.codeblast.plugin1;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.externalSystem.model.DataNode;
import com.intellij.openapi.externalSystem.model.ExternalSystemException;
import com.intellij.openapi.externalSystem.model.ProjectKeys;
import com.intellij.openapi.externalSystem.model.project.ProjectData;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationEvent;
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener;
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FooSystemProjectResolver implements ExternalSystemProjectResolver<FooExecutionSettings> {
    protected static final Logger LOG = Logger.getInstance(FooSystemProjectResolver.class);

    @Nullable
    @Override
    public DataNode<ProjectData> resolveProjectInfo(@NotNull ExternalSystemTaskId externalSystemTaskId,
                                                    @NotNull String path, boolean isPreviewMode,
                                                    @Nullable FooExecutionSettings settings,
                                                    @NotNull ExternalSystemTaskNotificationListener externalSystemTaskNotificationListener)
            throws ExternalSystemException, IllegalArgumentException, IllegalStateException {
        LOG.info("resolveProjectInfo");
        final ProjectData project = new ProjectData(FooConstants.SYSTEM_ID, path, "foo-path", "linked-path");
        final DataNode<ProjectData> node = new DataNode<ProjectData>(ProjectKeys.PROJECT, project, null);

        if (!isPreviewMode) {
            LOG.info("Simulating a project load problem");
            pretendToWork(externalSystemTaskId, externalSystemTaskNotificationListener);
            throw new ExternalSystemException("Simulating a project load problem");
        }

        // TODO: add more nodes for modules
        return node;
    }

    private void pretendToWork(@NotNull ExternalSystemTaskId id, @NotNull ExternalSystemTaskNotificationListener listener) {
        listener.onStatusChange(new ExternalSystemTaskNotificationEvent(id, "Loading project... "));
        try {
            listener.onTaskOutput(id, "Simulating work... ", true);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        listener.onTaskOutput(id, "Done", true);
    }

    @Override
    public boolean cancelTask(@NotNull ExternalSystemTaskId externalSystemTaskId, @NotNull ExternalSystemTaskNotificationListener externalSystemTaskNotificationListener) {
        LOG.info("cancelTask");
        return false;
    }
}
