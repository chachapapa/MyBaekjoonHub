function solution(s) {
    var answer = [];
    
    
    // 정규표현식은 '//' 내부에 작성
    // \d => 숫자
    // 외부의 g 는 문자열 전체에서 찾음. 없으면 조건에 맞는 맨처음 문자
    // +는 해당 규칙이 한번 이상 반복되는 텍스트를 뜻함.
    // () 는 그룹을 만들어 해당 그룹에 일치하는 텍스트를 참조할 수 있도록 함.
    // (?: ...) 의 형태는 비캡처그룹을 뜻함. 
    
    let tuples = s.match(/\d+(?:,\d+)*/g)
    let count = new Map()                  
    for(let tuple of tuples){
        let curr = tuple.split(",")
        
        for(let num of curr){
            count.get(num)?count.set(num, count.get(num)+1) : count.set(num, 1)
        }
        
    }
    
    
    let arr = [...count]
    
    arr.sort((a,b) => b[1]-a[1])
    
    for(let num of arr){
        answer.push(Number(num[0]))
    }
    
    return answer;
}