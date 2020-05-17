import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public  MainPage(WebDriver driver){
        this.driver = driver;
    }
    private By signInButton = By.xpath("//*[text()=\"Войти\"]");
    private By singUpButton = By.xpath("//*[text()=\"Регистрация\"]");
    private By heading = By.xpath("//header//span[text()=\"Stack Overflow на русском\"]");


    public LoginPage clickSingnIn(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public SignUpPage clickSingUp(){
        driver.findElement(singUpButton).click();
        return  new SignUpPage(driver);
    }

    public String getButtonSingInText(){
        return driver.findElement(signInButton).getText();
    }

    public String getButtonSingUpText(){
        return driver.findElement(singUpButton).getText();
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }


}
