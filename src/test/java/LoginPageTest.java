import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest {

   private LoginPage loginPage;
   private Logger logger;

    @Before
    public void setUp(){
        logger = Logger.getLogger("new logger");
        Driver.getDriver();
        Driver.getDriver().get("https://ru.stackoverflow.com/users/login");
        loginPage = new LoginPage(Driver.getDriver());
    }
    @Test
    public void mailandPassIsEmptyTest(){
        logger.info("start test in LoginPage number 1");
    loginPage.clickButton();
    logger.debug("loginPage.getMailEmtyError() " + loginPage.getMailEmtyError()+"\n"
    + "loginPage.getpasswordEmtyError() " + loginPage.getpasswordEmtyError());
        logger.info("loginPage.getMailEmtyError() " + loginPage.getMailEmtyError()+"\n"
                + "loginPage.getpasswordEmtyError() " + loginPage.getpasswordEmtyError());
        Assert.assertEquals("Поле ввода почты не может быть пустым.", loginPage.getMailEmtyError());
        Assert.assertEquals("Поле ввода пароля не может быть пустым.", loginPage.getpasswordEmtyError());
        logger.info("end test in LoginPage number 1");
    }

    @Test
    public void passIsEmptyTest(){
        loginPage.loginWithInvalidCreates("Test@gmail.com");
        Assert.assertEquals("Поле ввода пароля не может быть пустым.", loginPage.getpasswordEmtyError());
    }

    @Test
    public void maitOrPasswordErrorTest(){
        loginPage.loginWithInvalidCreates("Test@gmail.com", "Qwe1234567");
        Assert.assertEquals("Почта или пароль заданы неверно.",loginPage.getMailOrPasswordError());
    }



    @After
    public void tearDown(){
        Driver.getDriver().quit();;
    }

}
