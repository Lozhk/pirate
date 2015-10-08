package com.retrotax.test.web.tests;

import com.retrotax.test.web.tests.abstracttests.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class LastNameCompleteTest extends AbstractTest {

    @Override
    public String getTestName() {
        return "LastNameCompleteTest";
    }

    @Override
    public void test() {
        driver.get(PAGE_URL);

        driver.findElement(By.xpath("//button[@id=\"retrotax_plugin_trigger\"]")).click();

        WebDriverWait wait_iframe = new WebDriverWait(driver, 20);
        wait_iframe.until(ExpectedConditions.visibilityOfElementLocated(By.id("_bftn_iframe")));
        driver.switchTo().frame("_bftn_iframe");

        driver.findElement(By.xpath("//input[@name='lastname']")).click();

        assertEquals("Last Name is required",
                     driver.findElement(By.cssSelector("input[name='lastname'] ~ .hint")).getText());
        assertTrue(driver.findElement(By.cssSelector("input[name='lastname'] ~ .hint")).isDisplayed());

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("A");
        assertEquals("A", driver.findElement(By.xpath("//input[@name='lastname']")).getAttribute("value"));

        try {
            assertEquals("", driver.findElement(By.cssSelector("input[name='lastname'] ~ .hint")).getText());
        } catch (NoSuchElementException e) {}
    }
}
