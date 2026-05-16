public class ServicoImpressaoFacade {
    private final GerenciadorFila fila;
    private final DriverImpressora driver;
    private final VerificadorStatus status;

    public ServicoImpressaoFacade(GerenciadorFila fila, DriverImpressora driver, VerificadorStatus status) {
        this.fila = fila;
        this.driver = driver;
        this.status = status;
    }

    public ResultadoImpressao executarImpressao(String documento) {
        if (!status.temPapel()) {
            return new ResultadoImpressao(false, "Erro: Sem papel na impressora.");
        }
        if (!status.temTinta()) {
            return new ResultadoImpressao(false, "Erro: Sem tinta na impressora.");
        }

        try {
            driver.conectar();
            driver.configurarMargens(20, 20);

            String logFila = fila.adicionarDocumento(documento);
            String logEnvio = driver.enviarDados(documento);

            driver.desconectar();

            String msgSucesso = "Impressão realizada com sucesso. Detalhes: " + logFila + " | " + logEnvio;
            return new ResultadoImpressao(true, msgSucesso);

        } catch (Exception e) {
            return new ResultadoImpressao(false, "Falha crítica no hardware: " + e.getMessage());
        }
    }
}