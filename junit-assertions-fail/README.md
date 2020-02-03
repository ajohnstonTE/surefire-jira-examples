

To demonstrate, compare the output of the following commands:

a) `mvn -q -Dtest=JUnit5Test test`

b) `mvn -q -Dtest=JUnit4Test test`

c) `mvn -q -Dtest=JUnit5Test#failWithNoParameters test`

d) `mvn -q -Dtest=JUnit5Test#failWithNonEmptyParameters test`

Output:

a) `mvn -q -Dtest=JUnit5Test test`

```log
[ERROR] Tests run: 2, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.016 s <<< FAILURE! - in JUnit5Test
[ERROR] JUnit5Test.failWithNonEmptyParameters  Time elapsed: 0.008 s  <<< FAILURE!
org.opentest4j.AssertionFailedError: not empty
        at JUnit5Test.failWithNonEmptyParameters(JUnit5Test.java:19)

[ERROR] JUnit5Test.failWithNoParameters  Time elapsed: 0 s  <<< FAILURE!
[ERROR] Failures:
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.: NullPointerException -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace...
```

b) `mvn -q -Dtest=JUnit4Test test`

```log
[ERROR] Tests run: 2, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.01 s <<< FAILURE! - in JUnit4Test
[ERROR] JUnit4Test.failWithNonEmptyParameters  Time elapsed: 0.002 s  <<< FAILURE!
java.lang.AssertionError: not empty
        at JUnit4Test.failWithNonEmptyParameters(JUnit4Test.java:19)

[ERROR] JUnit4Test.failWithNoParameters  Time elapsed: 0 s  <<< FAILURE!
java.lang.AssertionError
        at JUnit4Test.failWithNoParameters(JUnit4Test.java:11)

[ERROR] Failures:
[ERROR]   JUnit4Test.failWithNoParameters:11
[ERROR]   JUnit4Test.failWithNonEmptyParameters:19 not empty
[ERROR] Tests run: 2, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: There are test failures.
[ERROR]
[ERROR] Please refer to G:\development\surefire-jira-examples\junit-assertions-fail\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace...
```

c) `mvn -q -Dtest=JUnit5Test#failWithNoParameters test`

```log
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.016 s <<< FAILURE! - in JUnit5Test
[ERROR] JUnit5Test.failWithNoParameters  Time elapsed: 0.008 s  <<< FAILURE!
[ERROR] Failures:
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.: NullPointerException -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace...
```

d) `mvn -q -Dtest=JUnit5Test#failWithNonEmptyParameters test`

```log
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.017 s <<< FAILURE! - in JUnit5Test
[ERROR] JUnit5Test.failWithNonEmptyParameters  Time elapsed: 0.008 s  <<< FAILURE!
org.opentest4j.AssertionFailedError: not empty
        at JUnit5Test.failWithNonEmptyParameters(JUnit5Test.java:19)

[ERROR] Failures:
[ERROR]   JUnit5Test.failWithNonEmptyParameters:19 not empty
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: There are test failures.
[ERROR]
[ERROR] Please refer to G:\development\surefire-jira-examples\junit-assertions-fail\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace...
```

Running (c) with the `-e` flag `mvn -q -Dtest=JUnit5Test#failWithNoParameters test -e`:

Trimmed:

```log
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.016 s <<< FAILURE! - in JUnit5Test
[ERROR] JUnit5Test.failWithNoParameters  Time elapsed: 0.007 s  <<< FAILURE!
[ERROR] Failures:
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.: NullPointerException -> [Help 1]
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.
Caused by: org.apache.maven.plugin.PluginExecutionException: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.
Caused by: java.lang.NullPointerException
    at org.apache.maven.plugin.surefire.report.DefaultReporterFactory.printTestFailures (DefaultReporterFactory.java:398)
    at org.apache.maven.plugin.surefire.report.DefaultReporterFactory.runCompleted (DefaultReporterFactory.java:198)
    at org.apache.maven.plugin.surefire.report.DefaultReporterFactory.close (DefaultReporterFactory.java:171)
    at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run (ForkStarter.java:254)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeProvider (AbstractSurefireMojo.java:1217)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeAfterPreconditionsChecked (AbstractSurefireMojo.java:1063)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.execute (AbstractSurefireMojo.java:889)
```

Full:

```log
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.016 s <<< FAILURE! - in JUnit5Test
[ERROR] JUnit5Test.failWithNoParameters  Time elapsed: 0.007 s  <<< FAILURE!
[ERROR] Failures:
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.: NullPointerException -> [Help 1]
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test (default-test) on project junit-assertions-fail: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:215)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:957)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:289)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:193)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:282)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:225)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:406)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:347)
Caused by: org.apache.maven.plugin.PluginExecutionException: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4:test failed.
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:148)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:957)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:289)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:193)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:282)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:225)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:406)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:347)
Caused by: java.lang.NullPointerException
    at org.apache.maven.plugin.surefire.report.DefaultReporterFactory.printTestFailures (DefaultReporterFactory.java:398)
    at org.apache.maven.plugin.surefire.report.DefaultReporterFactory.runCompleted (DefaultReporterFactory.java:198)
    at org.apache.maven.plugin.surefire.report.DefaultReporterFactory.close (DefaultReporterFactory.java:171)
    at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run (ForkStarter.java:254)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeProvider (AbstractSurefireMojo.java:1217)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeAfterPreconditionsChecked (AbstractSurefireMojo.java:1063)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.execute (AbstractSurefireMojo.java:889)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:957)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:289)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:193)
    at sun.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:498)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:282)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:225)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:406)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:347)
[ERROR]
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginExecutionException
```
