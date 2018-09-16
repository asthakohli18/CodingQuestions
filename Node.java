/**
 * Created by kohas02 on 7/3/18.
 */
//Node of a linked list
public class Node {
    Node next =null;
    int data;

    Node(int d){
        this.data = d;
    }

    void appendToTail(int d){
        Node end = new Node(d);
        end.next=null;
        Node node = this;

        while(node.next!=null){
            node = node.next;
        }
        node.next = end;
    }

    Node deleteNode(Node head, int d){
        Node n =head;

        if(n.data == d){
            return head.next; // if first node neads deletion
        }

        while(n.next!=null){
            if(n.next.data==d){
                n.next = n.next.next;
                return head;
            }
            n=n.next;
        }
        return head;
    }

    static void printLinkedList(Node list){
        while(list!=null){
            System.out.print("->"+list.data);
            list = list.next;
        }
    }

    public static void main(String args[]){
        Node list = new Node(1);
        list.appendToTail(2);
        list.appendToTail(3);
        printLinkedList(list);
    }
}
