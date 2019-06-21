/**
 * NoraRobot generated free by NoraUi Organization https://github.com/NoraUi
 * NoraRobot is licensed under the license BSD.
 * 
 * CAUTION: NoraRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.axel.orange.application.steps.albanque;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axel.orange.application.pages.albanque.HomePage;
import com.axel.orange.application.pages.albanque.LoginPage;
import com.github.noraui.application.steps.Step;
import com.github.noraui.browser.Auth;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;
import com.github.noraui.utils.Utilities;
import com.google.inject.Inject;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlbanqueSteps extends Step {
	
	private static final Logger logger = LoggerFactory.getLogger(AlbanqueSteps.class);

    @Inject
    private LoginPage loginPage;
    
    @Inject
    private HomePage homePage;
   
   /**
    * Check Login page.
    *
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @Then("The ALBANQUE home page is displayed")
   public void checkAlbanqueLoginPage() throws FailureException {
       if (!loginPage.checkPage()) {
           new Result.Failure<>(loginPage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, loginPage.getCallBack());
       }
   }
   
   /**
    * Log in to ALBANQUE without NoraRobot (login and password in Gherkin scenario).
    *
    * @param login
    *            Login to use.
    * @param password
    *            Password to use.
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @When("I log in to ALBANQUE as '(.*)' '(.*)'")
   public void logInToAlbanque(String login, String password) throws FailureException {
       try {
//           Utilities.findElement(albanquePage.accountMenu).click();
//           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(albanquePage.signinMenu))).click();
//           
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(loginPage.signInButton)));
           Utilities.findElement(loginPage.login).sendKeys(login);
           Utilities.findElement(loginPage.password).sendKeys(password);
           Utilities.findElement(loginPage.signInButton).click();
       } catch (Exception e) {
           new Result.Failure<>(e, Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, loginPage.getCallBack());
       }
   }
   
   /**
    * Check Albanque portal page.
    *
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @Then("The ALBANQUE portal is displayed with '(.*)'")
   public void checkAlbanquePage(String login) throws FailureException {
       try {
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(homePage.signInMessage, login)));           
           String text_username = getDriver().findElement(By.xpath(String.format("//*[@id='username' and text()='%s']", login))).getText();           
           if (!text_username.equals(login)) {        	   
               logInToAlbanqueWithNoraRobot();
               logger.error("Le compte n'est pas bien authentifié -> login entré : "+login+" et login affiché : "+text_username);
           }
           if (text_username.equals(login)) {
        	   
               logger.error("Le compte est bien authentifié avec le login : "+login);
           }
           if (!homePage.checkPage()) {
               new Result.Failure<>(homePage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, loginPage.getCallBack());
           }
       } catch (Exception e) {
           new Result.Failure<>(homePage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, loginPage.getCallBack());
       }    
       Auth.setConnected(true);
   }
   
   /**
    * Logout of Albanque.
    *
    * @throws FailureException
    *             if the scenario encounters a functional error.
    * @throws TechnicalException
    *             is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
    */
   @When("I log out of ALBANQUE")
   public void logOutOfAlbanque() throws FailureException, TechnicalException {
       if (Auth.isConnected()) {
           getDriver().switchTo().defaultContent();           
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(homePage.signoutMenu))).click();
       }
   }
   
   /**
   * Check Logout page.
   */
  @Then("The ALBANQUE logout page is displayed")
  public void checkAlbanqueLogoutPage() {
	  Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(loginPage.login_form)));
      loginPage.checkPage();
  }
  
  /**
   * Log in to ALBANQUE with NoraRobot (login and password in job parameters).
   *
   * @throws FailureException
   *             if the scenario encounters a functional error.
   */
  private void logInToAlbanqueWithNoraRobot() throws FailureException {
      String login = Auth.getLogin();
      String password = Auth.getPassword();
      if (!"".equals(login) && !"".equals(password)) {
          logInToAlbanque(login, password);
      }
  }

}
