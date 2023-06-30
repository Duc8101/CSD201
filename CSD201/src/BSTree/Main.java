package BSTree;

public class Main {

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.add(30);
        tree.add(10);
        tree.add(40);
        tree.add(8);
        tree.add(15);
        tree.add(31);
        tree.add(26);
        tree.add(35);
        tree.add(45);
        tree.DeleteByMerging(40);
        tree.breadth();
        System.out.println();
    }

}
