function solution(maps) {
    var answer = 1;
    let visited = maps
    let queue = []
    const dx = [0, 0, 1, -1]
    const dy = [1, -1, 0, 0]
    const goalX = maps.length-1
    const goalY = maps[0].length-1

    queue.push([0,0])
    visited[0][0] = 0
    
    while(queue.length > 0){
        let left = queue.length
        
        for(let x = 0 ; x<left ; x++){
            let now = queue.shift()
            for(let i = 0 ; i<4 ; i++){
            
                let nextX = now[0] + dx[i]
                let nextY = now[1] + dy[i]
                
                if(nextX >= 0 && nextY >= 0 && nextX <= goalX && nextY <= goalY && visited[nextX][nextY] === 1){
                    if(nextX == goalX && nextY == goalY){
                    return ++answer
                    }
                    queue.push([nextX,nextY])
                    visited[nextX][nextY] = 0
                }
            }
        }
        answer++
    }
    
    return -1;
}