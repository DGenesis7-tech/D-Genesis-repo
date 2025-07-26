for star in range(10):
	print(star * '*')
	star += 1
print()	
for star in range(10, 0, -1):
	print('*' * star)
print()
space = ' '
star = '*'
for space in range(10, 0, -1) and star in range(10):
	space *= ' '
	print(space)
	print(star * '*')	
		
	