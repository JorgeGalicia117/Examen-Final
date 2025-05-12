public class AVLTree {
    Node raiz;  // Esta es la raíz del árbol AVL

    // Método para obtener la altura de un nodo
    int altura(Node nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }

    // Método para calcular el factor de balance de un nodo
    int getFactorBalance(Node nodo) {
        if (nodo == null) return 0;
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }

    // Rotación derecha
    Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        // Realizar la rotación
        x.derecha = y;
        y.izquierda = T2;

        // Actualizar las alturas
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;  // Nueva raíz después de la rotación
    }

    // Rotación izquierda
    Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        // Realizar la rotación
        y.izquierda = x;
        x.derecha = T2;

        // Actualizar las alturas
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;  // Nueva raíz después de la rotación
    }

    // Método para insertar un nodo en el árbol AVL
    Node insertar(Node nodo, int valor) {
        // 1. Inserción normal en un árbol binario de búsqueda
        if (nodo == null) return new Node(valor);

        if (valor < nodo.valor)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo;  // No se permiten valores duplicados

        // 2. Actualización de la altura del nodo ancestro
        nodo.altura = Math.max(altura(nodo.izquierda), altura(nodo.derecha)) + 1;

        // 3. Calcular el factor de balance
        int balance = getFactorBalance(nodo);

        // 4. Realizar rotaciones si el árbol se desbalancea

        // Rotación simple a la derecha (caso LL)
        if (balance > 1 && valor < nodo.izquierda.valor)
            return rotarDerecha(nodo);

        // Rotación simple a la izquierda (caso RR)
        if (balance < -1 && valor > nodo.derecha.valor)
            return rotarIzquierda(nodo);

        // Rotación doble a la izquierda (caso LR)
        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        // Rotación doble a la derecha (caso RL)
        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;  // Retornar el nodo sin modificaciones
    }

    // Método para imprimir el árbol
    void imprimirArbol(Node nodo, int nivel) {
        if (nodo == null)
            return;

        imprimirArbol(nodo.derecha, nivel + 1);

        for (int i = 0; i < nivel; i++)
            System.out.print("    ");
        System.out.println(nodo.valor);

        imprimirArbol(nodo.izquierda, nivel + 1);
    }
}
