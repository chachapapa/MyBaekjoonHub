function solution(n) {
    var answer = 0;
    for(let i = 1; i*2<=n ; i++){
        answer += i*2
    }
    
    return answer;
}