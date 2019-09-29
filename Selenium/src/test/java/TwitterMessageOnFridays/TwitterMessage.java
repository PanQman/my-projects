package TwitterMessageOnFridays;

import PageObejcts.Twitter.Twitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Common.Actions.clickElement;
import static Common.Actions.enterText;
import static Common.Waits.pauseTest;
import static Common.Waits.waitUntilElementIsVisible;
import static org.testng.Assert.assertTrue;

public class TwitterMessage {

    private WebDriver driver;
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
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, Twitter.class);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://twitter.com/login");
        //krok1PrzejscieDoStronyLogowania();
        krok2Logowanie();
        krok3PrzejscieDoProfilu();
        krok4OtwarcieOknaTweeta();
        krok5UtworzTweet();
        krok6UsunTweet();
        krok7PotwierdzUsuniecie();
    }

    private void krok1PrzejscieDoStronyLogowania(){
        if (waitUntilElementIsVisible(driver, Twitter.buttonToLoginPage, 10) != null){
            clickElement(Twitter.buttonToLoginPage);
        } else System.out.println("Nie udało się załadować strony Twitter.com");
    }

    private void krok2Logowanie(){
        if (waitUntilElementIsVisible(driver, Twitter.loginTextField, 10) != null){
            enterText(Twitter.loginTextField, "Login");
            enterText(Twitter.passwordTextField, "Haslo");
            clickElement(Twitter.loginButton);
        } else System.out.println("Nie udało się załadować strony logowania");
    }

    private void krok3PrzejscieDoProfilu(){
        if (waitUntilElementIsVisible(driver, Twitter.profilButton, 10) != null){
            clickElement(Twitter.profilButton);
        } else System.out.println("Nie udało się zalogować");
    }

    private void krok4OtwarcieOknaTweeta(){
        if (waitUntilElementIsVisible(driver, Twitter.createTweet, 10) != null){
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
        pauseTest(3);
        if (waitUntilElementIsVisible(driver, Twitter.firstTweetOptions, 10) != null){
            clickElement(Twitter.firstTweetOptions);
            clickElement(Twitter.deleleTweet);
            clickElement(Twitter.confirmDeleteTweet);
        } else System.out.println("Błąd w znalezieniu tweeta!");
    }

    private void krok7PotwierdzUsuniecie(){
        if (waitUntilElementIsVisible(driver, Twitter.popupDeletedTweet, 30) != null){
            System.out.println("Test pozytywny");
        } else System.out.println("Nie znaleziono komunikatu o usunięciu tweeta");
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
