package rlnitsua.contest;

public class NumberOfRounds {
    public int numberOfRounds(String startTime, String finishTime) {
        int startMinute = Integer.parseInt(startTime.split(":")[1]);
        int startHour = Integer.parseInt(startTime.split(":")[0]);
        int finishMinute = Integer.parseInt(finishTime.split(":")[1]);
        int finishHour = Integer.parseInt(finishTime.split(":")[0]);

        if ((startHour == finishHour && startMinute < finishMinute)) {
            return inHourTime(startMinute, finishMinute);
        } else if (startHour < finishHour) {
            return (finishHour - startHour - 1) * 4
                    + startWithMinute(startMinute)
                    + endWithMinute(finishMinute);
        } else {
            return (24 - startHour) * 4
                    + (finishHour - 1) * 4
                    + startWithMinute(startMinute)
                    + endWithMinute(finishMinute);
        }
    }

    private int inHourTime (int sm, int fm) {
        if (sm == 0 || sm == 15 || sm == 30 || sm == 45) {
            return (fm - sm) / 15;
        } else {
            return (fm - sm) / 15 - 1;
        }
    }

    private int startWithMinute(int startMinute) {
        if (startMinute == 0 || startMinute == 15 || startMinute == 30 || startMinute == 45) {
            return 4 - startMinute / 15;
        } else {
            return 3 - startMinute / 15;
        }
    }
    private int endWithMinute(int finishMinute) {
        return finishMinute / 15;
    }


}
