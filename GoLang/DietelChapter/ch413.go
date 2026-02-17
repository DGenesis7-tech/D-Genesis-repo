package main

import "fmt"

func main() {
	var number int
	var newNumber int

	for {
		fmt.Print("Enter a number (-1 to stop): ")
		fmt.Scanln(&number)
		
		if number < 7 {
			newNumber := number 
		}

		if number == -1 {
			break
		}

		fmt.Println("You entered:", number)
	}

	factorial := newNumber

	for i := 5; i >= 1; i-- {
		factorial *= i
	}

	fmt.Println("Factorial of the first input less than 7 is:", factorial)
}

}
