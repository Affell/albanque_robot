/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * 
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.axel.orange.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.Application;
import com.github.noraui.application.page.Page;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;

public class NoraRobotContext extends Context {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NoraRobotContext.class);

    // applications
    public static final String LOGINLOGOUT_KEY = "LoginLogout";
    public static final String LOGINLOGOUT_HOME = "LOGINLOGOUT_HOME";
    private String LoginLogoutHome; // LOGINLOGOUT home url
    public static final String ALBANQUE_KEY = "albanque";
    public static final String ALBANQUE_HOME = "ALBANQUE_HOME";
    private String albanqueHome; // ALBANQUE home url

    // targets
    public static final String GO_TO_LOGINLOGOUT_HOME = "GO_TO_LOGINLOGOUT_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_LOGINLOGOUT_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_LOGINLOGOUT_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGINLOGOUT_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGINLOGOUT_HOME";
    public static final String GO_TO_ALBANQUE_HOME = "GO_TO_ALBANQUE_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_ALBANQUE_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_ALBANQUE_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_ALBANQUE_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_ALBANQUE_HOME";

    /**
     * Constructor is useless because all attributes are static
     */
    private NoraRobotContext() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void initializeRobot(Class clazz) throws TechnicalException {
        super.initializeRobot(clazz);
        logger.info("NoraRobotContext > initializeRobot()");
        
        // This line is here as an example to show how to do with internationalization using messages bundles.
        logger.info(Messages.format(Messages.getMessage("HELLO", "albanque_robot"), "albanque_robot"));

        // Urls configuration
        LoginLogoutHome = getProperty(LOGINLOGOUT_KEY, applicationProperties);
        albanqueHome = getProperty(ALBANQUE_KEY, applicationProperties);

        // Selectors configuration
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, LOGINLOGOUT_KEY);
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, ALBANQUE_KEY);
 
        // Exception Callbacks
        exceptionCallbacks.put(GO_TO_LOGINLOGOUT_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, LOGINLOGOUT_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_LOGINLOGOUT_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeWindowAndSwitchTo", LOGINLOGOUT_KEY, LOGINLOGOUT_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGINLOGOUT_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeAllWindowsAndSwitchTo", LOGINLOGOUT_KEY);
        exceptionCallbacks.put(GO_TO_ALBANQUE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, ALBANQUE_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_ALBANQUE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeWindowAndSwitchTo", ALBANQUE_KEY, ALBANQUE_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_ALBANQUE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeAllWindowsAndSwitchTo", ALBANQUE_KEY);

        // applications mapping
        applications.put(LOGINLOGOUT_KEY, new Application(LOGINLOGOUT_HOME, LoginLogoutHome));
        applications.put(ALBANQUE_KEY, new Application(ALBANQUE_HOME, albanqueHome));

        Page.setPageMainPackage("com.axel.orange.application.pages.");
    }
    
    /**
     * Get context singleton.
     *
     * @return context instance
     */
    public static Context getInstance() {
        if (instance == null || !(instance instanceof NoraRobotContext)) {
            instance = new NoraRobotContext();
        }
        return instance;
    }

    // home getters
    public String getLoginLogoutHome() {
        return LoginLogoutHome;
    }
    public String getAlbanqueHome() {
        return albanqueHome;
    }

}