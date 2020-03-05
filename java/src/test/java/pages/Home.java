package pages;

import support.DriverQA;

public class Home {

    private DriverQA driver;

    public Home(DriverQA stepDriver){
        driver = stepDriver;
    }

    public void abrirPagina() {
        driver.openURL("http://agapito-server.herokuapp.com/");
    }
}
