function phoneNumber(array){
let string = "(";
for (let index = 0; index < array.length; index++){
if (index <= 0) string += array[index];
else if (index == 2) string += array[index] + ") ";
else if (index == 5) string += array[index] + "-";
else string += array[index];
}
return string;
}

let myArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
console.log(phoneNumber(myArray));
