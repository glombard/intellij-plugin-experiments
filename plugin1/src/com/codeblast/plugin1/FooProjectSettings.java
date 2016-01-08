package com.codeblast.plugin1;

import com.intellij.openapi.externalSystem.settings.ExternalProjectSettings;
import org.jetbrains.annotations.NotNull;

public class FooProjectSettings extends ExternalProjectSettings {
    @NotNull
    @Override
    public ExternalProjectSettings clone() {
        final FooProjectSettings result = new FooProjectSettings();
        copyTo(result);
        return result;
    }
}
