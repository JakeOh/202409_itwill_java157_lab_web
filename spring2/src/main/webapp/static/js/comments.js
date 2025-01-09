/**
 * 댓글 보기/감추기, 댓글 CRUD 요청/응답 처리.
 * post/details.jsp 파일에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    // btnToggleComment 요소를 찾음.    const btnToggleComment = document.querySelector('button#btnToggleComment');
    
    // div#collapseComments 요소를 부트스트랩의 Collapse 객체로 생성.
    const bsCollapse = new bootstrap.Collapse('div#collapseComments', { toggle: false });
    
    // btnToggleComment 버튼에 클릭 이벤트 리스너를 설정.
    btnToggleComment.addEventListener('click', () => {
        bsCollapse.toggle();
        
        if (btnToggleComment.innerHTML === '댓글 보기') {
            btnToggleComment.innerHTML = '댓글 감추기';
        } else {
            btnToggleComment.innerHTML = '댓글 보기';
        }
    });
    
    // button#btnRegisterComment 요소를 찾음.
    const btnRegisterComment = document.querySelector('button#btnRegisterComment');
    
    // btnRegisterComment 버튼에 클릭 이벤트 리스너를 설정.
    btnRegisterComment.addEventListener('click', registerComment);
    
    
    /* -------------------- (콜백) 함수 선언 -------------------- */
    
    // btnRegisterComment 버튼의 클릭 이벤트 리스너(콜백). 댓글 등록.
    function registerComment() {
        alert('댓글 등록!');
    }
    
});
