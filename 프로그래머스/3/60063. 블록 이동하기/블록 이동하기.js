let dx = [0,0,1,-1]
let dy = [1,-1,0,0]
let turn = [1,-1]
let tx = []
//축회전은 l, r 중 하나 잡고
//나머지 하나를 기준에서 dx dy 더한값으로 변경하는 것.

const posCheck = (left, right, board) => {
    
    
    if(left[0] < 0 ||left[0] >= board.length || left[1] < 0 || left[1] >= board.length){
        return false
    }
    
    if(right[0] < 0 ||right[0] >= board.length || right[1] < 0 || right[1] >= board.length){
        return false
    }
    
    if(board[left[0]][left[1]] === 1 || board[right[0]][right[1]] === 1){
        return false
    }
    
    
    return true
}

const turnCheck = (now, board, direction, status) => {
    
    if(status === "horizontal"){
        
        if(now.left[0]+direction < 0 || now.left[0]+direction >= board.length) return false

        if(board[now.left[0]+direction][now.left[1]] === 0 && board[now.right[0]+direction][now.right[1]] === 0){
            return true
        }else{
            return false
        }
    }else{
        
        if(now.left[1]+direction < 0 || now.left[1]+direction >= board.length) return false
        
        if(board[now.left[0]][now.left[1]+direction] === 0 && board[now.right[0]][now.right[1]+direction] === 0){
            return true
        }else{
            return false
        }
    }
}

const bfs = (board, sl, sr, visited) => {
    let q = []
    q.push({left : sl, right : sr, time : 0})
    visited[sl[0]][sl[1]].push(sr.toString())
    visited[sr[0]][sr[1]].push(sl.toString())
    while(q.length > 0){
        let now = q.shift()
        if(now.left[0] === board.length-1 && now.left[1] === board.length-1){
            return now.time
        }
        
        if(now.right[0] === board.length-1 && now.right[1] === board.length-1){
            return now.time
        }
        
        for(let i = 0 ; i<4 ; i++){
            //이동
            let next = {left : [now.left[0]+dx[i],now.left[1]+dy[i]],
                        right : [now.right[0]+dx[i],now.right[1]+dy[i]], 
                        time : now.time+1}
            if(posCheck(next.left,next.right, board)){
                if(!visited[next.left[0]][next.left[1]].includes(next.right.toString())){
                    q.push(next)
                    visited[next.left[0]][next.left[1]].push(next.right.toString())
                    visited[next.right[0]][next.right[1]].push(next.left.toString())
                }
            }
        }
        
        let status = "vertical"
        
        if(now.left[0] === now.right[0]){
            status = "horizontal"
        }    
        
        
        for(let direction of turn){
            if(turnCheck(now, board, direction, status)){
               let next1
               let next2
               
               if(status === "horizontal"){
                    next1 = {left : [now.left[0],now.left[1]],
                        right : [now.left[0]+direction,now.left[1]], 
                        time : now.time+1}
                    next2 = {left : [now.right[0],now.right[1]],
                        right : [now.right[0]+direction,now.right[1]], 
                        time : now.time+1}
                }else{
                    next1 = {left : [now.left[0],now.left[1]],
                        right : [now.left[0],now.left[1]+direction], 
                        time : now.time+1}
                    next2 = {left : [now.right[0],now.right[1]],
                        right : [now.right[0],now.right[1]+direction], 
                        time : now.time+1}
                }
               
        
               if(!visited[next1.left[0]][next1.left[1]].includes(next1.right.toString())){
                    q.push(next1)
                    visited[next1.left[0]][next1.left[1]].push(next1.right.toString())
                    visited[next1.right[0]][next1.right[1]].push(next1.left.toString())
                }
            
                if(!visited[next2.left[0]][next2.left[1]].includes(next2.right.toString())){
                    q.push(next2)
                    visited[next2.left[0]][next2.left[1]].push(next2.right.toString())
                    visited[next2.right[0]][next2.right[1]].push(next2.left.toString())
                }
            }
        }
            
    }
    
}


function solution(board) {
    var answer = 0;
    //로봇은 두칸을 차지한다
    //회전시 축의 대각선에 있는 칸이 막혀있으면 회전할 수 없다.
    //n,n 까지 두칸중 하나만 들어가면 성공
    //현재 방향에서 들어갈 수 없는 빈칸을 찾아야겠네..
    //bfs긴 한데 조금 복잡한 bfs
    //그냥 회전까지 경우의수로 넣어서 돌려야되나?
    //이동이랑 같은 느낌으로?
    //방문처리는 어떻게 처리하지.
    //들어간 자리에 같이 들어간 좌표를 넣어야겠다.
    
    let visited = new Array(board.length).fill().map(_=>new Array(board.length).fill().map(()=>new Array()))
    answer = bfs(board, [0,0], [0,1], visited)
    
    return answer;
}