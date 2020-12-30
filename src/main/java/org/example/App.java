package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class App {

    public static WebDriver driver;
    private static String website = "https://www.diary.ru";
    private static String login1 = "koryapinig";
    private static String password = "aoses2cx";



    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        return driver;
    }

    public static void main(String[] args)  {
        getDriver();
        test1(driver);
        test2(driver);
        driver.quit();
    }

    private static void test1(WebDriver driver) {
        driver.get(website);
        System.out.println("Page title is: " + driver.getTitle());
        WebElement input = driver.findElement(By.id("drop-login"));
        input.click();
        WebElement login = driver.findElement(By.id("usrlog2"));
        login.click();
        login.sendKeys(login1);
        WebElement passw = driver.findElement(By.id("usrpass2"));
        passw.click();
        passw.sendKeys(password);
        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/button"));
        input1.click();
        WebElement check1 = driver.findElement(By.linkText("koryapinig"));
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(check1));
        WebElement drop = driver.findElement(By.id("drop"));
        drop.click();
        WebElement exit = driver.findElement(By.linkText("Выход"));
        exit.click();

    }

    private static void test2(WebDriver driver) {
        driver.get(website);
        System.out.println("Page title is: " + driver.getTitle());
        WebElement input = driver.findElement(By.id("drop-login"));
        input.click();
        WebElement login = driver.findElement(By.id("usrlog2"));
        login.sendKeys(login1);
        WebElement passw = driver.findElement(By.id("usrpass2"));
        passw.click();
        passw.sendKeys(password);
        WebElement input1 = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/button"));
        input1.click();
        WebElement check1 = driver.findElement(By.linkText("koryapinig"));
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(check1));
        WebElement newrecord = driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/ul[2]/li[2]/a"));
        newrecord.click();
//        WebElement check2 = driver.findElement(By.linkText("тесттесттест"));
//        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(check2));
        WebElement title = driver.findElement(By.id("postTitle"));
        title.click();
        title.sendKeys("AutoTestWeb");
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        msg.click();
        msg.sendKeys("Auto test #2 OK");
        WebElement save = driver.findElement(By.id("rewrite"));
        save.click();
        WebElement drop = driver.findElement(By.id("drop"));
        drop.click();
        WebElement exit = driver.findElement(By.linkText("Выход"));
        exit.click();
        driver.quit();
    }
}
