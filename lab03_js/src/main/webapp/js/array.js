/**
 * array.html 파일에 포함.
 * 
 * JS 배열: 여러 개의 원소(아이템)들을 하나의 변수 이름으로 저장하기 위한 데이터 타입.
 * Java 배열: "한가지" 타입의 값 여러 개를 저장하기 위한 타입.
 *   - int[], double[], String[], Object[], ...
 * JS 배열은 다른 타입의 값들을 저장할 수 있음.
 */

// 아이디가 output인 div 요소를 찾음.
const output = document.querySelector('div#output');

// 배열 선언, 초기화
const numbers = [1, 2, -3, -4, 5, 0]; // (Java 비교) int[] numbers = {1, 2, 3, 4};

// 배열의 아이템들을 output 영역에 출력:
let html = '';
for (let i = 0; i < numbers.length; i++) {
    html += `${numbers[i]}, `;
}
output.innerHTML = html + '<br />';

// Java 향상된 for 문장: for (변수 선언 : 배열) { ... }

// JS for-of 문장: 배열의 아이템들을 반복(iteration).
html = '';
for (const value of numbers) {
    html += `${value}, `;
}
output.innerHTML += html + '<br />';
