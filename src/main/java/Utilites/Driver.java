package Utilites;

import org.openqa.selenium.WebDriver;

public class Singleton {
    private static Singleton instance;

    private Singleton(){ }

    public static Singleton create(){
        if(instance==null) {
            instance = new Singleton();
        }
        return instance;
    }
    /*public static WebDriver Instance = null;

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
    }*/
}
