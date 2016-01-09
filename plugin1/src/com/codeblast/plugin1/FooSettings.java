package com.codeblast.plugin1;

import com.intellij.openapi.components.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemSettings;
import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.util.containers.ContainerUtilRt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

@State(name = "FooSettings",
        storages = {
                @Storage(file = StoragePathMacros.PROJECT_FILE),
                @Storage(file = StoragePathMacros.PROJECT_CONFIG_DIR + "/foo.xml", scheme = StorageScheme.DIRECTORY_BASED)
        })
public class FooSettings extends AbstractExternalSystemSettings<FooSettings, FooProjectSettings, FooSettingsListener>
        implements PersistentStateComponent<FooSettings.FooState> {

    private static final Logger LOG = Logger.getInstance(FooSettings.class);

    public FooSettings(@NotNull Project project) {
        super(FooSettingsListener.TOPIC, project);
    }

    @NotNull
    public static FooSettings getDefault() {
        return new FooSettings(ProjectManager.getInstance().getDefaultProject());
    }

    @Override
    public void subscribe(@NotNull ExternalSystemSettingsListener<FooProjectSettings> externalSystemSettingsListener) {
        LOG.info("subscribe");
    }

    @Override
    protected void copyExtraSettingsFrom(@NotNull FooSettings fooSettings) {
        LOG.info("copyExtraSettingsFrom");
    }

    @Override
    protected void checkSettings(@NotNull FooProjectSettings fooProjectSettings, @NotNull FooProjectSettings ps1) {
        LOG.info("checkSettings");
    }

    @Nullable
    @Override
    public FooSettings.FooState getState() {
        LOG.info("getState");
        final FooState state = new FooState();
        fillState(state);
        return state;
    }

    @Override
    public void loadState(FooSettings.FooState fooState) {
        LOG.info("loadSate");
        super.loadState(fooState);
    }

    @NotNull
    public static FooSettings getInstance(Project project) {
        return ServiceManager.getService(project, FooSettings.class);
    }

    public static class FooState implements State<FooProjectSettings> {
        private Set<FooProjectSettings> linkedExternalProjectsSettings = ContainerUtilRt.newTreeSet();

        @Override
        public Set<FooProjectSettings> getLinkedExternalProjectsSettings() {
            return linkedExternalProjectsSettings;
        }

        @Override
        public void setLinkedExternalProjectsSettings(Set<FooProjectSettings> set) {
            linkedExternalProjectsSettings = set;
        }
    }
}
