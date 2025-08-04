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

public class AddProjecttest {

    
    public static void main(String[] args) {

          System.out.println("AddProjectTest START");

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

            // /html/body/div/div/div[2]/div[2]/div/div[1]/div/a[5]
            WebElement buttonParametrization = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[1]/div/a[5]"));
            buttonParametrization.click();
            System.out.println("Step 3: Click on parametrization");
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

              // /html/body/div/div/div[2]/nav/ul/li[1]/a
              WebElement buttonViewProjects = driver.findElement(By.xpath("/html/body/div/div/div[2]/nav/ul/li[1]/a"));
              buttonViewProjects.click();
              System.out.println("Step 3: Click on View Projects");
              
              try {
                  Thread.sleep(5000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }



            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
            String formattedDate = now.format(formatter).concat("admin");
            System.out.println("Generated Date Number: " + formattedDate);
       
            WebElement fieldProjectName = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/input"));
            fieldProjectName.sendKeys(formattedDate.concat("project"));
           
            WebElement fieldDescription = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/textarea"));
            fieldDescription.sendKeys("Project description");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement elementStartDateXpath = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[3]/input"));
            elementStartDateXpath.sendKeys("01.02.2025");

            WebElement elementEndDateXpath = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[4]/input"));
            elementEndDateXpath.sendKeys("01.03.2025");
          

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement buttonAddProject = driver.findElement(By.xpath("/html/body/div/div/div[2]/form/button"));
            buttonAddProject.click();

            System.out.println("Step 4: Fill fields and click add project");
         



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
