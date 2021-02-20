package ru.appline.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//div[@class='service__title']")
    private List<WebElement> serviceButton;

    @Step("Переход в главное меню и выбор вкладки '{name}'")
    public CalculatorPage selectService(String name) {
        for (WebElement webElement : serviceButton) {
            if (webElement.getText().contains(name)) {
                wait.until(ExpectedConditions.visibilityOf(webElement));
                scrollToElementJs(webElement);
                webElement.click();
                return app.getCalculatorPage();
            }
        }
        Assert.fail("Подменю " + name + " не было найдено на стартовой странице!");
        return app.getCalculatorPage();
    }
}
