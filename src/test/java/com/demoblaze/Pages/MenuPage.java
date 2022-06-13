package com.demoblaze.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuPage extends BasePage {
    @FindBy(xpath = "//a[@id='itemc']")
    public List<WebElement> menuList_loc;

    @FindBy(xpath = "//a[normalize-space()='Sony vaio i5']")
    public WebElement laptop_loc;

    public void verifyMenuList_Method(String menu1, String menu2, String menu3) {

        Assert.assertEquals(menu1, menuList_loc.get(0).getText());
        Assert.assertEquals(menu2, menuList_loc.get(1).getText());
        Assert.assertEquals(menu3, menuList_loc.get(2).getText());

    }
}
