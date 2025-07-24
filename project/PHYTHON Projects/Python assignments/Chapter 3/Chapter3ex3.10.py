PRINCIPAL = 10000
RATE_OF_RETURN = 7
number_of_years = 1
for number_of_years in range(0, 30):
	expected_amount = PRINCIPAL * ((1 + RATE_OF_RETURN) ** number_of_years)
	number_of_years +=1
	print('Expected return amount after',  number_of_years, ' years is: ', expected_amount)
