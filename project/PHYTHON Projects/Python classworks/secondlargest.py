x = int(input("Enter first number"))
y = int(input("Enter second number"))
z = int(input("Enter third number"))
largest = x
second_largest = y
if y > largest:
	largest = y
	if z < largest:
		largest = z
		if  x == largest and y < x and y > z and y > second_largest:
			second_largest = y
			if y == largest and z < y and z > x:
				second_largest = z
				if z == largest and x < z and x > y:
					second_largest = x			
print("second largest is: ", second_largest)
	
	