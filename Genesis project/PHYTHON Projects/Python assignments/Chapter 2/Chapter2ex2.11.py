numbers = int(input('enter 5 numbers: '))
first_number = numbers // 10000
second_number = (numbers // 1000) % 10
third_number = ((numbers // 100) % 10) % 10
fourth_number = ((numbers // 10) % 100) % 10
fifth_number = numbers % 10
print(first_number   ,second_number   ,third_number   ,fourth_number   ,fifth_number)