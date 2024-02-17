function solution(emergency) {
    var answer = [];
    let sortedArr = [...emergency].sort((a,b)=>{return b-a})
    for(let i = 0; i<emergency.length ; i++){
        let currentNum = emergency[i]
        for(let j = 0; j<sortedArr.length ; j++){
            if(sortedArr[j] === currentNum){
                answer.push(j+1)
            }
        }
    }
    
    return answer;
}