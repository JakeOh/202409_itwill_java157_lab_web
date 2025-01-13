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
    
    // 부트스트랩 모달 객체를 생성.
    const commentModal = new bootstrap.Modal('div#commentModal', { backdrop: true });
    
    // 모달의 [저장] 버튼을 찾고, 클릭 이벤트 리스너를 설정.
    const btnUpdateCmnt = document.querySelector('button#btnUpdateCmnt');
    btnUpdateCmnt.addEventListener('click', updateComment);
    
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
                    // 댓글 목록을 다시 불러옴.
                    getAllComments();
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
        // 댓글 목록을 출력할 div 영역
        const divComments = document.querySelector('div#divComments');

        // div에 출력할 html 코드를 저장할 문자열 변수        
        let html = '<ul class="list-group list-group-flush">';
        for (const comment of data) {
            // timestamp를 날짜/시간 포맷 문자열로 변환
            const modifiedTime = new Date(comment.modifiedTime).toLocaleString();
            
            html += `
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div>
                    <div class="text-secondary" style="font-size: 0.825rem;">
                        <span>${comment.username}</span>
                        <span>${modifiedTime}</span>
                    </div>
                    <div>
                        ${comment.ctext}
                    </div>
                </div>
                <div>
                    <button class="btnDeleteComment btn btn-outline-danger btn-sm"
                        data-id="${comment.id}">삭제</button>
                    <button class="btnUpdateComment btn btn-outline-primary btn-sm"
                        data-id="${comment.id}">수정</button>
                </div>
            </li>
            `;
        }
        html += '</ul>';
        
        // 작성된 html을 div에 삽입.
        divComments.innerHTML = html;
        
        // html 코드가 div에 삽입된 후에 (삭제/수정) 버튼들을 찾을 수 있음
        // -> 이벤트 리스너를 설정할 수 있음.
        
        // 모든 댓글 삭제 버튼들을 찾아서 클릭 이벤트 리스너를 설정.
        const btnDeletes = document.querySelectorAll('button.btnDeleteComment');
        for (const btn of btnDeletes) {
            btn.addEventListener('click', deleteComment);
        }
        
        // 모든 댓글 수정 버튼들을 찾아서 클릭 이벤트 리스너를 설정.
        const btnModifies = document.querySelectorAll('button.btnUpdateComment');
        for (const btn of btnModifies) {
            btn.addEventListener('click', showCommentModal);
        }
        
    }
    
    // 댓글 삭제 버튼의 클릭 이벤트 리스너(콜백)
    function  deleteComment(event) {
        console.log(event.target);
        //-> 모든 이벤트 리스너(콜백)으 event 객체를 아규먼트로 전달받음.
        //-> event 객체는 target 속성(이벤트가 발생한 HTML 요소)을 가지고 있음.
        
        // 댓글 삭제 여부를 확인
        const result = confirm('댓글을 정말 삭제할까요?');
        if (!result) { // 사용자가 [취소]를 클릭했을 때
            return; // 함수 종료
        }
        
        // HTML 요소의 속성(attribute)의 값을 찾음:
        const commentId = event.target.getAttribute('data-id');
        
        // Ajax 댓글 삭제 요청 REST API(요청 URI)
        const uri = `../api/comment/${commentId}`;
        
        // Ajax 요청을 보냄.
        axios
        .delete(uri)
        .then((response) => {
            // console.log(response);
            alert('댓글이 삭제됐습니다.');
            getAllComments(); // 댓글 목록 갱신
        })
        .catch((error) => {
            console.log(error);
        });
    }
    
    function showCommentModal(event) {
        // 이벤트가 발생한 타겟(HTML 요소)에서 data-id 속성 값을 찾음.
        const commentId = event.target.getAttribute('data-id');
        
        // 댓글 아이디로 댓글 1개 검색하기 Ajax 요청
        // -> 성공 콜백에서 모달(commentModal)의 input과 textarea를 채움.
        // -> 모달 보여주기
        const uri = `../api/comment/${commentId}`;
        axios
        .get(uri)
        .then((response) => {
            console.log(response);
            
            // 모달의 input에 댓글 아이디를 value 속성으로 저장.
            document.querySelector('input#modalCommentId').value = response.data.id;
            // 모달의 textarea에 댓글 내용을 value 속성으로 저장.
            document.querySelector('textarea#modalCommentText').value = response.data.ctext;
            
            commentModal.show(); // bootstrap.Modal 객체의 show() 메서드 호출 - 모달 보여주기
        })
        .catch((error) => {
            console.log(error);
        });
        
    }
    
    // 모달의 [저장] 버튼 클릭 리스너(콜백) 작성
    // -> 댓글 업데이트 Ajax 요청을 보내고, 성공/실패 콜백 작성.
    function updateComment() {
        // 업데이트할 댓글 아이디(번호)
        const commentId = document.querySelector('input#modalCommentId').value;
        
        // 업데이트할 댓글 내용
        const ctext = document.querySelector('textarea#modalCommentText').value;
        if (ctext === '') {
            alert('댓글 내용을 입력하세요.');
            return;
        }
        
        // 댓글 업데이트 REST API(요청 URI)
        const uri = `../api/comment/${commentId}`;
        
        // Ajax 요청을 보냄.
        axios
        .put(uri, { ctext })
        .then((response) => {
            console.log(response);
            commentModal.hide(); // 댓글 업데이트 모달을 닫음.
            getAllComments(); // 댓글 목록 갱신.
        })
        .catch((error) => {
            console.log(error);
        });
    }
    
});
