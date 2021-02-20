package ru.appline.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalculatorPage extends BasePage {

    @FindBy(xpath = "//label[@class='calculator__currency-field']")
    List<WebElement> currencyList;

    @FindBy(xpath = "//div[@class='calculator__slide-section']")
    List<WebElement> pointContributionList;

    @FindBy(xpath = "//label[@class='calculator__check-block']")
    List<WebElement> markList;

    @FindBy(xpath = "//div[@class='calculator__result-block']//td[contains(text(),'Начислено')]/..//span[@class='js-calc-earned']")
    WebElement parcent;

    @FindBy(xpath = "//div[@class='calculator__result-block']//td[contains(text(),'Пополнение')]/..//span[@class='js-calc-replenish']")
    WebElement replenish;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement result;

    @Step("Выбераем валюту '{name}'")
    public CalculatorPage selectionsCurrency(String name) {
        for (WebElement webElement : currencyList) {
            if (webElement.findElement(By.xpath(".//input")).getAttribute("value").equals(name)) {
                WebElement currencyBtn = webElement.findElement(By.xpath(".//span"));
                currencyBtn.click();
                return this;
            }
        }
        Assert.fail("Валюта не выбрана");
        return this;
    }

    @Step("Выбираем дополнительные условия '{name}'")
    public CalculatorPage selectionsItems(String name, String value) {
        WebElement element;
        for (WebElement webElement : pointContributionList) {
            element = webElement.findElement(By.xpath(".//label"));
            if (element.getText().contains(name)) {
                if (element.getText().equals("На срок")) {
                    WebElement timeDeposit = webElement.findElement(By.xpath(".//select"));
                    Select select = new Select(timeDeposit);
                    select.selectByVisibleText(value);
                } else {
                    WebElement itmsBtn = webElement.findElement(By.xpath(".//input"));
                    scrollWithOffset(itmsBtn, 0, 400);
                    fillInputField(itmsBtn, value);
                }
                return this;
            }
        }
        Assert.fail("Не выбраны дополнительные условия");
        return this;
    }

    @Step("Ставим галочки на дополнительных пунктах '{name}'")
    public CalculatorPage selectionsMark(String name, Boolean value) {
        for (WebElement webElement : markList) {
            if (webElement.findElement(By.xpath(".//span[@class='calculator__check-text']")).getText().contains(name)) {
                WebElement element = webElement.findElement(By.xpath(".//span//div"));
                if (element.getAttribute("class").contains("checked") != value)
                    element.click();
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(parcent,parcent.getText())));
                return this;
            }
        }
        return this;
    }

    @Step("Проверяем поле \"Начисленно\"")
    public CalculatorPage checkParcent(String value) {
        scrollWithOffset(parcent, 0, -400);
        Assert.assertEquals("Значение \"Начислено\" не соответствует ожидаемому", parcent.getText().replaceAll("\\D", ""), value.replaceAll("\\D", ""));
        return this;
    }

    @Step("Проверяем поле \"Пополнение\"")
    public CalculatorPage checkReplenish(String value) {
        Assert.assertEquals("Значение \"Пополнение\" не соответствует ожидаемомоу", replenish.getText().replaceAll("\\D", ""), value.replaceAll("\\D", ""));
        return this;
    }

    @Step("Проверяем поле \"К снятию\"")
    public  CalculatorPage checkResult(String value){
        Assert.assertEquals("Значение \"К снятию\" не соответствует ожидаемомоу", result.getText().replaceAll("\\D",""), value.replaceAll("\\D", ""));
        return this;
    }


}
