function solution(babbling) {
    return babbling.filter((word) => 
        word.replace(/aya|woo|ye|ma/g,'') === ""
    ).length;
}

// 정규 표현식에서 g 유무의 차이.
// g가 빠지면 1번 이상 등장하는 패턴은 조건에 합치하지 못한다.
