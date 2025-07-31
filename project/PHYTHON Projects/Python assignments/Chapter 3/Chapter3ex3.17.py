for star in range(10):
	print(star * '*')
	star += 1
print()	
for star in range(10, 0, -1):
	print('*' * star)
print()
space = ' '
star = '*'
print()
		
rows = 10
for i in range(1, rows + 1):
	space = rows - i
	star = i
	print(	space * ' ' + '*' * star)
print()
 
rows = 10
for i in range(10, 0, -1):
 	space = rows - i 
 	star = i
 	print(' ' * space +  '*' * 	i)