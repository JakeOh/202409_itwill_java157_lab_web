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

// button#btn3 요소를 찾음.
const btn3 = document.querySelector('button#btn3');

// btn3 요소에 클릭 이벤트 리스너를 설정 -> 모든 div 요소들을 찾아서 바탕색을 변경.
btn3.addEventListener('click', function () {
    const divs = document.getElementsByTagName('div');
    // console.log(divs); //-> HTMLCollection
    for (const d of divs) {
        console.log(d);
        d.style.backgroundColor = 'LightGray';
    }
});

// button#btn4 요소를 찾음.
const btn4 = document.querySelector('button#btn4');

// btn4 요소에 클릭 이벤트 리스너를 설정.
btn4.addEventListener('click', () => {
    // div#div4 요소를 찾음.
    const div4 = document.querySelector('div#div4'); // document.getElementById('div4');
    console.log(div4);
    div4.style.backgroundColor = 'SlateBlue';
});

// button#btn5 요소를 찾음.
const btn5 = document.querySelector('button#btn5');

// btn5 요소에 클릭 이벤트 리스너를 설정 -> 클래스 이름이 c2인 요소(들)의 바탕색을 변경.
btn5.addEventListener('click', () => {
    const divs = document.querySelectorAll('div.c2');
    // console.log(divs); //-> NodeList - HTML 요소(노드)들의 배열.
    
    // for (const d of divs) {
    //     d.style.backgroundColor = 'violet';
    // }
    divs.forEach(d => d.style.backgroundColor = 'violet');
});
