const getOrder = (char) => {
    if(char === "(" || char ===")"){
        return 0
    }
    
    if(char === "+" || char === "-"){
        return 1
    }
    
    if(char === "*" || char === "/"){
        return 2
    }
}

function solution(my_string) {
    var answer = 0;
    let arr = my_string.split(" ")
    let operator = new Set(["+","-", "*", "/", "(", ")"])
    let stack = []
    let problem = []
    for(let char of arr){
        let order = getOrder(char)
        if(!operator.has(char)){
            problem.push(char)
        }else{
            if(stack.length === 0){
                stack.push(char)
            }else if(char === ")"){
                while(stack[stack.length-1] !== "("){
                    problem.push(stack.pop())
                }
                stack.pop()
            }else{
                if(getOrder(stack[stack.length-1]) >= order){
                    problem.push(stack.pop())
                    stack.push(char)
                }else{
                    stack.push(char)
                }
                
            }
        }
    }
    
    while (stack.length >0){
        problem.push(stack.pop())
    }
    
    console.log(problem)
    
    for(let char of problem){
        if(!operator.has(char)){
            stack.push(char)
        }else{
            if (char==="+"){
                let second = Number(stack.pop())
                let first = Number(stack.pop())
                stack.push(first+second)
            }
            if(char==="-"){
                let second = Number(stack.pop())
                let first = Number(stack.pop())
                stack.push(first-second)
            }
            if(char==="*"){
                let second = Number(stack.pop())
                let first = Number(stack.pop())
                stack.push(first*second)
            }
            if(char==="/"){
                let second = Number(stack.pop())
                let first = Number(stack.pop())
                stack.push((first-(first%second))/second)
            }
        }
    }
    
    answer = stack.pop()
    
    
    return answer;
}