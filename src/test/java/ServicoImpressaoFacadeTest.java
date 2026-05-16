import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoImpressaoFacadeTest {

    @Test
    public void deveImprimirComSucessoQuandoSubSistemasEstiveremOk() {
        // Configuração
        GerenciadorFila fila = new GerenciadorFila();
        DriverImpressora driver = new DriverImpressora();
        VerificadorStatus status = new VerificadorStatus(); // Retorna true para papel e tinta

        ServicoImpressaoFacade facade = new ServicoImpressaoFacade(fila, driver, status);


        ResultadoImpressao resultado = facade.executarImpressao("Texto de Teste");


        assertTrue(resultado.isSucesso(), "A impressão deveria ter sucesso.");
        assertTrue(resultado.getMensagem().contains("Impressão realizada com sucesso"));
        assertTrue(resultado.getMensagem().contains("Texto de Teste"));
    }
}