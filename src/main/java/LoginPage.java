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
    private By mailFieldError = By.xpath("//p[@class=\"grid--cell s-input-message js-error-message \"]");
    private By passwordFieldEmtyError = By.xpath("//*[text()=\"Поле ввода пароля не может быть пустым.\"]");
    private By mailOrPasswordFieldError = By.xpath("//p[@class=\"grid--cell s-input-message js-error-message \"]");
    private By questionAboutlogin = By.xpath("//*[contains(text(), \"Ещё нет учётной записи\")]");

    public LoginPage typeMail (String mail){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }
    public LoginPage typePassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return  this;
    }
    public LoginPage loginWithInvalidCreates(String mail, String password){
        this.typeMail(mail);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);

    }
    public String getMailEmtyError(){
        return driver.findElement(mailFieldEmtyError).getText();
    }
    public String getMailError(){
        return driver.findElement(mailFieldError).getText();
    }
    public String getpasswordEmtyError(){
        return driver.findElement(passwordFieldEmtyError).getText();
    }
    public String getMailOrPasswordError(){
        return driver.findElement(mailOrPasswordFieldError).getText();
    }
    public String getTextQuestion(){
        return driver.findElement(questionAboutlogin).getText();
    }

}
