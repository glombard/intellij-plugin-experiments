package com.codeblast.plugin1;

import com.intellij.openapi.externalSystem.service.project.wizard.AbstractExternalProjectImportProvider;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;

public class FooProjectImportProvider extends AbstractExternalProjectImportProvider {
    protected FooProjectImportProvider(FooProjectImportBuilder builder) {
        super(builder, FooConstants.SYSTEM_ID);
    }

    @Override
    protected boolean canImportFromFile(VirtualFile file) {
        return true;
    }

    @Nullable
    @Override
    public String getFileSample() {
        return "<b>Foo</b> build file (*.*)";
    }
}
