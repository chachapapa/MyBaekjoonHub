function solution(phone_book) {
    var answer = true;
    phone_book.sort()
    console.log(phone_book)
    for(let i = 0 ; i<phone_book.length-1 ; i++){

        if(phone_book[i+1].indexOf(phone_book[i])===0){
            answer =false
            break;
        } 
    }
    

    
    
    return answer;
}