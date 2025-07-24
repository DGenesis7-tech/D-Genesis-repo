count = '*'
for count in range(1):
	print('*')
	count += 1
	for count in range(2):
		print('*', end = '')
		count -= 1
		for count in range(3):
			print('*', end = '')
			count += 1

	print()
		 