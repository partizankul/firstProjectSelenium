import Utilites.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

   private LoginPage loginPage;

    @Before
    public void setUp(){
        Driver.Initialize();
        Driver.Instance.get("https://ru.stackoverflow.com/users/login");
        loginPage = new LoginPage(Driver.Instance);

    }

    @Test
    public void mailandPassIsEmptyTest(){
    loginPage.clickButton();
        Assert.assertEquals("Поле ввода почты не может быть пустым.", loginPage.getMailEmtyError());
        Assert.assertEquals("Поле ввода пароля не может быть пустым.", loginPage.getpasswordEmtyError());
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
        Driver.quit();;
    }

}
