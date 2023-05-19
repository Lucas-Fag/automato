import java.util.*;

public class Automato {

    private Set<Integer> states;
    private Set<Character> alphabet;
    private Map<Integer, Map<Character, Set<Integer>>> transitions;
    private Set<Integer> initialStates;
    private Set<Integer> finalStates;

    public Automato(Set<Integer> states, Set<Character> alphabet, Map<Integer, Map<Character, Set<Integer>>> transitions,
               Set<Integer> initialStates, Set<Integer> finalStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.initialStates = initialStates;
        this.finalStates = finalStates;
    }

    public boolean simulate(String input) {
        Set<Integer> currentStates = epsilonClosure(initialStates);

        for (char symbol : input.toCharArray()) {
            Set<Integer> nextStates = new HashSet<>();
            for (int state : currentStates) {
                Map<Character, Set<Integer>> transitionMap = transitions.get(state);
                if (transitionMap != null) {
                    Set<Integer> statesWithSymbol = transitionMap.get(symbol);
                    if (statesWithSymbol != null) {
                        nextStates.addAll(statesWithSymbol);
                    }
                }
            }
            currentStates = epsilonClosure(nextStates);
        }

        for (int state : currentStates) {
            if (finalStates.contains(state)) {
                return true; // Aceita
            }
        }
        return false; // Recusa
    }

    private Set<Integer> epsilonClosure(Set<Integer> states) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> closure = new HashSet<>(states);
        stack.addAll(states);

        while (!stack.isEmpty()) {
            int state = stack.pop();
            Map<Character, Set<Integer>> transitionMap = transitions.get(state);
            if (transitionMap != null) {
                Set<Integer> epsilonStates = transitionMap.get('ε');
                if (epsilonStates != null) {
                    for (int epsilonState : epsilonStates) {
                        if (!closure.contains(epsilonState)) {
                            closure.add(epsilonState);
                            stack.push(epsilonState);
                        }
                    }
                }
            }
        }
        return closure;
    }
}
