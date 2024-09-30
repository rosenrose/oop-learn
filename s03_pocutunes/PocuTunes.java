package s03_pocutunes;

import java.util.ArrayList;
import java.util.Optional;

public class PocuTunes {
    private final ArrayList<Song> songs;
    private final ArrayList<Playlist> playlists;

    public PocuTunes() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public PocuTunes(ArrayList<Song> songs, ArrayList<Playlist> playlists) {
        this.songs = songs;
        this.playlists = playlists;
    }

    public int getSongCount() {
        return this.songs.size();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public boolean removeSong(String songName) {
        for (Playlist playlist : this.playlists) {
            playlist.removeSong(songName);
        }

        Optional<Song> song = findSong(songName);

        if (song.isEmpty()) {
            return false;
        }

        this.songs.remove(song.get());
        return true;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public boolean removePlaylist(String playlistName) {
        Optional<Playlist> playlist = findPlaylist(playlistName);

        if (playlist.isEmpty()) {
            return false;
        }

        this.playlists.remove(playlist.get());

        return true;
    }

    public void playSong(String songName) {
        Optional<Song> song = findSong(songName);

        if (song.isEmpty()) {
            System.out.printf("Song \"%s\" not found.%n", songName);
            return;
        }

        song.get().play();
    }

    public void playPlaylist(String playlistName) {
        Optional<Playlist> playlist = findPlaylist(playlistName);

        if (playlist.isEmpty()) {
            System.out.printf("Playlist \"%s\" not found.%n", playlistName);
            return;
        }

        playlist.get().play();
    }

    private Optional<Playlist> findPlaylist(String playlistName) {
        return this.playlists.stream().filter(playlist -> playlist.getName().equals(playlistName)).findAny();
    }

    private Optional<Song> findSong(String songName) {
        return this.songs.stream().filter(song -> song.getName().equals(songName)).findAny();
    }
}
