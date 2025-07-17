print(" ~Mortgage Calculator Console App~ 'Loan Officers' uses to know the Monthly payment value for a client => ")
PERCENTAGE = 100
MONTHS_IN_YEAR = 12
principal = float(input("Please enter the Principal amount: "))
annual_interest_rate = float(input("Please enter the Annual interest rate: "))
duration_of_loan = float(input("Please enter the Duration of the loan in years: "))

monthly_duration = duration_of_loan * 12
annual_rate = annual_interest_rate / PERCENTAGE
monthly_interest_rate = annual_rate / MONTHS_IN_YEAR
calculation1 = (1 + monthly_interest_rate)**monthly_duration 
calculation2 = (monthly_interest_rate * calculation1) / (calculation1 - 1)
monthly_payment_value = principal * calculation2

print("The Monthly payment value is: ", monthly_payment_value, "after the 'Annual' values have been converted to 'Monthly values.'")



