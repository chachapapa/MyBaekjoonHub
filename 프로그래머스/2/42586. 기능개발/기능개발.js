function solution(progresses, speeds) {
    var answer = [];
    let day = 1;
    let count = 0;
    let total = progresses.length
    
    while(progresses.length > 0){
        if(progresses[0] + day*speeds[0] >= 100){
            count += 1
            progresses.shift()
            speeds.shift()
        }else{
            if(count > 0){
                answer.push(count)
                count = 0
            }
            day += 1
        }
    }
    
    if(count > 0){
        answer.push(count)
    }
    return answer;
}