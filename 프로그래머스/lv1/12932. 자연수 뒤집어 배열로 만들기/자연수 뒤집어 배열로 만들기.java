class Solution {
    public int[] solution(long n) {
        
        String value = String.valueOf(n);
        int[] answer = new int[value.length()];
        
        for(int i = 0; i<value.length() ; i++){
                answer[i] = (int)(n%Math.pow(10,i+1)/Math.pow(10,i));
                n -= answer[i]*Math.pow(10,i);
        }
                                                                                                                        
        
        return answer;
    }
}