let min = 16000
let dirX = [0,0,1,-1]
let dirY = [1,-1,0,0]
const move = (map, x, y, count , itemX, itemY) => {
    // console.log()
    // console.log("x:" + x + " y:"+ y)
    if(x === itemX && y === itemY){
        if(count < min) min = count
    }else{
        for(let i = 0 ; i<4 ; i++){
            let nextX = x+dirX[i]
            let nextY = y+dirY[i]
            if(map[nextX][nextY] === 1 || map[nextX][nextY] === 2){
                let copyMap = JSON.parse(JSON.stringify(map))
                copyMap[x][y] = 0;
                move(copyMap, nextX, nextY, count+1, itemX, itemY);
            }
        }
                
    }
    
    
}

function solution(rectangle, characterX, characterY, itemX, itemY) {
    var answer = 0;
    //[좌하x,y / 우상x,y]
    //캐릭터 -> 아이템 최소거리....
    //이게 dfs bfs?
    //하나의 사각형 잡고. 왼쪽으로 갈지 오른쪽으로 갈지 정하고...
    //걍 2차원배열 만들어서 못가는 사각형 안쪽을 false 로 만들자.
    
    let map = new Array(102)
    for(let i = 0 ; i<102 ; i++){
        map[i] = new Array(102)
        for(let j = 0 ; j<102 ; j++){
            map[i][j]= 0
        }
    }
    
    for(let i = 0 ; i< rectangle.length ; i++){
        currRec = rectangle[i]
        
        for(let j = currRec[0]*2; j<=currRec[2]*2 ; j++){
            for(let z = currRec[1]*2 ; z<=currRec[3]*2 ;z++){
                if(j<currRec[2]*2 && j>currRec[0]*2 && z>currRec[1]*2 && z<currRec[3]*2){
                    map[j][z] += 3;
                }else{
                    map[j][z] += 1; 
                }
                
            }
        }        
    }
    
    move(map, characterX*2, characterY*2, 0 , itemX*2, itemY*2)
    answer = min/2
    
    return answer;
}