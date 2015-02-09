import java.util.*;
class Node {
    int val;
    Node left;
    Node right;
    Node parent;
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node leftParent, Node rightParent) {
        this.val = val;
        if (leftParent != null) {
            leftParent.left = this;
            this.parent = leftParent;
        }
        if (rightParent != null) {
            rightParent.right = this;
            this.parent = rightParent;
        }
    }
}


public class TreeIterator{
  private Node next;
  private Node prev;

  public void TreeIterator2(Node root){
     next = root;
     if(next == null)
       return;
     while (next.left != null)
       next = next.left;
  }

  public boolean hasNext(){
     return next != null;
  }

    //              1
    //        2          3
    //     4     5      6   7
    //          8

    private Node leftMost(Node root) {
        Node node = root;
        while(node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeIterator(Node root) {
        next = leftMost(root);
    }

    public Node next() {
        if (next == null) {
            return null;
        }
        Node nextNode = next;
        if (next.right != null) {
            next = leftMost(next.right);
        } else {
            Node lastNode = next;
            while(next != null && next.left != lastNode) {
                lastNode = next;
                next = next.parent;
            }
        }
        return nextNode;
    }




  public Node next2(){
     if(!hasNext()) throw new NoSuchElementException();
     Node r = next;
     // if you can walk right, walk right, then fully left.
     // otherwise, walk up until you come from left.
     if(next.right != null){
       next = next.right;
       while (next.left != null)
         next = next.left;
       return r;
     }else while(true){
       if(next.parent == null){
         next = null;
         return r;
       }
       if(next.parent.left == next){
         next = next.parent;
         return r;
       }
       next = next.parent;
     }
   }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void main(String args[]) {
        Node t1 = new Node(1);
        Node t2 = new Node(2, t1, null);
        Node t3 = new Node(3, null, t1);
        Node t4 = new Node(4, t2, null);
        Node t5 = new Node(5, null, t2);
        Node t6 = new Node(6, t3, null);
        Node t7 = new Node(7, null, t3);
        Node t8 = new Node(8, t5, null);

        TreeIterator it = new TreeIterator(t1);

        it.inorder(t1);
        System.out.println("-----");

        while(it.hasNext()) {
            Node n = it.next();
            System.out.println(n.val);
        }
    }
 }
