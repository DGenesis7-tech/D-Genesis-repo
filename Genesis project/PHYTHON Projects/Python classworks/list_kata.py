def maximum_in_list(my_list):
	maximum = max(my_list)
	return maximum

def minimum_in_list(my_list):
	minimum = min(my_list)
	return minimum

def sum_of_values_in_list_of_integers(my_list):
	sum = 0
	for index in range(len(my_list)):
		sum = sum + my_list[index]
	return sum

def sum_of_even_values_in_list_of_integers(my_list):
	sum_of_even = 0
	for index in range(len(my_list)):
		if my_list[index] % 2 == 0:
			sum_of_even += my_list[index]
	return sum_of_even

def sum_of_odd_values_in_list_of_integers(my_list):
	sum_of_odd = 0
	for index in range(len(my_list)):
		if my_list[index] % 2 != 0:
			sum_of_odd += my_list[index]
	return sum_of_odd

def maximum_and_minimum_list_in_list(my_list):
	maximum_and_minimum_in_list = []
	maximum = max(my_list)
	minimum = min(my_list)
	maximum_and_minimum_in_list.append(maximum)
	maximum_and_minimum_in_list.append(minimum)
	return maximum_and_minimum_in_list

def number_of_even_values_in_list_of_integers(my_list):
	number_of_even_values_in_list = 0
	for index in range(len(my_list)):
		if my_list[index] % 2 == 0:
			number_of_even_values_in_list += 1
	return number_of_even_values_in_list

def number_of_odd_values_in_list_of_integers(my_list):
	number_of_odd_values_in_list = 0
	for index in range(len(my_list)):
		if my_list[index] % 2 != 0:
			number_of_odd_values_in_list += 1
	return number_of_odd_values_in_list

def even_values_list_in_list_of_integers(my_list):
	even_values_list_in_list1 = []
	for index in range(len(my_list)):
		if my_list[index] % 2 == 0:
			even_values_list_in_list1.append(my_list[index])
	return even_values_list_in_list1 
	
def odd_values_list_in_list_of_integers(my_list):
	odd_values_list_in_list = []
	for index in range(len(my_list)):
		if my_list[index] % 2 != 0:
			odd_values_list_in_list.append(my_list[index])	
	return odd_values_list_in_list 

def square_of_values_list_in_list_of_integers(my_list):
	square_of_values_list_in_list = []
	for index in range(len(my_list)):
		square_of_values_list_in_list += [(my_list[index]** 2)]	
	return square_of_values_list_in_list 
	
	
	
m_list = [1, 3, 4, 5]
print(square_of_values_list_in_list_of_integers(m_list))
	
		