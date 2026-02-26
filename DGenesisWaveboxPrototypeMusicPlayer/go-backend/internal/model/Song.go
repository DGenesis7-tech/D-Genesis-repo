package model

import "fmt"

type Song struct {
	ID				int64
	Title			string
	Artist			string
	Album			*string
	DurationSeconds *int
	FileName		string
	OriginalFileName string
	FileSizeBytes		int64
}

func (s Song) GetFormattedDuration() string {
	if s.DurationSeconds == nil || *s.DurationSeconds <= 0 {
		return "0:00"
	}

	total := *s.DurationSeconds
	minutes := total / 60
	seconds := total % 60

	return fmt.Sprintf("%d:%02d", minutes, seconds)

}

func (s Song) IsValid() bool {
	return s.Title != "" && s.Artist != "" && s.FileName != "" 	
}

func (s Song) String() string {
	album := "None"
	if s.Album != nil {
		album = *s.Album
	}
	return fmt.Sprintf(
		"Song{id=%d, title='%s', artist='%s', album='%s', duration=%s, fileName='%s', originalFileName='%s', fileSizeBytes=%d}",
		s.ID, s.Title, s.Artist, album, s.GetFormattedDuration(), s.FileName, s.OriginalFileName, s.FileSizeBytes,
	)
}	
	
