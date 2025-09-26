for number in range(1, 11):
	if number % 4 == 0:
		sum = (number) + (number * number) + (number * number * number) + (number * number * number * number) + (number * number * number * number * number);
		print(sum, end = " ")