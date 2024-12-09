/**
 * while.html 파일에 포함.
 */

// 아이디가 list인 ul 요소를 찾음.
const list = document.querySelector('ul#list');

let html = ''; // list에 추가할 HTML 문자열을 저장하기 위해서.

// while 반복문을 사용해서 list에 li 요소 5개를 추가.
let n = 1;
while (n <= 5) {
    html += `<li>Item ${n} </li>`;
    n++;
}
list.innerHTML = html;

