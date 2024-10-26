function solution(p) {
    var answer = '';
    

    answer = balancing(p)
    
    
    return answer;
}

const balancing = (text) => {
    console.log("밸런싱 실행", text)
    if(text == "") return ""
    
    let count = 0
    let u = ""
    let v = ""
    let correct = true
    
    for(let i = 0 ; i<text.length ; i++){
        
        if(count < 0) correct = false
        
        if(text[i] == "("){
            count += 1
        }else{
            count -= 1
        }
        
        if(count == 0){
            u = text.slice(0,i+1)
            v = text.slice(i+1)
            break
        }
    }
    
    let result = ""
    if(correct) {
        result = balancing(v)
        return u+result
    }else{
        result = correcting(u,v)
    }
    
    return result
}

const correcting = (u, v) => {
    let tmp = "("
    let result = "" 
    result = balancing(v)
    tmp += result
    tmp += ")"
    let slicedU = u.slice(1, u.length-1)
    let newU = ""
    for(let i = 0 ; i<slicedU.length ; i++){
        if(slicedU[i] == "(") {
            newU += ")"
        }else{
            newU += "("
        }
        
    }
    
    tmp += newU
    
    return tmp
}