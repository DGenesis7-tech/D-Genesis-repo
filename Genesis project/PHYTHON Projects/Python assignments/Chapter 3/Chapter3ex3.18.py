count = 12 
row = 10
space = 3
for i in range(1, 11, 1):
	star = i
	print(('*' * i) + (' ' * count) + ('*' * row) + (' ' * space) + ('*' * row) + (' ' * count) + ('*' * i))
	count -= 1
	row -= 1	
	space += 2		