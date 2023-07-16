public class DominoSequence {

    public static int solution(int[] a) {
        int remove = 0;
        int n = a.length;

        for (int i = 0; i < n - 2; i += 2) {
            if (a[i] != a[i + 2] || a[i + 1] != a[i + 3]) {
                remove++;
            }
        }

        // Check the first and last tiles
        if (a[0] != a[1]) {
            remove++;
        }
        if (a[n - 2] != a[n - 1]) {
            remove++;
        }

        // Check for cases where removing a tile affects neighboring pairs
        for (int i = 0; i < n - 4; i += 2) {
            if (a[i] == a[i + 2] && a[i + 1] == a[i + 3] && a[i + 2] == a[i + 4]) {
                remove++;
            }
        }

        return remove;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 3, 4, 6, 2, 4, 1, 6};
        int remove = solution(a);
        System.out.println("The minimum number of tiles to remove is " + remove);
    }
}
