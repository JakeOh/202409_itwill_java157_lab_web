/**
 * post/modify.jsp 파일에 포함.
 * 포스트 업데이트 & 삭제 기능.
 */

document.addEventListener('DOMContentLoaded', () => {
    const modifyForm = document.querySelector('form#modifyForm');
    const inputId = document.querySelector('input#id');
    const inputTitle = document.querySelector('input#title');
    const textContent = document.querySelector('textarea#content');
    const btnDelete = document.querySelector('button#btnDelete');
    const btnUpdate = document.querySelector('button#btnUpdate');
    
    // 삭제 버튼에 클릭 이벤트 리스너를 설정.
    btnDelete.addEventListener('click', () => {
        const result = confirm('정말 삭제할까요?');
        if (result) {
            // 사용자가 [확인]을 클릭하면 GET 방식의 /post/delete?id=번호 요청을 보냄.
            location.href = `delete?id=${inputId.value}`;
        }
    });
    
});
