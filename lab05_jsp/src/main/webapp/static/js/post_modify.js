/**
 * 포스트 업데이트, 삭제 기능.
 */

document.addEventListener('DOMContentLoaded', () => {
    // form#modifyForm 요소를 찾음.
    const modifyForm = document.querySelector('form#modifyForm');
    
    // input#id 요소(글 번호/아이디 입력 필드)를 찾음.
    const inputId = document.querySelector('input#id');
    
    // input#title 요소(글 제목 입력 필드)를 찾음.
    const inputTitle = document.querySelector('input#title');
    
    // textarea#content 요소(글 내용 입력 필드)를 찾음.
    const textareaContent = document.querySelector('textarea#content');
    
    // 삭제 버튼을 찾음.
    const btnDelete = document.querySelector('button#btnDelete');
    
    // 업데이트 버튼을 찾음.
    const btnUpdate = document.querySelector('button#btnUpdate');
    
    // 삭제 버튼에 클릭 이벤트 리스너를 설정.
    btnDelete.addEventListener('click', (e) => {
        confirm('정말 삭제할까요?');
    });
    
});
