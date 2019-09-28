package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Actions {

    //Kliknięcie w element o podanym lokatorze

    public static void clickElement(WebElement element){
        if (!element.isEnabled()){
            System.out.println("Element jest wyłączony");
        }
        if (element.isDisplayed()){
            Waits.pauseTest(1);
            element.click();
        }

    }

    //przewiń do WebElementu
    public static void scrollTo(WebElement element, WebDriver driver){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true):", element);
    }

    //Wpisz tekst
    public static void enterText(WebElement element, String text){
        if (element.isDisplayed() & element.isEnabled()){
            element.clear();
            Waits.pauseTest(1);
        element.sendKeys(text);
        } else {
            System.out.println("Pole tekstowe jest niedostępne");
            return;
        }
        if (!element.getText().equals(text.trim())){
            System.out.println("Nie wpisano tekstu w pole tekstowe");
        }
    }


}
