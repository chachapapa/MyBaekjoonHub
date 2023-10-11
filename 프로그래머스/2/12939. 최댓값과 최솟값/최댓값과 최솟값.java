class Solution {
    
    public String solution(String s) {
        String answer = "";
        
        
        String[] arr = s.split(" ");
        
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;
        
        for(int i = 0 ; i<arr.length ; i++){
            if(Integer.parseInt(arr[i]) < small){
                small = Integer.parseInt(arr[i]);
            }
            
            if(Integer.parseInt(arr[i]) > big){
                big = Integer.parseInt(arr[i]);
            }
        }
        
        // System.out.println(small+" "+big);
        answer = small+" "+big;
        
        return answer;
    }
}