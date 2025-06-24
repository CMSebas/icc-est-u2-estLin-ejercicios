package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();

        
        for(int i=0;i<texto.length();i++){
            pila.push(texto.charAt(i));
        }
        
        StringBuilder cadenaInvertida = new StringBuilder();

        while (!pila.isEmpty()) {
            cadenaInvertida.append(pila.pop()); 
        }
        return cadenaInvertida.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();

        
        for(int i=0;i<expresion.length();i++){
            char c=expresion.charAt(i);
            if(c=='('||c=='['||c=='{'){
                pila.push(c);
            }else{
                if(pila.isEmpty()==false);

                char top=pila.pop();
                if((c==')'&& top!='(')||
                   (c=='}'&& top!='{')||
                   (c==']'&& top!='[')){
                    return false;
                   }
            }
        }



        return pila.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> pilaordenada=new Stack<>();

        while(!pila.isEmpty()){
            int tope=pila.pop();

            while (!pilaordenada.isEmpty() && pilaordenada.peek() > tope) {
            pila.push(pilaordenada.pop()); 
        }
            
            pilaordenada.push(tope);
    
        }
        return pilaordenada;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares=new LinkedList();
        LinkedList<Integer> impares=new LinkedList();
        for(int numero:original){
            if(numero%2==0){
                pares.add(numero);
            }else{
                impares.add(numero);
            }
        }
        pares.addAll(impares);
        return pares;
    }
}
