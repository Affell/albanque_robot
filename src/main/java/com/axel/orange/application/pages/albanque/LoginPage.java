/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * 
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.axel.orange.application.pages.albanque;

import static com.axel.orange.utils.NoraRobotContext.ALBANQUE_KEY;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.axel.orange.utils.NoraRobotContext;

import com.github.noraui.application.page.Page;
import com.github.noraui.utils.Context;

public class LoginPage extends Page {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public final PageElement login = new PageElement("-login_field", "Login");
    public final PageElement password = new PageElement("-password_field", "Password");
    public final PageElement signInButton = new PageElement("-sign_in_button", "Sign-in button");
    public final PageElement login_form = new PageElement("-login_form", "Login form");

    private static final String TITLE_PAGE = "ALBanque - Connexion";

    public LoginPage() {
        super();
        this.application = ALBANQUE_KEY;
        this.pageKey = "ALBANQUE_LOG";
        this.callBack = Context.getCallBack(NoraRobotContext.CLOSE_WINDOW_AND_SWITCH_TO_ALBANQUE_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!TITLE_PAGE.equals(getDriver().getTitle())) {
                logger.error("HTML title is not good -- LoginPage : " + getDriver().getTitle() + " et normalement : " + TITLE_PAGE);
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("HTML title Exception", e);
            return false;
        }
    }
    
    /**
     * isDisplayed returns true if ALBANQUE portal page is displayed.
     *
     * @return boolean
     */
    public boolean isDisplayed() {
        return isDisplayed(TITLE_PAGE);
    }
    
    /**
     * isDisplayed returns true if the required ALBANQUE portal page is displayed.
     *
     * @param titlePage
     *            The page title to check
     * @return boolean
     */
    public boolean isDisplayed(String titlePage) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!titlePage.equals(getDriver().getTitle())) {
                return false;
            }
        } catch (Exception e) {
            logger.error("Exception in isDisplayed", e);
            return false;
        }
        return true;
    }
    
}