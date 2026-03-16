package main

import "fmt"

func ch415() {
    age := 70

    if age >= 65 {
        fmt.Println("Age is greater than or equal to 65")
    } else {
        fmt.Println("Age is less than 65")
    }

    x := 1
    total := 0

    for x <= 10 {
        total += x
        fmt.Println("x is:", x)
        x++
    }

    fmt.Println("Total is:", total)

    x = 1
    total = 0

    for x <= 100 {
        total += x
        x++
    }

    fmt.Println("Total:", total)

    y := 5

    for y != 0 {
        fmt.Println(y)
        y--
    }
}