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
