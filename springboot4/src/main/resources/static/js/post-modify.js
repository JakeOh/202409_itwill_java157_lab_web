/**
 * /post/modify.html 파일에 포함.
 * 포스트 삭제, 업데이트 버튼의 클릭 이벤트 처리.
 */

document.addEventListener('DOMContentLoaded', () => {
    // 삭제 버튼을 찾음.
    const btnDelete = document.querySelector('button#btnDelete');
    
    // 삭제 버튼에 'click' 이벤트 리스너를 설정.
    btnDelete.addEventListener('click', () => {
        // 사용자 확인 후 서버로 삭제 요청을 보냄.
        const check = confirm('정말 삭제할까요?');
        if (check) {
            const postId = document.querySelector('input#id').value;
            location.href = `/post/delete?id=${postId}`;
        }
    });
    
});
