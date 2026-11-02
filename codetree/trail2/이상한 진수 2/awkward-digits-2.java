import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<a.length();i++){
            maxVal = Math.max(maxVal, find(a,i));
        }
        System.out.println(maxVal);
    }

    public static int find(String a, int i){
        int ans = 0;
        int value = 0;
        int idx = 0;
        for(int k=a.length()-1;k>=0;k--){
            // 
            idx = a.length() - k - 1;
            if((a.length() - k - 1) == i){
                value = a.charAt(idx) == '1' ? 0 : 1;
            }
            else {
                value = a.charAt(idx) == '1' ? 1 : 0; 
            }
            ans += (int) (value * Math.pow(2,k));
        }
        return ans;
    }
}