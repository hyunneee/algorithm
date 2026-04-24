import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        String str=br.readLine(); //문자열 입력
        int m = Integer.parseInt(br.readLine()); //몇 번 수행? 입력
        Stack<Character> left_s = new Stack<>();
        Stack<Character> right_s = new Stack<>();

        for(int i=0;i<str.length();i++){
            left_s.push(str.charAt(i));
        }

        for(int i=0;i<m;i++){ //m번 반복
            String input = br.readLine(); //그때마다 입력받고
            char ch_zero = input.charAt(0);
            
            switch(ch_zero){
            case 'L':
                if(left_s.size()!=0)
                    right_s.push(left_s.pop());
                break;
            case 'D':
                if(right_s.size()!=0)
                    left_s.push(right_s.pop());
                break;
            case 'B':
                if(left_s.size()!=0)
                    left_s.pop();
                break;
            case 'P':
                left_s.push(input.charAt(2));
                break;
            }
        }
        while(left_s.size()!=0){
            right_s.push(left_s.pop());
        }
        while(right_s.size()!=0){
            bw.write(right_s.pop());
        }
        bw.flush();
        bw.close();
    }
}