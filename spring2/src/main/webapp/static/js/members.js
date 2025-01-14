/**
 * username 중복체크, email 중복체크
 * user/signup.jsp 파일에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    // username 중복 체크 결과를 저장할 변수.
    // true이면 회원가입이 가능한 username. false이면 [작성완료] 버튼은 비활성화.
    let isUsernameChecked = false;
    
    // password를 입력했는 지 여부를 저장할 변수. false이면 [작성완료] 버튼은 비활성화.
    let isPasswordChecked = false;
    
    // email 중복 체크 결과를 저장할 변수.
    // true이면 회원가입이 가능한 email. false이면 [작성완료] 버튼은 비활성화.
    let isEmailChecked = false;
    
    const inputUsername = document.querySelector('input#username');
    const checkUsernameResult = document.querySelector('div#checkUsernameResult');
    const inputPassword = document.querySelector('input#password');
    const inputEmail = document.querySelector('input#email');
    const checkEmailResult = document.querySelector('div#checkEmailResult');
    const btnSignUp = document.querySelector('button#signUp');
    
    // inputUsername 요소에 'change' 이벤트 리스너를 설정
    inputUsername.addEventListener('change', checkUsername);
    
    
    /* -------------------- 함수 선언 -------------------- */
    function changeButtonState() {
        if (isUsernameChecked && isPasswordChecked && isEmailChecked) {
            // 버튼 활성화 - class 속성들 중에서 'disabled'를 제거.
            btnSignUp.classList.remove('disabled');
        } else {
            // 버튼 비활성화 - class 속성에 'disabled'를 추가.
            btnSignUp.classList.add('disabled');
        }
    }
    
    function checkUsername() {
        const username = inputUsername.value;
        if (username === '') {
            checkUsernameResult.innerHTML = '사용자 아이디는 필수 입력 항목입니다.';
            checkUsernameResult.classList.add('text-danger');
            checkUsernameResult.classList.remove('text-success');
            
            isUsernameChecked = false;
            changeButtonState();
            
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
            checkUsernameResult.classList.add('text-success');
            checkUsernameResult.classList.remove('text-danger');
            isUsernameChecked = true;
        } else {
            checkUsernameResult.innerHTML = '사용할 수 없는 아이디입니다.';
            checkUsernameResult.classList.add('text-danger');
            checkUsernameResult.classList.remove('text-success');
            isUsernameChecked = false;
        }
        changeButtonState();
    }
    
});
