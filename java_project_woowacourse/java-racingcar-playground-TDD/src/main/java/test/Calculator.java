package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {


    public int splitAndSum(String input) {
        if (noInput(input)) return 0;
        if (inputOnlyOne(input)) return Integer.parseInt(input);

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] inputArr = m.group(2).split(customDelimiter);
            int sumNum = 0;
            for (String s : inputArr) {
                checkValid(s);
                sumNum += Integer.parseInt(s);
            }
            return sumNum;
        }

        String[] inputArr = input.split(",|:");
        int sumNum = 0;
        for (String s : inputArr) {
            checkValid(s);
            sumNum += Integer.parseInt(s);
        }

        return sumNum;
    }


    private boolean inputOnlyOne(String input) {
        if (input.length() == 1) {
            return true;
        }
        return false;
    }

    private boolean noInput(String input) {
        if (input == null || input.equals("")) {
            return true;
        }
        return false;
    }

    private void checkValid(String s) {
        try {
            int result = Integer.parseInt(s);
            if (result < 0) {
                throw new RuntimeException("[ERROR]");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR]");
        }
    }


}
