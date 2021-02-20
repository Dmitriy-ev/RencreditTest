package ru.appline.managers;

import ru.appline.pages.CalculatorPage;
import ru.appline.pages.StartPage;

public class ManagerPages {

    private static ManagerPages managerPages;

    StartPage startPage;
    CalculatorPage calculatorPage;

    private ManagerPages() {

    }

    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public CalculatorPage getCalculatorPage() {
        if (calculatorPage == null) {
            calculatorPage = new CalculatorPage();
        }
        return calculatorPage;
    }
}
