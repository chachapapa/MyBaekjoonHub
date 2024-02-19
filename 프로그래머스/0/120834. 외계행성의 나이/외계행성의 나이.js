function solution(age) {
    var answer = '';
    let alphabet = ["a","b","c","d","e","f","g","h","i","j"]
    
    let arr = age.toString().split("")
    for(let i = 0 ; i<arr.length ; i++){
      for(let j = 0 ; j<alphabet.length ; j++){
        if(arr[i] == j){
            answer+= alphabet[j]
        }
      }  
    }
    
    return answer;
}