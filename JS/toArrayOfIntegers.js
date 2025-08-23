function toArrayOfIntegers(number){
let myArray = [];
if (number > 0){
for (let count = number; count >= 1; count--){
myArray.push(count);
}
}
else {
console.log("invalid");
}
return myArray;

}

console.log(toArrayOfIntegers(5));