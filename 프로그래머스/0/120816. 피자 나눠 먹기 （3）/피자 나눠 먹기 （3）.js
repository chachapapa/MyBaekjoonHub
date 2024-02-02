function solution(slice, n) {
    var answer = 0;
    
    if(n%slice > 0){
        answer = (n-n%slice)/slice + 1
    }else{
        answer = n/slice
    }
    
    return answer;
}