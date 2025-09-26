number1 = int(input('Enter first number: '))
number2 = int(input('Enter second number: '))
number3 = int(input('Enter third number: '))
number4 = int(input('Enter fourth number: '))
number5 = int(input('Enter fifth number: '))
largest = number1 
smallest = number2
if number2 > number1:
	largest = number2
	if number3 > number2:
		largest = number3
		if number4 > number3:
			largest = number4
			if number5 > number4:
				largest = number5
				if number2 < number1:
					smallest = number2
					if number3 < number2:
						smallest = number3
						if number4 < number3:
							smallest = number4
							if number5 < number4:
								smallest = number5
print(largest, smallest)