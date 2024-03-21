function solution(genres, plays) {
    var answer = [];
    let total = new Map();
    let each = new Map();
    for(let i = 0 ; i<genres.length ; i++){
        if(total.get(genres[i])){
            total.set(genres[i], {number : total.get(genres[i]).number+1 , play : total.get(genres[i]).play+plays[i], best : 0})
        }else{
            total.set(genres[i], {number : 1, play : plays[i], best : 0 })
        }
        
        
        each.set(i, {genre : genres[i], play : plays[i]})
        }
    
    
    let best = [...each]
    
    best.sort((a, b)=> {
            if(total.get(b[1].genre).play-total.get(a[1].genre).play >0){
                return 1
            }else if(total.get(b[1].genre).play-total.get(a[1].genre).play < 0){
                return -1
            }else{
                return b[1].play - a[1].play
            }
        }
    )
    
   for(let i  = 0 ; i< best.length ; i++){
       if(answer.length === total.size*2){
           break;
       }
       // console.log(total.get(best[i][1].genre))
       if(total.get(best[i][1].genre).best <2){
           answer.push(best[i][0])
        let tmpGenre = total.get(best[i][1].genre)
        tmpGenre.best+=1;
       }
       
   }
    
    return answer;
}