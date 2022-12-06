package tree;

import java.util.ArrayList;
import java.util.List;

public class AncestorPath {

    static class Node{
        int data;
        ArrayList<Node> children;

        Node(int data){
            this.data = data;
            this.children = new ArrayList<Node>();
        }

    }

    public static boolean getAncestorPath(Node head, List<Node> result, int childData) {
        if( head==null ) {
            return false;
        }

        result.add(head);
        if( head.data==childData ){
            return true;
        }
        boolean isPathFound = false;
        for( Node childNode : head.children ){
            isPathFound = getAncestorPath(childNode,result,childData);
            if( isPathFound ){
                break;
            }
        }
        if( !isPathFound ){
            result.remove(head);
        }
        return isPathFound;
    }

    public static void insertNode(Node root, Node child){
        ArrayList<Node> children = root.children;
        children.add(child);
    }


    public static void main(String args[]){

    }
}
