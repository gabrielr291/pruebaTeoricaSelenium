package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    static WebDriver driver;
    @BeforeAll
    static void initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //Crea el objeto del driver.
        driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximizar la ventana
        driver.manage().window().maximize();
    }

    @Test
    public void holamundo(){
        System.out.println("Hola mundo");
        assertTrue(true);
    }
    @Test
    public void testGoogleSearch(){
        //Obtiene una URL, navega al sitio.
        driver.get("https://www.google.cl/");

        //Buscar un texto:
        WebElement searchBox= driver.findElement(By.id("APjFqb"));
        String busqueda= "Gato";
        searchBox.sendKeys(busqueda);

        //DAR CLICK AL BUTTON
        WebElement buttonSearch= driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > " +
                "div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div.lJ9FBc > center > input.gNO89b"));
        buttonSearch.click();

        //validar si funciono
        WebElement titleSearchedPage= driver.findElement(By.id("APjFqb"));
        assertEquals(titleSearchedPage.getText(), "Gato");
    }

    @AfterAll
    static void closeDriver(){
        driver.close();
        driver.quit();
    }

}