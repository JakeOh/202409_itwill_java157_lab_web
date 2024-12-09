/**
 * for.html 파일에 포함.
 */

// 아이디가 result인 div 요소를 찾음.
const result = document.querySelector('div#result');

// 구구단 2단을 result에 출력: result.innerHTML = 문자열;
let html = ''; // result 요소에 출력할 HTML 문자열을 저장하기 위한 변수.
for (let x = 1; x < 10; x++) {
    html += `2 x ${x} = ${2 * x} <br />`;
    // `문자열 템플릿 ${변수 또는 식}`
}
result.innerHTML = html;

result.innerHTML += '<hr />'; // result.innerHTML = result.innerHTML + '<hr />'

// 구구단 3단 ~ 9단까지를 result에 추가: result.innerHTML += 문자열;


