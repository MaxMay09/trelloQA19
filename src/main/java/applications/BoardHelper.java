package applications;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;
import java.util.List;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }


    public void pressCreateButton() {
        click(By.xpath("//span[text()='Create new board']"));
    }

    public void fillBoardForm(Board board) {
        type(By.xpath("//input[@data-testid='create-board-title-input']"), board.getName());
    }
    public void submitCreate() {
        click(By.xpath("//button[@data-testid='create-board-submit-button']"));
    }

    public void pressBoard() {
        click(By.xpath("//p[@class='nNvJhnERHVQb9o']"));
    }
    public int counterBoards(){
        List<WebElement> boardList = wd.findElements(By.cssSelector(".boards-page-board-section-list-item"));
        return boardList.size();
    }
    public String getTitle(){
        return wd.findElement(By.xpath("//h1[@class='HKTtBLwDyErB_o']")).getText();
    }
}
