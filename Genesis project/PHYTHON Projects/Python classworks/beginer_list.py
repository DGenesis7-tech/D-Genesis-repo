my_list = [2, 3, 4, 5]
sum_list = [0]
for index in range(0, 4):
	sum_list[0] += my_list[index] 
print("Sum of values in my_list =",sum_list)

print()


words_list = ["its", "a", "gym", "not", "a", "spar"]
index_lenght_list = []
for index in range(0, 6):
	index_lenght_list.append(len(words_list[index]))
print(index_lenght_list)
	
print()

integer_list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
odd_index_list = []
for index in range(0, 11):
	if index % 2 != 0:
		odd_index_list.append(integer_list[index])
print(odd_index_list)		
	
