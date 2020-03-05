package pages;

import support.DriverQA;

public class PaginaSucesso {

    private DriverQA driver;

    public PaginaSucesso(DriverQA driverSteps) {
        driver = driverSteps;
    }

    public String buscarMensagem() {
        return driver.getText("result");
    }
}
