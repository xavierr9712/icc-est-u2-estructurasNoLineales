package materia.controllers;

import java.util.List;

import materia.models.Node;

public class BinaryTree {
    
    private Node root;
    private int peso;
    private List <Node> desquilibrado;

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
    public void printOrder(){
        printOrderRec(root);
        System.out.println("");
    }

    private void printOrderRec(Node node){
        if (node != null){
            printOrderRec(node.getIz());
            System.out.println(node.getVal() + ", ");
            printOrderRec(node.getDe());
        }
    }


    public boolean search(int val){
        return searchRec(root, val);
    }
    private boolean searchRec(Node node, int val){
        if (node == null){
            return false;
        }
        if (node.getVal() == val){
            return true;
        }
        if (val < node.getVal()){
            return searchRec(node.getIz(), val);
        } else {
            return searchRec(node.getDe(), val);
        }
    }

    public  int getHeight(){
        return getHeightRec(root);
    }

    private int getHeightRec(Node node){
        if (node == null){
            return 0;
        }
        int leftHeight = getHeightRec(node.getIz());
        int rightHeight = getHeightRec(node.getDe());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void printOrderWithHeight() {
        printOrderWithHeightRec(root);
        System.out.println("");
    }
    
    private void printOrderWithHeightRec(Node node) {
        if (node != null) {
            printOrderWithHeightRec(node.getIz());
            int height = getHeightRec(node);
            System.out.println("Valor: " + node.getVal() + "(h= " + height + ")");
            printOrderWithHeightRec(node.getDe());
        }
    }

    public int getBalanceFactor() {
        return getBalanceFactorRec(root);
    }

    private int getBalanceFactorRec(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeightRec(node.getIz()) - getHeightRec(node.getDe());
    }
    public void printBalanceFactor() {
        printBalanceFactorRec(root);
        System.out.println("");
    }
    private void printBalanceFactorRec(Node node) {
        if (node != null) {
            printBalanceFactorRec(node.getIz());
            int balanceFactor = getBalanceFactorRec(node);
            System.out.println("Valor: " + node.getVal() + ",(Bf: " + balanceFactor + "),");
            printBalanceFactorRec(node.getDe());
        }
    }

    public Node getRoot() {
        return root;
    }
    public void printOrderWithBalanceFactor() {
        printOrderWithBalanceFactorRec(root);
        System.out.println("");
    }
    private void printOrderWithBalanceFactorRec(Node node) {
        if (node != null) {
            printOrderWithBalanceFactorRec(node.getIz());
            int balanceFactor = getBalanceFactorRec(node);
            System.out.println("Valor: " + node.getVal() + ",(Bf: " + balanceFactor + "),");
            printOrderWithBalanceFactorRec(node.getDe());
        }
    }
    public int getPeso() {
        return getPesoRec(root);
    }

    private int getPesoRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getPesoRec(node.getIz()) + getPesoRec(node.getDe());
    }   

}
