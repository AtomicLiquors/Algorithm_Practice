// 접미사인지 확인하기
function solution (my_string, is_suffix)  {
    return my_string.slice(my_string.length - is_suffix.length) === is_suffix ? 1 : 0;
}

/* endsWith 메서드가 있다. */
//const solution = (str, suff) => str.endsWith(suff) ? 1 : 0
