package balanceoparentesis;

import java.util.Scanner;
import java.util.Stack;

public class BalanceoParentesis {
    public static boolean balancear(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char caracter : expresion.toCharArray()) {
            if (caracter == '(' || caracter == '{' || caracter == '[') {
                pila.push(caracter);
            } else if (caracter == ')' || caracter == '}' || caracter == ']') {
                if (pila.isEmpty()) {
                    return false;
                }
                char top = pila.pop();
                if ((caracter == ')' && top != '(') ||
                    (caracter == '}' && top != '{') ||
                    (caracter == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese una expresion matematica porfavor, para verificar el balanceo de parentesis:");
        String expresion = scanner.nextLine();

        if (balancear(expresion)) {
            System.out.println("La expresion esta balanceada.");
        } else {
            System.out.println("La expresion no esta balanceada.");
        }

        scanner.close();
    }
}
