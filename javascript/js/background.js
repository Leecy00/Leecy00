// Array에서 랜덤하게 한가지 element를 골라내는거 -> background.js랑 quotes.js에서 사용했던 방식
// 가장 중요한 부분은 숫자를 고르는 부분 랜던하게 Math.floor(Math.random() <- 0과 1사이의 숫자를 랜덤하게 가져다줌 *images.length)
// Math.floor <- 소수자릿수를 버려버린다. 
const images = ["1img.jpg","2img.jpg","3img.jpg"];
 const chosenImage = images[Math.floor(Math.random()*images.length)];
 const bgImage = document.createElement("img"); // 자바스크립트로 html태그를 만들었다. img태그 왜 자바스크립트로 만들었냐 랜던하게 이미지 배경을 돌릴려고!!
 bgImage.src = `img/${chosenImage}`;
 document.body.appendChild(bgImage);