def tuple_appending(my_tuple, number):
	if not isinstance(number, (int, float)):
		raise ValueError("Appending number must be a numeric value")
	new_tuple = my_tuple + (number,)
	return new_tuple