function solution(relation) {
    var answer = 0;
    
    //학번 이름 전공 학년
    // 유일성 : 데이터가 유일해 식별가능함
    // 최소성 : 키를 구성하는 속성중 하나를 제외하면 유일성이 파괴됨
    // 기능한 후보키의 갯수를 구하라.
    
    
    //가능한 모든 후보키의 나열
    let keyCombinations = new Map()
    getCombination(keyCombinations, relation[0].length, 0, [])
    // console.log(keyCombinations)
    //유일성을 확보하지 못한 키 제거
    let keyToDelete = []
    for(let keyCombi of keyCombinations){
        
        for(let key of keyCombi[1]){
             if(!checkOnly(relation, key)){
                keyToDelete.push(key)
            }
        }
       
        
    }
    
    for(let key of keyToDelete){
        let tmpKeys = keyCombinations.get(key.length)
        
        tmpKeys = tmpKeys.filter(arr => arr != key)
        keyCombinations.set(key.length, tmpKeys)
    }
    
    // console.log(keyCombinations)
    
    
    //최소성을 확보하지 못한 키 제거
    //어떻게?
    //일단 길이 제일 작은 데이터부터 올라가면서
    //해당 데이터를 포함하는 키는
    //제거하는 방향으로?
    checkMinimum(keyCombinations, relation[0].length)
    
    for(let key of keyCombinations){
        answer += key[1].length
    }
    return answer;
}

const checkOnly = (relation, keyCombi) => {
    
    let map = new Map()
    for(let data of relation){
        let key = ""
        for(let index of keyCombi){
            key += data[index]
        }
        
        if(!map.get(key)){
            map.set(key, 1)
        }else{
            return false
        }
    }
    
    return true
    
}

const checkMinimum = (keyCombinations, length) => {
    
    // console.log(keyCombinations, length)
    for(let i = 1 ; i<=length ; i++){
        
        let Keys = keyCombinations.get(i)
        // console.log("Keys", Keys)
        
        //짧은 키부터 순회
        for(let key of Keys){
            
            //자기보다 긴 애 순회
            for(let j=i+1 ; j<=length ; j++){
                
                //삭제할 키 넣을 배열
                let newKeys = []
                let targetKeys = keyCombinations.get(j)
                
                targetCheck :
                for(let targetKey of targetKeys){
                    let isSubset = true
                    
                    for(let keyData of key){
                        targetKey.includes(keyData)? null : isSubset = false; 
                        
                        if(!isSubset) {
                            newKeys.push(targetKey)
                            continue targetCheck
                        }
                        
                    }
                }
                keyCombinations.set(j, newKeys)
            }
        
        }
        

        
    }
}

//컬럼의 인덱스로 조합 구하기
const getCombination = (arr, length, index, result) => {
    
    if(index == length){
        if(arr.get(result.length)){
            arr.set(result.length, [...arr.get(result.length),result] )
        }else{
            arr.set(result.length, [result])
        }
        return
    }

    getCombination(arr, length, index+1, [...result, index])
    getCombination(arr, length, index+1, result)
    
}

