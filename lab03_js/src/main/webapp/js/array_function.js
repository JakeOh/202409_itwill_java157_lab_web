/**
 * array_function.html 파일에 포함.
 * 
 * JS 배열 객체의 함수(메서드)들.
 */

const arr = [ 1, 2, 3 ];
console.log(arr);

// Array.push(arg): 배열의 끝에 새로운 아이템을 추가. 원본 배열이 바뀜!
arr.push(100);
console.log(arr); //-> [1, 2, 3, 100]

// Array.concat(arg): 원본 배열을 바꾸지 않고, 아이템이 추가된 새로운 배열을 리턴! 
let result = arr.concat(200);
console.log(arr); //-> [1, 2, 3, 100]. 원본 배열을 그대로 유지.
console.log(result); //-> [1, 2, 3, 100, 200]

// Array.pop(): 배열의 마지막 아이템을 삭제. 원본 배열이 바뀜!
arr.pop();
console.log(arr); //-> [1, 2, 3]. 원본 배열이 바뀜.

// Array.slice(start, end): 배열에서 인덱스 start부터 end까지의 원소들을 잘라낸 새로운 배열을 리턴.
// start <= index < end 범위의 아이템들로 이루어진 배열을 리턴.
result = arr.slice(0, 2);
console.log(arr); //-> [1, 2, 3]. 원본 배열이 바뀌지 않음.
console.log(result); //-> [1, 2]

result = arr.slice(0, -1);
console.log(result);


