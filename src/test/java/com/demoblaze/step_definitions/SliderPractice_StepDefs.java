package com.demoblaze.step_definitions;

import com.demoblaze.Pages.PracticePage;
import com.demoblaze.Utilities.ConfigurationReader;
import com.demoblaze.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SliderPractice_StepDefs {
    PracticePage practicePage = new PracticePage();
    int actualValue;
    @Given("the user is on the demoqa slider page")
    public void the_user_is_on_the_demoqa_slider_page() {

        Driver.get().get(ConfigurationReader.get("urlPractice"));


    }

    @Then("the user verify that default slider is {int}")
    public void the_user_verify_that_default_slider_is(int expectedValue) {
        System.out.println("practicePage.sliderValue.getAttribute(\"value\") = " + practicePage.sliderValue.getAttribute("value"));
        actualValue = Integer.parseInt(practicePage.sliderValue.getAttribute("value"));
        Assert.assertEquals(expectedValue,actualValue);

    }

    @When("the user slides the slider")
    public void the_user_slides_the_slider() {
        WebElement slider= Driver.get().findElement(By.xpath("//input[@type='range']"));

        for (int i=0; i<60 ; i++){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        for(int i=60; i>20; i--){
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        actualValue=Integer.valueOf(slider.getAttribute("value"));

    }

    @Then("the user verify that slider is {int}")
    public void the_user_verify_that_slider_is(int expectedValue) {
        Assert.assertEquals(expectedValue,actualValue);

    }


}
