function solution(fees, records) {
    var answer = [];
    
    //[기본시간, 기본요금, 단위시간, 단위요금]
    //["시간 번호 in/out"]
    
    const defaultTime = fees[0];
    const defaultFee = fees[1];
    const unitTime = fees[2];
    const unitFee = fees[3];
    
    let sortedRecords = {}
    
    for(let i = 0 ; i<records.length ; i++){
        let current = records[i].split(" ");
        
        if(sortedRecords[current[1]]){
            sortedRecords[current[1]].push(current[0])
        }else{
            
            // if(sortedRecords[current[2]] === "OUT"){
            //     sortedRecords[current[1]] = ["00:00"]
            //     sortedRecords[current[1]].push(current[0])
            // }else{
                sortedRecords[current[1]] = [current[0]]
            // }
            
        }
    }
    console.log(sortedRecords)
    
    let keys = Object.keys(sortedRecords)
    keys.sort()
    
    for(let i = 0; i<keys.length ;i++){
        let currentCar = sortedRecords[keys[i]]
        let totalTime = 0;
        let totalFee = 0;
            for(let j = 0 ; j<Math.ceil(currentCar.length/2) ; j++){
                let inTime = currentCar[j*2].split(":").map(Number)
            
                let outTime = []
            
                if(currentCar[j*2+1]){
                    outTime = currentCar[j*2+1].split(":").map(Number)
                }else{
                    outTime = [23, 59]
                }
        
                let time = (outTime[0]-inTime[0]) * 60 + outTime[1]-inTime[1]
                totalTime += time;
                
            }
            if(totalTime <= defaultTime ){
                totalFee += defaultFee
            }else{
              totalFee += Math.ceil((totalTime-defaultTime)/unitTime)*unitFee+defaultFee
            }
        answer.push(totalFee)
    }
    
    return answer;
}