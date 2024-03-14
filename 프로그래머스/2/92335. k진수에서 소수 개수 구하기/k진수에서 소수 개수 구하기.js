function solution(n, k) {
    let result = []
    while(n > 0){
        result.unshift(n % k);
        n = Math.floor(n / k);
    }
    const convertedNums = result.join("").split('0');
    
    let count = 0;
    for(let i = 0; i < convertedNums.length; i++){
        const num = Number(convertedNums[i]);
        if(convertedNums[i] === '') continue;
        if(isPrime(num)) count++;
    }
    return count;
}

const isPrime = (num) => {
    if(num <= 1){
        return false;
    }
    for(let i = 2; i <= Math.sqrt(num); i++){
        if(num % i === 0){
            return false;
        }
    }
    return true;
}