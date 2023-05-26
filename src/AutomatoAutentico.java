import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AutomatoAutentico {

    private List<Estado> estados;
    private List<String> alfabeto;
    private Estado estadoInicial;
    private List<Estado> estadosFinais;

    public AutomatoAutentico(List<Estado> estados, List<String> alfabeto, String estadoInicial) {
        this.estados = estados;
        this.alfabeto = alfabeto;

        for(Estado estado : estados) {
            if (estado.isFinal()) {
                this.estadosFinais.add(estado);
            }

            if (estado.getNome() == estadoInicial) {
                this.estadoInicial = estado;
            }
        }



    }

}