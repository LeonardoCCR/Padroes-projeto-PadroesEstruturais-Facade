public class DriverImpressora {
    private boolean conectado = false;

    public boolean conectar() {
        this.conectado = true;
        return this.conectado;
    }

    public String configurarMargens(int superior, int esquerda) {
        return "Margens definidas: Sup=" + superior + ", Esq=" + esquerda;
    }

    public String enviarDados(String dados) {
        if (!conectado) {
            throw new IllegalStateException("Impressora não está conectada.");
        }
        return "Dados enviados para o hardware: [" + dados + "]";
    }

    public boolean desconectar() {
        this.conectado = false;
        return true;
    }
}
