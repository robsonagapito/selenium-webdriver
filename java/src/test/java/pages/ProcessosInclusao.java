package pages;

import support.DriverQA;

public class ProcessosInclusao {

    private DriverQA driver;

    public ProcessosInclusao(DriverQA driverQA) {
        driver = driverQA;
    }

    public void preencherCampo(String campo, String valor) {
        driver.sendKeys(valor, campo);
    }

    public void clicarSalvar(String botao) {
        driver.click(botao);
    }

    public void selecionarUrgencia(String valor) {
        driver.selectByText(valor, "processo_urgente");
    }

    public void clicarArbitramentoSim() {
        driver.click("processo_arbitramento_s");
    }
}
