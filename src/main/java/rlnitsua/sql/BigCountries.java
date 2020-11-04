package rlnitsua.sql;

public class BigCountries {
    public static final String SQL =
            "SELECT name, population, area FROM World"
                    + "WHERE area > 3000000 OR population > 25000000";
}
