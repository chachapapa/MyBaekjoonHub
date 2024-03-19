let min = 50;
const search = (count, now, target, words, visit) => {

    if(now === target && count < min){
        min = count
        return
    }
    
    for(let i = 0 ; i<words.length; i++){
        //다음으로 바꿀 단어 후보 
        nextWord = words[i]

        //바꿨었던 단어가 아니라면
        if(!visit[i]){
            //현재 단어와 하나만 다른지 체크.
            let charCheck = 0;
            for(let j = 0; j<now.length ;j++){
                if(now.charAt(j) !== nextWord.charAt(j)){
                    charCheck +=1;
                } 
            }
            
            if(charCheck === 1){
                visitCopy = JSON.parse(JSON.stringify(visit))
                visitCopy[i] = true;
                search(count+1, nextWord, target, words, visitCopy)
            }
        }
         
    }
   
}

const solution = (begin, target, words) => {
    var answer = 0;
    //begin 에서 target 까지 words 를 통해서 변환
    let visit = []
    
    for(let i = 0 ; i<words.length ;i++){
        visit.push(false)
    }
    if(words.includes(target)){
        search(0, begin, target, words, visit, words.length)
        answer = min;
    }
    
    return answer;
}

