/**
 * /post/details.html 파일에 포함.
 * 댓글 보기/등록/수정/삭제 기능(Ajax 요청/응답 처리).
 */
document.addEventListener('DOMContentLoaded', () => {
    // 현재 댓글 페이지 번호 -> 댓글 [더보기] 버튼에서 이용하기 위해서
    let currentPageNo = 0;
    
    // div#collapseComments HTML 요소를 bootstrap Collapse 객체로 생성
    const bsCollapse = new bootstrap.Collapse('div#collapseComments', {toggle: false});
    
    // button#btnToggle 버튼을 찾고, 클릭 이벤트 이벤트 리스너를 설정
    const btnToggle = document.querySelector('button#btnToggle');
    btnToggle.addEventListener('click', () => {
        bsCollapse.toggle(); // Collapse 객체를 보기/숨기기 토글.
        
        const dataToggle = btnToggle.getAttribute('data-toggle');
        if (dataToggle === 'collapse') {
            btnToggle.innerHTML = '댓글 숨기기';
            btnToggle.setAttribute('data-toggle', 'unfold');
            
            // 첫번째 페이지(p=0) 댓글 목록 가져오기
            getAllComments(0);
        } else {
            btnToggle.innerHTML = '댓글 보기';
            btnToggle.setAttribute('data-toggle', 'collapse');
        }
    });
    
    // 댓글 [더보기] 버튼에 클릭 이벤트 리스너를 설정
    const btnMore = document.querySelector('button#btnMore');
    btnMore.addEventListener('click', () => getAllComments(currentPageNo + 1));
    
    
    /* ---------- 함수 선언 ---------- */
    // 파라미터 pageNo에 전달된 페이지의 댓글 목록 가져오기.
    async function getAllComments(pageNo = 0) {
        // 댓글들이 달려 있는 포스트 아이디:
        const postId = document.querySelector('input#id').value;
        
        // Ajax 요청을 보낼 url:
        const uri = `/api/comment/all/${postId}?p=${pageNo}`;
        
        // Ajax 요청을 보내고 응답/에러 처리.
        /*
        axios
        .get(uri) // 비동기 함수 호출
        .then((response) => { 성공 콜백 구현부 }) // 성공 콜백 등록
        .catch((error) => { 실패 콜백 구현부 }); // 실패 콜백 등록
        */
        
        try {
            // 비동기 함수 호출
            /*
            const response = await axios.get(uri);
            const data = response.data;
            */
            const { data } = await axios.get(uri);
            
            // 성공 콜백에서 할 일들을 작성.
            console.log(data);
            currentPageNo = data.page.number; // 현재 댓글 목록의 페이지 번호를 저장.
            makeCommentElements(data); // 댓글 목록을 html 요소로 작성해서 보여줌.
        } catch (error) {
            // 실패 콜백에서 할 일들을 작성.
            console.log(error);
        }
        
    }
    
    // 댓글 목록을 html 요소로 만들어서 div에 추가.
    /*
    function makeCommentElements(data) {
        const content = data.content;
        const page = data.page;
    }
    */
    function makeCommentElements({ content, page }) {
        // 댓글 목록을 추가할 div 요소
        const divComments = document.querySelector('div#divComments');
        
        // div에 삽입할 HTML 문자열(댓글 목록)
        let htmlStr = '';
        for (const comment of content) {
            htmlStr += `
            <div class="mt-2 card card-body">
                <div class="mt-2">
                    <span class="fw-bold">${comment.writer}<span>
                    <span class="text-secondary">${comment.modifiedTime}</span>
                </div>
                <div class="mt-2">
                    <div class="mt-2">
                        <textarea class="form-control">${comment.text}</textarea>
                    </div>
                    <div class="mt-2">
                        <button class="btn btn-outline-danger">삭제</button>
                        <button class="btn btn-outline-primary">수정</button>
                    </div>
                </div>
            </div>
            `;
        }
        
        if (currentPageNo === 0) {
            // 댓글 목록 첫번째 페이지이면, 기존 내용을 다 지우고 새로 작성.
            divComments.innerHTML = htmlStr;
        } else {
            // 댓글 목록의 첫번째 페이지가 아니면, 기존 내용 밑에 댓글 목록을 추가.
            divComments.innerHTML += htmlStr;
        }
    }
    
});
