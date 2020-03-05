package pages;

import support.DriverQA;

public class PaginaErro {

    private final DriverQA driver;

    public PaginaErro(DriverQA driverSteps) {
        driver = driverSteps;
    }

    public String buscarMensagem() {
        return driver.getText("result");
    }
}
