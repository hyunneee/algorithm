import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String arr=br.readLine();
        char[] tmp=arr.toCharArray();
        /*
        for(int i=0;i<tmp.length;i++){
            bw.write(tmp[i]+"");
        }
        */
        int amount=0;
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<tmp.length;i++){
            if(tmp[i]=='('){
                stk.push(tmp[i]);
            }
            else if(tmp[i]==')'){
                if(i>0&&tmp[i-1]=='('){ //레이저
                    stk.pop();
                    amount+=stk.size();
                }else{
                    stk.pop();
                    amount++; //막대기 길이 끝나고 남은 1조각 더해주기
                }
            }
        }
        bw.write(amount+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
