let max = 0

const dfs = (map, start, sheep, wolf, leftNodes) => {
    let now = map.get(start)
    
    if(now.value === 0) sheep += 1
    if(now.value === 1) wolf += 1
    
    // console.log(start, now, sheep, wolf, leftNodes)
    if(sheep > wolf){
        sheep > max? max = sheep: null
    }
    
    if(sheep <= wolf){
        // console.log("먹혔따!")
        return
    }
    
    if(leftNodes.length > 0){
        for(let i = 0 ; i<leftNodes.length ; i++){
            let tmpNodes = JSON.parse(JSON.stringify(leftNodes))
            let next = leftNodes[i]
            tmpNodes.splice(i, 1)
            now.left? tmpNodes.push(now.left) : null
            now.right? tmpNodes.push(now.right) : null
            dfs(map, next, sheep, wolf, tmpNodes)
        }
    }
    
    if(now.left){
        let tmpNodes = JSON.parse(JSON.stringify(leftNodes))
        let next = now.left
        now.right? tmpNodes.push(now.right) : null
        dfs(map,next, sheep, wolf, tmpNodes)
    }
    
    if(now.right){
        let tmpNodes = JSON.parse(JSON.stringify(leftNodes))
        let next = now.right
        now.left? tmpNodes.push(now.left) : null
        dfs(map,next, sheep, wolf, tmpNodes)
    }
  
}

function solution(info, edges) {
    var answer = 0;
    //이진트리
    //각 노드의 양을 모으자
    //양 보다 늑대가 같거나 많아지면 늑대는 양을 잡아먹는다.
    //최대한 많은 양을 모아서 루트로 돌아오는 법
    //방문처리는 필요없다. 다시 돌아올 수 있음. 데려갔는지 체크는 필요할듯.
    //각 노드 별로 최소 양 수를 체크해둬야하나.
    //늑대 1 양 0
    //늑대 카운팅 하라고 1 로 준거 아닐까?
    //
    edges.sort((a,b)=>{
        return a[0]-b[0]
    })
    
    let map = new Map()
    
    for(let edge of edges){
        if(map.get(edge[0])){
            !map.get(edge[0]).left? map.get(edge[0]).left = edge[1] :  map.get(edge[0]).right = edge[1]
        }else{
            map.set(edge[0], {value : info[edge[0]], left : edge[1], right : null})
        }
        
        if(!map.get(edge[1])){
             map.set(edge[1], {value : info[edge[1]], left : null, right : null})
        }
    }
    // console.log(map)
    dfs(map, 0, 0, 0, [])
    
    answer = max
    return answer;
}