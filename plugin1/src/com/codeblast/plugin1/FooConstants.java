package com.codeblast.plugin1;

import com.intellij.openapi.externalSystem.model.ProjectSystemId;
import org.jetbrains.annotations.NotNull;

public class FooConstants {
    public static final String FOO = "foo";

    @NotNull
    public static final ProjectSystemId SYSTEM_ID = new ProjectSystemId(FOO);
}
