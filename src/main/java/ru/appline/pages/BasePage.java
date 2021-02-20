package ru.appline.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.managers.ManagerPages;

import static ru.appline.managers.DriverManager.getDriver;

public class BasePage {



    protected ManagerPages app = ManagerPages.getManagerPages();


    protected Actions action = new Actions(getDriver());


    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();


    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);


    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }


    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected WebElement elementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement elementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void scrollWithOffset(WebElement element, int x, int y) {
        String code = "window.scroll(" + (element.getLocation().x + x) + ","
                + (element.getLocation().y + y) + ");";
        ((JavascriptExecutor) getDriver()).executeScript(code, element, x, y);
    }

    protected void fillInputField(WebElement field, String value){
        elementToBeClickable(field);
        field.sendKeys(value);
    }


}
