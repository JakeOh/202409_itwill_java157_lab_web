/**
 * index.html에 포함.
 */

// const 키워드: 값을 변경할 수 없는 변수(상수, constant variable) 선언
const x = 1;
// x = 2; //--> 실행 중에 에러가 발생(const 변수는 값을 재할당할 수 없기 때문에)
console.log('x =', x); // 브라우저의 콘솔 창에 로그 출력.

// let 키워드: 값을 변경할 수 있는 변수 선언.
let y = 100;
console.log('y =', y);

y = '안녕!'; // let으로 선언된 변수는 재할당할 수 있음.
console.log('y =', y);
