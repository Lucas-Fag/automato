import java.util.List;
import java.util.Map;

public class Estado {
    private Map<String, Estado> transicoes;
    private String nome;
    private boolean isFinal;

    public Estado(String nome, boolean isFinal) {
        this.nome = nome;
        this.isFinal = isFinal;
    }

    public List<String> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<String> entradas) {
        this.entradas = entradas;
    }

    public Map<String, Estado> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Map<String, Estado> transicoes) {
        this.transicoes = transicoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }
}
