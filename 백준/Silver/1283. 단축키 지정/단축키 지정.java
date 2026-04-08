import java.io.*;
import java.util.*;

/**
 * 1283. 단축키 지정
 * 메뉴 총 N개 옵션, 각 옵션들은 한 개 또는 여러 개의 단어로 옵션의 기능을 설명
 * 각 옵션에 단축키를 의미하는 대표 알파벳을 지정
 * - 하나의 옵션에 대해 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지 확인
 * - 만약 지정이 안 되었다면 그 알파벳을 단축키로 지정
 * - 첫 글자가 이미 지정 -> 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정
 * - 어떠한 것도 단축키로 지정할 수 없다면, 그냥 놔두며 대소문자 구분 x
 *
 * 하나의 옵션은 5개 이하의 단어로 표현, 각 단어 역시 10개 이하의 알파벳으로 표현 -> 5 * 10 + 4 = 54
 * - 단축키가 지정된 알파벳을 저장하는 boolean 배열 -> 대문자로 관리하자
 * - 공백을 기준으로 단어를 스플릿하고, 각 단어의 첫 글자가 등록이 됐는지 확인을 한다.
 * - 등록이 안되어 있으면, 등록하고 리턴
 * - 등록이 모두 되어 있으면, 순회해서 등록
 */

public class Main {

    static int N;
    static int[] commandIndex;
    static boolean[] isRegister = new boolean[27];
    static List<String> commands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        commandIndex = new int[N];
        Arrays.fill(commandIndex, -1);

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            solve(command, i);
            commands.add(command);
        }

        printResult();
        br.close();
    }

    public static void solve(String command, int num) {
        boolean isFirstSearch = firstSearch(command, num);
        if (isFirstSearch) {
            return ;
        }
        secondSearch(command, num);
    }

    public static boolean firstSearch(String command, int num) {
        StringTokenizer st = new StringTokenizer(command);
        int index = 0;

        while (st.hasMoreTokens()) {
            String token = st.nextToken().toUpperCase();
            if (!isRegister[token.charAt(0) - 'A']) {
                isRegister[token.charAt(0) - 'A'] = true;
                commandIndex[num] = index;
                return true;
            } else {
                index += token.length() + 1;
            }
        }

        return false;
    }

    public static void secondSearch(String command, int num) {
        String upperCaseCommand = command.toUpperCase();

        for (int i = 0; i < upperCaseCommand.length(); i++) {
            if (upperCaseCommand.charAt(i) == ' ') {
                continue;
            }

            if (!isRegister[upperCaseCommand.charAt(i) - 'A']) {
                isRegister[upperCaseCommand.charAt(i) - 'A'] = true;
                commandIndex[num] = i;
                return ;
            }
        }
    }

    public static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String command = commands.get(i);

            if (commandIndex[i] != -1) {
                for (int j = 0; j < command.length(); j++) {
                    char c = command.charAt(j);

                    if (j == commandIndex[i]) {
                        sb.append('[').append(c).append(']');
                    } else {
                        sb.append(c);
                    }
                }
            } else {
                sb.append(command);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
