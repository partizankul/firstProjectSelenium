import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "E:\\Java Projects\\WebDriverChrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ru.stackoverflow.com/users/signup?ssrc=head&returnurl=https%3a%2f%2fru.stackoverflow.com%2fusers");
        signUpPage = new SignUpPage(driver);
    }
    /*@Test
    public void mailEmptyTest(){
        signUpPage.registerWithInvalidCreads("Alex", " ", "Qwerty123");
        Assert.assertEquals("Поле ввода почты не может быть пустым.", signUpPage.getMailFieldEmptyErrorText());
    }*/

    /*@Test
    public void passEmptyTest(){
        signUpPage.registerWithInvalidCreads("Alex","Test@gmail.com", "");
        Assert.assertEquals("Поле ввода пароля не может быть пустым.", signUpPage.getPasswordFieldEmptyError());
    }*/



   @Test
   public void getHeadingTest(){
       Assert.assertEquals("Присоединяйтесь к сообществу «Stack Overflow на русском». Это бесплатно и займёт не больше минуты.", signUpPage.getHeading());
   }




    @After
    public void tearDown(){
        driver.quit();
    }


}
