const items = [["cpp", "java", "python"], ["backend", "frontend"], ["junior", "senior"], ["chicken", "pizza"]];

function solution(info, query) {
    var answer = [];
    let candidates = new Map();

    // 지원자 정보를 Map에 저장
    for (let i = 0; i < info.length; i++) {
        let tmp = info[i].split(" ");
        let key = tmp[0] + tmp[1] + tmp[2] + tmp[3];
        if (candidates.get(key)) {
            candidates.set(key, [...candidates.get(key), Number(tmp[4])]);
        } else {
            candidates.set(key, [Number(tmp[4])]);
        }
    }

    // 지원자의 점수를 정렬
    for (let candi of candidates) {
        candidates.set(candi[0], candi[1].sort((a, b) => a - b));
    }

    // 각 쿼리 조건을 처리
    for (let options of query) {
        let arr = options.split(" and ");
        let foodAndScore = arr[3].split(" ");
        arr = arr.slice(0, 3);
        arr.push(...foodAndScore);

        // 조합 생성
        let option = new Map();
        getCombinations(arr, 0, "", option);

        let count = 0;

        // 각 옵션별로 일치하는 점수 가져오기
        for (let curr of option) {
            let scores = candidates.get(curr[0]);

            if (scores) {
                let index = binarySearch(scores, curr[1]);

                // index가 -1이 아닌 경우, count 업데이트
                if (index >= 0) {
                    count += scores.length - index; // index부터 끝까지의 개수
                }
            }
        }

        answer.push(count);
    }

    return answer;
}

const getCombinations = (arr, idx, curr, result) => {
    if (idx === 4) {
        result.set(curr, arr[4]);
        return;
    }

    if (arr[idx] === "-") {
        for (let item of items[idx]) {
            getCombinations(arr, idx + 1, curr + item, result);
        }
    } else {
        getCombinations(arr, idx + 1, curr + arr[idx], result);
    }
}

const binarySearch = (arr, target) => {
    let left = 0;
    let right = arr.length - 1;
    
    // target보다 큰 수 중 가장 작은 수의 인덱스를 찾기
    while (left <= right) {
        let center = Math.floor((left + right) / 2);
        let curr = arr[center];

        if (curr < target) {
            left = center + 1;
        } else {
            right = center - 1;
        }
    }

    return left; // left가 target보다 큰 값의 인덱스
}