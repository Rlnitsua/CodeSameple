package lizbyu.contest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RankTeamsbyVotesTest {
    private String[] votes;
    private String res;

    public RankTeamsbyVotesTest(String[] votes, String res) {
        this.votes = votes;
        this.res = res;
    }

    @Parameterized.Parameters(name = "{index} --- param : {0}")
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {new String[]{"ABC","ACB","ABC","ACB","ACB"}, "ACB"},
                {new String[]{"WXYZ","XYZW"}, "XWYZ"},
                {new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"}, "ABC"},
                {new String[]{"M","M","M","M"}, "M"}
        });
    }

    @Test
    public void rankTeams() {
        RankTeamsbyVotes rankTeamsbyVotes = new RankTeamsbyVotes();
        assertEquals(rankTeamsbyVotes.rankTeams(votes), res);
    }
}