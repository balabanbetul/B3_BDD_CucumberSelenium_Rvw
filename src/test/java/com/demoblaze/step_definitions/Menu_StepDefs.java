package com.demoblaze.step_definitions;

import com.demoblaze.Pages.MenuPage;
import com.demoblaze.Utilities.BrowserUtils;
import com.demoblaze.Utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Menu_StepDefs {
    MenuPage menuPage= new MenuPage();
    String laptopName;
    @Then("verify {string} {string} {string} in categories Menu")
    public void verify_in_categories_Menu(String menu1, String menu2, String menu3) {
      menuPage.verifyMenuList_Method(menu1,menu2, menu3);
    }

    @Then("the user able to see following categories")
    public void theUserAbleToSeeFollowingCategories(List<String> expectedList) {
        List<String> actualList=  BrowserUtils.getElementsText(menuPage.menuList_loc);
        Assert.assertEquals("List does NOT MATCH",expectedList,actualList);

    }


    @And("the user get laptops name")
    public void theUserGetLaptopsName() {
        laptopName= menuPage.laptop_loc.getText();
    }

    @Then("the compiler adds laptops name tothe Configuration properties")
    public void theCompilerAddsLaptopsNameTotheConfigurationProperties() {
        ConfigurationReader.set("LaptopName",laptopName);
    }
}
