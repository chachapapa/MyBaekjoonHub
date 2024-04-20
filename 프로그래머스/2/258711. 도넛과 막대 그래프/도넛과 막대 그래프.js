

const solution = (edges) => {
    //도넛 그래프 n 개의 정점 n개의 간선 => 순환그래프
    //막대 그래프 직선 n개의 정점 n-1개의 간선 트리
    //8자 그래프  2n+1개의 정점 2n+2개의 간선
    //무관한 정점을 찾는게 포인트겠네
    //들어오는 간선은 당연히 없을거구
    //다른 그래프를 구성하는 노드가 들어오는 간선이 없는게 있나?
    //있다. 막대모양그래프 첫째노드
    //그럼 들어오는거 없는애들 다세서 -1 하면 막대그래프 갯수
    // 고려하지 못한 예외가 있을 것 같다 일단..
    // 찾았다. 각 그래프의 갯수 합은 2 이상.
    
    let inputCheck = new Map()
    
    for(let line of edges){
        
        if(!inputCheck.get(line[0])){
            inputCheck.set(line[0],{in : 0, out : 1})
        }else{
            inputCheck.get(line[0]).out += 1
        }
        
        if(!inputCheck.get(line[1])){
            inputCheck.set(line[1],{in : 1, out : 0})
        }else{
            inputCheck.get(line[1]).in += 1
        }
    }
    let myNode = 0
    let total = 0
    let doughnut = 0
    let stick = 0
    let eight = 0
    for(let node of inputCheck){
       
        if(node[1].in === 0 && node[1].out >= 2){
                myNode = node[0]
                total = node[1].out
        }
        
        if(node[1].out === 0){
            stick += 1
        }
        
        if(node[1].in >= 2 && node[1].out === 2){
            eight += 1
        }
    }
    
    answer = [myNode,total-stick-eight, stick, eight]
    
    return answer;
}