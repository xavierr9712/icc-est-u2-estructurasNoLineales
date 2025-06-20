package materia.controllers;



import materia.models.Node;

public class BinaryTree {
    
    private Node root;
    private int size;
   

    public BinaryTree() {
        this.root = null;
        this.size = 0;          
    }
    
    public void Insert(int val){ // 50
                    // null, 50
        size++;
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
        return padre;
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
    public void printArbol() {
        printArbolRec(root);
    }

    public void printArbolRec(Node node) {
        if (node != null) {
            System.out.println(node.getVal() + " ");
            printArbolRec(node.getIz());
            printArbolRec(node.getDe());
            return;
        }
    }
     public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println("");
    }

    private void printPreOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getVal() + " ");
            printPreOrderRec(node.getIz());
            printPreOrderRec(node.getDe());
        }
    }

    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println("");
    }

    private void printPostOrderRec(Node node) {
        if (node != null) {
            printPostOrderRec(node.getIz());
            printPostOrderRec(node.getDe());
            System.out.print(node.getVal() + " ");
        }
    }

    public void printInOrder(){
        printInOrderRec(root);
        System.out.println("");
    }

    public void printInOrderRec(Node node){
        if (node != null){
            printInOrderRec(node.getIz());
            System.out.print(node.getVal() + " ");
            printInOrderRec(node.getDe());
        }
    }


    public void printInOrderWithHeigth(){
        printInOrderWithHeightRec(root);
        System.out.println("");
    }

    public void printInOrderWithHeightRec(Node node){
        if (node != null){
            printInOrderWithHeightRec(node.getIz());
            int height = getHeightRec(node);
            System.out.print(node.getVal() + "(h="+height+") ");
            printInOrderWithHeightRec(node.getDe());
        }
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeightRec(node.getIz()) - getHeightRec(node.getDe());
    }

    public void printInOrderWithBalanceFactor() {
        printInOrderWithBalanceFactorRec(root);
        System.out.println("");
    }

    public void printInOrderWithBalanceFactorRec(Node node) {
        if (node != null) {
            printInOrderWithBalanceFactorRec(node.getIz());
            int balanceFactor = getBalanceFactor(node);
            System.out.print(node.getVal() + "(bf=" + balanceFactor + ") ");
            printInOrderWithBalanceFactorRec(node.getDe());
        }
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    public boolean searchRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getVal() == value) {
            return true;
        }
        if (value < node.getVal()) {
            return searchRec(node.getIz(), value);
        } else {
            return searchRec(node.getDe(), value);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    public int getHeightRec(Node node) {
        if (node == null) {
            return 0; 
        }
        int leftHeight = getHeightRec(node.getIz());
        int rightHeight = getHeightRec(node.getDe());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalancedRec(node.getIz()) && isBalancedRec(node.getDe());
    }

    public void getUnbalancedNodesCount() {
        getUnbalancedNodesCountRec(root);
        System.out.println("");
    }

    private void getUnbalancedNodesCountRec(Node node) {
        if (node != null) {
            int balanceFactor = getBalanceFactor(node);
            if (Math.abs(balanceFactor) > 1 || Math.abs(balanceFactor) <-1) {
                System.out.print(node.getVal() + "(bf=" + balanceFactor + ") ");
            }
            getUnbalancedNodesCountRec(node.getIz());
            getUnbalancedNodesCountRec(node.getDe());
        }
    }

    public boolean contains(int value) {
        return searchRec(root, value);
    }
    

    public int getSize() {
        return size;
    }

}
