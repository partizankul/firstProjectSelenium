import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private  MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "E:\\Java Projects\\kuleshovcom\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ru.stackoverflow.com/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){

        String heading = mainPage.getHeadingText();
        Assert.assertEquals("Stack Overflow на русском", heading);

    }

    @Test
    public void singInButtonText(){
        String buttonSingInText = mainPage.getButtonSingInText();
        Assert.assertEquals("Войти", buttonSingInText);
    }

    @Test
    public void singUpButtonText(){
        String buttonSingUpText = mainPage.getButtonSingUpText();
        Assert.assertEquals("Регистрация", buttonSingUpText);
    }

    @Test
    public void singIn(){
        LoginPage loginPage = mainPage.clickSingnIn();
        Assert.assertEquals("Ещё нет учётной записи? Зарегистрируйтесь", loginPage.getTextQuestion());
    }

    @Test
    public void singUp(){
        SignUpPage signUpPage = mainPage.clickSingUp();
        Assert.assertEquals("Присоединяйтесь к сообществу «Stack Overflow на русском». Это бесплатно и займёт не больше минуты.", signUpPage.getHeading() );


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
