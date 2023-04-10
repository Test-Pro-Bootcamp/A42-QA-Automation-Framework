import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTest extends BaseTest{
    @Test
    public void createPlayListTest()  {
        // Login
        login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");

        //navigate create playList button
        WebElement createPlayListButton = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        new Actions(driver)
                .contextClick(createPlayListButton)
                .perform();

        //click create playList button
        WebElement clickPlayListButton = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        new Actions(driver)
                .click(clickPlayListButton)
                .perform();

        //navigate New Playlist button
        WebElement NewPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple'] "));
        new Actions(driver)
                .contextClick(NewPlayListButton)
                .perform();


        // click New Playlist button
        WebElement clickNewPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple'] "));
        new Actions(driver)
                .click(clickNewPlayListButton)
                .perform();


        // navigate field
        WebElement navigateFieldCreatePlayList = driver.findElement(By.xpath("//form[@name='create-simple-playlist-form']//input"));
        new Actions(driver)
                .contextClick(navigateFieldCreatePlayList)
                .perform();


        //add name New Playlist
        WebElement addplayListNameField = driver.findElement(By.xpath("//form[@name='create-simple-playlist-form']//input"));
        addplayListNameField.click();
        addplayListNameField.clear();
        addplayListNameField.sendKeys("Di1");
        new Actions(driver).keyDown(Keys.ENTER).perform();

        //assert playlist appeared
        WebElement playListCreated = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        Assert.assertTrue(playListCreated.isDisplayed());
    }

    @Test
    public void deletePlayListTest() {
        login("dsalina1984@gmail.com", "Qazxsw123@Qazxsw123@");

        //navigate playlist
        WebElement navigatePlayList = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        new Actions(driver)
                .contextClick(navigatePlayList)
                .perform();
        //right click playlist
        WebElement rightClickPlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        new Actions(driver)
                .contextClick(rightClickPlaylist)
                .perform();
        //navigate delete button
        WebElement navigateDeleteButton = driver.findElement(By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]"));
        new Actions(driver)
                .clickAndHold(navigateDeleteButton)
                .perform();
        //click delete button
        WebElement clickable = driver.findElement(By.xpath(".//*[@class='menu playlist-item-menu']//li[contains (text(), 'Delete')]"));
        new Actions(driver)
                .click(clickable)
                .perform();
        //assert playlist deleted
        WebElement playListDeleted = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(playListDeleted.isDisplayed());
    }
}
