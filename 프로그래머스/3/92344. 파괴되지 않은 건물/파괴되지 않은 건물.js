function solution(board, skill) {
    var answer = 0;
    
    //그대로 이차원배열로 구현하면 당연히 터지게 만들어놨겠지?
    //스킬들이 영향을 준 타일을 저장해두고 한방에 계산해볼까
    //살아있는 타일 수만 반환하면 된대
    //[스킬타입, 행, 열, 행, 열, 수치] 1이면 공격 2 면 회복
    
    let skills = new Array(board.length+1).fill().map(_ => new Array(board[0].length+1).fill(0))
    
    skills = prefix(skill, skills)
    
    for(let i = 0 ; i<board.length ; i++){
        for(let j = 0 ; j<board[0].length ; j++){
            let hp = board[i][j] + skills[i][j]
            if(hp > 0) answer += 1
        }
    }
    
    return answer;
}
const prefix = (skills, board) => {
    for(let skill of skills){
        let deal = 0
        
        if(skill[0] === 1){
            deal = -skill[5]
        }else{
            deal = skill[5]
        }

        board[skill[1]][skill[2]] += deal
        board[skill[1]][skill[4]+1] -= deal
        board[skill[3]+1][skill[2]] -= deal
        board[skill[3]+1][skill[4]+1] += deal
    }
       for(let i = 0 ; i<board.length ; i++){
           for(let j = 1; j<board[0].length ; j++){
             board[i][j] += board[i][j-1]  
           }
       }
       
       for(let i = 1 ; i<board.length ; i++){
           for(let j = 0; j<board[0].length ; j++){
             board[i][j] += board[i-1][j]  
           }
       }
        
    
    return board
}