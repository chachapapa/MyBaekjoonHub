const dx = [0,0,1,1]
const dy = [0,1,0,1]
let found = true

function solution(m, n, board) {
    var answer = 0;

    for(let i = 0 ; i<m ; i++){
        board[i] = board[i].split("")
    }
    
        while(true){
            
            let found = false
            for(let i = 0; i<m-1 ; i++){
                for(let j = 0 ; j<n-1 ; j++){
                    if(board[i][j] != " ") {
                        let result = squareCheck(board, {x : i , y : j})
                        if(result) found=true
                    }
                } 
             }
            
            if(!found) break

           removeEmpty(board) 
            // console.log(board)
        }
        
        
        for(let i = 0 ; i< board.length ; i++){
            for(let j = 0 ; j<board[0].length ; j++){
                if(board[i][j] == " ") answer += 1
            }
        }
    
    
  return answer  
}

const squareCheck = (board, start)=>{
    let startChar = board[start.x][start.y].toLowerCase()
    for(let i = 0 ; i<4 ; i++){
        let tx = start.x+dx[i]
        let ty = start.y+dy[i]
        if(board[tx][ty].toLowerCase() != startChar) return false
    }
    
    
     for(let i = 0 ; i<4 ; i++){
        let tx = start.x+dx[i]
        let ty = start.y+dy[i]
        
        board[tx][ty] = startChar 
    }
    
    return true
}

const removeEmpty = (board) => {
    for(let i = board.length-1 ; i>=0 ; i--){
        for(let j = 0 ; j<board[0].length ; j++){
            
            
            if(board[i][j].toUpperCase() != board[i][j] | board[i][j] == " "){
                // console.log(board)
                board[i][j] = " "
                dropCheck(board, i, j)
            }
        }
    }
}
    
    
const dropCheck = (board , x, y) => {
    
    let found = false
    for(let i = x-1 ; i>=0 ; i--){
        if(board[i][y].toUpperCase() == board[i][y] && board[i][y] != " ") {
            board[x][y] = board[i][y]
            board[i][y] = " "
            found = true
            break;
        }
    }
    if(!found) board[x][y] = " "
}