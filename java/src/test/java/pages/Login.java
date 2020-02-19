package pages;

import support.DriverQA;

public class Login {

    private DriverQA driver;

    public Login(DriverQA stepDriver){
        driver = stepDriver;
    }

    public void clickLogin(){
        driver.click("btnLogin");
    }

    public void fillLogin(String value){
        driver.sendKeys(value,"login");
    }

    public void fillPass(String value){
        driver.sendKeys(value,"password");
    }

    public void openPage() {
        String url = "file:///" + System.getProperty("user.dir") + "\\..\\html\\login.html";
        driver.openURL(url);
    }

    public String getGeneralResult(){
        return driver.getText("result");
    }

    public void fillLoginXpath(String value) {
        driver.sendKeys(value,"//*[@id=\"login\"]", "xpath");
    }

    public void fillLoginCSS(String value) {
        driver.sendKeys(value,"#login", "css");
    }

    public void fillLoginName(String value) {
        driver.sendKeys(value,"uname", "name");
    }

}
