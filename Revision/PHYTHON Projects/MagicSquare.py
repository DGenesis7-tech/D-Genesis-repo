def get_magic_square(test_list):
	for lists in test_list:
		if type(lists) == list :
			for value in lists:
				if type(value) != int:
					raise TypeError("Values must be integers")
				else:
					return True	