function solution(cacheSize, cities) {
    var answer = 0;
    //db 캐시 사이즈, 도시 이름 배열
    //cache hit 일 경우 실행시간 1
    //cache miss 일 경우 실행시간 5
    //hit 은 저장되어있을때, miss는 저장 안되어있을때인듯...?
    //캐시 교체 알고리즘은 LRU 즉 가장 사용한지 오래된 캐시 교체 (map 가장 앞에 있는 값)
    //
    //같을때는... 아마 먼저 들어온거 빼는거인걸로 아는데...
    //이 경우가 필요가 없을수도?
    //해보자
    //대소문자 구분 없음 ㅅㅂ 함정
    
    //캐시의 형태는 city : 횟수
    let cache = new Map()
    let time = 0
    for(let city of cities){
        city = city.toUpperCase()
        //캐시에 도시가 존재할 때
        if(cache.has(city)){
            time += 1
            //시간 업데이트 해서 가장 최신으로 데이터 업데이트
            let currentCount = cache.get(city)
            cache.delete(city)
            cache.set(city, currentCount+1)
            
        //캐시에 도시가 없을 때
        }else{
            time += 5
            //캐시 교체 로직
            //빈칸이 있을 때
            if(cache.size < cacheSize){
                cache.set(city, 1)
            //빈칸이 없을 때
            }else{
                //설정된 캐시 사이즈가 0 보다 크면 교체
                if(cacheSize > 0){
                    cache.delete(cache.keys().next().value)
                    cache.set(city, 1)
                }
            }
            
        }
    }
    
    answer = time

    
    
    return answer;
}