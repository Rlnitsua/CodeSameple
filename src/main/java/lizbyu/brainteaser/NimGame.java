package lizbyu.brainteaser;

public class NimGame {
    // 1->true 2->true 3->true 4->false
    // 5-1 = 4->false(other) 6-2 = 4->false(other) 7-3 = 4->false(other) ...
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
