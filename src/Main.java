import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval one = new Interval(1,3);
        Interval two = new Interval(2,6);
        Interval three = new Interval(8,10);
        Interval four = new Interval(15,18);
        intervals.add(one);
        intervals.add(two);
        intervals.add(three);
        intervals.add(four);
        ArrayList<Interval> res = mergeIntervals(intervals);
        System.out.println("Hello world!");
    }

    private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1;i < intervals.size();i++) {
            Interval top = stack.peek();
            Interval current = intervals.get(i);
            if (top.end < current.start) {
                stack.push(current);
            } else {
                top.end = Math.max(current.end, top.end);
            }
        }
        ArrayList<Interval> merged = new ArrayList<>();
        while (!stack.isEmpty()) {
            merged.add(0,stack.pop());
        }
        return merged;
    }
}