function solution(my_string, letter) {
    var answer = '';
    
    let arr = my_string.split("")
    
    for(let i = 0 ; i<my_string.length ; i++){
        if(arr[i] !== letter){
            answer += arr[i]
        } 
    }
    
    return answer;
}