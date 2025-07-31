for sides in range(1, 21, 1):
	side1 = sides
	side2 = sides + 1
	side1_square = side1 ** 2
	side2_square = side2 ** 2
	for hypo in range(1, 21, 1):
		side3 = hypo
		side3_square = hypo ** 2
		if (side1_square + side2_square) == side3_square:
			print(side1, side2, side3)
			print(side1 ** 2, '+', side2 ** 2, '=', hypo ** 2)
		else:
			print(side1, side2, side3)
			print(side1 ** 2, '+', side2 ** 2, '!=', hypo ** 2)


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
#	for side2 in range(2, 21, 1):
#		side2_square = (side2 * side2)
#		for side3 in range(3, 21, 1):
#			side3_square = (side3 * side3)
#			sum_side1_side2_squares = (side1_square + side2_square)
#			if sum_side1_side2_squares == side3_square:
#				print(side1, side2, side3)
#			else:
#				print()
	
