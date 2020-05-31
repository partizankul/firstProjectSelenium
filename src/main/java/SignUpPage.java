import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//input[@id=\"display-name\"]");
    private By mailField = By.xpath("//input[@id=\"email\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By signUpButton = By.xpath("//button[@id=\"submit-button\"]");
    private By mailFieldEmptyError = By.xpath("//*[text()=\"Поле ввода почты не может быть пустым.\"]");
    private By passwordFieldEmptyError = By.xpath("//*[text()=\"Поле ввода пароля не может быть пустым.\"]");
    private By mailFieldError = By.xpath("//*[contains(text(), 'неверный адрес почты.')]");
    private By paswordFieldError = By.xpath("//div/p[@class=\"fs-caption fc-light mt4 mb4\"]");
    private By heading = By.xpath("//*[contains(text(), \"Это бесплатно и займёт не больше минуты.\")]");

    public SignUpPage typeUserName (String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }
    public SignUpPage typeMail (String mail){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }
    public SignUpPage typePassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithInvalidCreads (String usermane, String mail, String password){
        this.typeUserName(usermane);
        this.typeMail(mail);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    public SignUpPage registerWithInvalidCreads (String mail, String password){
        this.typeMail(mail);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    public String getMailFieldEmptyErrorText (){
        return driver.findElement(mailFieldEmptyError).getText();
    }
    public String getPasswordFieldEmptyError (){
        return driver.findElement(passwordFieldEmptyError).getText();
    }
    public String getMailFieldError (){
        return driver.findElement(mailFieldError).getText();
    }
    public String getPaswordFieldError (){
        return driver.findElement(passwordField).getText();
    }
    public String getHeading(){
        return driver.findElement(heading).getText();
    }
    public String getPaswordFieldErrorText(){
       return driver.findElement(paswordFieldError).getText();
    }
}
