import Utilites.Driver;


public class MainClass {

    public  static void main(String[] args) {
        Driver.Initialize();
        Driver.Instance.get("https://ru.stackoverflow.com/");

    }
}
