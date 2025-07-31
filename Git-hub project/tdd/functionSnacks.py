import math

def divide_or_square(number):
	if type(number) == str :
		raise ValueError("input must be a number")
	if type(number) == float:
		number = math.sqrt(number)
	
	if number == (-number):
		raiseValueError( math.sqrt(-number), ('input must be possitive'))		
		
	if number % 5 == 0:
		number = round(math.sqrt(number), 2)
		return number
	
	else :
		result = number % 5
		return result
		
	