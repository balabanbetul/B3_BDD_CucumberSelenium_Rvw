package com.demoblaze.Pages;

import com.demoblaze.Utilities.BrowserUtils;
import com.demoblaze.Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
@FindBy(xpath = "//a[.='Add to cart']")
public WebElement addCart;

@FindBy (xpath = "(//a[@class='nav-link'])[1]")
public WebElement homeLink_loc;

    public void addProduct_Method(String category, String product){
        WebElement categoryElm= Driver.get().findElement(By.xpath("//*[.='"+category+"']"));
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForClickablility(categoryElm,3).click();
        BrowserUtils.waitFor(2);
        WebElement productElm=Driver.get().findElement(By.xpath("//a[.='"+product+"']"));
        BrowserUtils.waitForClickablility(productElm,3).click();
        BrowserUtils.waitFor(1);
        addCart.click();
        BrowserUtils.waitFor(3);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();
        homeLink_loc.click();


    }
}
