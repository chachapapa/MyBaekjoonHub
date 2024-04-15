function solution(gems) {
    var answer = [];
    
    let check = new Set()
    let basket = new Map()
    
    for(let gem of gems) check.add(gem)
    
    let startIdx = 0
    for(let i  = 0 ; i<gems.length ;i++){
        let gem = gems[i]
        
        //스타트 갱신을 언제 하느냐...
        //startidx가 endIdx의 값과같을때...
        //스타트 값은 들어있는 값 중 가장 작은 값.
        //
        if(basket.has(gem)){
            
            basket.delete(gem)
            basket.set(gem,i)
            
            if(gems[startIdx] === gem){
                for(let gem of basket){
                    startIdx = gem[1]
                    break;
                }
            }
        }else{
            basket.set(gem,i)
        }
        
        if(basket.size === check.size){
            if(answer.length === 0){
                answer = [startIdx+1,i+1]
            }else{
                if(answer[1]-answer[0] > i-startIdx){
                    answer = [startIdx+1, i+1]
                }
            }
        }
    }
    
    
    return answer

}