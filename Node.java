public class Node {
    int valor;
    Node izquierda, derecha;
    int altura;

    public Node(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.izquierda = null;
        this.derecha = null;
    }
}
