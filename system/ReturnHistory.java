package system;

import java.util.Stack;

public class ReturnHistory {
    private Stack<String> returnLog = new Stack<>();

    public void addReturnLog(String log) {
        returnLog.push(log);
    }

    public void showHistory() {
        System.out.println("Return History:");
        for (String s : returnLog)
            System.out.println("- " + s);
    }
}
