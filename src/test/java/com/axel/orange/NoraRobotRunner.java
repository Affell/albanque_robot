package com.axel.orange;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.axel.orange.utils.NoraRobotContext;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = { "com.github.noraui.application.steps", "com.github.noraui.browser.steps", "com.axel.orange.application.steps" }, plugin = { "html:target/reports/html", "json:target/reports/json/report.json", "junit:target/reports/junit/report.xml" },
features = { "src/test/resources" })
public class NoraRobotRunner {

    /**
     * BeforeClass Read constants file.
     * 
     * @throws TechnicalException is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
     */
    @BeforeClass
    public static void setUpClass() throws TechnicalException {
        NoraRobotContext.getInstance().initializeEnv("NoraRobot.properties");
        NoraRobotContext.getInstance().initializeRobot(NoraRobotRunner.class);
    }

    /**
     * AfterClass clear Context.
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}
