input1 = 8
input2 = 5
input3 = 4
input4 = 7
input5 = 1
largest = 0
if input1 > input2 and input1 > input3 and input1 > input4 and input1 > input5 :
	largest = input1
if input2 > input1 and input2 > input3 and input2 > input4 and input2 > input5 :
	largest = input2
if input3 > input2 and input3 > input1 and input3 > input4 and input3 > input5 :
	largest = input3
if input4 > input2 and input4 > input3 and input4 > input3 and input4 > input5 :
	largest = input4
if input5 > input2 and input5 > input3 and input5 > input4 and input5 > input1 :
	largest = input5
print(largest)	
smallest = 0
if input1 < input2 and input1 < input3 and input1 < input4 and input1 < input5 :
	smallest = input1
if input2 < input1 and input2 < input3 and input2 < input4 and input2 < input5 :
	smallest = input2
if input3 < input2 and input3 < input1 and input3 < input4 and input3 < input5 :
	smallest = input3
if input4 < input2 and input4 < input3 and input4 < input3 and input4 < input5 :
	smallest = input4
if input5 < input2 and input5 < input3 and input5 < input4 and input5 < input1 :
	smallest = input5
print(smallest)
	
	
#range = largest - smallest

#print('input => ', '{', input1, input2, input3, input4, input5, '}')
#print('range =', range)
#print()
#input1 = 12
#input2 = 6
#input3 = 4
#input4 = 5
#input5 = 9
#range = input1 - input4
#print('input => ', '{', input1, input2, input3, input4, input5, '}')
#print('range =', range)
