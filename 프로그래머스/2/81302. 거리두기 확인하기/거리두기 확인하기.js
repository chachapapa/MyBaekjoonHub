let dx = [0,0,1,-1,1,-1,1,-1,2,-2,0,0]
let dy = [1,-1,0,0,1,-1,-1,1,0,0,2,-2]

function solution(places) {
    var answer = [];

    
    for(let room of places){

        let ruleCheck = true
        
        for(let i = 0 ; i<5 ; i++){
            room[i] = room[i].split("")
        }
        
       roomLoop: 
        for(let i = 0 ; i<5 ; i++){
            for(let j = 0 ; j<5 ; j++){
                if(room[i][j] == "P"){
                  ruleCheck = distanceCheck(room, [i,j])
                }
                
                if(!ruleCheck) break roomLoop
            }
        }
        
        answer.push(ruleCheck? 1 : 0)
    }
    
    return answer;
}


const distanceCheck = (room, curr) => {
    for(let i = 0 ; i<4 ; i++){
        let tx = curr[0]+dx[i]
        let ty = curr[1]+dy[i]
       
        if(tx < 0 | tx >= 5 | ty < 0 | ty >= 5 ){
           continue 
        } 
        if(room[tx][ty] == "P") return false
    }
    
    for(let i = 4; i<8; i++){
        let tx = curr[0]+dx[i]
        let ty = curr[1]+dy[i]
        if(tx < 0 | tx>=5 | ty<0 | ty>=5) continue
        if(room[tx][ty] == "P"){
            if(room[curr[0]][ty] != "X" | room[tx][curr[1]] != "X") return false
        }
    }
    
    for(let i = 8 ; i<12 ;i++){
        let tx = curr[0]+dx[i]
        let ty = curr[1]+dy[i]
        let bx = curr[0]+dx[i]/2
        let by = curr[1]+dy[i]/2
        if(tx < 0 | tx>=5 | ty<0 | ty>=5) continue
        if(room[tx][ty] == "P"){
            if(room[bx][by] != "X") return false
        }
    }
    
    return true
}