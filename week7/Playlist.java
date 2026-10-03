import java.util.Arrays;
public class Playlist {
    private String[] songs;
    private int count;
    public Playlist(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }
    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }
    public int getSongCount() {
        return count;
    }
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Modifying the copy

        System.out.println("p.getSongs()[0] is still: " + p.getSongs()[0]); // Song A
        System.out.println("Song count: " + p.getSongCount()); // 2
    }
}
