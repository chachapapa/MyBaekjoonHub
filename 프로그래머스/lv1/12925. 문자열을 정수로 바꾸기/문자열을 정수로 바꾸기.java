class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] num = s.split("");
        
        if(num[0].equals("-")){
            for(int i = 1 ; i<num.length ; i++){
                answer -= Integer.parseInt(num[i])*Math.pow(10,num.length-1-i);
            }
        }else if(num[0].equals("+")){
            for(int i = 1 ; i<num.length ; i++){
                answer += Integer.parseInt(num[i])*Math.pow(10,num.length-1-i);
            }
        }else{
            for(int i = 0 ; i<num.length ; i++){
                answer += Integer.parseInt(num[i])*Math.pow(10,num.length-1-i);
            }
        };
        
            
        return answer;
    }
}