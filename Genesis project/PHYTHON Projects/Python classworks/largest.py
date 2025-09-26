a = int(input("Enter score of the first subject: "))
b = int(input("Enter score of the second subject: "))
c = int(input("Enter score of the third subject: "))
largest = a
if b > largest:
	largest = b
	if c > largest:
		largest = c
print('largest score is : ', largest)	