purchase_price_in_dollar = 10.27
money_paid_in_dollar = int(input("Please enter your payment in dollar (price of item is $10.27) : "))
expected_change_in_cents = ((money_paid_in_dollar - purchase_price_in_dollar) * 100) // 1
print("Your change is")
if expected_change_in_cents > 25:
	expected_change_in_quarters = expected_change_in_cents // 25
	if expected_change_in_cents % 25 > 10:
		remaining_change_in_dimes = (expected_change_in_cents % 25) // 10
		if (expected_change_in_cents - (expected_change_in_quarters * 2)) % 10 > 5:
			remaining_change_in_nickels = ((expected_change_in_cents - (expected_change_in_quarters * 2)) % 10) // 5
			if (expected_change_in_cents - (expected_change_in_quarters * 2)) % 10 < 5:
				remaining_change_in_pennies= (expected_change_in_cents - (expected_change_in_quarters * 2)) % 10
	
print(expected_change_in_cents, "cents")
print(expected_change_in_quarters, "quaters")
print(remaining_change_in_dimes, "dimes")