let dic
let answer = []
function solution(msg) {
    
    let word = msg.split("")
    
    dic = new Map()
    for(let i = 65 ; i<=90 ; i++){
        let letter = String.fromCharCode(i)
        
        dic.set(letter, i-64)
        
    }
    // 1. start 지점에서 한 글자씩 붙여가면서 저장되어있는지 확인
    // 2. 저장되어 있지 않은 단어 확인시 저장되어있는 부분까지의 단어 index 출력
    // 3. 저장되어 있지 않은 단어 저장
    
    getIndex(word, "", 0)
    
    return answer;
}


const getIndex = (word, prevWord, endIdx) => {
    
    
    
    let currWord = prevWord+word[endIdx]
    
    if(endIdx >= word.length){
        answer.push(dic.get(prevWord))
        return;
    }
   
    
    if(dic.has(currWord)){
        getIndex(word, currWord, endIdx+1)
    }else{
        answer.push(dic.get(prevWord))
        dic.set(currWord, dic.size+1)
        getIndex(word, "", endIdx)
    }
    
}