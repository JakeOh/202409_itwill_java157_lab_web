/**
 * condition.html 파일에 포함.
 * 
 * 자바는 if () 구문에서는 조건식만 사용이 가능함!
 * 자바 if (식)의 식을 평가했을 때 true/false 여야만 함.
 * (예) if (x % 2 == 1) { ... } --> 문법에 맞는 문장.
 * (예) if (x % 2) { ... } --> 문법 오류.
 * 
 * 자바스크립트는 false로 취급하는 값들이 있음.
 * - 숫자 0
 * - 빈 문자열('')
 * - 빈 배열([])
 * - null
 * - undefined(값이 할당되지 않은 변수). (예) let x;
 * (예) if (x % 2) { ... } --> 자바스크립트에서는 허용되는 문법.
 */

// 아이디가 numberInput인 input 요소를 찾음.
const numberInput = document.querySelector('input#numberInput');
console.log(numberInput);

// 아이디가 result인 div 요소를 찾음.
const result = document.querySelector('div#result');
console.log(result);

function checkEven() {
    const number = numberInput.value; // input에 입력된 값.
    console.log('number =', number);
    
    // if (number % 2 == 1) {
    if (number % 2) { // number를 2로 나눈 나머지가 있으면
        result.innerHTML = '홀수';
    } else {
        result.innerHTML = '짝수';
    }
}

function checkPositive() {
    const number = numberInput.value;
    if (number > 0) {
        result.innerHTML = '양수';
    } else if (number == 0) {
        result.innerHTML = '영';
    } else {
        result.innerHTML = '음수';
    }
}

function checkEven2() {
    const number = numberInput.value;
    result.innerHTML = (number % 2) ? 'odd number(홀수)' : 'even number(짝수)';
}
