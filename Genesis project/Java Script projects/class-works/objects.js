let person = {
	firstame: "feyi",
	lastname: "onoja",
	age: 92,
	nationality: "togolese"
	}
	
for (const Age in person	){
if (Age == "age") 
console.log(`${Age}: ${person[Age]}`);
}