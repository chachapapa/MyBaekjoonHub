function solution(n, weak, dist) {
    // 많은 거리를 수리할 수 있는 인원이 최소 인원을 구하기에 항상 적합하므로 내림차 순 정렬
    dist = dist.sort((a,b) => b-a)
    
    // 정방향/역방향 탐색을 위한 일렬 형태의 배열을 생성해야함 즉,
    // [1, 5, 6, 10] -> [1, 5, 6, 10, 13(1+12(역방향)), 17, 18]
    const linear = [...weak]
    weak.forEach(day => {
        linear.push(day+n)    
    })
    linear.pop()
    
    // 최소 인원 구하기
    for(let i = 1 ; i <= dist.length ; i ++) {
        // 이번 순열을 구함 ex) [[4],[3],[2],[1]] , [[4,3], [4,2] ...]
        const curPermutation = Permutation(dist, i)
        for(const cur of curPermutation) {
            for(let j = 0 ; j < weak.length ; j ++) {
                // ex) [[1, 5, 6, 10], [5, 6, 10, 13] ...]
                let line = linear.slice(j, weak.length+j)
                for(const p of cur) {
                    // 경로 시작점과 현재 인원의 거리를 더해 이 범위보다 크다면 작업 불가
                    const coverage = line[0] + p
                    line = line.filter(a => a > coverage)
                    // 작업이 가능한 최소 인원이라면 반환
                    if(!line.length) return i
                }
            }
        }
    }
    
    
    return -1
}

    // 현재 가능한 경우의 순열을 구해준다.
    function Permutation(arr, n) {
        if(n === 1) return arr.map(el => [el])
        const result = []

        arr.forEach((fix, idx, origin) => {
            const another = [...origin.slice(0, idx), ...origin.slice(idx+1)]
            const perms = Permutation(another, n-1)
            const attach = perms.map(perm => [fix, ...perm])
            result.push(...attach)
    })
    
    return result
}