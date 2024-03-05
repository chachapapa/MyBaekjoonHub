function solution(s) {
    
    
    var answer = s.length;
    let res = ''
    function zip(arr, start, count, str) {
        if(start < arr.length-1){
            if(arr[start] === arr[start+1]){
                zip(arr, start+1, count+1, str)
            }else{
                if(count === 0){
                    str += arr[start]
                    zip(arr, start+1, 0, str)
                }else{
                    str += String(count+1)+arr[start]
                    zip(arr,start+1, 0, str)
                }
            }
        }else{
             if(count === 0){
                res = str + arr[start]
            }else{
                res = str+String(count+1)+arr[start]
            }
        }
    }
    
    
    //자르는 갯수 1~s.length
    for(let i = 1 ; i<=Math.floor(s.length) ; i++){
        
        let arr = []
        for (let j = 0; j < s.length; j += i) {
        arr.push(s.slice(j, j + i));
        }
        zip(arr, 0,0, '')

        if(res.length < answer){
            answer = res.length
        }
    }
    return answer;
}
