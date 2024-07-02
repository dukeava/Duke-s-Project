def mortgage_calculator(loan_amount, annual_interest_rate, loan_term_years):
    # Convert annual interest rate to monthly rate
    monthly_interest_rate = annual_interest_rate / 100 / 12
    
    # Convert loan term from years to months
    loan_term_months = loan_term_years * 12
    
    # Calculate monthly mortgage payment
    monthly_payment = (loan_amount * monthly_interest_rate) / (1 - (1 + monthly_interest_rate)**(-loan_term_months))
    
    # Calculate total payment over the loan term
    total_payment = monthly_payment * loan_term_months
    
    # Calculate total interest paid
    total_interest = total_payment - loan_amount
    
    return monthly_payment, total_payment, total_interest

# Example usage:
if __name__ == "__main__":
    print("Welcome to the Mortgage Calculator!")
    print("---------------------------------")
    
    # Input loan details
    loan_amount = float(input("Enter loan amount ($): "))
    annual_interest_rate = float(input("Enter annual interest rate (%): "))
    loan_term_years = int(input("Enter loan term (years): "))
    
    # Calculate mortgage details
    monthly_payment, total_payment, total_interest = mortgage_calculator(loan_amount, annual_interest_rate, loan_term_years)
    
    # Print results
    print("\nMortgage Details:")
    print("----------------")
    print(f"Loan Amount: ${loan_amount:,.2f}")
    print(f"Annual Interest Rate: {annual_interest_rate}%")
    print(f"Loan Term: {loan_term_years} years")
    print(f"Monthly Payment: ${monthly_payment:.2f}")
    print(f"Total Payment: ${total_payment:.2f}")
    print(f"Total Interest Paid: ${total_interest:.2f}")
