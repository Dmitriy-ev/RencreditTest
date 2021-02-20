package ru.appline.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.managers.DriverManager;


public class MyAllureListener  extends AllureJunit4 {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
