package theory.questions.concurrency.fork_join_pool;


import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long> {
    private int[] arr;
    private int start, end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        if (end - start <= 10) {
            long sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);
            left.fork();
            return right.compute() + left.join();
        }
    }
}


public class ForkJoinPoolExample {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        SumTask task = new SumTask(arr, 0, 4);
        var sum = task.compute();
        System.out.println(sum);
    }
}
