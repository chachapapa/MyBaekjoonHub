function solution(num_list) {
    var answer = [];
    
    for(let i = 0 ; i<num_list.length ; i++){
        answer.push(num_list[num_list.length-1-i])
    }
    return answer;
}