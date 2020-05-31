import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "E:\\Java Projects\\WebDriverChrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ru.stackoverflow.com/users/login");
        loginPage = new LoginPage(driver);
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
        driver.quit();
    }

}
