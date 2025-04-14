import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class Recording {
	private final int year;
	private final String artist;
	private final String title;
	private final String type;
	private final Set<String> genre;

	public Recording(String title, String artist, int year, String type, Set<String> genre) {
		this.title = title;
		this.year = year;
		this.artist = artist;
		this.type = type;
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public Collection<String> getGenre() {
		return genre;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return String.format("{ %s | %s | %s | %d | %s }", artist, title, genre, year, type);
	}

	@Override
	public int hashCode(){
		return Objects.hash(artist,title,genre,year,type);
	}
	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Recording recording = (Recording) o;
		return year == recording.year &&
				Objects.equals(artist, recording.artist) &&
				Objects.equals(title, recording.title) &&
				Objects.equals(genre, recording.genre) &&
				Objects.equals(type, recording.type);
	}
}

