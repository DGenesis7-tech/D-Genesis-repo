function add (firstNumber, secondNumber){
    return firstNumber + secondNumber;
}

function subtract (firstNumber, secondNumber){
    return firstNumber - secondNumber;
}   

function multiply (firstNumber, secondNumber){
    return firstNumber * secondNumber;
}

function divide (firstNumber, secondNumber){
    return firstNumber / secondNumber;
}  

function square (firstNumber, secondNumber){
    return firstNumber * secondNumber * secondNumber;
} 

function addList (numbers){
    let sum = 0;
    for (let index = 0; index < numbers.length; index++) {
        sum += numbers[index];
    }
    return sum;
}

module.exports = {add, subtract, multiply, divide, square, addList};

