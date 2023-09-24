class Solution {
    public long solution(long n) {
        long answer = 0;
        
        int value = (int) Math.sqrt(n);
        if(value == Math.sqrt(n)){
            answer = (long) Math.pow(value+1,2);
        }else{
            answer = -1;
        }
        
        return answer;
    }
}