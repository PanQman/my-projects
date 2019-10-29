package TwitterMessageOnFridays;

import Configurations.BrowserOptions.initLocalDriver;
import Configurations.BrowserType;
import PageObejcts.Twitter.Twitter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Common.CommonActions.*;
import static Common.Waits.waitUntilElementIsClickable;
import static Common.Waits.waitUntilElementIsVisible;
import static Configurations.BrowserOptions.initLocalDriver.getTypeOfBrowser;

public class TwitterMessage {

    private static WebDriver driver;
    private static BrowserType browserType;

    String message = "Today is Friday, so..";
       /*     "       ✨\n" +
            "✨    DON'T  ✨\n" +
            "     ✨\n" +
            "   ✨ PUSH  ✨\n" +
            "✨        ✨\n" +
            "  ✨  TO   ✨\n" +
            "      ✨\n" +
            "✨ PRODUCTION ✨\n" +
            "    ✨\n" +
            "         ";*/

    @BeforeMethod
    public void initalizeWebElements(){
        if (browserType == null){
            browserType = getTypeOfBrowser();
            driver = new initLocalDriver(browserType).getBrowser();
        } else {
            driver = new initLocalDriver(browserType).getBrowser();
        }
        driver.manage().window().maximize();


        PageFactory.initElements(driver, Twitter.class);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        if (!getTypeOfBrowser().equals(BrowserType.FIREFOX)){
            driver.quit();
        }
    }

    @Test
    public void myFirstTest() {
        navigateToURL("http://twitter.com/login");
        krok2Logowanie();
        krok3PrzejscieDoProfilu();
        krok4OtwarcieOknaTweeta();
        krok5UtworzTweet();
        krok6UsunTweet();
        krok7PotwierdzUsuniecie();
    }


    private void krok2Logowanie(){
        if (waitUntilElementIsVisible(driver, Twitter.loginTextField, 10) != null){
            enterText(Twitter.loginTextField, "_Adamq12");
            enterText(Twitter.passwordTextField, "5084c151");
            clickElement(Twitter.loginButton);
        } else System.out.println("Nie udało się załadować strony logowania");
    }

    private void krok3PrzejscieDoProfilu(){
        if (waitUntilElementIsVisible(driver, Twitter.profilButton, 10) != null){
            clickElement(Twitter.profilButton);
        } else System.out.println("Nie udało się zalogować");
    }

    private void krok4OtwarcieOknaTweeta(){
        if (waitUntilElementIsClickable(driver, Twitter.createTweet, 10) != null){
            clickElement(Twitter.createTweet);
        } else System.out.println("Nie udało się załadować strony profilu");
    }

    private void krok5UtworzTweet(){
        if (waitUntilElementIsVisible(driver, Twitter.tweetTextField, 10) != null){
            enterText(Twitter.tweetTextField, message);
            clickElement(Twitter.tweetButton);
        } else System.out.println("Nie udało się otworzyć okna napisania tweeta");
    }

    private void krok6UsunTweet(){
        if (waitUntilElementIsVisible(driver, Twitter.firstTweetOptions, 10) != null){
            clickElement(Twitter.firstTweetOptions);
            clickElement(Twitter.deleleTweet);
        } else System.out.println("Błąd w znalezieniu tweeta!");

        if (waitUntilElementIsVisible(driver, Twitter.confirmDeleteTweet, 10) != null){
            clickElement(Twitter.confirmDeleteTweet);
        } else System.out.println("Błąd podczas usunięcia tweeta");
    }

    private void krok7PotwierdzUsuniecie(){
        if (waitUntilElementIsVisible(driver, Twitter.popupDeletedTweet, 30) != null){
            System.out.println("Test pozytywny");
        } else System.out.println("Nie znaleziono komunikatu o usunięciu tweeta");
    }

}
