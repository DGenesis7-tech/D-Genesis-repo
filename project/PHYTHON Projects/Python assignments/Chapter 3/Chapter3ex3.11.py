gallons_used = float(input('Enter gallons used (-1 to end): '))
miles_driven = float(input('Enter the miles driven (-1 to end): '))
miles_per_gallon = miles_driven / gallons_used
print('The miles/gallon for this tank was: ', miles_per_gallon)
count = 1
while gallons_used != -1 :
	gallons_used = float(input('Enter gallons used (-1 to end): '))
	miles_driven = float(input('Enter the miles driven (-1 to end): '))
	miles_per_gallon = miles_driven / gallons_used
	print('The miles/gallon for this tank was: ', miles_per_gallon)
	count += 1
	if gallons_used != -1:
		miles_per_gallon += miles_per_gallon
	
print('The overall average miles/gallon was ', (miles_per_gallon / count))
	
	