package com.codeblast.intellij.salmon.config;

import com.intellij.execution.filters.Filter;
import com.intellij.execution.testframework.sm.runner.TestProxyFilterProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SalmonTestProxyFilterProvider implements TestProxyFilterProvider {
    @Nullable
    @Override
    public Filter getFilter(@NotNull String nodeType, @NotNull String nodeName, @Nullable String nodeArguments) {
        return null;
    }
}
