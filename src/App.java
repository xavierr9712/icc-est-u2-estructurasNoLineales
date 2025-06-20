import materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree ab = new BinaryTree();
        ab.Insert(50);
        ab.Insert(17);
        ab.Insert(76);
        ab.Insert(9);
        ab.Insert(23);
        ab.Insert(54);
        ab.Insert(14);
        ab.Insert(19);
        //ab.imprimirArbol();

        System.out.println("Peso del Arbol:" + ab.getPeso() );
        System.out.println("Altura del Arbol:" + ab.getHeight() );
        System.out.println("");

        System.out.println("Arbol InOrder:");
        ab.printOrder();
        System.out.println("");

        System.out.println("Arbol InOrder con altura:");
        ab.printOrderWithHeight();
        System.out.println();

        System.out.println("Arbol InOrder con factor de equilibrio:");
        ab.printOrderWithBalanceFactor();
        System.out.println(""); 


                

    }
}
