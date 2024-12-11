/**
 * destructure.html 파일에 포함.
 */

function println1(student) {
    console.log(`번호: ${student.no}, 이름: ${student.name}, 학년: ${student.grade}, 반: ${student.classNo}`);
}

function println2(student) {
    const no = student.no;
    const name = student.name;
    const grade = student.grade;
    const classNo = student.classNo;
    
    console.log(`번호: ${no}, 이름: ${name}, 학년: ${grade}, 반: ${classNo}`);
}

function println3({ no, name, grade, classNo }) {
    console.log(`번호: ${no}, 이름: ${name}, 학년: ${grade}, 반: ${classNo}`);
}

const student1 = {
    no: 100,
    name: '오쌤',
    grade: 1,
    classNo: 2,
};

println1(student1);
println2(student1);
println3(student1);

const student2 = {
    no: 200,
    name: '홍길동',
};

println1(student2);
println2(student2);
println3(student2);

function printStudent({ name, ...rest }) {
    console.log(`name = ${name}`);
    console.log(rest);
}

printStudent(student1);
printStudent(student2);
printStudent({ name: '아이티', no: 123, email: 'it@itwill.com' });

// 지역변수를 사용해서 객체 생성 & 프로퍼티 초기화:
const x = 1;
const y = 2;
const point1 = { x: x, y: y };
console.log(point1);

// 객체의 프로퍼티 이름을 지역 변수 이름과 동일하게 할 경우, 간단히 쓸 수 있음.
const point2 = { x, y }; // [x, y] -> 배열
console.log(point2);
