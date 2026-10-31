import java.util.Arrays;

public class DutyRosterRotation {
    public static void rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        System.out.println(Arrays.toString(rotated));
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        rotateRoster(names1, 2);

        String[] names2 = {"A", "B", "C", "D", "E"};
        rotateRoster(names2, 7);
    }
}
