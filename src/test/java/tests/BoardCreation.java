package tests;

import models.Board;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{

    @BeforeMethod
    public void preConditions(){
        if(!app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))){
            app.getUserHelper().openLoginForm();
            app.getUserHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7_*"));
            app.getUserHelper().submitLogIn();
            app.getUserHelper().pause(3000);
        }
    }
    @Test
    public void boardCreationTest() {
        while (app.getBoardHelper().counterBoards() < 9) {
            String boardName = "qa19_" + System.currentTimeMillis();
            app.getUserHelper().pause(1000);
            int before = app.getBoardHelper().counterBoards();
            app.getBoardHelper().pressCreateButton();
            app.getUserHelper().pause(3000);
            app.getBoardHelper().fillBoardForm(new Board().withName(boardName));
            app.getBoardHelper().submitCreate();
            app.getUserHelper().pause(3000);
            app.getBoardHelper().pressBoard();
            app.getUserHelper().pause(2000);
            int after = app.getBoardHelper().counterBoards();
            app.getUserHelper().pause(3000);
            String title = app.getBoardHelper().getTitle();
            app.getUserHelper().pause(3000);
          //  Assert.assertEquals(boardName, title);
            Assert.assertEquals(before, after - 1);
        }
    }
}
