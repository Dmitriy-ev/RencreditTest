package ru.appline.baseclass;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.managers.InitManager;
import ru.appline.managers.ManagerPages;
import ru.appline.managers.TestPropManager;

import static ru.appline.managers.DriverManager.getDriver;
import static ru.appline.utils.MyAllureListener.addScreenshot;
import static ru.appline.utils.PropConst.APP_URL;

public class BaseTest {

    protected ManagerPages app = ManagerPages.getManagerPages();

    @BeforeClass
    public static void beforeAll(){
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        getDriver().get(TestPropManager.getTestPropManager().getProperty(APP_URL));
    }

    @AfterClass
    public static void afterEach() {
        addScreenshot();
        InitManager.quitFramework();
    }

}
