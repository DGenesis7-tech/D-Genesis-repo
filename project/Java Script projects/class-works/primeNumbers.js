let n = 10;
let count = 1; 
let primeCount = 0;
let notPrimeCount = 0;
let totalPrime = 0;
do{
for (count = 1; count <= n; count++){
let prime = n % count;
if (prime == 0) {
primeCount += 1;
}
else {
notPrimeCount +=1;
}
}
} while (count == n);
if (primeCount == 2){
console.log(n + "is a prime number");
console.log("First prime is" + n);
n -= 1;

}


