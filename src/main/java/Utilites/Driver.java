package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver Instance = null;

    public static void Initialize(){
        if(Instance == null){
            System.setProperty("webdriver.chrome.driver",
                    "drivers\\chromedriver.exe");

        }
        Instance = new ChromeDriver();
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Instance.manage().window().maximize();
    }

    public static  void quit(){
        Instance.quit();
        Instance=null;
    }
}
