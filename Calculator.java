import java.util.*;

public class Calculator {
    private static final List<String> a = new ArrayList<>();
    private static final Scanner b = new Scanner(System.in);
    
    public static void main(String[] c) {
        System.out.println("Welcome to the Calculator!");
        
        while (true) {
            System.out.print("Please enter your arithmetic expression: ");
            String d = b.nextLine();
            
            if (d.equalsIgnoreCase("history")) {
                e();
                continue;
            }
            
            if (d.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Calculator!");
                break;
            }
            
            try {
                double f = g(d);
                System.out.println("Result: " + f);
                a.add(d + " = " + f);
            } catch (Exception h) {
                System.out.println("Error: " + h.getMessage());
            }
        }
    }
    
    private static double g(String i) {
        i = i.replaceAll("\\s+", "");
        
        while (i.contains("pow(") || i.contains("abs(") || i.contains("sqrt(") || i.contains("round(")) {
            i = r(i);
        }
        
        Stack<Double> j = new Stack<>();
        Stack<Character> k = new Stack<>();
        
        for (int l = 0; l < i.length(); l++) {
            char m = i.charAt(l);
            
            if (Character.isDigit(m)) {
                StringBuilder n = new StringBuilder();
                while (l < i.length() && (Character.isDigit(i.charAt(l)) || i.charAt(l) == '.')) {
                    n.append(i.charAt(l));
                    l++;
                }
                l--;
                j.push(Double.parseDouble(n.toString()));
            } else if (m == '(') {
                k.push(m);
            } else if (m == ')') {
                while (!k.isEmpty() && k.peek() != '(') {
                    j.push(o(k.pop(), j.pop(), j.pop()));
                }
                k.pop();
            } else if (p(m)) {
                while (!k.isEmpty() && q(m) <= q(k.peek())) {
                    j.push(o(k.pop(), j.pop(), j.pop()));
                }
                k.push(m);
            }
        }
        
        while (!k.isEmpty()) {
            j.push(o(k.pop(), j.pop(), j.pop()));
        }
        
        return j.pop();
    }
    
    private static String r(String s) {
        int t = s.lastIndexOf("(");
        if (t == -1) return s;
        int u = s.indexOf(")", t);
        String v = s.substring(t + 1, u);
        
        double w = 0;
        if (s.startsWith("pow", t - 3)) {
            String[] x = v.split(",");
            w = Math.pow(Double.parseDouble(x[0]), Double.parseDouble(x[1]));
            s = s.substring(0, t - 3) + w + s.substring(u + 1);
        } else if (s.startsWith("abs", t - 3)) {
            w = Math.abs(Double.parseDouble(v));
            s = s.substring(0, t - 3) + w + s.substring(u + 1);
        } else if (s.startsWith("sqrt", t - 4)) {
            w = Math.sqrt(Double.parseDouble(v));
            s = s.substring(0, t - 4) + w + s.substring(u + 1);
        } else if (s.startsWith("round", t - 5)) {
            w = Math.round(Double.parseDouble(v));
            s = s.substring(0, t - 5) + w + s.substring(u + 1);
        }
        return s;
    }
    
    private static boolean p(char r) {
        return r == '+' || r == '-' || r == '*' || r == '/' || r == '%';
    }
    
    private static int q(char s) {
        return (s == '+' || s == '-') ? 1 : (s == '*' || s == '/' || s == '%') ? 2 : 0;
    }
    
    private static double o(char t, double u, double v) {
        switch (t) {
            case '+': return v + u;
            case '-': return v - u;
            case '*': return v * u;
            case '/': return (u == 0) ? Double.POSITIVE_INFINITY : v / u;
            case '%': return v % u;
            default: throw new IllegalArgumentException("Invalid operator: " + t);
        }
    }
    
    private static void e() {
        if (a.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("Calculation History:");
            for (String w : a) {
                System.out.println(w);
            }
        }
    }
}
