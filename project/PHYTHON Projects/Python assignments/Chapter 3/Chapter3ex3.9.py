numbers = int(input('enter 5 numbers: '))
count = 0
for count in range(1):
	count += 1
	if numbers < 100000 :
		first_number = numbers // 10000
		print(first_number)
	if numbers < 100000 :		
		second_number = (numbers // 1000) % 10
		print(second_number)
	if numbers < 100000 :		
		third_number = ((numbers // 100) % 10) % 10
		print(third_number)
	if numbers < 100000 :
		fourth_number = ((numbers // 10) % 100) % 10
		print(fourth_number)
	if numbers < 100000 :
		fifth_number = numbers % 10
		print(fifth_number)
			








