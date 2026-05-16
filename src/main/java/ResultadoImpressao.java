public class ResultadoImpressao {
    private final boolean sucesso;
    private final String mensagem;

    public ResultadoImpressao(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() { return this.sucesso; }
    public String getMensagem() { return this.mensagem; }
}