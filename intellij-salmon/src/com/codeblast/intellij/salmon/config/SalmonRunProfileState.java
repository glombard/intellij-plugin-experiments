package com.codeblast.intellij.salmon.config;

import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.testframework.sm.SMTestRunnerConnectionUtil;
import com.intellij.execution.testframework.ui.BaseTestsOutputConsoleView;
import com.intellij.execution.ui.ExecutionConsole;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Nullable;

public class SalmonRunProfileState implements RunProfileState {
    private SalmonRunConfiguration salmonRunConfiguration;

    public SalmonRunProfileState(@NotNull Project project, @NotNull SalmonRunConfiguration salmonRunConfiguration, @NotNull ExecutionEnvironment executionEnvironment) {
        this.salmonRunConfiguration = salmonRunConfiguration;
    }

    @Nullable
    @Override
    public ExecutionResult execute(Executor executor, @NotNull ProgramRunner programRunner) throws ExecutionException {
        final ProcessHandler processHandler = new SalmonEmptyProcessHandler();
        final ExecutionConsole consoleView = createConsoleView(processHandler, executor);
        final SalmonTestReportReader reader = new SalmonTestReportReader(processHandler);
        reader.startReading();
        return new DefaultExecutionResult(consoleView, processHandler);
    }

    @NotNull
    private ExecutionConsole createConsoleView(@NotNull ProcessHandler processHandler, @NotNull Executor executor) throws ExecutionException {
        SalmonConsoleProperties consoleProperties = new SalmonConsoleProperties(salmonRunConfiguration, executor);
        final BaseTestsOutputConsoleView view = SMTestRunnerConnectionUtil.createAndAttachConsole(consoleProperties.getTestFrameworkName(), processHandler, consoleProperties);
        Disposer.register(salmonRunConfiguration.getProject(), view);
        return view;
    }
}
