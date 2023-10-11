class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split("");
        String before = "";
        for(int i = 0 ; i<arr.length ; i++){
            if(before.equals(" ") || i==0){
                before = arr[i];
                arr[i] = arr[i].toUpperCase();
            }else{
                before = arr[i];
                arr[i] = arr[i].toLowerCase();
            }
            
        }
        
        for(int i = 0 ; i<arr.length; i++){
            answer += arr[i];
        }
        System.out.println(answer);
        return answer;
    }
}