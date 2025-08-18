function highestAndLowestInStringOfNumbers(string){
let stringToStringArray = string.split(" ");
let stringToNumberArray = [];
let count = 0;
for (count = 0; count < stringToStringArray.length; count++){
stringToNumberArray.push(Number(stringToStringArray[count]));
}
let highest = Math.max(...stringToNumberArray);
let lowest = Math.min(...stringToNumberArray);
let newString = "";
newString += highest + " ";
newString += lowest;
return newString;
}

console.log(highestAndLowestInStringOfNumbers("4 5 7 2 3"));