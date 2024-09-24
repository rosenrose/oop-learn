package s02_pocutunes;

public class Program {
    public static void main(String[] args) {
        Song s1 = new Song("s1", "a1", 100);
        Song s2 = new Song("s2", "a2", 300);
        Song s3 = new Song("s3", "a3", 500);
        Song s4 = new Song("s4", "a4", 1000);

        System.out.printf("%s by %s. Playtime is %dms.%n", s1.getName(), s1.getArtist(), s1.getPlayTimeInMs());

        Playlist p1 = new Playlist("classic");
        p1.addSong(s1);
        p1.addSong(s2);
        p1.addSong(s3);

        Playlist p2 = new Playlist("rock");
        p2.addSong(s2);
        p2.addSong(s3);
        p2.addSong(s4);

        PocuTunes tune = new PocuTunes();
        tune.addSong(s1);
        tune.addSong(s2);
        tune.addSong(s3);
        tune.addSong(s4);
        tune.addPlaylist(p1);
        tune.addPlaylist(p2);

        System.out.printf("Song count: %d.%n", tune.getSongCount());

        tune.playSong("s1");
        tune.playSong("s3");
        tune.playSong("haha");

        tune.playPlaylist("trance");
        tune.playPlaylist("rock");

        p2.removeSong("s4");
        tune.playPlaylist("rock");

        tune.removeSong("s2");
        tune.playSong("s2");
        tune.playPlaylist("rock");
        tune.playPlaylist("classic");

        System.out.printf("Song count: %d.%n", tune.getSongCount());

        tune.removePlaylist("classic");
        tune.playPlaylist("classic");

        System.out.printf("Song count: %d.%n", tune.getSongCount());
    }
}
