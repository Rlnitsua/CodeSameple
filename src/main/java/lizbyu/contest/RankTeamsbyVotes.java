package lizbyu.contest;

import java.util.*;

public class RankTeamsbyVotes {

    public String rankTeams(String[] votes) {
        List<Team> teams = initTeamRankInfo(votes);
        Collections.sort(teams);

        return rankTeam(teams);
    }

    private List<Team> initTeamRankInfo(String[] votes) {
        Map<Character, int[]> teamRankInfo = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char ch = vote.charAt(i);

                if (!teamRankInfo.containsKey(ch)) {
                    int[] score = new int[vote.length()];
                    score[i]++;
                    teamRankInfo.put(ch, score);
                } else {
                    teamRankInfo.get(ch)[i]++;
                }
            }
        }

        List<Team> teams = new ArrayList<>();
        for (Map.Entry<Character, int[]> entry : teamRankInfo.entrySet()) {
            Team team = new Team(entry.getKey(), entry.getValue());
            teams.add(team);
        }

        return teams;
    }


    private String rankTeam(List<Team> teams) {
        StringBuffer sb = new StringBuffer();
        for (Team team : teams) {
            sb.append(team.getName());
        }
        return new String(sb);
    }


    private class Team implements Comparable<Team> {
        private char name;
        private int[] score;

        public Team(char name, int[] score) {
            this.name = name;
            this.score = score;
        }

        public char getName() {
            return name;
        }

        public int[] getScore() {
            return score;
        }

        @Override
        public int compareTo(Team o) {
            for (int i = 0; i < score.length; i++) {
                if (this.getScore()[i] > o.getScore()[i]) {
                    return -1;
                } else if (this.getScore()[i] < o.getScore()[i]) {
                    return 1;
                }
            }

            return this.getName() - o.getName();
        }
    }

}
