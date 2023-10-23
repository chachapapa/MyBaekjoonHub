import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
         PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0 ; i<scoville.length ; i++ ){
            q.add(scoville[i]);
        }
        
        while(q.peek() < K){
            int a = q.poll();
            int b = 0;
                if(q.peek() == null){
                    return -1;
                }else{
                   b = q.poll() ;
                       q.add(a+b*2);
                    answer+=1;
                }
            
        }
        return answer;
    }
}