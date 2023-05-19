import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> states = new HashSet<>(Arrays.asList(5, 6, 7, 8));
        Set<Character> alphabet = new HashSet<>(Arrays.asList('0', '1'));
        Map<Integer, Map<Character, Set<Integer>>> transitions = new HashMap<>();
        transitions.put(0, Map.of('0', Set.of(0), '1', Set.of(0, 1)));
        transitions.put(1, Map.of('1', Set.of(2)));
        transitions.put(2, Map.of('0', Set.of(3)));
        Set<Integer> initialStates = new HashSet<>(Collections.singletonList(0));
        Set<Integer> finalStates = new HashSet<>(Collections.singletonList(3));

        Automato automato = new Automato(states, alphabet, transitions, initialStates, finalStates);

        // Testando algumas cadeias de entrada
        String[] inputs = {"00100", "0011"};
        for (String input : inputs) {
            boolean accepted = automato.simulate(input);
            System.out.println("Cadeia: " + input + ", Resultado: " + (accepted ? "ACEITA" : "RECUSA"));
        }
    }
}