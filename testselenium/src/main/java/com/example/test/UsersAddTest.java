package com.example.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  This test is used to add new user
 * 
 */
public class UsersAddTest {

    public static void main(String[] args) {
      

        System.out.println("UsersAddTest Start");

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
            username.sendKeys("admin17006");
            username.submit();

            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            password.sendKeys("admin17006");
            password.submit();      
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            WebElement buttonAdd = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/div/a[1]"));
            buttonAdd.click();
            System.out.println("Step 3: Click on  add user");
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
            String formattedDate = now.format(formatter).concat("admin");
            System.out.println("Generated Date Number: " + formattedDate);
       
            WebElement fieldName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[1]/input"));
            fieldName.sendKeys(formattedDate);
           
            WebElement fieldUsername = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[2]/input"));
            fieldUsername.sendKeys(formattedDate);

            WebElement fieldEmailAddress = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[3]/input"));
            fieldEmailAddress.sendKeys(formattedDate.concat("@mail.com"));
        

            WebElement fieldPassword = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[4]/input"));
            fieldPassword.sendKeys(formattedDate);
          

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement buttonConfirm = driver.findElement(By.xpath("html/body/div/div/div[2]/div/div/form/button"));
            buttonConfirm.click();

            System.out.println("Step 4: Fill fields and click confirm");
         



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
