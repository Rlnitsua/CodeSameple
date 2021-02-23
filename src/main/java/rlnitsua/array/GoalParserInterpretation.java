package rlnitsua.array;

public class GoalParserInterpretation {
    // G -> G
    // () -> o
    // (al) -> al
    public String interpret(String command) {
        boolean isAL = false;

        StringBuilder sb = new StringBuilder();
        for (char ch : command.toCharArray()) {
            switch (ch) {
                case 'G':
                    sb.append(ch);
                    break;
                case '(':
                    isAL = false;
                    break;
                case ')':
                    if (!isAL) {
                        sb.append('o');
                    } else {
                        sb.append('a');
                        sb.append('l');
                    }
                    break;
                default:
                    isAL = true;
                    break;
            }
        }
        return sb.toString();
    }
}
