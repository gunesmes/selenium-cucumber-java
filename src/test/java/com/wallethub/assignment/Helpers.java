package com.wallethub.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mesutgunes on 05/07/17.
 */
public class Helpers{
    static public void waitSelectorVisible(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    static public void waitSelectorInVisible(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }
}

