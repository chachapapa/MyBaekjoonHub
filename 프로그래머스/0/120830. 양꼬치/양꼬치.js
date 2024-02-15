function solution(n, k) {
    var answer = 0;
    
    service = (n-n%10)/10
    
    answer = 12000*n+2000*(k-service)
    return answer;
}