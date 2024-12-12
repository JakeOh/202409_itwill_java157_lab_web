/**
 * element.html 파일에 포함.
 * 
 * HTML 요소를 찾는 메서드:
 * - document.getElementById
 * - document.getElementsByClassName
 * - document.getElementsByTagName
 * - document.querySelector
 * - document.querySelectorAll
 */

// button#btn1 요소를 찾음.
const btn1 = document.querySelector('button#btn1');

// btn1 요소에 클릭 이벤트 리스너를 설정.
btn1.addEventListener('click', function () {
    // document.getElementById 메서드를 사용해서 아이디가 div1인 요소를 찾음.
    const div1 = document.getElementById('div1'); // 아이디 앞에 #을 사용하지 않음.
    console.log(div1);
    
    // div1 요소의 바탕색을 변경.
    div1.style.backgroundColor = 'lime';
});

// button#btn2 요소를 찾음.
const btn2 = document.querySelector('button#btn2'); // document.getElementById('btn2');

// btn2 요소에 클릭 이벤트 리스너를 설정.
btn2.addEventListener('click', function () {
    // 클래스 이름이 c1인 모든 요소들을 찾음.
    const divs = document.getElementsByClassName('c1');
    // console.log(divs); //-> HTMLCollection: HTML 요소들을 저장하는 배열.
    for (const e of divs) {
        console.log(e);
        // HTML 요소의 바탕색을 변경.
        e.style.backgroundColor = 'tomato'; 
    }
});
