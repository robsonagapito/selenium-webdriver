package pages;

import support.DriverQA;

public class LoginOk{

    private DriverQA driver;

    public void updateDriver(DriverQA parDriver) {
        driver = parDriver;
    }

    public String getResult(){
        return driver.getText("result");
    }
}
