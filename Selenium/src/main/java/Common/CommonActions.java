package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static Configurations.BrowserOptions.initLocalDriver.driver;
import static Common.Waits.pauseTest;

public class CommonActions {

    //Przejdź do strony url
    public static void navigateToURL(String url){
        driver.get(url);
    }

    public static void clickElement(WebElement element){
        clickElement(element, true);
    }

    //Kliknięcie w element o podanym lokatorze
    public static void clickElement(WebElement element, boolean needScrollToElement){
        if (!element.isEnabled()){
            System.out.println("Element jest wyłączony");
        }
        if (needScrollToElement){
            scrollToElement(element);
        }
        if (element.isDisplayed()){
            element.click();
        }

    }

    //Wpisz tekst
    public static void enterText(WebElement element, String text){
        if (element.isDisplayed() & element.isEnabled()){
            element.clear();
            pauseTest(1);
        element.sendKeys(text);
        } else {
            System.out.println("Pole tekstowe jest niedostępne");
            return;
        }
        if (!element.getText().equals(text.trim())){
            System.out.println("Wpisano tekst '" + element.getText());
        }
    }

    //Kliknięcie w elementy typu Checkbox
    public static void clickCheckbox(WebElement element){

        if (element.isDisplayed()){
            boolean isChecked = element.getAttribute("checked").equals("true");
            element.click();
            Waits.pauseTest(1);
        }

    }

    //przewiń do WebElementu
    public static void scrollToElement(WebElement element){
        if (!element.isDisplayed()){
            executeJavascript("arguments[0].scrollIntoView(true):", element);
        }
    }

    //Uruchom podany Javascript
    public static Object executeJavascript(String script, WebElement element){
        return ((JavascriptExecutor) driver).executeScript(script, element);
    }

}
