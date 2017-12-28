package component.steps;

import com.acn.agile.controller.LoginController;
import com.acn.agile.service.LoginService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class LoginSteps {

    @Autowired
    LoginController loginController;

    @Autowired
    LoginService loginService;

    @Given("^el usuario (\\w+) ingresa a la app$")
    public void navigateToAppUrl(String userId) throws Throwable{
        //The web driver would navigate to the web app
    }

    @When("^el usuario ingresa (\\w+) y (\\w+)$")
    public void inputUserAndPass(String userId, String password) throws Throwable {
        String loginResult = loginController.doLogin(userId, password);
        System.out.println(loginResult);
    }

    @Then("^la aplicacion muestra la pantalla de bienvenida y los datos del usuario$")
     public void checkRenderedUserData() throws Throwable {
        //Selenium checks the rendered information
    }

    @Then("^la aplicacion muestra un mensaje de error$")
    public void checkRenderedErrorMsg() throws Throwable {
        //Selenium checks the rendered error message
    }

    @And("^el usuario (\\w+) esta registrado$")
    public void checkRegisteredUser(String userId) throws Throwable {
        loginService.isUserRegistered(userId);
    }
}
