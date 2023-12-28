//로그인 성공?
function solution(id_pw, db) {
    const userMap = new Map();
    
    for(const data of db){
        userMap.set(data[0], data[1]);
    }
    
    
    if(!userMap.get(id_pw[0]))
        return "fail"
    else if(userMap.get(id_pw[0]) === id_pw[1])
        return "login"
    else 
        return "wrong pw"
    
}

// 모범답안 : map 활용
/*function solution(id_pw, db) {
  const [id, pw] = id_pw;
  const map = new Map(db);
  return map.has(id) ? (map.get(id) === pw ? 'login' : 'wrong pw') : 'fail';
}*/
