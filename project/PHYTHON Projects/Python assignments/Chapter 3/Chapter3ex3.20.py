integer = 1101
first_char_in_integer = integer // 1000
second_char_in_integer = (integer % 1000) // 100
third_char_in_integer = (integer % 100) // 10
fourth_char_in_integer = integer % 10
decimal_equivalent = (first_char_in_integer * 8) + (second_char_in_integer * 4) + (third_char_in_integer * 2) + (fourth_char_in_integer * 1)
print(decimal_equivalent)

