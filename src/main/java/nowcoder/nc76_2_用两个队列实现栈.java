package nowcoder;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by WangSai on 2021/8/8
 */
public class nc76_2_用两个队列实现栈<T> {
    private final Queue<T> queue1 = new ArrayDeque<>();
    private final Queue<T> queue2 = new ArrayDeque<>();

    public boolean push(T t) {
        if (!queue1.isEmpty()) {
            queue1.offer(t);
        } else if (!queue2.isEmpty()) {
            queue2.offer(t);
        } else {
            queue1.offer(t);
        }
        return true;
    }

    public T pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            return null;
        }
    }

    public T top() {
        T top = null;
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                top = queue1.poll();
                queue2.offer(top);
            }
            return top;
        } else if (!queue2.isEmpty()) {
            while (!queue2.isEmpty()) {
                top = queue2.poll();
                queue1.offer(top);
            }
        }
        return top;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        nc76_2_用两个队列实现栈<Integer> t = new nc76_2_用两个队列实现栈<>();

        System.out.println("t.isEmpty():" + t.isEmpty());
        System.out.println("t.push(1):" + t.push(1));
        System.out.println("t.top():" + t.top());
        System.out.println("t.pop():" + t.pop());

        System.out.println("t.push(2):" + t.push(2));
        System.out.println("t.push(3):" + t.push(3));
        System.out.println("t.push(4):" + t.push(4));
        System.out.println("t.pop():" + t.pop());
        System.out.println("t.pop():" + t.pop());
        System.out.println("t.pop():" + t.pop());

    }
}
