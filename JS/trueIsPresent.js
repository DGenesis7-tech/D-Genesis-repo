function trueIsPresest(array){
let total = 0;
for (let index = 0; index < array.length; index++){
if (array[index] == true) total += 1;
}
return total;
}

let myArray = [true, true, true, false, true, true, true, true, true, false, true, false, true, false, false, true, true, true, true, true, false, false, true, true]
console.log(trueIsPresest(myArray));