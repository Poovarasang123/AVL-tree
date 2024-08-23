public class Avltree {
    Node root;
    class Node{
        int key;
        Node left , right;
        int height;

        public Node(int val){
            key = val;
            left = right = null;
            height = 0;
        }
    }
    public Avltree(int val){
        root = new Node(val);
    }
    public void insert(int val){
       root = insert(root,val);
    }
    public Node insert(Node node,int val){
        if(node==null)
            return new Node(val);

        if(val<node.key)
            node.left = insert(node.left, val);

        else if(val > node.key)
            node.right = insert(node.right, val);

        else return node;
        node.height = 1+max(getHeight(node.left) ,getHeight(node.right));

        int balFact = getBalanceFactor(node);
        //LL
        if(balFact>1 && val < node.left.key){
            return rightRotate(node);
        }
        //LR
        if(balFact>1 && val > node.left.key){
           node.left = leftRotate(node.left);
           return rightRotate(node);
        }
        //RR
        if(balFact<-1 && val > node.right.key){
            return leftRotate(node);
        }
        //RL
        if(balFact<-1 && val < node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    private int getBalanceFactor(Node node){
        if(node==null) return 0;
        return getHeight(node.left)-getHeight(node.right);
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
    public int getHeight(Node node){
        if(node == null) return -1;
        return node.height;
    }
    private Node rightRotate(Node Z){
        Node y = Z.left;
        Node t3 = y.right;

        y.right = Z;
        Z.left = t3;
        Z.height = 1+max(getHeight(Z.left), getHeight(Z.right));
        y.height = 1+max(getHeight(y.left), getHeight(y.right));

        return y; 
    }
    private Node leftRotate(Node Z){
        Node y = Z.right;
        Node t3 = y.left;
        y.left = Z;
        Z.right = t3;
        Z.height = 1+max(getHeight(Z.left), getHeight(Z.right));
        y.height = 1+max(getHeight(y.left), getHeight(y.right));
        return y;
    }
    public static void inorderTraversal(Node root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.println(root.key+" Height is "+root.height);
            inorderTraversal(root.right);
        }
     }
}
