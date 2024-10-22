function solution(m, musicinfos) {
    var answer = '(None)';
    let maxPlayTime = 0
    
    let mArr = []
    for(let code of m){
        if(code == "#"){
            mArr[mArr.length-1] = mArr[mArr.length-1]+"#"
        }else{
            mArr.push(code)
        }
    }
    
    for(let musicInfo of musicinfos){
        let musicInfoArr = musicInfo.split(",")
        let start = musicInfoArr[0].split(":")
        let end = musicInfoArr[1].split(":")
        let playTime = end[0]*60+end[1]*1-(start[0]*60+start[1]*1)
        let title = musicInfoArr[2]
        let melodi = musicInfoArr[3]
        
        
        
        //한곡의 멜로디 구분
        let melodiArr = []
        for(let code of melodi){
            if(code == "#"){
                melodiArr[melodiArr.length-1] = melodiArr[melodiArr.length-1]+"#"
            }else{
                melodiArr.push(code)
            }
        }
        
        //재생 시간동안 재생된 모든 멜로디
        let totalMelodi = []
        for(let i = 0 ; i < playTime ; i++){
            totalMelodi.push(melodiArr[i%melodiArr.length]) 
        }

        for(let i = 0; i< totalMelodi.length ; i++){
            
            if(totalMelodi[i] == mArr[0]){
                let targetMelodi = totalMelodi.slice(i, i+mArr.length).reduce((acc, curr)=>{return acc+curr},"")
                
                if(m == targetMelodi){
                    if(playTime > maxPlayTime){
                        maxPlayTime = playTime
                        answer = title
                    }
                    break
                }
            }
        }
        
    }
    
    return answer;
}