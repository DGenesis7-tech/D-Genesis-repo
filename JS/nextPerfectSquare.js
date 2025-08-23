function nextPerfectSquare(number){
let squareRoot = Math.sqrt(number);
let nextSquare = Math.pow(squareRoot + 1, 2);
if (squareRoot != Math.floor(squareRoot)) return -1;
else return nextSquare;
}

console.log(`The next perfect square is ${nextPerfectSquare(25)} but -1 if input is not a perfect square`);


