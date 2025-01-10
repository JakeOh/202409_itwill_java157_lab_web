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
            // 댓글 목록 가져오기 요청을 보냄.
            getAllComments();
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
        // input#id 요소의 값을 읽음 -> 댓글을 등록할 포스트 아이디
        const postId = document.querySelector('input#id').value;
        
        // input#username 요소의 값을 읽음 -> 댓글 작성자 아이디
        const username = document.querySelector('input#username').value;
        
        // textarea#ctext 요소의 값을 읽음 -> 댓글 내용
        const ctext = document.querySelector('textarea#ctext').value;
        
        // 댓글 내용이 비어 있는 지를 체크.
        if (ctext === '') {
            alert('댓글 내용을 입력하세요.');
            return;
        }
        
        // Ajax 요청으로 보낼 데이터 객체
//        const data = { postId: postId, username: username, ctext: ctext };
        const data = { postId, username, ctext };
//        console.log(data);
        
        // 서버로 POST 방식의 Ajax 요청을 보내고 응답을 처리.
        axios.post('../api/comment', data)
            .then((response) => {
                // console.log(response);
                if (response.data === 1) {
                    alert('1개 댓글 등록 성공');
                    document.querySelector('textarea#ctext').value = '';
                }
            })
            .catch((error) => {
                console.log(error);
            });
    }
    
    // 포스트에 달려 있는 댓글 목록 가져오기
    function getAllComments() {
        // 댓글 목록을 요청하기 위한 포스트 아이디(글 번호)
        const postId = document.querySelector('input#id').value;
        
        // 댓글 목록을 요청하기 위한 REST API(요청 URI)
        const uri = `../api/comment/all/${postId}`;
        
        // Ajax 요청을 보냄.
        axios
        .get(uri)
        .then((response) => {
            console.log(response); //-> response.data 속성에 서버가 보내준 댓글 목록이 있음.
            // divComments 영역에 댓글 목록을 출력.
            makeCommentElements(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    }
    
    // 댓글 목록(댓글 객체들의 배열)을 아규먼트로 전달받아서 div에 출력할 html을 작성.
    function makeCommentElements(data) {
        const divComments = document.querySelector('div#divComments');
        
        let html = '<ul>'; // div에 출력할 html 코드를 저장할 문자열 변수
        for (const comment of data) {
            html += `<li> ${comment.ctext} </li>`;
        }
        html += '</ul>';
        
        divComments.innerHTML = html;
    }
    
});
