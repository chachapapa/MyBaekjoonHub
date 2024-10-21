function solution(files) {
    var answer = [];
    
     files.sort((a,b)=>{
        
        let aArr = splitName(a)
        let bArr = splitName(b) 
        // console.log(aArr, bArr) 
        // let aHead = aArr[0].replace(/[\s\-.]/g, "").toLowerCase()
        // let bHead = bArr[0].replace(/[\s\-.]/g, "").toLowerCase()
        
        let aHead = aArr[0].toLowerCase()
        let bHead = bArr[0].toLowerCase()
        if(aHead < bHead) return -1
        if(aHead > bHead) return 1         
         
        return numSort(aArr[1], bArr[1])
    })
    
    
    answer = files
    return answer;
}


const numSort = (a, b) => {
    let aNum = parseInt(a,10)
    let bNum = parseInt(b,10)
    
    if(aNum < bNum) return -1
    if(aNum > bNum) return 1
        
    return 0
}

const splitName = (text) => {
   
    let numStart = 0
    let tailStart = 0
    
    for(let i = 0 ; i<text.length ; i++){
         //48~57 숫자
        if(text[i].charCodeAt() >= 48 && text[i].charCodeAt() <= 57){
            numStart = i
            break
        }
    }
    
    for(let i = numStart ; i<text.length ; i++){
        
       if(text[i].charCodeAt() < 48 | text[i].charCodeAt() > 57){
            tailStart = i
            break
        }
    }
    
    if(tailStart === 0) tailStart = text.length+1
    
    if(tailStart - numStart > 5){
        return [text.slice(0,numStart), text.slice(numStart, numStart+5), text.slice(numStart+5)]
    }else{
        return [text.slice(0,numStart), text.slice(numStart, tailStart), text.slice(tailStart)]
    }
    
    
}