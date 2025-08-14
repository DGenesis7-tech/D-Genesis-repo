for side1 in range(1, 21, 1):
	side1_square = (side1 * side1)
	for side2 in range(2, 21, 1):
		side2_square = (side2 * side2)
		for side3 in range(3, 21, 1):
			side3_square = (side3 * side3)
			sum_side1_side2_squares = (side1_square + side2_square)
			if sum_side1_side2_squares == side3_square:
				print(side1, side2, side3)
		
	
