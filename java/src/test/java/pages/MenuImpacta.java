package pages;

import support.DriverQA;

public class MenuImpacta {

    private DriverQA driver;

    public MenuImpacta(DriverQA stepDriver){
        driver = stepDriver;
    }

    public void clicarMenu(String vMenu) {
        driver.click(vMenu);
    }
}
