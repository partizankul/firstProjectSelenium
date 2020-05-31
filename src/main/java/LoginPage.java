import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By mailField = By.xpath("//input[@id=\"email\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By signInButton = By.xpath("//button[@id=\"submit-button\"]");
    private By mailFieldEmtyError = By.xpath("//*[text()=\"Поле ввода почты не может быть пустым.\"]");
    private By passwordFieldEmtyError = By.xpath("//*[text()=\"Поле ввода пароля не может быть пустым.\"]");
    private By mailOrPasswordFieldError = By.xpath("//p[@class=\"grid--cell s-input-message js-error-message \"]");
    //private By mailOrPasswordError = By.xpath("//div[@class=\"grid fd-column gs4 gsy js-auth-item has-error\"]/p[contains(text(), \"Почта или пароль заданы неверно.\")]");
    private By questionAboutLogin = By.xpath("//*[contains(text(), \"Ещё нет учётной записи\")]");

    public LoginPage typeMail (String mail){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }
    public LoginPage typePassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return  this;
    }
    public LoginPage loginWithInvalidCreates(String mail){
        this.typeMail(mail);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public LoginPage loginWithInvalidCreates(String mail, String password){
        this.typeMail(mail);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public LoginPage clickButton(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public String getMailEmtyError(){
        return driver.findElement(mailFieldEmtyError).getText();
    }
    public String getpasswordEmtyError(){
        return driver.findElement(passwordFieldEmtyError).getText();
    }
    public String getMailOrPasswordError(){
        return driver.findElement(mailOrPasswordFieldError).getText();
    }
   /* public String getTextQuestion(){
        return driver.findElement(mailOrPasswordError).getText();
    }*/
    public String getQuestionAboutLogin(){
        return driver.findElement(questionAboutLogin).getText();
    }

}
