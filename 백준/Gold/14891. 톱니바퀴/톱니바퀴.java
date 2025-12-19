import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static List<int[]> turnMethods = new ArrayList<>();
    static List<CogWheel> cogwheels = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            int[] wheel = new int[9];
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[j] = input.charAt(j) - '0';
            }
            cogwheels.add(new CogWheel(wheel));
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            turnMethods.add(new int[] {num, turn});
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < K; i++) {
            int[] turnMethod = turnMethods.get(i);
            int num = turnMethod[0];
            int turn = turnMethod[1];
            turn(num, turn);
        }

        int result = 0;
        result += cogwheels.get(0).getValue(0) == 1 ? 1 : 0;
        result += cogwheels.get(1).getValue(0) == 1 ? 2 : 0;
        result += cogwheels.get(2).getValue(0) == 1 ? 4 : 0;
        result += cogwheels.get(3).getValue(0) == 1 ? 8 : 0;

        System.out.print(result);
    }

    public static void turn(int num, int turn) {
        CogWheel firstCogWheel = cogwheels.get(0);
        CogWheel secondCogWheel = cogwheels.get(1);
        CogWheel thirdCogWheel = cogwheels.get(2);
        CogWheel fourthCogWheel = cogwheels.get(3);

        boolean notEqualFirstSecond = isNotEqual(firstCogWheel.getValue(2),  secondCogWheel.getValue(6));
        boolean notEqualSecondThird = isNotEqual(secondCogWheel.getValue(2),  thirdCogWheel.getValue(6));
        boolean notEqualThirdFour = isNotEqual(thirdCogWheel.getValue(2),  fourthCogWheel.getValue(6));
        if (num == 1) {
            if (turn == 1) {
                firstCogWheel.turnClockWise();
                if (notEqualFirstSecond) {
                    secondCogWheel.turnCounterClockWise();
                    if (notEqualSecondThird) {
                        thirdCogWheel.turnClockWise();
                        if (notEqualThirdFour) {
                            fourthCogWheel.turnCounterClockWise();
                        }
                    }
                }
            } else if (turn == -1) {
                firstCogWheel.turnCounterClockWise();
                if (notEqualFirstSecond) {
                    secondCogWheel.turnClockWise();
                    if (notEqualSecondThird) {
                        thirdCogWheel.turnCounterClockWise();
                        if (notEqualThirdFour) {
                            fourthCogWheel.turnClockWise();
                        }
                    }
                }
            }
        } else if (num == 2) {
            if (turn == 1) {
                secondCogWheel.turnClockWise();
                if (notEqualFirstSecond) {
                    firstCogWheel.turnCounterClockWise();
                }
                if (notEqualSecondThird) {
                    thirdCogWheel.turnCounterClockWise();
                    if (notEqualThirdFour) {
                        fourthCogWheel.turnClockWise();
                    }
                }
            } else if (turn == -1) {
                secondCogWheel.turnCounterClockWise();
                if (notEqualFirstSecond) {
                    firstCogWheel.turnClockWise();
                }
                if (notEqualSecondThird) {
                    thirdCogWheel.turnClockWise();
                    if (notEqualThirdFour) {
                        fourthCogWheel.turnCounterClockWise();
                    }
                }
            }
        } else if (num == 3) {
            if (turn == 1) {
                thirdCogWheel.turnClockWise();
                if (notEqualThirdFour) {
                    fourthCogWheel.turnCounterClockWise();
                }
                if (notEqualSecondThird) {
                    secondCogWheel.turnCounterClockWise();
                    if (notEqualFirstSecond) {
                        firstCogWheel.turnClockWise();
                    }
                }
            } else if (turn == -1) {
                thirdCogWheel.turnCounterClockWise();
                if (notEqualThirdFour) {
                    fourthCogWheel.turnClockWise();
                }
                if (notEqualSecondThird) {
                    secondCogWheel.turnClockWise();
                    if (notEqualFirstSecond) {
                        firstCogWheel.turnCounterClockWise();
                    }
                }
            }
        } else if (num == 4) {
            if (turn == 1) {
                fourthCogWheel.turnClockWise();
                if (notEqualThirdFour) {
                    thirdCogWheel.turnCounterClockWise();
                    if (notEqualSecondThird) {
                        secondCogWheel.turnClockWise();
                        if (notEqualFirstSecond) {
                            firstCogWheel.turnCounterClockWise();
                        }
                    }
                }
            } else if (turn == -1) {
                fourthCogWheel.turnCounterClockWise();
                if (notEqualThirdFour) {
                    thirdCogWheel.turnClockWise();
                    if (notEqualSecondThird) {
                        secondCogWheel.turnCounterClockWise();
                        if (notEqualFirstSecond) {
                            firstCogWheel.turnClockWise();
                        }
                    }
                }
            }
        }
    }

    public static boolean isNotEqual(int left, int right) {
        return left != right;
    }

    public static class CogWheel {
        int[] wheel;

        public CogWheel(int[] wheel) {
            this.wheel = wheel;
        }

        public void turnClockWise() {
            for (int i = 8; i > 0; i--) {
                wheel[i] = wheel[i - 1];
            }
            wheel[0] = wheel[8];
        }

        public void turnCounterClockWise() {
            wheel[8] = wheel[0];
            for (int i = 0; i < 8; i++) {
                wheel[i] = wheel[i + 1];
            }
        }

        public Integer getValue(int index) {
            return wheel[index];
        }
    }
}
