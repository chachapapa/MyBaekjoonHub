
let results = new Set()
function solution(user_id, banned_id) {
    
    //밴 아이디에는 * 최소 하나.
    //비슷한 아이디가 있을 수 있음. 경우의수
    //몇가지? 리턴하시오
    
    let banned = new Map()
    
    for(let id of banned_id){
        if(banned.get(id)){
            let update = banned.get(id)
            update.count += 1
            banned.set(id, update)
        }else{
             banned.set(id, {count : 1, match : []})
        }
       
       
    }
    
    for(let id of user_id){
        
        correctCheck:
        for(let bannedId of banned){
            
            let currOption = bannedId[0]
            if(id.length != currOption.length) continue
            
            for(let i = 0 ; i<id.length ; i++){
                if(currOption[i] == "*") continue
                if(currOption[i] != id[i]) continue correctCheck
            }
            
            let update = bannedId[1]
            update.match.push(id)
            banned.set(currOption, update)
        }
        
    }
    
    
    getCombination(banned, banned_id, [])
    
    return results.size;
}

const getCombination = (banned, banned_id, arr) => {
   if(arr.length == banned_id.length){
       // console.log("텍스트모야이 아닌디", JSON.stringify(arr.sort()))
       results.add(JSON.stringify(arr.sort()))
       return
   }
    
    let curr = banned_id[arr.length]
    
    let option = banned.get(curr)
    
    for(let id of option.match){
        if(!arr.includes(id)) getCombination(banned,banned_id, [...arr, id])
    }
    
    
}