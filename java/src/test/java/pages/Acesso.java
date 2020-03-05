package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.DriverQA;

public class Acesso {

    private DriverQA driver;

    public Acesso(DriverQA stepDriver){
        driver = stepDriver;
    }

    public void abrirPagina() {
        driver.openURL("file:///C:/Users/Robson.Correa/workspace/selenium-webdriver/html/login.html");
    }

    public void preencherCampo(String nomeCampo, String valorCampo) {
        driver.sendKeys(valorCampo,nomeCampo);

    }

    public void clicarBotaoLogin() {
        driver.click("#btnLogin","css");
    }
}
