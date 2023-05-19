import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AutomatoAutentico {

    private List<Estado> estados;
    private List<String> alfabeto;
    private Estado estadoInicial;
    private List<Estado> estadosFinais;

    class Estado {
        private List<String> entradas;
        private Map<String, Estado> transicoes;
        private String nome;
        private boolean isFinal;
    }

    public AutomatoAutentico(List<Estado> estados) {
        this.estados = estados;

    }


    public AutomatoAutentico() {
        this.estados = Arrays.asList("q1", "q2", "q3", "q4");
        this.alfabeto = Arrays.asList("0", "1", "ε");

    }

}
