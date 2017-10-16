package support;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class DriverQA {

    private WebDriver driver;

    public void start(String parBrowser){
        switch (parBrowser) {
            case "firefox":
                FirefoxDriverManager.getInstance().setup();
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
                break;
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                DesiredCapabilities capabilitiesC = DesiredCapabilities.chrome();
                capabilitiesC.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
                driver = new ChromeDriver(capabilitiesC);
                break;
            default:
                break;
        }
    }

    private WebElement findElem(String parValue, String... parType){
        String sel_type = "";
        String param2 = "";
        WebElement element = null;
        if (parType.length == 0) { param2 = "id"; }
        else { param2 = parType[0];}
        try {
            switch (param2) {
                case "id":
                    element = driver.findElement(By.id(parValue));
                    break;
                case "name":
                    element = driver.findElement(By.name(parValue));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(parValue));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(parValue));
                    break;
                case "link":
                    element = driver.findElement(By.linkText(parValue));
                    break;
            }
        }
        catch (NoSuchElementException e)
        { element = null; }
        return element;
    }

    public void click(String parValue, String... parType){
        WebElement element = findElem(parValue, parType);
        element.click();
    }

    public void openURL(String parUrl){
        driver.get(parUrl);
    }

    public void quit(){
        driver.quit();
    }

    public void close(){
        driver.close();
    }

    public void sendKeys(String parText, String parName, String... parType){
        WebElement element = findElem(parName, parType);
        element.clear();
        element.sendKeys(parText);
    }

    public String getText(String parValue, String... parType){
        WebElement element = findElem(parValue, parType);
        return element.getText();
    }

    public void selectByIndex(Integer parIndex, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(parIndex);
    }

    public void selectByText(String parText, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(parText);
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void waitElementAll(String parName, String... parType){
        WebElement element = findElem(parName, parType);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String param2 = "";
        if (parType.length == 0) { param2 = "id"; }
        else { param2 = parType[0];}
        try {
            switch (param2) {
                case "id":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parName)));
                    break;
                case "name":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(parName)));
                    break;
                case "css":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parName)));
                    break;
                case "xpath":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parName)));
                    break;
                case "link":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(parName)));
                    break;
            }
        }
        catch (NoSuchElementException e)
        { System.out.println("ERROR WAIT => " + e.toString()); }
    }

    public void waitElement(String parId){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parId)));
    }

    public void waitElementCSS(String parCss){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parCss)));
    }

    public void waitElementXP(String parXp){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parXp)));
    }

    public void switchTo(String... parValue){
        if (parValue.length == 0 ) {
            driver.switchTo().defaultContent();
        }
        else{
            driver.switchTo().window(String.valueOf(parValue));
        }
    }

    public void  ChooseOkOnNextConfirmation(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void  ChooseCancelOnNextConfirmation(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
