/**
 * NoraRobot generated free by NoraUi Oraganization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * 
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.axel.orange.application.steps.LoginLogout;

import com.github.noraui.application.steps.Step;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.utils.Messages;
import com.google.inject.Inject;
import com.axel.orange.application.pages.LoginLogout.LoginLogoutPage;

import cucumber.api.java.en.Then;

public class LoginLogoutSteps extends Step {

    @Inject
    private LoginLogoutPage LoginLogoutPage;

    /**
     * Check Login page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The LOGINLOGOUT home page is displayed")
    public void checkLoginLogoutHomePage() throws FailureException {
        if (!LoginLogoutPage.checkPage()) {
            new Result.Failure<>(LoginLogoutPage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, LoginLogoutPage.getCallBack());
        }
    }

}
