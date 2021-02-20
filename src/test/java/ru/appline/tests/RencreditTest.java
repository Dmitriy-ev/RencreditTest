package ru.appline.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.appline.baseclass.BaseTest;

import io.qameta.allure.junit4.DisplayName;

@RunWith(Parameterized.class)
public class RencreditTest extends BaseTest{

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
			{"Вклады", "RUB", "300000", "6 месяцев", "50000", true, "9 132,17", "250000", "55 9132,17"},
            {"Вклады", "USD", "500000", "12 месяцев", "70000", true, "1 003,59", "330000", "831 003,59"}
		});
	}
	
	@Parameterized.Parameter(0)
    public String menuName;
    @Parameterized.Parameter(1)
    public String nameCurrency;
    @Parameterized.Parameter(2)
    public String nameSum;
    @Parameterized.Parameter(3)
    public String deadline;
    @Parameterized.Parameter(4)
    public String deposit;
    @Parameterized.Parameter(5)
    public Boolean capitalization;
    @Parameterized.Parameter(6)
    public String parcent;
    @Parameterized.Parameter(7)
    public String replenish;
    @Parameterized.Parameter(8)
    public String rezult;
    
    @Test
    @DisplayName("Оформление вклада")
    public void startTest() {
    	
    	app.getStartPage()
    	.selectService(menuName)
        .selectionsCurrency(nameCurrency)
        .selectionsItems("Сумма вклада", nameSum)
        .selectionsItems("На срок", deadline)
        .selectionsItems("Ежемесячное пополнение", deposit)
        .selectionsMark("Ежемесячная капитализация", capitalization)
        .checkParcent(parcent)
        .checkReplenish(replenish)
        .checkResult(rezult);
    	
    }
	
}
