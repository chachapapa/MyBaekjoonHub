const dx = [1,-1,0,0]
const dy = [0,0,1,-1]

const posCheck = (board, pos) => {
    if(pos.x === 0 && pos.y === 0){
        return false
    }
    if(pos.x >= 0 && pos.x < board.length && pos.y >= 0 && pos.y < board.length && board[pos.x][pos.y] !== 1) return true
    return false
}

const bfs = (board) => {
    let cost = new Array(board.length).fill().map(_=> new Array(board.length).fill().map(_=>new Array(2).fill(0)))
    let q = []
    q.push({enter:-1, x:0, y:0, cost: 0})
    //세로는 0 , 가로 1, 없음 -1
    
    while(q.length > 0){
        let now = q.shift()
        
        for(let i = 0 ; i<4 ; i++){
            let direction = -1
            if(i < 2) {
                direction = 0
            }else{
                direction = 1
            }
            
            let next = {x: now.x+dx[i], y: now.y+dy[i]}
            
            //범위 안인지 체크
            if(posCheck(board, next)){
                // console.log(now,"에서",next, cost[next.x][next.y], direction)
                //방문한적없는 땅이면
                if(cost[next.x][next.y][direction] === 0){
                    if(now.enter === -1 || now.enter === direction){
                        // console.log("방문한적없고 코너가 안생김")
                        cost[next.x][next.y][direction] = now.cost+100
                        q.push({enter:direction, x: next.x, y: next.y, cost : now.cost+100})
                    }else{
                        // console.log("방문한적없고 코너가 생김")
                        cost[next.x][next.y][direction] = now.cost+600
                        q.push({enter:direction, x: next.x, y: next.y, cost : now.cost+600})
                    }
                }else{
                    if(now.enter === direction){
                        if(cost[next.x][next.y][direction] > now.cost+100){
                            // console.log("방문한적 있고 코너가 안생김")
                            cost[next.x][next.y][direction] = now.cost+100
                            q.push({enter:direction, x: next.x, y: next.y, cost : now.cost+100})
                        }
                    }else{
                        if(cost[next.x][next.y][direction] > now.cost+600){
                            // console.log("방문한적 있고 코너가 생김")
                        cost[next.x][next.y][direction] = now.cost+600
                        q.push({enter:direction, x: next.x, y: next.y, cost : now.cost+600})
                        }
                    }
                }
                
            }
        }
    
    }
    
    return cost[board.length-1][board.length-1]
    
}

function solution(board) {
    var answer = 0;
    
    //bfs 로 최단거리 구하기
    //코너 하나당 500원
    //타일과 타일 사이 잇는데 100원
    
    let dest = bfs(board)
    if(dest.includes(0)){
        answer = Math.max(dest[0], dest[1])
    }else{
        answer = Math.min(dest[0],dest[1])
    }
    
    return answer;
}