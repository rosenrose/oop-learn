package s02_pocutunes;

public class Song {
    private final String name;
    private final String artist;
    private final int playTimeInMs;

    public Song(String name, String artist, int playTimeInMs) {
        this.name = name;
        this.artist = artist;
        this.playTimeInMs = playTimeInMs;
    }

    public String getName() {
        return this.name;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getPlayTimeInMs() {
        return this.playTimeInMs;
    }

    public void play() {
        System.out.printf("Playing %s by %s, Duration: %dms.%n", this.name, this.artist, this.playTimeInMs);
    }
}
