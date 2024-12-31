import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by kohas02 on 7/12/18.
 */
public class TreeUtils {


/**
 *
 * Finding the lowest common ancestor of given nodes in a tree
 * */
Tree findLCA(Tree tree, int n1, int n2){

    if(tree == null){
        return null;
    }


    // If either n1 or n2 matches with root's key, report
    // the presence by returning root (Note that if a key is
    // ancestor of other, then the ancestor key becomes LCA
    if(tree.data==n1 || tree.data==n2){
        return tree;
    }

    Tree leftLCA = findLCA(tree.left, n1, n2);
    Tree rightLCA = findLCA(tree.right, n1, n2);

    // If both of the above calls return Non-NULL, then one key
    // is present in once subtree and other is present in other,
    // So this node is the LCA
    if(leftLCA!=null && rightLCA!=null) {
        return tree;
    }

    return leftLCA!=null?leftLCA:rightLCA;

}

/**
 * Helper method for traversing the tree by level
 * */
private static void printTreeInLevel(Tree tree, int level, List<Integer> values){
    if(tree == null)
        return;

    if(level == 1){
        System.out.print(tree.data+" ");
        values.add(tree.data);
    }

    else{
        printTreeInLevel(tree.left, level-1,values);
        printTreeInLevel(tree.right, level-1,values);
    }
}

/**
 * Prints and returns tree by level order traversal
 * Returns : List<Integer>
 * */
private static List<Integer> printTree(Tree tree, List values){
    int height = heightOfTree(tree);

    for(int i=1;i<=height;i++) {
        System.out.println("");
        printTreeInLevel(tree, i, values);
    }
    return values;
}


/**
 * Helper method to calculate the height of a binary tree
 * */
    private static int  heightOfTree(Tree tree) {

        if(tree == null){
            return 0;
        }
        int leftHeight = 0;
        if(tree.left!=null){
            leftHeight = heightOfTree(tree.left);
        }
        int rightHeight = 0;
        if(tree.right!=null){
            rightHeight = heightOfTree(tree.right);
        }
        return (Math.max(leftHeight, rightHeight))+1;

    }

/**
 * Method for inOrder traversal of a binary tree
 * */
    private List<Integer> inOrderTraversal(Tree tree, List<Integer> arr){
    if(tree==null){
        return null;
    }

    if(tree.left!=null){
        inOrderTraversal(tree.left, arr);
    }
    arr.add(tree.data);

    if(tree.right!=null){
        inOrderTraversal(tree.right,arr);
    }
    return arr;

}
/**
 * This method prints the kth smallest tree node from BST
 * */
private int kthSmallestTreeNode(Tree tree, int k){
    List<Integer> values = new ArrayList<>();
    List<Integer> arr = printTree(tree, values);
    System.out.println("\nPrinting out the whole list created by In order traversal\n");
    System.out.print(arr);
    return arr.get(k);
}


/**
 * Method for checking if the Binary tree left is the mirror image of right binary tree
 * Return : Boolean
 * */
private static boolean isMirrorImage(Tree left, Tree right){
    if(left==null || right == null){
        return (left==null && right==null);
    }

    return left.data==right.data && isMirrorImage(left.left,right.right) && isMirrorImage(left.right,right.left);
}


private static boolean isBalanced(Tree tree){
    if(tree == null)
        return true;

    int leftHeight = heightOfTree(tree.left);
    int rightHeight = heightOfTree(tree.right);

    if(Math.abs(leftHeight-rightHeight)<=1 && isBalanced(tree.left) && isBalanced(tree.right))
        return true;
    return false;
}

public static void main(String args[]){
    /**
     * Creation of tree
     * */
    TreeUtils treeUtils = new TreeUtils();
    Tree binarySearchTree = new Tree(1);
    binarySearchTree.left = new Tree(2);
    binarySearchTree.right = new Tree(3);
    binarySearchTree.left.left = new Tree(4);
    binarySearchTree.left.right = new Tree(5);
    binarySearchTree.right.left = new Tree(6);
    binarySearchTree.right.right = new Tree(7);

    System.out.println("\nPrinting the tree\n");

    printTree(binarySearchTree, new ArrayList());

    System.out.println("\nLCA(4, 5) = " +
            treeUtils.findLCA(binarySearchTree,4, 5).data);
    System.out.println("LCA(4, 6) = " +
            treeUtils.findLCA(binarySearchTree,4, 6).data);
    System.out.println("LCA(3, 4) = " +
            treeUtils.findLCA(binarySearchTree,3, 4).data);
    System.out.println("LCA(2, 4) = " +
            treeUtils.findLCA(binarySearchTree,2, 4).data);


    System.out.println("\nprint kth smallest element from tree "+treeUtils.kthSmallestTreeNode(binarySearchTree, 4));

    System.out.println("\nIf above left binary tree is Mirror image of right bnary tree");
    System.out.println(isMirrorImage(binarySearchTree.left,binarySearchTree.right));

    Tree binaryTree = new Tree(5);
    binaryTree.left = new Tree(4);
    binaryTree.right = new Tree(4);
    binaryTree.left.left = new Tree(7);
    binaryTree.left.right = new Tree(2);
    binaryTree.right.left = new Tree(2);
    binaryTree.right.right = new Tree(7);
    printTree(binaryTree, new ArrayList());

    System.out.println("\nIf above left binary tree is Mirror image of right bnary tree");
    System.out.println(isMirrorImage(binaryTree.left,binaryTree.right));

}

}
