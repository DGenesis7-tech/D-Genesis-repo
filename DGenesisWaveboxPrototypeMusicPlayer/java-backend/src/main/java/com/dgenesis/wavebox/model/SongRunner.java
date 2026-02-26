package com.dgenesis.wavebox.model;

public class SongRunner {
    public static void main(String[] args) {
        Song song1 = new Song();
        song1.setId(1L);
        song1.setTitle("Shape of You");
        song1.setArtist("Ed Sheeran");
        song1.setAlbum("Divide");
        song1.setGenre("Pop");
        song1.setDurationSeconds(233);
        song1.setFileName("shape_of_you.mp3");
        song1.setOriginalFileName("shape_of_you_original.mp3");
        song1.setFileSizeBytes(4096000L);
    
        Song song2 = new Song(2L, "Blinding Lights", "The weekend", "After Hours", "Alte", 200, "blinding_lights.mp3", "blinding_lights_original.mp3", 5120000L);
        
        System.out.println("=== D-GENESIS WAVEBOX- Song Model Test  ===");
        System.out.println(song1);
        System.out.println(song2);
        
        System.out.println("\n--- Duration Formatting ---");
        System.out.println(song1.getTitle() + " → " + song1.getFormatedDuration());
        System.out.println(song2.getTitle() + " → " + song2.getFormatedDuration());

        System.out.println("\n--- Validation ---");
        System.out.println(song1.getTitle() + " valid? " + song1.isValid());
        System.out.println(song2.getTitle() + " valid? " + song2.isValid());

        Song emptySong = new Song();
        System.out.println(emptySong.getTitle() + " valid? " + emptySong.isValid());    
    }
    
    }