package com.codeblast.intellij.salmon.config;

import com.intellij.execution.Executor;
import com.intellij.execution.testframework.TestConsoleProperties;
import com.intellij.execution.testframework.sm.runner.SMTRunnerConsoleProperties;
import com.intellij.execution.testframework.sm.runner.SMTestLocator;
import com.intellij.execution.testframework.sm.runner.TestProxyFilterProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SalmonConsoleProperties extends SMTRunnerConsoleProperties {
    @NotNull
    private final SalmonTestProxyFilterProvider filterProvider;

    public SalmonConsoleProperties(@NotNull SalmonRunConfiguration configuration, @NotNull Executor executor) {
        super(configuration, "Salmon", executor);
        this.filterProvider = new SalmonTestProxyFilterProvider();
        setUsePredefinedMessageFilter(false);
        setIfUndefined(TestConsoleProperties.HIDE_PASSED_TESTS, false);
        setIfUndefined(TestConsoleProperties.HIDE_IGNORED_TEST, true);
        setIfUndefined(TestConsoleProperties.SCROLL_TO_SOURCE, false);
        setIdBasedTestTree(true);
        setPrintTestingStartedTime(false);
    }

    @Nullable
    @Override
    public TestProxyFilterProvider getFilterProvider() {
        return filterProvider;
    }

    @Nullable
    @Override
    public SMTestLocator getTestLocator() {
        return null;
    }
}

