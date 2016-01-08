package com.codeblast.plugin1;

import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.externalSystem.model.DataNode;
import com.intellij.openapi.externalSystem.model.project.ProjectData;
import com.intellij.openapi.externalSystem.service.project.manage.ProjectDataManager;
import com.intellij.openapi.externalSystem.service.project.wizard.AbstractExternalProjectImportBuilder;
import com.intellij.openapi.project.Project;
import icons.Icons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.File;

public class FooProjectImportBuilder extends AbstractExternalProjectImportBuilder<FooImportFromExternalSystemControl> {
    private static final Logger LOG = Logger.getInstance(FooProjectImportBuilder.class);

    public FooProjectImportBuilder(@NotNull ProjectDataManager dataManager) {
        super(dataManager, new FooImportFromExternalSystemControl(), FooConstants.SYSTEM_ID);
    }

    @Override
    protected void doPrepare(@NotNull WizardContext wizardContext) {
        LOG.info("doPrepare");
    }

    @Override
    protected void beforeCommit(@NotNull DataNode<ProjectData> dataNode, @NotNull Project project) {
        LOG.info("beforeCommit");
    }

    @NotNull
    @Override
    protected File getExternalProjectConfigToUse(@NotNull File file) {
        LOG.info("getExternalProjectConfigToUse");
        return file;
    }

    @Override
    protected void applyExtraSettings(@NotNull WizardContext wizardContext) {
        LOG.info("applyExtraSettings");
    }

    @NotNull
    @Override
    public String getName() {
        return "Foo";
    }

    @Override
    public Icon getIcon() {
        return Icons.Icon;
    }
}
