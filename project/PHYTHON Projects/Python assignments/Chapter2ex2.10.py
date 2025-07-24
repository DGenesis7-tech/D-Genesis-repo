input_a = int(input('Enter first integer: '))
input_b = int(input('Enter second integer: '))
input_c = int(input('Enter third integer: '))
largest = input_a 
if input_b > largest:
	largest = input_b
if input_c > largest:
	largest = input_c
print('largest is ', largest)
smallest = input_a
if input_b < smallest:
	smallest = input_b
if input_c < smallest:
	smallest = input_c
print('smallest is ', smallest)
product = input_a * input_b * input_c
print('product is ', product)
average = (input_a + input_b + input_c) / 3
print('average is ', average)
sum = input_a + input_b + input_c
print('sum is ', sum)
