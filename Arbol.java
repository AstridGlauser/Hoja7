
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//Obtenido y modificado de geek for geeks

public class Arbol {

    class Node {

        ArrayList<String> key;
        Node left, right;

        public Node(ArrayList<String> item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    Arbol() {
        root = null;
    }

    void insertar(ArrayList<String> key) {
        root = AgregarR(root, key);
    }

    Node AgregarR(Node root, ArrayList<String> key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.get(0).compareTo(root.key.get(0)) < 0)
            root.left = AgregarR(root.left, key);
        else if (key.get(0).compareTo(root.key.get(0)) > 0)
            root.right = AgregarR(root.right, key);

        return root;
    }

}