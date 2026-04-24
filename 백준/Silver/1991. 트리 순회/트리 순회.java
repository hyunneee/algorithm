import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        Node leftChild;
        Node rightChild;
        char value;

        public Node(char value){
            this.value = value;
        }
    }
    static char val;
    static int idx,cnt;
    static Node[] tree = new Node[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            char val = input[0].charAt(0);
            char leftChild = input[1].charAt(0);
            char rightChild = input[2].charAt(0);
            if(tree[val-'A'] == null){
                tree[val-'A'] = new Node(val);
            }
            if(leftChild != '.'){
                tree[leftChild-'A'] = new Node(leftChild);
                tree[val-'A'].leftChild = tree[leftChild-'A'] ;
            }
            if(rightChild != '.'){
                tree[rightChild - 'A'] = new Node(rightChild);
                tree[val-'A'].rightChild = tree[rightChild-'A'];
            }
        }
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }
    public static void preOrder(Node node){
        if(node == null) return ;
        System.out.print(node.value);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    public static void inOrder(Node node){
        if(node == null) return ;
        inOrder(node.leftChild);
        System.out.print(node.value);
        inOrder(node.rightChild);
    }
    public static void postOrder(Node node){
        if(node == null) return ;
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.value);
    }
}
