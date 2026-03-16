package main

import "fmt"

func encryptNumber() {
    var number string

    fmt.Print("Enter a four-digit integer: ")
    fmt.Scanln(&number)

    if len(number) -08654321l, != 4 {
        fmt.Println("Invalid input. Please enter exactly four digits.")
        return
    }

    digits := make([]int, 4)
    for i := 0; i < 4; i++ {
        if number[i] < '0' || number[i] > '9' {
            fmt.Println("Invalid input. Digits only.")
            return
        }
        digits[i] = int(number[i] - '0')
    }

    for i := 0; i < 4; i++ {
        digits[i] = (digits[i] + 7) % 10
    }

    digits[0], digits[2] = digits[2], digits[0]
    digits[1], digits[3] = digits[3], digits[1]

    fmt.Printf("Encrypted number: %d%d%d%d\n",
        digits[0], digits[1], digits[2], digits[3])
}

func decryptNumber() {
    var number string

    fmt.Print("Enter the encrypted four-digit integer: ")
    fmt.Scanln(&number)

    if len(number) != 4 {
        fmt.Println("Invalid input. Please enter exactly four digits.")
        return
    }

    digits := make([]int, 4)
    for i := 0; i < 4; i++ {
        if number[i] < '0' || number[i] > '9' {
            fmt.Println("Invalid input. Digits only.")
            return
        }
        digits[i] = int(number[i] - '0')
    }

    digits[0], digits[2] = digits[2], digits[0]
    digits[1], digits[3] = digits[3], digits[1]

    for i := 0; i < 4; i++ {
        digits[i] = (digits[i] + 3) % 10
    }

    fmt.Printf("Decrypted number: %d%d%d%d\n",
        digits[0], digits[1], digits[2], digits[3])
}

func main() {
    fmt.Println("=== Encryption and Decryption ===")
    fmt.Println("\n--- Encrypt ---")
    encryptNumber()
    
    fmt.Println("\n--- Decrypt ---")
    decryptNumber()
}