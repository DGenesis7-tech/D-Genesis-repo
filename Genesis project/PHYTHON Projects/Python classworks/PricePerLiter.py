print('Current price of one liter is 855 naira')
PRICE_PER_LITER = 855
total_budget = float(input("Please enter your total budget: "))
liter_per_budget = total_budget / PRICE_PER_LITER
print('Total liters per budget is: ', round(liter_per_budget, 2))