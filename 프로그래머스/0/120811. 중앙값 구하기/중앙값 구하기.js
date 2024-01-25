function solution(array) {
    var answer = 0;

    array = array.sort((a, b) => a - b);
    console.log()
    answer = array[Math.floor(array.length/2)]
    return answer;
}