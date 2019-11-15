package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;


public class Waits {

    //Oczekiwanie na pojawienie się elementu o podanym lokatorze
    public static WebElement waitUntilElementPresent(WebDriver driver, By by, int seconds){
        WebElement element;
        try {
            element = new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (NoSuchElementException | TimeoutException e){
            return null;
        }
        return element;
    }

    //Oczekiwanie aż element o podanym lokatorze będzie widoczny
    public static WebElement waitUntilElementIsVisible(WebDriver driver, WebElement element, int seconds){
        if (element == null){
            System.out.println("Cannot wait for visibility of null element");
            return null;
        }
        WebElement visibleElement;
        try {
            visibleElement = new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException e){
            return null;
        }
        return visibleElement;
    }

    public static WebElement waitUntilElementIsClickable(WebDriver driver, WebElement element, int seconds){
        if (element == null){
            System.out.println("Cannot wait for visibility of null element");
            return null;
        }
        WebElement clickableElement;
        try {
            clickableElement= new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException | TimeoutException e){
            return null;
        }
        return clickableElement;
    }



    //Oczekiwanie aż element o podanym lokatorze zniknie
    public static boolean waitUntilElementDissapear(WebDriver driver, WebElement element, int seconds){
        if (element == null){
            System.out.println("Cannot wait for dissepear of null element");
            return false;
        }
        boolean isDissapear;
        try {
            isDissapear = new WebDriverWait(driver, seconds)
                    .until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e){
            return false;
        }
        return isDissapear;
    }



    //Zatrzymaj test
    public static void pauseTest(int seconds){
        try {
            seconds = seconds * 1000;
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
