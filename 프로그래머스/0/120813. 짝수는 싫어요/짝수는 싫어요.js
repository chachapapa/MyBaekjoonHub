function solution(n) {
    var answer = [];
    for(let i = 1  ; i<=n ; i++){
        if(i*2-1 > n){
            break;
        }
        answer.push(i*2-1);
        
    }
    return answer;
}