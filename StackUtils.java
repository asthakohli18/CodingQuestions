import java.util.Stack;

/**
 * Created by kohas02 on 8/9/18.
 */
public class StackUtils {



    /**
     * This method is to print the tree traversal in zig zag order
     * One level left to right and another one right to left
     * */
    private void zigzagtreetraversal(Tree tree){
        Stack<Tree> currStack = new Stack();
        Stack<Tree> nextStack = new Stack();


        currStack.push(tree);
        boolean leftToRight = true;

        while(!currStack.isEmpty()){

            Tree temp = currStack.pop();
            System.out.print(temp.data+" ");


            if(leftToRight)
            {
                if(temp.left!=null)
                    nextStack.push(temp.left);
                if(temp.right!=null)
                    nextStack.push(temp.right);
            } else{
                if(temp.right!=null)
                    nextStack.push(temp.right);
                if(temp.left!=null)
                    nextStack.push(temp.left);
            }

            if(currStack.isEmpty()){
                leftToRight = !leftToRight;
                Stack tempStack = currStack;
                currStack=nextStack;
                nextStack=tempStack;
            }

        }


    }
    public static void main(String args[] ){
        StackUtils obj = new StackUtils();
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(7);
        tree.left.right = new Tree(6);
        tree.right.left = new Tree(5);
        tree.right.right = new Tree(4);

        obj.zigzagtreetraversal(tree);
    }
}
