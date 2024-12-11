/**
 * object.html 파일에 포함.
 */

// JSON(JavaScript Object Notation): 자바스크립트 객체 표현법.
// { property: value, ... }
// JS: [] - 배열(array), {} - 객체(object)
const person = {
    name: '홍길동',
    age: 16,
    phone: ['010-0000-0000', '02-0000-0000'],
};
console.log(person);

// 객체의 프로퍼티를 접근하는 방법: (1)참조 연산자, (2)인덱스 연산자
console.log(person.name); // 참조 연산자(.): object.propertyName
console.log(person['age']); // 인덱스 연산자([]): object['propertyName']
console.log(person.phone);
console.log(person.phone[0]);
console.log(person['phone'][1]);

// 객체의 프로퍼티 값을 변경.
person.age = 17;
console.log(person);

// JS 객체는, 객체가 생성된 이후에 새로운 프로퍼티를 동적인 추가할 수 있음!
person.email = 'hgd@itwill.com';
console.log(person);

// 메서드를 갖는 객체:
const score = {
    // properties
    html: 100,
    css: 90,
    js: 85,
    // methods
    sum: function () {
        // 메서드에서 객체의 프로퍼티를 참조할 때 this 키워드를 사용해야 함!
        return this.html + this.css + this.js;
    },
    mean: function () {
        // 같은 객체의 다른 메서드를 호출할 때도 this 키워드를 사용해야 함!
        return this.sum() / 3;
    },
};

console.log(score);
// 객체의 메서드 호출:
console.log(score.sum());
console.log(score.mean());

// 생성자 함수(constructor function): this 키워드를 사용해서 프로퍼티(들)을 선언하고,
// 같은 프로퍼티(들)을 갖는 객체들을 생성할 수 있는 함수.
function Score(html=0, css=0, js=0) {
    // 필드
    this.html = html;
    this.css = css;
    this.js = js;
    
    // 메서드
    this.sum = function () {
        return this.html + this.css + this.js;
    };
    
    this.mean = function () {
        return this.sum() / 3;
    };
}

// 생성자 함수 호출은 new 키워드를 사용해야 함.
const score1 = new Score(100, 100, 50);
console.log(score1);
console.log(score1.sum());
console.log(score1.mean());

const score2 = new Score();
console.log(score2);
console.log(score2.sum());
console.log(score2.mean());

// JS 객체는 for-in 구문에서 사용할 수 있음.
const student = {
    no: 123,
    name: '홍길동',
    grade: 1,
    classNo: 1,
};
console.log(student);
console.log(student['name']);

// for-in 구문은 객체의 프로퍼티 이름들을 순회(iteration)함.
for (const x in student) {
    console.log(x, ':', student[x]); // (주의) student.x 문법 오류.
}

for (const x in score1) {
    console.log(x, ':', score1[x]);
}

// JS 객체의 destructuring assignment(구조분해 할당)
// const stuNo = student.no;
// const stuName = student.name;
// const stuGrade = student.grade;
// const stuClassNo = student.classNo;
// const/let { propertyName: 변수선언, ... } = object;
// 지역변수 이름을 프로퍼티 이름과 동일하게 선언할 경우, const/let { proeprtyName, ... } = object;
const { no: stuNo, name: stuName } = student;
console.log(stuNo, stuName);

// const { no: no, name: name } = student;
const { no, name } = student;
console.log(no, name);

// 객체의 구조분해 할당에서 rest 연산자(...)
const { name: studentName, ...rest } = student;
console.log(studentName);
console.log(rest);

// 클래스 선언과 객체 생성:
class Rectangle {
    // 생성자(constructor): 필드 선언과 초기화. 생성자 이름은 constructor.
    constructor(width=0, height=0) {
        this.width = width;
        this.height = height;
    }
    
    // 메서드 - function 키워드를 사용하지 않음!
    area() {
        return this.width * this.height;
    }
    
    perimeter() {
        return (this.width + this.height) * 2;
    }
}

const rect1 = new Rectangle(); // 클래스 이름으로 생성자 호출
console.log(rect1);
console.log(rect1.area(), rect1.perimeter());

const rect2 = new Rectangle(3, 4);
console.log(rect2);
console.log(rect2.area(), rect2.perimeter());

// 원(Circle) 클래스 선언: 필드(radius), 메서드(area, perimeter)
class Circle {
    // 생성자
    constructor(radius=0) {
        this.radius = radius;
    }
    
    // 메서드
    area() {
        return 3.14 * this.radius * this.radius;
    }
    
    perimeter() {
        return 2 * 3.14 * this.radius;
    }
}

const circle = new Circle(10);
console.log(circle);
console.log(circle.area(), circle.perimeter());
