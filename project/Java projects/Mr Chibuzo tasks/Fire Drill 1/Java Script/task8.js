let number = 1;
let sum = 0;
let sum1 = 0;
while (number <= 10) {
	if (number % 4 == 0 && number != 8){
	let sum = (number) + (number * number) + (number * number * number) + (number * number * number * number) + (number * number * number * number * number);
	}
	if (number % 4 == 0 && number != 4 && number == 8){
	let sum1 = (number) + (number * number) + (number * number * number) + (number * number * number * number) + (number * number * number * number * number);
	console.log(sum + sum1);
	}
	
number ++;
}
