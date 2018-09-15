/**
 * Created by kohas02 on 7/16/18.
 */
public class DFS {

    private static void inorderTraversal(Tree tree){

        if(tree == null)
            return;
        inorderTraversal(tree.left);
        System.out.println(tree.data);
        inorderTraversal(tree.right);
    }

    public static void main(String args[]){
        Tree tree = new Tree(1);
        tree.left= new Tree(2);
        tree.right= new Tree(3);
        tree.left.left= new Tree(4);
        tree.left.right= new Tree(5);

        System.out.println("\nPrinting the order of traversal\n");
        inorderTraversal(tree);

    }

}
