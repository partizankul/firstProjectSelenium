import Utilites.Driver;


public class MainClass {

    public  static void main(String[] args) {
        Driver.getDriver();
        Driver.getDriver().get("https://ru.stackoverflow.com/");

    }
}
