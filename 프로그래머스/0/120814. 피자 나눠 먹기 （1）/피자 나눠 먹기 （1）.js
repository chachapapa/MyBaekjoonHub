function solution(n) {
    var answer = 0;
    count = (n-(n%7))/7;
    
    if(n%7 !== 0){
        count += 1;
    }
    answer = count
    return answer;
}