function solution(n, t, m, timetable) {
    var answer = '';
    
    // 9:00 부터 총 n 회 t 분 간격 최대 m명 탑승
    //크루들이 대기열에 도착하는 시간 timetable
    //도착시간 이전까지 쌓인 인원 - 탑승가능인원 => 이월
    //마지막 버스에 남은 자리가 있다면 해당 도착시간이 정답
    //마지막 버스에 남은 자리가 없다면 해당 버스 
    //콘이 셔틀을 타고 사무실로 갈 수 있는 도착시간 중 제일 늦은 시간
    
    let buses = new Map()
    let keys = []
    
    for(let i = 0 ; i< n ; i++){
        buses.set(540+t*i,[])
        keys.push(540+t*i)
    }
    
    for(let i = 0 ; i<timetable.length ; i++){
        let passenger = timetable[i]
        let tmp = passenger.split(":")
        let time = tmp[0]*60+Number(tmp[1])
        timetable[i] = time;
        
    }
    
    
    
    timetable.sort((a,b)=>{
        return a-b
    })
    let idx = 0
    let lastBus
    //각각의 버스에 대해
    for(let key of keys){
        
        //승객을 태웁시다.
        while(idx <timetable.length){
            let passenger = timetable[idx]
            
            //못태우는 경우 (시간 놓침 or 만석)
            if(key < passenger || buses.get(key).length === m){
                
                //이번차 이후로 버스도 더 없는 경우
                if(buses.size === 1){
                    //여기에 어떻게든 태워야되니까 저장
                    lastBus = [key, buses.get(key)]
                }
                
                //버스 삭제
                buses.delete(key)
                break;
            }
            //탑승
            buses.set(key, [...buses.get(key),passenger])
            idx += 1
        }
        
        if(idx === timetable.length){
            // console.log("여기 걸리는 경우가 있나")
            while(buses.size > 1){
                buses.delete(buses.keys().next().value)
            }
            lastBus = [buses.keys().next().value, buses.get(buses.keys().next().value)]
            break;
        }
        
    }

    // console.log(buses)
    // console.log(lastBus)
    let time = 0
    
    if(lastBus[1].length < m){
        time = lastBus[0]
    }else{
        time = lastBus[1][lastBus[1].length-1]-1
    }
    
    
    let hour= (time-(time%60))/60
    let minute = time%60
    
    if(hour < 10){
        answer = "0"+hour
    }else{
        answer = hour
    }
    
    answer += ":"
    
    if(minute === 0){
        answer += "00"
    }else if(minute < 10){
        answer += "0"+minute
    }else{
        answer += minute
    }
    
    return answer;
}