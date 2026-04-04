import java.io.*;
import java.util.*;

class Car{
    int id, pos, fuel;
    Car(int id, int pos, int fuel) {
        this.id = id; this.pos = pos; this.fuel = fuel;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] idList = new int[N+1];
        int[] fuelList = new int[N+1];
        Car[] cars = new Car[N+1];

        for(int i=1;i<=N;i++){
            idList[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            fuelList[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            cars[i] = new Car(i,idList[i],fuelList[i]);
        }

        Queue<Car> q = new LinkedList<>();
        boolean[] isAdded = new boolean[N+1];

        q.add(cars[S]);
        isAdded[S] = true;

        int minL = cars[S].pos - cars[S].fuel;
        int maxR = cars[S].pos + cars[S].fuel;
        int leftIdx = S, rightIdx = S; // 현재 탐색된 차의 인덱스 범위

        while(!q.isEmpty()){
            Car curr = q.poll();
            minL = Math.min(minL, curr.pos - curr.fuel);
            maxR = Math.max(maxR, curr.pos + curr.fuel);

            while(leftIdx > 1 && cars[leftIdx-1].pos >= minL) {
                leftIdx--;
                if (!isAdded[leftIdx]) {
                    isAdded[leftIdx] = true;
                    q.add(cars[leftIdx]);
               }
            }
            while(rightIdx < N && cars[rightIdx+1].pos <= maxR){
                rightIdx++;
                if(!isAdded[rightIdx]) {
                    isAdded[rightIdx] = true;
                    q.add(cars[rightIdx]);
                }
            }
        }

        // 결과 정렬 및 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (isAdded[i]) sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
