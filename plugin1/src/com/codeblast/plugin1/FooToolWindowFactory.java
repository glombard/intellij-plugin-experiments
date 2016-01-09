package com.codeblast.plugin1;

import com.intellij.openapi.externalSystem.service.task.ui.AbstractExternalSystemToolWindowFactory;

public class FooToolWindowFactory extends AbstractExternalSystemToolWindowFactory {
    public FooToolWindowFactory() {
        super(FooConstants.SYSTEM_ID);
    }
}
