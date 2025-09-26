number1 = float(input('Enter first floating-point number: '))
number2 = float(input('Enter second floating-point number: '))
number3 = float(input('Enter third floating-point number: '))
if float(number1) > float(number2) > float(number3):
	print(float(number3), float(number2), float(number1))
if float(number1) > float(number3) > float(number2):
	print(float(number2),  float(number3), float(number1))
if float(number2) > float(number1) > float(number3):
	print( float(number3), float(number1), float(number2))
if float(number2) > float(number3) > float(number1):
	print(float(number1),  float(number3), float(number2))
if  float(number3) > float(number2 ) > float(number1):
	print(float(number1), float(number2), float(number3))
if  float(number3) > float(number1) > float(number2):
	print(float(number2), float(number1),  float(number3))
						
						
		

