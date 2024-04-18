const dij = (map, start) => {
    let q = []
    let visit = new Array(map.size).fill()
    
    q.push({node : start, cost : 0, route : []})
    visit[start] = {cost : 0, route : []}
    
    while(q.length > 0){
        let now = q.shift()
        //현재 위치에서 연결된 노드들
        let routes = map.get(now.node)
        
        
        for(let route of routes){
            //방문한 적이 없는 노드라면
            if(!visit[route.dest]){
                //현재까지의 비용+가는데 비용, 현재까지의 루트 + 현재노드
                visit[route.dest] = {cost : now.cost+route.cost, route : [...now.route, now.node]}
                q.push({node : route.dest, cost : now.cost+route.cost, route :  [...now.route, now.node]})
            //방문한 적 있는 노드라면
            }else{
                //해당 지점까지 가격이 같은 경우가 있을텐데... 일단 배제하고 짜보자
                //비용이 더 적을때만 루트 교체
                if(visit[route.dest].cost > now.cost+route.cost){
                    visit[route.dest] = {cost : now.cost+route.cost, route : [...now.route, now.node]}
                    q.push({node : route.dest, cost : now.cost+route.cost, route :  [...now.route, now.node]})
                }
            }
        }   

    }
    
    return visit
}

function solution(n, s, a, b, fares) {
    var answer = 0;
    
    //지점 갯수 n, 출발 s, a도착지점 a, b도착지점 b, 요금[여기서,여기까지,가격] fares
    //모든 지점에서 각각의 도착지점까지 합산.
    //스타트에서 해당 지점까지 비용 체크
    //합산
    //겹친다면 해당 비용 /2 

    let map = new Map()
    
    for(let route of fares){
        
        if(map.get(route[0])){
            map.set(route[0],[...map.get(route[0]),{dest : route[1], cost : route[2]}])
        }else{
            map.set(route[0],[{dest : route[1], cost : route[2]}])
        }
        
        if(map.get(route[1])){
            map.set(route[1],[...map.get(route[1]),{dest : route[0], cost : route[2]}])
        }else{
            map.set(route[1],[{dest : route[0], cost : route[2]}])
        }
        
    }

    
    let min = Infinity
    let start

        
        let fs = dij(map, s)
        let fa = dij(map, a)
        let fb = dij(map, b)
        let sum

        for(let el of map){
            let tmpSum = 0 
            if(!fs[el[0]] || !fa[el[0]] || !fb[el[0]]) continue
            if(fs[el[0]]) tmpSum += fs[el[0]].cost
            if(fa[el[0]]) tmpSum += fa[el[0]].cost
            if(fb[el[0]]) tmpSum += fb[el[0]].cost
        
            
            if(tmpSum < min){
                min = tmpSum
            }
        }

    answer = min
    return answer;
}

