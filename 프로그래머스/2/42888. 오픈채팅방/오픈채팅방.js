function solution(record) {
    var answer = [];
    
    // push 알림, pop 알림
    // 닉 변경은 나가서 또는 방 안에서 가능
    // 기존 출력 메세지의 닉도 바뀜
    let user = new Map()
    let list = []
    for(let i of record){
        let info = i.split(" ")
        
        
        if(info[0] == "Leave"){
            list.push([info[0],info[1]])
        }else{
            user.set(info[1],info[2])
            
            if(info[0] == "Enter") list.push([info[0],info[1]])
        }
    }
    
    for(let i of list){
        if(i[0] === "Leave"){
            answer.push(user.get(i[1])+"님이 나갔습니다.")
        }else{
            answer.push(user.get(i[1])+"님이 들어왔습니다.")
        }
    }
    
    return answer;
}