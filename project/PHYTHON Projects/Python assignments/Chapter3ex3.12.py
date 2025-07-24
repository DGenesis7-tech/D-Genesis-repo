numbers = int(input('enter 5 numbers: '))
first_number = numbers // 10000
second_number = (numbers // 1000) % 10
third_number = ((numbers // 100) % 10) % 10
fourth_number = ((numbers // 10) % 100) % 10
fifth_number = numbers % 10
if first_number == fifth_number and second_number == fourth_number:
	print('Number is a palindrome')
else :
	print('Number is not a palindrome')
	