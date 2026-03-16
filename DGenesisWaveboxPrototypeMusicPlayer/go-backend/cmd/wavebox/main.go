package main

import (
    "fmt"
    "github.com/dgenesis/wavebox/internal/model"
)

func main() {
    // Create a song — Go has no constructor, we use
    // a struct literal instead. Name each field explicitly.
    // Unset fields get their "zero value":
    //   string  → ""
    //   int64   → 0
    //   *string → nil

    album1 := "After Hours"   // we need a variable to get a pointer
    duration1 := 212

    song1 := model.Song{
        ID:               1,
        Title:            "Blinding Lights",
        Artist:           "The Weeknd",
        Album:            &album1,   // & means "give me the address of this variable"
        DurationSeconds:  &duration1,
        FileName:         "uuid-123.mp3",
        OriginalFileName: "blinding_lights.mp3",
        FileSizeBytes:    5242880,
    }

    album2 := "A Night at the Opera"
    duration2 := 354

    song2 := model.Song{
        ID:               2,
        Title:            "Bohemian Rhapsody",
        Artist:           "Queen",
        Album:            &album2,
        DurationSeconds:  &duration2,
        FileName:         "uuid-456.mp3",
        OriginalFileName: "bohemian_rhapsody.mp3",
        FileSizeBytes:    8388608,
    }

    fmt.Println("=== D-Genesis Wavebox (Go) — Song Model Test ===")
    fmt.Println(song1)
    fmt.Println(song2)

    fmt.Println("\n--- Duration Formatting ---")
    fmt.Printf("%s → %s\n", song1.Title, song1.GetFormattedDuration())
    fmt.Printf("%s → %s\n", song2.Title, song2.GetFormattedDuration())

    fmt.Println("\n--- Validation ---")
    fmt.Printf("%s valid? %v\n", song1.Title, song1.IsValid())

    emptySong := model.Song{}
    fmt.Printf("Empty song valid? %v\n", emptySong.IsValid())
}