/**
 * function.html 파일에 포함.
 * 
 * JS 함수 선언 방법:
 * function 함수이름([파라미터 선언, ...]) {
 *     실행 코드;
 *     [return [값];]
 * }
 * 
 * 함수 이름 앞에 리턴 타입을 선언하지 않음.
 * 파라미터를 선언할 때는 const, let, var 키워드를 사용하지 않음!
 */

// 함수 선언
function add(x, y) {
    console.log(`add 함수 파라미터: x = ${x}, y = ${y}`);
    return x + y;
}

let result = add(1, 2); // 함수 호출.
console.log(`result = ${result}`);

// JS 함수는 파라미터 타입을 검사하지 않음.
result = add('Hello', '안녕하세요');
console.log(`result = ${result}`);

// JS 함수는 파라미터 개수를 검사하지 않음.
result = add(1, 2, 3); // 선언된 파라미터 개수보다 더 많은 아규먼트를 전달한 경우.
console.log(`result = ${result}`);

result = add(1); // 선언된 파라미터 개수보다 적은 개수의 아규먼트를 전달한 경우.
console.log(`result = ${result}`);
// x = 1, y = undefined, x + y = 1 + undefined = NaN(Not a Number)

// 모든 JS 함수는 arguements 속성(property)를 가지고 있음.
// arguments: 함수를 호출하는 곳에서 전달한 모든 아규먼트들을 저장하고 있는 배열.
function testArgs() {
    console.log(arguments);
    for (const arg of arguments) {
        console.log(arg);
    }
}

testArgs(); //-> arguments: 아이템 개수가 0인 배열
testArgs('Hello'); //-> arguments: 아이템이 1개인 배열
testArgs(1, '안녕'); //-> arguements: 아이템 2개를 갖는 배열
