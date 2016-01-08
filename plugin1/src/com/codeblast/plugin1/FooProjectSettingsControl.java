package com.codeblast.plugin1;

import com.intellij.openapi.externalSystem.service.settings.AbstractExternalProjectSettingsControl;
import com.intellij.openapi.externalSystem.service.settings.ExternalSystemSettingsControlCustomizer;
import com.intellij.openapi.externalSystem.util.PaintAwarePanel;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.NotNull;

public class FooProjectSettingsControl extends AbstractExternalProjectSettingsControl<FooProjectSettings> {
    public FooProjectSettingsControl(FooProjectSettings projectSettings) {
        super(null, projectSettings, new ExternalSystemSettingsControlCustomizer(true, true));
    }

    @Override
    protected void fillExtraControls(@NotNull PaintAwarePanel paintAwarePanel, int indentLevel) {

    }

    @Override
    protected boolean isExtraSettingModified() {
        return false;
    }

    @Override
    protected void resetExtraSettings(boolean b) {

    }

    @Override
    protected void applyExtraSettings(@NotNull FooProjectSettings fooProjectSettings) {

    }

    @Override
    public boolean validate(@NotNull FooProjectSettings fooProjectSettings) throws ConfigurationException {
        return true;
    }
}
