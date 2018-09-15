/**
 * Created by kohas02 on 7/16/18.
 */
public class BFS {


    private static int height(Tree tree){

        if(tree == null){
            return 0;
        }

        int lheight = height(tree.left);
        int rheight = height(tree.right);

        int maxHeightChild = Math.max(lheight,rheight);

        return maxHeightChild+1;
    }

    private static void printGivenLevel(Tree tree, int level){
        if(tree==null){
            return ;
        }

        if(level == 1){
            System.out.println(tree.data);
        }

        else if(level > 1){
            printGivenLevel(tree.left,level-1);
            printGivenLevel(tree.right,level-1);
        }
    }

    private static void traverse(Tree tree){
        int height = height(tree);

        for(int i=1;i<=height;i++){
            printGivenLevel(tree, i);
        }
    }

    public static void main(String args[]){
        Tree tree = new Tree(1);
        tree.left= new Tree(2);
        tree.right= new Tree(3);
        tree.left.left= new Tree(4);
        tree.left.right= new Tree(5);

        System.out.println("\nPrinting the order of traversal\n");
        traverse(tree);

    }

}
