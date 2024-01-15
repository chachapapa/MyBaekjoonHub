function solution(num1, num2) {
    var answer = 0;
    num1 = num1- (num1%num2)
    
    
    answer = num1/num2
    return answer;
}