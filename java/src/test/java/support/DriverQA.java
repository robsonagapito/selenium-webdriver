package support;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DriverQA {

    private static WebDriver driver;

    public WebDriver getSelenium() {
        return driver;
    }

    public void start(String parBrowser){
        String title = "";
        try{
            title = driver.getTitle();
        } catch (Exception e){
            title = "ERROR";
        }
        if (title.equals("ERROR")) {
            switch (parBrowser) {
                case "firefox":
                    FirefoxDriverManager.getInstance().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addPreference(FirefoxDriver.MARIONETTE, true);
                    driver = new FirefoxDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                case "chrome":
//                    ChromeDriverManager.getInstance().setup();
                    ChromeOptions optionsC = new ChromeOptions();
                    // hides the info message that says chrome is being controlled by automated test software
                    optionsC.addArguments(Arrays.asList(
                            "disable-infobars", "ignore-certificate-errors",
                            "start-maximized"));
                    driver = new ChromeDriver(optionsC);
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    break;
                default:
                    break;
            }
        }
    }

    private String getAttributeType (String... parType){
        String type;
        if (parType.length == 0) { type = "id"; }
        else { type = parType[0];}
        return type;
    }
    private WebElement findElem(String parValue, String... parType){
        String param2 = getAttributeType(parType);
        WebElement element = null;
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

    public Boolean getTextAllPage(String parValue){
        return driver.getPageSource().contains(parValue);
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
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String param2 = getAttributeType(parType);
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
            driver.switchTo().window(Arrays.toString(parValue));
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
