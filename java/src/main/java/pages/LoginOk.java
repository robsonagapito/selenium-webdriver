package pages;

import support.DriverQA;

public class LoginOk{

    private DriverQA driver;

    public LoginOk(DriverQA stepDriver){
        driver = stepDriver;
    }

    public String getResult(){
        return driver.getText("result");
    }
}
