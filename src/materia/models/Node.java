package materia.models;

public class Node {

    private int val;
    private Node iz;
    private Node de;

    public Node(int val) {
        this.val = val;
        this.iz = null;
        this.de = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getIz() {
        return iz;
    }

    public void setIz(Node iz) {
        this.iz = iz;
    }

    public Node getDe() {
        return de;
    }

    public void setDe(Node de) {
        this.de = de;
    }

    @Override
    public String toString() {
        return "Node [val=" + val + ", iz=" + iz + ", de=" + de + "]";
    }

   
    
    
}
