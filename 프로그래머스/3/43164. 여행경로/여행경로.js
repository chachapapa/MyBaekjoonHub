let lastHistory = []

const flight = (tickets, visit, now, history) => {

    let finishCheck = true
    
    for(let i = 0 ; i<visit.length ; i++){
        if(!visit[i]){
            finishCheck = false
        }
    }
    
    if(finishCheck){
   
        for(let i = 0 ; i<history.length ; i++){

            if(history[i].localeCompare(lastHistory[i])>0){
                break;
            }
            if(history[i].localeCompare(lastHistory[i])<0){
                lastHistory = history
                break;
            }
        }
    }else{
       for(let i = 0; i<tickets.length ; i++){
        if(tickets[i][0] == now && !visit[i]){
                let updatedHistory = JSON.parse(JSON.stringify(history))
                let updatedVisit = JSON.parse(JSON.stringify(visit))
                updatedHistory.push(tickets[i][1])
                updatedVisit[i] = true;
                flight(tickets, updatedVisit, tickets[i][1], updatedHistory)
            }
        }     
    }
    
}

function solution(tickets) {
    var answer = [];
    let visit = []
    for(let i = 0; i<tickets.length ; i++){
        visit.push(false);
    }

        let history = []
        history.push("ICN")
        flight(tickets, visit, "ICN", history)

    
    answer = lastHistory
    return answer;
}