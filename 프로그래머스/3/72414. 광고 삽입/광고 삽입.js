const getSecond = (time) => {
    let arr = time.split(":")
    
    let hour = arr[0]*60*60
    let minute = arr[1]*60
    let second = Number(arr[2])
    
    
    return hour+minute+second
    
}

const getTime = (second) => {
    let hour = (second-second%3600)/3600
    second -= hour*3600
    let minute = (second-second%60)/60
    second -= minute*60
    
    
    if(String(hour).length === 1){
        hour = "0"+hour
    }
    
    if(String(minute).length === 1){
        minute = "0"+minute
    }
    
    if(String(second).length === 1){
        second = "0"+second
    }
    return hour+":"+minute+":"+second
}

function solution(play_time, adv_time, logs) {
    var answer = '';
    
    // console.log(play_time, adv_time, logs)
    //가장 많은 사람이 시청할 수 있는 광고 시간
    let playTime = getSecond(play_time)
    let arr = new Array(playTime+1).fill(0)
    
    logs.forEach(log => {
        let start = getSecond(log.split("-")[0])
        let end = getSecond(log.split("-")[1])
        
        arr[start] += 1
        arr[end] -= 1
        
    })
    // console.log(arr)
    let max = 0
    for(let i = 1 ; i<arr.length ; i++){
        arr[i] += arr[i-1]
    }  
        // console.log(arr)
    for(let i = 1 ; i<arr.length ; i++){
        arr[i] += arr[i-1]
    }
    
    let advTime = getSecond(adv_time)
    
    for(let i = 0 ; i<arr.length-advTime ; i++){
        // console.log(i+"시작"+(i+advTime)+"끝"+ arr[i+advTime]+"에서"+arr[i]+"빼기")
        let viewSum = arr[i+advTime]-arr[i]
        if(max < viewSum){
            // console.log(viewSum)
            max = viewSum
            answer = i
        }
    }
    
    if(answer > 0){
        answer = getTime(answer+1)
    }else{
        answer = getTime(answer)
    }
    
    
    
    return answer;
}