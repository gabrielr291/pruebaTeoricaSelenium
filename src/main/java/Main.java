import org.example.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {
    public static void main(String[] args){
        System.out.println("hola mundo");
        DriverSingleton driverSingleton = DriverSingleton.getInstance("Chrome");
        WebDriver driver = driverSingleton.getDriver();

        driver.get("https://www.google.cl/");
        //Para escribir texto:
        WebElement searchBox=  driver.findElement(By.id("APjFqb"));
        String busqueda="mafia";
        searchBox.sendKeys(busqueda); //permite mandar texto a un input

        //click search button
        WebElement searchButton= driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div.lJ9FBc > center > input.gNO89b"));
        searchButton.click();
        driverSingleton.closeDriver();
    }
}
