package Chapter01.P19_DeclareMultilineStrings;

import java.util.concurrent.TimeUnit;

public class MainExt {
    private static final String LS = System.lineSeparator();
    private static long startTime = 0L;

    public static void main(String[] args) {
        startTime = System.nanoTime();
        String text1 = new StringBuilder()
                .append("My high school, ").append(LS)
                .append("the Illinois Mathematics and Science Academy,").append(LS)
                .append("showed me that anything is possible ").append(LS)
                .append("and that you're never too young to think big.")
                .toString();
        System.out.println("--------------------------------------------");
        System.out.println("Text 1:" + LS + text1);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("--------------------------------------------");

        startTime = System.nanoTime();
        String text2 = String.join(LS,
                "My high school, ",
                "the Illinois Mathematics and Science Academy,",
                "showed me that anything is possible ",
                "and that you're never too young to think big.");
        System.out.println("Text 2:" + LS + text2);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("--------------------------------------------");

        startTime = System.nanoTime();
        String text3 = "My high school, " + LS
                + "the Illinois Mathematics and Science Academy," + LS
                + "showed me that anything is possible " + LS
                + "and that you're never too young to think big.";
        System.out.println("Text 3:" + LS + text3);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("--------------------------------------------");

        startTime = System.nanoTime();
        String text4 = String.format("%s" + LS + "%s" + LS + "%s" + LS + "%s",
                "My high school, ",
                "the Illinois Mathematics and Science Academy,",
                "showed me that anything is possible ",
                "and that you're never too young to think big.");
        System.out.println("Text 4:" + LS + text4);
        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("--------------------------------------------");
    }

    private static void displayExecutionTime(long time) {
        System.out.println("실행 시간 : " + time + " ns ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
