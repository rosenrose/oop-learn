package s02_pocutunes;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private final ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public boolean removeSong(String songName) {
        for (Song song : this.songs) {
            if (song.getName().equals(songName)) {
                this.songs.remove(song);
                return true;
            }
        }

        return false;
    }

    public void play() {
        System.out.printf("--- Playing list: %s ---%n", this.name);

        for (Song song : this.songs) {
            song.play();
        }

        System.out.printf("--- Done list: %s ---%n%n", this.name);
    }
}
