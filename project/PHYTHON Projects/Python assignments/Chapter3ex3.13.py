number = int(input('enter a number: '))
factorial = number * (number - 1)
count = number - 1
for number in range(number):
	count -= 1
	number *= (count)
	print(factorial)
	