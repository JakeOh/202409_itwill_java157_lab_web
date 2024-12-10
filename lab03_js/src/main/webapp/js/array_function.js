/**
 * array_function.html 파일에 포함.
 * 
 * JS 배열 객체의 함수(메서드)들.
 * - mutable method: 원본 배열을 바꾸는 메서드.
 *   (예) push, pop, sort, ...
 * - immutable method: 원본 배열을 바꾸지 않고, 새로운 배열을 리턴하는 메서드.
 *   (예) concat, slice, toSorted, ...
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

const arr2 = [10, 100, -1, 9, 80];
console.log(arr2);

// Array.toSorted(): 오름차순으로 정렬된 "새로운" 배열을 리턴. 원본 배열이 바뀌지 않음!
// - 배열의 아이템들을 "문자열로 변환"한 후 크기를 비교함. 사전식 순서.
result = arr2.toSorted();
console.log(arr2); //-> 원본 배열을 바뀌지 않음.
console.log(result); //-> 정렬된 배열이 리턴됨.

// Array.toSorted(callback): 배열 아이템의 크기 비교에서 사용될 콜백 (함수)를 아규먼트로 전달.
// callback (x, y) => x가 크면 양수, y가 크면 음수, x와 y가 같으면 0을 리턴.
result = arr2.toSorted((x, y) => x - y);
console.log(result);

// Array.sort(): 원본 배열의 아이템 순서를 오름차순으로 변경. 원본 배열이 바뀜!
// - 배열의 아이템들을 "문자열로 변환"한 수 크기 비교. 사전식 순서.
arr2.sort();
console.log(arr2);

// Array.sort(callback): 배열의 아이템 크기 비교에서 사용되는 콜백 (함수)를 아규먼트로 전달.
arr2.sort((x, y) => x - y);
console.log(arr2);

// Array.forEach, Array.filter, Array.map, Array.reduce
const numbers = [ 1, 2, 3, 4, 5, 6 ];
console.log(numbers);
// for (const x of numbers) {
//     console.log(x);
// }
numbers.forEach(x => console.log(x)); // (x) => { console.log(x); }

// 배열 numbers의 아이템들 중에서 홀수들로만 이루어진 새로운 배열을 만들고 출력.
let odds = []; // 빈 배열 선언. 홀수들을 저장하기 위해서.
for (const x of numbers) {
    if (x % 2) {
        odds.push(x);
        // odds = odds.concat(x);
    }
}
console.log(odds);

// TODO: Array.filter 메서드를 사용.

// 배열 numbers 아이템의 제곱들을 아이템으로 갖는 새로운 배열을 만들고 출력.
let squares = []; // 아이템의 제곱을 저장하기 위한 빈 배열 선언.
for (const x of numbers) {
    squares = squares.concat(x * x);
}
console.log(squares);

// TODO: Array.map 메서드 사용.

// 배열 numbers의 아이템들 중에서 홀수의 제곱들을 아이템으로 갖는 새로운 배열을 만들고 출력.
const oddSquares = []; // 홀수의 제곱들을 저장할 배열.
for (const x of numbers) {
    if (x % 2) {
        oddSquares.push(x * x);
    }
}
console.log(oddSquares);

// TODO: Array.filter, Array.map 메서드를 연쇄 호출. numbers.filter().map();

// 배열 numbers의 모은 아이템들의 합계를 계산하고 출력.
let total = 0;
for (const x of numbers) {
    total += x;
}
console.log(total);

// TODO: Array.reduce 메서드를 호출.

// numbers의 모든 아이템들의 곱(1*2*3*4*5*6)을 계산하고 출력.
// numbers의 아이템들 중에서 짝수들의 합(2 + 4 + 6)을 계산하고 출력.
// numbers의 아이템의 제곱들의 합(1*1 + 2*2 + 3*3 + ...)을 계산하고 출력.
// numbers의 아이템들 중에서 짝수의 제곱들의 합(2*2 + 4*4 + 6*6)을 계산하고 출력.
