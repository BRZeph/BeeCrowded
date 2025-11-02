package estudos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PilhaFila {

    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        pilha.push(1);
        pilha.peek();
        pilha.isEmpty();
        pilha.pop();
        pilha.size();

        Queue<Integer> fila = new LinkedList<>();
        fila.add(4); // Enqueue
        fila.poll(); // Dequeue
        fila.size();
        fila.isEmpty();
        fila.peek();
    }
    /*
    No geral, pilha é utilizada em problemas de:
        -> Balanceamento
        -> Operação (expressão)

    No geral, fila é utilizada em problemas de:
        -> Simulação
        -> Jogos
        -> Cartas
     */
}
