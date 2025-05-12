import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creamos una instancia de AVLTree
        AVLTree arbol = new AVLTree();

        // Inicializamos la raíz del árbol
        arbol.raiz = null;  // Aseguramos que la raíz esté inicializada

        Scanner sc = new Scanner(System.in);

        // Inserción de números en el árbol y mostrar el árbol después de cada inserción
        System.out.println("Ingrese números enteros para insertar en el árbol AVL. Escriba -1 o 'exit' para terminar.");

        while (true) {
            System.out.print("Número: ");
            String entrada = sc.nextLine();

            if (entrada.equals("exit") || entrada.equals("-1")) {
                System.out.println("Árbol AVL final:");
                arbol.imprimirArbol(arbol.raiz, 0);  // Mostrar el árbol final
                break;
            }

            try {
                int numero = Integer.parseInt(entrada);
                arbol.raiz = arbol.insertar(arbol.raiz, numero);  // Inserción del número en el árbol
                System.out.println("Árbol después de insertar " + numero + ":");
                arbol.imprimirArbol(arbol.raiz, 0);  // Imprimir el árbol después de cada inserción
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }

        sc.close();
    }
}
