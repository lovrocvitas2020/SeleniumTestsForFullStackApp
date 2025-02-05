package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *  This test is used to add new worklog
 * 
 * 
 */
public class WorklogAddTest {

    
    public static void main(String[] args) {

    
        System.out.println("WorklogAddTest Start");

        // Set the path to the chromedriver executable
        String driverPath = System.getProperty("user.dir") + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Set up explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);


        try {

            // Step 1: 
            driver.get("http://localhost:3000");
            System.out.println("Step 1: localhost:3000");

            // Maximize the browser window
            driver.manage().window().maximize();

            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            username.sendKeys("admin700");
            username.submit();

            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            password.sendKeys("admin700");
            password.submit();      
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement buttonAdd = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/a[4]"));
            buttonAdd.click();
            System.out.println("Step 2: Click on  View Worklog");
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


               WebElement selectUser = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/form/div[1]/select"));
               selectUser.click();
               selectUser.sendKeys("lovro");
               selectUser.click();
               System.out.println("Step 3: Click User and enter lovro");
               
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

                   // Locate the date input field   
                    WebElement dateField = driver.findElement(By.cssSelector("input.form-control[type='date']"));
                    dateField.click();
                    dateField.sendKeys("05-02-2025");

                    System.out.println("Step 4: Enter Date field");
                   
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                                                  
                // Enter start hour 
                WebElement elementStartHour = (WebElement) js.executeScript("return document.querySelector('#root > div > div.container.mt-4 > div.card.shadow.p-4 > form > div.row > div:nth-child(1) > input')");
                elementStartHour.sendKeys("07-00");
                // Enter end hour  
                WebElement elementEndHour = (WebElement) js.executeScript("return document.querySelector('#root > div > div.container.mt-4 > div.card.shadow.p-4 > form > div.row > div:nth-child(2) > input')");
                elementEndHour.sendKeys("15-00");

                System.out.println("Step 5: Enter hour elements");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Enter Work description
                WebElement fieldDescription = driver.findElement(By.cssSelector("#root > div > div.container.mt-4 > div.card.shadow.p-4 > form > div:nth-child(4) > input"));
                fieldDescription.click();
                fieldDescription.sendKeys("Description");

                System.out.println("Step 6: Enter description");
                
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                WebElement button = (WebElement) js.executeScript("return document.querySelector('#root > div > div.container.mt-4 > div.card.shadow.p-4 > form > button')");

                if (button != null) {
                    js.executeScript("arguments[0].click();", button);
                    System.out.println("Button clicked successfully!");
                } else {
                    System.out.println("Button not found!");
                }
           

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

          
            
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    
    }

}
