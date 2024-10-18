let combinations = []
function solution(orders, course) {
    var answer = [];
    
    //두가지 이상의 단품
    //최소 두명이상의 손님으로부터 주문된 조합
    //후보중에서 주어진 갯수인 코스만 추가.
    
    
    let combos = new Map()

    for(let order of orders){
        let orderArr = order.split("").sort()
        
            getCombination([], orderArr)
            
            for(let comb of combinations){
                let textify = comb.join("")
                
                if(combos.get(textify)){
                    combos.set(textify, combos.get(textify)+1)
                }else{
                    combos.set(textify, 1)
                }
            }
            
            combinations = []
                
    }
    
    for(let i of combos){
        if(i[1] === 1){
            combos.delete(i[0])
        }
    }
    
    console.log(combos)
    // removeSubset(combos)
    console.log(combos)
    
    // 코스갯수, 최대 주문횟수
    let maxCheck = new Map()
    
    
    //각 코스 갯수 별 주문횟수 맥스값 담아야함.
   for(let i = 0 ; i < course.length ; i++){
       // 현재 코스 메뉴갯수
       let count = course[i]
       
       //메뉴갯수 별 최대 주문횟수
       maxCheck.set(count, 0)
       
       combos.forEach((value, key) => {
           if(key.length === count && value >= maxCheck.get(count)) maxCheck.set(count, value)
       })
       
       
   }
    console.log(maxCheck)
    
    
    combos.forEach((value, key)=> {
        if(maxCheck.get(key.length) === value){
            answer.push(key)
        }
    })
    
    answer.sort()
    return answer;
}


//2가지 이상의 요리가 들어간 조합 구하는 함수
const getCombination = (current, remaining) => {

    if(remaining.length === 0){
        
        if(current.length >= 2) combinations.push(current)
        
        return
    }
    
    getCombination(current, remaining.slice(1))
    getCombination(current.concat(remaining[0]), remaining.slice(1))
    
}

const removeSubset = (map) => {
    let keys = Array.from(map.keys())
    for(let i = 0; i < keys.length ; i++){
        for(let j = 0 ; j< keys.length ; j++){
            
            if(keys[i] != keys[j]){
                if(isSubset(keys[i], keys[j]) && map.get(keys[i]) === map.get(keys[j])){
                    map.delete(keys[i])
                    break
                }
            }
            
        }
    }
    
}

const isSubset = (key1, key2) => {
    
    for(let i of key1){
        
        if(!key2.includes(i)){
            return false
        }
    }
    
    return true
    
}