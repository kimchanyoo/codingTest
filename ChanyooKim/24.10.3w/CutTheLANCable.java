package D28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTheLANCable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        int[] cable = new int[K];
        long max = 0;

        for(int i = 0; i < K; i++){
            cable[i] = Integer.parseInt(br.readLine());
            if(cable[i] > max){
                max = cable[i];
            }
        }

        max++;

        long mid = 0;
        long min = 0;

        while(min < max){
            mid = (max + min)/2;

            long count = 0;

            for(int i = 0; i < cable.length; i++){
                count += (cable[i] / mid);
            }

            if(count < N){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
