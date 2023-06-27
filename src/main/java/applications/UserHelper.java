package applications;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='user']"), user.getEmail());
        click(By.xpath("//input[@id='login']"));
        pause(3000);
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    public void submitLogIn() {
        click(By.xpath("//span[text()='Log in']"));
    }

    public void fillEmailFied(User user) {
        type(By.xpath("//input[@id='user']"), user.getEmail());
        click(By.xpath("//input[@id='login']"));

    }

    public void openAccountForm() {
        click(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"));
    }

    public void submitLogOut() {
        click(By.xpath("//button[.='Log out']"));
    }

    public void pressOkButton() {
        click(By.xpath("//span[@class='css-178ag6o']"));
    }


}
