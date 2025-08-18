function descendingOrder(number){
let numberToString = "" + number;
let stringArray = numberToString.split('');
let numberArray = stringArray.map(Number);
let descendingString = ""
let counter = 0;
while (numberArray.length > 0){
let max = Math.max(...numberArray);
for (counter = 0; counter < numberArray.length; counter++){
if (numberArray[counter] == max){
descendingString += max.toString(); 
numberArray[counter] = Number.MIN_SAFE_INTEGER;
}
}
let newArray = [];
for (let index = 0; index < numberArray.length; index++){
if (numberArray[index] !== Number.MIN_SAFE_INTEGER){
newArray.push(numberArray[index]);  
}
}
numberArray = newArray;
}

return Number(descendingString);
}

console.log(descendingOrder(5673838));




    