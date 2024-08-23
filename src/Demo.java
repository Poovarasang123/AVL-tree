public class Demo {
    public static void main(String[] args) {
        Avltree avl = new Avltree(50);
        avl.insert(20);
        avl.insert(60);
        avl.insert(10);
        avl.insert(30);
        avl.insert(40);
        avl.inorderTraversal(avl.root);
    }
}
