/**
 * username 중복체크, email 중복체크
 * user/signup.jsp 파일에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    const inputUsername = document.querySelector('input#username');
    const checkUsernameResult = document.querySelector('div#checkUsernameResult');
    const inputPassword = document.querySelector('input#password');
    const inputEmail = document.querySelector('input#email');
    const checkEmailResult = document.querySelector('div#checkEmailResult');
    const btnSignUp = document.querySelector('button#signUp');
    
    // inputUsername 요소에 'change' 이벤트 리스너를 설정
    inputUsername.addEventListener('change', checkUsername);
    
    
    /* -------------------- 함수 선언 -------------------- */
    function checkUsername() {
        const username = inputUsername.value;
        if (username === '') {
            checkUsernameResult.innerHTML = '사용자 아이디는 필수 입력 항목입니다.';
            return;
        }
        
        // 아이디 중복 체크 REST API(요청 URI)
        const uri = `./checkusername?username=${username}`;
        axios
        .get(uri)
        .then(handleCheckUsernameResp)
        .catch((error) => console.log(error));
    }
    
    function handleCheckUsernameResp({ data }) {
        // const {data} = response; //-> 구조분해 할당(destructuring assignment)
        console.log(data);
        if (data === 'Y') {
            checkUsernameResult.innerHTML = '멋진 아이디입니다.';
        } else {
            checkUsernameResult.innerHTML = '사용할 수 없는 아이디입니다.';
        }
    }
    
});
