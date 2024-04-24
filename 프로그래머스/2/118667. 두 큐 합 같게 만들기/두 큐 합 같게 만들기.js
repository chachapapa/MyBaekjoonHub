class Queue {
    constructor(){
        this.store = {}
        this.front = 0
        this.rear = 0
    }
    
    size = () => {
        if(this.store[this.rear] === undefined){
            return 0
        }else{
            return this.rear-this.front+1
        }
    }
    
    add = (value) => {
        if(this.size() === 0){
            this.store[0] = value
        }else{
            this.rear += 1
            this.store[this.rear] = value
        }
    }
    
    pop = () => {
        if(this.front === this.rear){
            let tmp = this.store[this.rear]
            delete this.store[this.rear]
            
            this.front = 0
            this.rear = 0
            return tmp
        }else{
            let tmp = this.store[this.front]
            delete this.store[this.front]
            this.front += 1
            return tmp
        }
    }
    
    getFront = () => {
        return this.front
    }
    
}

const sumCheck = (num1 ,num2)=>{
    if(num1 === num2){
        return false
    }else{
        if(num1 > num2){
            return 1
        }else{
            return 2
        }
    }
}

function solution(queue1, queue2) {
    var answer =-2;
    
    let sum1 = 0
    let sum2 = 0
    
    let q1 = new Queue()
    let q2 = new Queue()
    for(let num of queue1){
        sum1 += num
        q1.add(num)
    }
    
    for(let num of queue2){
        sum2 += num
        q2.add(num)
    }
    let total = sum1 + sum2
    let count = 0
    
    
     while(sum1 !== sum2){
    if(count > (q1.size()+q2.size())*2) return -1     
         if(sumCheck(sum1, sum2) === 1){
             let tmp = q1.pop()
             if(tmp > total/2) return -1
             sum1 -= tmp
             q2.add(tmp)
             sum2 += tmp
             count +=1
         }else {
             let tmp = q2.pop()
            if(tmp > total/2) return -1
             sum2 -= tmp
             q1.add(tmp)
             sum1 += tmp
             count +=1
         }         
     }
    
    answer = count
    return answer;
}