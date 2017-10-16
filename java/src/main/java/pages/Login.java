package pages;

import support.DriverQA;

public class Login {

    private DriverQA driver;

    public void updateDriver(DriverQA parDriver) {
        driver = parDriver;
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

}
