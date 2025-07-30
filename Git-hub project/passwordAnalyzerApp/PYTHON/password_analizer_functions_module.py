def get_password():
	"""Definining function to collect users password containing alphabets and numbers""" 
	password = input('Enter password using alphabets and numbers only: ')
	return password
	
	
def check_complexity1(password):
	count_alphabets = 0
	count_numbers = 0
	for character in password:
		if character.isalpha():
			count_alphabets += 1
		elif character.isdigit():
			count_numbers += 1	
	print('Total number of "alphabets" in password = ', count_alphabets )
	return count_alphabets	
	
def check_complexity2(password):
	count_alphabets = 0
	count_numbers = 0
	for character in password:
		if character.isalpha():
			count_alphabets += 1
		elif character.isdigit():
			count_numbers += 1	
	print('Total number of "numbers" in password = ', count_numbers )
	return count_numbers


	
def evaluate_strength(count_alphabets, count_numbers):
	if count_alphabets > 8 and count_numbers >= 2:
		print('The strength of password is STRONG')
	elif 5 < count_alphabets < 8 and count_numbers >= 1:
		print('The strength of password is 	MODERATE')
	elif count_alphabets < 5 or count_numbers < 1:
		print('The strength of password is 	WEAK')
		
		
			