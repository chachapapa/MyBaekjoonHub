function solution(s){
    var answer = true;

    let arr = s.split("")
    let stack = []
    stack.push(arr[0])
    for(let i = 1 ; i<arr.length ; i++){
        if(stack[stack.length-1] === "(" && arr[i] === ")" ){
            stack.pop(stack[stack.length-1])
        }else{
            stack.push(arr[i])
        }        
    }
    
    if(stack.length > 0){
        answer = false
    }

    return answer;
}