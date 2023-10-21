function solution(n, computers) {
    var answer = 0;
    let visited = [];
    for(let i = 0 ; i<n ; i++){
        if(!visited[i]){
            dfs(i, visited, computers)
            answer += 1
        }    
    }
    
    function dfs(node, visited, computers){
        visited[node] = true
        for(let j = 0 ; j<computers.length ; j++){
            if(computers[node][j] === 1 && !visited[j]){
                dfs(j, visited, computers)
            } 
        }
    }
    
    return answer;
}