/**
 * NoraRobot generated free by NoraUi Oraganization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * 
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.axel.orange.application.pages.LoginLogout;

import static com.axel.orange.utils.NoraRobotContext.LOGINLOGOUT_KEY;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.page.Page;
import com.github.noraui.utils.Context;
import com.axel.orange.utils.NoraRobotContext;

public class LoginLogoutPage extends Page {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginLogoutPage.class);

    public final PageElement pageElementSample = new PageElement("-pageElementSample", "PageElement Sample");

    private static final String TITLE_PAGE = "LoginLogout";

    public LoginLogoutPage() {
        super();
        this.application = LOGINLOGOUT_KEY;
        this.pageKey = "LOGINLOGOUT_HOM";
        this.callBack = Context.getCallBack(NoraRobotContext.CLOSE_WINDOW_AND_SWITCH_TO_LOGINLOGOUT_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!TITLE_PAGE.equals(getDriver().getTitle())) {
                logger.error("HTML title is not good");
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("HTML title Exception", e);
            return false;
        }
    }

}
