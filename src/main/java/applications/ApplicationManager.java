package applications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    BoardHelper boardHelper;



     public void init(){
         wd = new ChromeDriver();
         wd.manage().window().maximize();
         wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
         wd.navigate().to("https://trello.com/home");
         userHelper = new UserHelper(wd);
         boardHelper = new BoardHelper(wd);
     }

     public void stop(){
         wd.quit();
     }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }
}
