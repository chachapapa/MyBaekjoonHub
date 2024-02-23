function solution(hp) {
    var answer = 0;
    
    let mod1 = hp%5
    answer += (hp-mod1)/5
    let mod2 = mod1%3
    answer += (mod1-mod2)/3
    answer += mod2
    
    return answer;
}