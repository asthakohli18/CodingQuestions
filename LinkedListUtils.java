/**
 * Created by kohas02 on 7/3/18.
 */
public class LinkedListUtils {


    public static void deleteDups(Node node){

        while(node!=null) {
            Node runner = node;
            while(runner.next!=null){
                if(node.data == runner.next.data){
                    runner.next =runner.next.next;
                }
                else{
                    runner=runner.next;
                }
            }
            node=node.next;
        }
    }

    private static int indexFromStart=0;
    private static Node kthFromLastNode(Node head, int k){

        if(head == null)
            return null;

        Node n =  kthFromLastNode(head.next, k);
        indexFromStart = indexFromStart+1;

        if(indexFromStart == k)
            return head;

        return n;
    }

    private static Node kthFromLastNodeIterative(Node head, int k){
        Node p1 = head;
        Node p2 = head;

        //moving p1 k positions apart from p2 ; Result of this will be , they will be k positions apart
        for(int i=0;i<k;i++){
            if(p1!=null){
                p1=p1.next;
            }
        }

        //now move both p1 and p2 at same pace
        //now when p1 hits the end, p2 will be still k positions apart and at kth from last element
        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }


    private static Node partitionLinkedListArndValueX(Node n, int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;



        while(n!=null){
            Node next = n.next;
            n.next = null;

            if(n.data < x){
                if(beforeStart!=null){
                    beforeEnd.next=n;
                    beforeEnd =n;
                }
                else{
                    beforeStart = n;
                    beforeEnd = beforeStart;
                }
            }
            else{
                if(afterStart!=null){
                    afterEnd.next=n;
                    afterEnd=n;
                }else{
                    afterStart=n;
                    afterEnd = afterStart;
                }
            }

            n=next;
        }

        if(beforeStart==null){return afterStart;}

        beforeEnd.next=afterStart;
        return beforeStart;
    }

    private Node reverseLinkedList(Node list){
        Node head = null;
        while(list!=null){
            Node n = new Node(list.data);
            n.next = head;
            head = n;
            list = list.next;
        }
        return head;
    }


    public static void main(String args[]){
        Node list = new Node(1);
        list.appendToTail(5);
        list.appendToTail(6);
        list.appendToTail(7);
        list.appendToTail(5);
        list.appendToTail(3);

        System.out.println("\nLinked list : ");
        Node.printLinkedList(list);

        System.out.println("\nLinked list after removing duplicate elements : ");
        LinkedListUtils.deleteDups(list);
        Node.printLinkedList(list);

        System.out.println("\nKth Node from last :Recursive approach ");
        Node.printLinkedList(kthFromLastNode(list, 2));

        System.out.println("\nKth Node from last :Iterative approach ");
        Node.printLinkedList(kthFromLastNodeIterative(list, 3));

        Node list1 = new Node(1);
        list1.appendToTail(5);
        list1.appendToTail(6);
        list1.appendToTail(7);
        list1.appendToTail(5);
        list1.appendToTail(3);
        System.out.println("\nLinked list : ");
        Node.printLinkedList(list1);
        System.out.println("\nPartition linked list at value x -> Move all values less than x on left and bigger or equal on right\n ");
        Node.printLinkedList(partitionLinkedListArndValueX(list1, 6));


    }

}
