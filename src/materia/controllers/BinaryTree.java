package materia.controllers;

import materia.models.Node;

public class BinaryTree {
    
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void Insert(int val){ // 50
                    // null, 50
        root = insertRec(root, val);

    }

    private Node insertRec(Node padre, int val){
                        // null, 50
        if (padre ==  null){
            return  new Node(val);    
        }
        if (val  <= padre.getVal()){
            // me voy a insertar en la izquierda
            Node newNode = insertRec(padre.getIz(), val);
            padre.setIz(newNode);
        }else if (val > padre.getVal()){
            // me voy a insertar en la derecha
            padre.setDe(insertRec(padre.getDe(), val)); 
        }
        return null;
    }
    public void  imprimirArbol(){
        imprimirArbolRec(root);

    }

    public void  imprimirArbolRec(Node node){
        if (node != null){
            System.out.println(node.getVal() + ", ");
            imprimirArbolRec(node.getIz());
            imprimirArbolRec(node.getDe());
        }

    }
    //> <

}
