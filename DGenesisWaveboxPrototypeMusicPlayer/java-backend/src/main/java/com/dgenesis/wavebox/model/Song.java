package com.dgenesis.wavebox.model;

public class Song {
    private Long id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private int durationSeconds; // Duration in seconds
    private String fileName;
    private String OriginalFileName;
    private String fileSizeBytes;

    public Song() {
    }

    public Song(Long id, String title, String artist, String album, String genre, int durationSeconds, String fileName, String originalFileName, String fileSizeBytes) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.durationSeconds = durationSeconds;
        this.fileName = fileName;
        OriginalFileName = originalFileName;
        this.fileSizeBytes = fileSizeBytes;
    }

    public Long getId() {
        return id;
    }   

    public void setId(Long id) {
        this.id = id;
    }   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalFileName() {
        return OriginalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        OriginalFileName = originalFileName;
    }

    public String getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(String fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    
}
