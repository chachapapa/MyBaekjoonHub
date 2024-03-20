function solution(nums) {
    var answer = 0;
    const max = nums.length/2
    
    const set = new Set([...nums])
    
    if(max > set.size) {answer = set.size} else{
        answer = max
    }
    
    
    return answer;
}