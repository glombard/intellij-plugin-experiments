package com.codeblast.intellij.salmon.config;

import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessOutputTypes;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.NotNull;

public class SalmonTestReportReader {
    @NotNull
    private final ProcessHandler processHandler;

    public SalmonTestReportReader(@NotNull ProcessHandler processHandler) {
        this.processHandler = processHandler;
    }

    public void startReading() {
        ApplicationManager.getApplication().assertIsDispatchThread();
        ApplicationManager.getApplication().executeOnPooledThread(new MyRunnable());
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            //processHandler.notifyTextAvailable("Hmmm, just testing", ProcessOutputTypes.SYSTEM);

            String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<testsuites>\n" +
                    "   <testsuite name=\"JUnitXmlReporter\" errors=\"0\" tests=\"0\" failures=\"0\" time=\"0\" timestamp=\"2013-05-24T10:23:58\" />\n" +
                    "   <testsuite name=\"JUnitXmlReporter.constructor\" errors=\"0\" skipped=\"1\" tests=\"3\" failures=\"1\" time=\"0.006\" timestamp=\"2013-05-24T10:23:58\">\n" +
                    "      <properties>\n" +
                    "         <property name=\"java.vendor\" value=\"Sun Microsystems Inc.\" />\n" +
                    "         <property name=\"compiler.debug\" value=\"on\" />\n" +
                    "         <property name=\"project.jdk.classpath\" value=\"jdk.classpath.1.6\" />\n" +
                    "      </properties>\n" +
                    "      <testcase classname=\"JUnitXmlReporter.constructor\" name=\"should default path to an empty string\" time=\"0.006\">\n" +
                    "         <failure message=\"test failure\">Assertion failed</failure>\n" +
                    "      </testcase>\n" +
                    "      <testcase classname=\"JUnitXmlReporter.constructor\" name=\"should default consolidate to true\" time=\"0\">\n" +
                    "         <skipped />\n" +
                    "      </testcase>\n" +
                    "      <testcase classname=\"JUnitXmlReporter.constructor\" name=\"should default useDotNotation to true\" time=\"0\" />\n" +
                    "   </testsuite>\n" +
                    "</testsuites>\n";
            for (String l : s.split("\n")) {
                processHandler.notifyTextAvailable(l + "\n", ProcessOutputTypes.SYSTEM);
            }

            if (!processHandler.isProcessTerminated() && !processHandler.isProcessTerminating()) {
                processHandler.destroyProcess();
            }
        }
    }
}
