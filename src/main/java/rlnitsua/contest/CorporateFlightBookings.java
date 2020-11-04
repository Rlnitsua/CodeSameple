package rlnitsua.contest;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int[] bookInfo : bookings) {
            int startIndex = bookInfo[0];
            int endIndex = bookInfo[1];
            int bookNums = bookInfo[2];

            for (int i = startIndex - 1; i < endIndex; i++) {
                res[i] += bookNums;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        CorporateFlightBookings corporateFlightBookings = new CorporateFlightBookings();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.print(corporateFlightBookings.corpFlightBookings(bookings, 5));
    }
}
