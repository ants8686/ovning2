import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

public class Searcher implements SearchOperations{

	private final Set<Recording> recordings = new HashSet<>();
	private final Map<String, Set<Recording>> artistMap = new HashMap<>();
	private final Map<String, Set<Recording>> genreMap = new HashMap<>();
	private final Map<String, Recording> titleMap = new HashMap<>();
	private final Map<Integer, Set<Recording>> yearMap = new HashMap<>();

	public Searcher(Collection<Recording> data) {

		Collection<Recording> recordings = data;

	}
	@Override
	public long numberOfArtists(){
		return artistMap.keySet().size();
	}
	@Override
	public long numberOfGenres(){
		return genreMap.keySet().size();
	}

	@Override
	public long numberOfTitles(){
		return titleMap.keySet().size();
	}
	@Override
	public boolean doesArtistExist(String name){
		for(Recording r: recordings ){
			if(r.getArtist().equals(name)){
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<String> getGenres(){
		return Collections.unmodifiableSet(genreMap.keySet());

	}

	@Override
	public Recording getRecordingByName(String title){
		for(Recording r : recordings){
			if(r.getTitle().equals(title)){
				return r;
			}
		}
		return null;
	}
	@Override
	public Collection<Recording> getRecordingsAfter(int year){
		Set<Recording> recordingsByYear = new HashSet<>();
		for (Recording r : recordings){
			if(r.getYear() >= year){
				recordingsByYear.add(r);
			}
		}
		return Collections.unmodifiableSet(recordingsByYear);
	}

	@Override
	public SortedSet<Recording> getRecordingsByArtistOrderedByYearAsc(String artist){
		SortedSet<Recording> recordingsByArtist = new TreeSet<>(Comparator.comparing(Recording::getYear));
		for (Recording r : recordings){
			if(r.getArtist().equals(artist)){
				recordingsByArtist.add(r);
			}
		}
		return Collections.unmodifiableSortedSet(recordingsByArtist);

	}
	@Override
	public Collection<Recording> getRecordingsByGenre(String genre){

	}

}

