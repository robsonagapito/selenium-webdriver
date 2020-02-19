package pages;

import support.DriverQA;

public class LoginFail {

    private DriverQA driver;

    public LoginFail(DriverQA stepDriver){
        driver = stepDriver;
    }

    public String getResult(){
        return driver.getText("result");
    }
}
