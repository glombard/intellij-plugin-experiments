package com.codeblast.plugin1;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.externalSystem.service.settings.AbstractImportFromExternalSystemControl;
import com.intellij.openapi.externalSystem.util.ExternalSystemSettingsControl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FooImportFromExternalSystemControl extends AbstractImportFromExternalSystemControl<FooProjectSettings, FooSettingsListener, FooSettings> {
    private static final Logger LOG = Logger.getInstance(FooImportFromExternalSystemControl.class);

    public FooImportFromExternalSystemControl() {
        super(FooConstants.SYSTEM_ID, FooSettings.getDefault(), new FooProjectSettings(), true);
    }

    @Override
    protected void onLinkedProjectPathChange(@NotNull String path) {
        LOG.info("onLinkedProjectPathChange");
    }

    @NotNull
    @Override
    protected ExternalSystemSettingsControl<FooProjectSettings> createProjectSettingsControl(@NotNull FooProjectSettings projectSettings) {
        LOG.info("createProjectSettingsControl");
        return new FooProjectSettingsControl(projectSettings);
    }

    @Nullable
    @Override
    protected ExternalSystemSettingsControl<FooSettings> createSystemSettingsControl(@NotNull FooSettings systemSettings) {
        LOG.info("createSystemSettingsControl");
        return null;
    }
}
