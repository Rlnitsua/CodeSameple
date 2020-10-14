package lizbyu.easy;

public class Sum {
    public int sum(int[] datas) {
        int sum = 0;
        // traverse array and add every element
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] datas = init();
        System.out.println("1 + 2 + ... + 100 = " + new Sum().sum(datas));
    }

    private static int[] init() {
        int[] datas = new int[100];
        for (int i = 1; i <= 100; i++) {
            datas[i - 1] = i;
        }
        return datas;
    }
}
