function solution(my_string) {
    let answer = '';
    
    let arr = my_string.split("");
    let reverse = []
    for(let i = 0; i<arr.length; i++){
        reverse.push(arr[arr.length-1-i])
    }
    answer = reverse.join("")
    return answer;
}