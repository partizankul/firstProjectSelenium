import Utilites.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class SignUpTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){
        Driver.Initialize();
        Driver.Instance.get("https://ru.stackoverflow.com/users/signup?ssrc=head&returnurl=https%3a%2f%2fru.stackoverflow.com%2fusers");
        signUpPage = new SignUpPage(Driver.Instance);
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
        Driver.quit();
    }


}
