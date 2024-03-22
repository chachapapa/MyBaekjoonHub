
//내가 한 건 dfs 다. 끼엑
//bfs 는 큐 쓰는거다.
//shift 쓰면 될거같긴한데
// 구현해서 써보자

class Queue {
    constructor() {
        //값이 저장되는 곳
        this.store = {}
        //첫번째 데이터의 위치
        this.front = 0
        //마지막 데이터의 위치
        this.rear = 0
    }
    
    size(){
        if(this.store[this.rear] === undefined){
            return 0
        }else{
            return this.rear-this.front+1
        }
    }
    
    push(value){
        if(this.size() === 0){
            this.store[0] = value
        }else{
            this.rear += 1
            this.store[this.rear] = value
            
        }
    }
    
    pop() {
        let tmp
        if(this.rear === this.front){
            tmp = this.store[this.front]
            delete this.store[this.front]
            this.front = 0;
            this.rear = 0;
            return tmp
        }else{
            tmp = this.store[this.front]
            delete this.store[this.front]
            this.front +=1;
            return tmp
        }
    }
}

    let deepest = 0;
    let count = 0;

const bfs = (graph, start, visited) => {
    const q = new Queue();

    q.push({node : start, depth : 0})

    while(q.size() > 0){
        let curr = q.pop()
        if(deepest < curr.depth){
            deepest = curr.depth
            count = 1
        }else if(deepest === curr.depth){
            count += 1
        }
        
       for(let node of graph[curr.node]){
           if(!visited[node]){
               visited[node] = true;
               q.push({node: node, depth : curr.depth+1})
           }
       }
    }
    
    
}

function solution(n, edge) {
    var answer = 0;
    
    let graph = {}
    let visited = new Array(n+1).fill(false)
    visited[1] = true;
    
    for(let i = 0; i<=n ; i++){
        graph[i] = []
    }
    
    for(let i = 0; i<edge.length ; i++){
        let curr = edge[i]
        graph[curr[0]].push(curr[1])
        graph[curr[1]].push(curr[0])
    }
    bfs(graph, 1, visited)
    answer = count
    return answer;
}