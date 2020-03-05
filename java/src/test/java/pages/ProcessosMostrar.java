package pages;

import support.DriverQA;

public class ProcessosMostrar {

    private final DriverQA driver;

    public ProcessosMostrar(DriverQA driverQA) {
        driver = driverQA;
    }

    public String recuperarMensagemDeSucesso() {
        return driver.getText("notice");
    }

    public void clicarVoltar() {
        driver.click(".ls-btn-primary-danger","css");
    }
}
