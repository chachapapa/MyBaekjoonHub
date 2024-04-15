const alphabetCheck = (str) => {
    if(str.toUpperCase().toUpperCase().charCodeAt()>=65 && str.toUpperCase().charCodeAt()<= 90){
        return true;
    }
    return false
}

function solution(str1, str2) {
    var answer = 0;
    
    // 두 집합의 교집합크기를 합집합크기로 나눈 값.
    // 두 집합 모두 공집합이면 유사도는 1
    
    const arr1 = str1.split("")
    const arr2 = str2.split("")

    let pair1 = new Map()
    let pair2 = new Map()
    
    for(let i = 0 ; i<arr1.length-1 ; i++){
        let first = arr1[i]
        let second = arr1[i+1]
        //아스키코드 영문 대문자 65~90
        if(alphabetCheck(first) && alphabetCheck(second)){
            let word = first.toUpperCase()+second.toUpperCase()
            if(pair1.has(word)){

                pair1.set(word, pair1.get(word)+1) 
            }else{
                pair1.set(word,1) 
            }
        }
    }
    
    for(let i = 0; i<arr2.length-1 ; i++){
        let first = arr2[i]
        let second = arr2[i+1]
        //아스키코드 영문 대문자 65~90
        if(alphabetCheck(first) && alphabetCheck(second)){
            let word = first.toUpperCase()+second.toUpperCase()
            if(pair2.has(word)){

                pair2.set(word, pair2.get(word)+1)      
            }else{
                pair2.set(word,1)
            }
        }
    }
    let top = 0
    let bottom = 0
    //중복이 가능하니까
    //교집합은 하나 순회하면서 겹치면 작은수 넣으면되고
    //합집합은 그냥 한쪽으로 몰자.
    for(let word of pair1){
        
        if(pair2.has(word[0])){
            top += Math.min(word[1], pair2.get(word[0]))
            
            if(word[1] > pair2.get(word[0])){
                pair2.set(word[0],word[1])
            }
        }else{
            pair2.set(word[0],word[1])
        }
        
    }
    
    for(let word of pair2){
      bottom += word[1]
    }
    
    if(bottom !== 0){
        answer = Math.floor(top/bottom*65536)
    }else{
        answer = 65536
    }
    
    
    
    return answer;
}