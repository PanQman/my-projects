package PageObejcts.Twitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Twitter {

    //Login
    @FindBy(className = "StaticLoggedOutHomePage-input")
    public static WebElement buttonToLoginPage;

    @FindBy(className = "js-username-field")
    public static WebElement loginTextField;

    @FindBy(className = "js-password-field")
    public static WebElement passwordTextField;

    @FindBy(className = "EdgeButtom--medium")
    public static WebElement loginButton;

    //Create tweet
    @FindBy(css = "[data-testid='SideNav_NewTweet_Button']")
    public static WebElement createTweet;

    @FindBy(className = "public-DraftEditor-content")
    public static WebElement tweetTextField;

    @FindBy(css = "[data-testid='tweetButton']")
    public static WebElement tweetButton;

    //Delete tweet

    @FindBy(css = "[aria-label='Profil']")
    public static WebElement profilButton;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n r-18u37iz r-1h0z5md r-1joea0r']//div)[1]")
    public static WebElement firstTweetOptions;

    @FindBy(xpath = "//div[@role='menuitem'][1]")
    public static WebElement deleleTweet;

    @FindBy(css = "[data-testid='confirmationSheetConfirm']")
    public static WebElement confirmDeleteTweet;

    @FindBy(xpath = "//span[text()='Twój Tweet został usunięty']")
    public static WebElement popupDeletedTweet;


}
