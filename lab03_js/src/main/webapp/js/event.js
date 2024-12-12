/**
 * event.html 파일에 포함.
 */

// DOM(Document Object Model)
// document 객체에 이벤트 리스너를 설정.
// DOMContentLoaded 이벤트: 브라우저가 HTML 문서의 모든 요소들을 생성하면 발생하는 이벤트.
document.addEventListener('DOMContentLoaded', function () {
    // HTML 문서의 모든 요소들이 생성된 이후에 실행될 코드.
    
    // button#btnInput 요소를 찾음.
    const btnInput = document.querySelector('button#btnInput');
    
    // btnInput에 클릭 이벤트 리스너를 설정.
    btnInput.addEventListener('click', function (e) {
        // console.log(e); //-> PointerEvent 객체
        // e.target 프로퍼티: 이벤트가 발생한 HTML 요소.
        
        // intput#itemInput 요소를 찾음.
        const itemInput = document.querySelector('input#itemInput');
        
        // ul#itemList 요소를 찾음.
        const itemList = document.querySelector('ul#itemList');
        
        // itemList에 입력된 문자열을 itemList의 <li>로 추가(append).
        itemList.innerHTML += `<li> ${itemInput.value} </li>`;
        
        // itemInput 입력된 내용을 지움.
        itemInput.value = '';
    });
    
});
