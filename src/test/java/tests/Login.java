package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase{

    @Test
    public void positiveLoginTest(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7_*"));
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']")));
    }
    @Test
    public void negativePasswordLoginTest(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7"));
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        Assert.assertTrue(app.getUserHelper()
                .isElementPresent(By.xpath("//span[contains(text(),'Incorrect email address and / or password. If you ')]")));

    }
    @Test
    public void negativeEmailLoginTest(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillEmailFied(new User().withEmail("sna.sfn"));
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//input[@id='login']")));

    }
    @Test
    public void logOutTest(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7_*"));
        app.getUserHelper().submitLogIn();
        app.getUserHelper().pause(10000);
        app.getUserHelper().openAccountForm();
        app.getUserHelper().pause(2000);
        app.getUserHelper().submitLogOut();
        app.getUserHelper().pressOkButton();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")));


    }
}
