from password_analizer_functions_module import get_password
from password_analizer_functions_module import check_complexity1
from password_analizer_functions_module import check_complexity2
from password_analizer_functions_module import evaluate_strength
def main():
	while True:
		password = get_password()
		count_alphabets = check_complexity1(password)
		count_numbers = check_complexity2(password)
		strength = evaluate_strength(count_alphabets, count_numbers)		
		retry = input('Try another password? (yes/no): ')
		if retry == 'yes':
			print('Ok lets go again')
		else:
			print('End of program BYE!!')
		break
main()

