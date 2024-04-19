class Node {
    constructor(value){
        this.value = value
        this.left = null
        this.right = null
    }
}

class Tree {
    constructor(){
        this.root = null
    }
    
    add = (data) => {
        const currRoot = this.root

        //처음 생성된 루트노드가 빈 트리
        if(currRoot === null){
            this.root = new Node(data)
            return
        }else{
            
            //여기 들어가는 건 지속적으로 변경되는 타겟 노드
            const searchPlace = (currNode) => {
                //노드의 계층은 y값으로 정해진다
                //x좌표가 노드보다 작다면 왼쪽노드
                //x좌표가 노드보다 크다면 오른쪽노드에 들어간다
                //자식노드가 맞을때
                if(data.y < currNode.value.y){
                    //x값이 작다면 왼쪽
                    if(data.x < currNode.value.x){
                        //왼쪽이 비었으면 넣기
                        if(currNode.left === null){
                            currNode.left = new Node(data)
                            return
                        //안비었으면 내려가서 재귀돌리기
                        }else{
                            return searchPlace(currNode.left)
                        }
                    //x값이 크다면 오른쪽 (같은 경우는 없다)
                    }else{
                        if(currNode.right === null){
                            currNode.right = new Node(data)
                            return 
                        }else{
                            return searchPlace(currNode.right)
                        }
                    }   
                //같은 층일때
                }else if(currNode.value.y === data.y){
                    //임시 루트노드 생성
                    if(currNode.value.idx === null){
                        currNode.value = data
                    }else{
                       this.root = new Node({idx : null, x : null, y: currNode.value.y+1})
                    
                        if(currNode.value.x < data.x){
                            this.root.left = currNode
                            this.root.right = new Node(data)
                        }else{
                            this.root.left = currNode
                            this.root.right = new Node(data)
                        } 
                    }
                    
                    
                //자식노드가 아닐때    
                }else{
                   //루트 교체
                    this.root = new Node(data)
                    
                    if(currNode.value.x < data.x){
                        //왼쪽이 비었으면 넣기
                        this.root.left = currNode
                        return
                    //x값이 크다면 오른쪽
                    }else{
                       this.root.right = currNode
                        return
                    } 
                }
                
            }
            
            return searchPlace(currRoot)
        }
    }
}


const preorder = (tree) => {
    let order = []
    let root = tree.root

    
    const next = (node) => {
        
        order.push(node.value.idx)

        if(node.left){
            next(node.left)
        }
        if(node.right){
            next(node.right)
        }
    }
    
    next(root)
    
    return order
}


const postorder = (tree) => {
    let order = []
    let root = tree.root
    
    const next = (node) => {
        if(node.left){
            next(node.left)
        }
        
        if(node.right){
            next(node.right)
        }
        
        order.push(node.value.idx)

    }
    
    next(root)
    
    return order
}

function solution(nodeinfo) {
    var answer = [];
    
    let tree = new Tree()
    let sortedNodeList = []
    for(let i = 0 ; i<nodeinfo.length ; i++){
        let node = {idx : i+1, x : nodeinfo[i][0], y: nodeinfo[i][1]}
        sortedNodeList.push(node)
    }
    
    sortedNodeList.sort((a,b)=>{
        return b.y-a.y
    })
    
    for(let node of sortedNodeList){
        tree.add(node)
        
    }
    
    answer.push(preorder(tree))
    answer.push(postorder(tree))
    
    
    
    return answer;
}