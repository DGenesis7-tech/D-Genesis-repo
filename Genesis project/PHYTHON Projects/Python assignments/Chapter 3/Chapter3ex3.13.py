number = int(input('enter a number: '))
count = number - 1
for number in range(number):
	factorial = number * (count)
	count -= 1
	print(factorial)
	