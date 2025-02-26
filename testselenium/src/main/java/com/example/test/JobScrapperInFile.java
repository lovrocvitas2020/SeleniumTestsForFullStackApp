package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobScrapperInFile {


    
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
            driver.get("https://mojposao.hr");
            System.out.println("Step 1: search moj posao IT");

            // Maximize the browser window
            driver.manage().window().maximize();

            ///html/body/div[1]/div/div[2]/div[2]/div/div/div/button/span/span
            WebElement cookiesbutton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/button/span/span"));
            cookiesbutton.click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

               JavascriptExecutor js = (JavascriptExecutor) driver;
                                                  
                // Enter start hour   document.querySelector("#__nuxt > div > div.page.mp-box.mp-box--shade-50.page > div.page__content > div > div.searchbar > div > div.searchbar__select-location.searchbar__select-location--active.mp-box.searchbar__select-location.searchbar__select-location--active > span > span > div > span > div > div")
                WebElement elementSearch = (WebElement) js.executeScript("document.querySelector(\"#__nuxt > div > div.page.mp-box.mp-box--shade-50.page > div.page__content > div > div.searchbar > div > div.searchbar__select-location.searchbar__select-location--active.mp-box.searchbar__select-location.searchbar__select-location--active > span > span > div > span > div > div\")");
                elementSearch.click();
                elementSearch.sendKeys("Zagreb");
         
          
        
            
            try {
                Thread.sleep(15000);
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

