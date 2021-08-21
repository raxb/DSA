package com.dsa;

public class DelimiterMatching {
    public static boolean isMatched(String data) {
        String opening = "([{";
        String closing = ")]}";
        Stack<Character> linkedStack = new LinkedStack<>();
        char[] check = data.toCharArray();
        for (char c : check) {
            if (opening.indexOf(c) != -1) {
                linkedStack.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (linkedStack.isEmpty())
                    return false;
                if (closing.indexOf(c) != opening.indexOf(linkedStack.pop()))
                    return false;
            }
        }
        return linkedStack.isEmpty();
    }

    public static boolean isHTMLMatched(String data) {
        Stack<String> linkedStack = new LinkedStack<>();
        int openIndex = data.indexOf('<');
        while (openIndex != -1) {
            int k = data.indexOf('>', openIndex + 1);
            String tagString = data.substring(openIndex + 1, k);
            if (!tagString.contains("/")) {
                linkedStack.push(tagString);
            } else {
                if (linkedStack.isEmpty())
                    return false;
                if (!tagString.substring(1).equals(linkedStack.pop()))
                    return false;
            }
            openIndex = data.indexOf('<', k + 1);
        }
        return linkedStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isMatched("[({property})]"));
        System.out.println(isMatched("[({property}]"));
        System.out.println(isMatched("(){})"));
        System.out.println(isMatched("[(5*(14/7)+3]"));
        System.out.println(isMatched("}[()]"));
        System.out.println("----HTML TAG MATCH----");
        System.out.println(isHTMLMatched("<body></body>"));
        System.out.println(isHTMLMatched("<h1><h2><p>Something</h2></p></h1>"));
        System.out.println(isHTMLMatched("<head><body></head></body>"));
        System.out.println(isHTMLMatched("<h1><h2><p>Something</p></h2></h1>"));
        System.out.println(isHTMLMatched("<h1><h2></h2>"));
    }
}
