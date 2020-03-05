package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.Acesso;
import pages.PaginaErro;
import pages.PaginaSucesso;
import support.BaseSteps;

public class LoginPortuguesSteps extends BaseSteps {

    private Acesso acesso = new Acesso(driver);
    private PaginaSucesso paginaSucesso = new PaginaSucesso(driver);
    private PaginaErro paginaErro = new PaginaErro(driver);

    @Dado("^que o usuário está na página de login$")
    public void queOUsuarioEstaNaPaginaDeLogin() {
        acesso.abrirPagina();
    }

    @E("^o usuário preenche no campo \"([^\"]*)\" o valor \"([^\"]*)\"$")
    public void oUsuarioPreencheNoCampoOValor(String nomeCampo, String valorCampo) throws Throwable {
        acesso.preencherCampo(nomeCampo, valorCampo);
    }

    @Quando("^o usuário clicar no botão login$")
    public void oUsuarioClicarNoBotaoLogin() {
        acesso.clicarBotaoLogin();
    }

    @Então("^usuário deveria ver a mensagem de \"([^\"]*)\"$")
    public void usuarioDeveriaVerAMensagemDe(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, paginaSucesso.buscarMensagem());
    }

    @Então("^usuário deveria ver a mensagem invalida igual a \"([^\"]*)\"$")
    public void usuarioDeveriaVerAMensagemInvalidaIgualA(String mensagem) throws Throwable {
        Assert.assertEquals(mensagem, paginaErro.buscarMensagem());
    }
}
