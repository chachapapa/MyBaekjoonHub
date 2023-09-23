class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String[] arr = s.split("");
        int countP = 0;
        int countY = 0;
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i].equals("p") || arr[i].equals("P")){
                countP += 1;
            }else if(arr[i].equals("Y") || arr[i].equals("y")){
                countY += 1;
            }
        }
    if(countP != countY) {answer = false;} 
        
        return answer;
    }
}