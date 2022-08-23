import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futureTask = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            futureTask.add(executorService.submit(new MyCallable("поток " + i)));
        }

        Thread.sleep(15000);
        executorService.shutdownNow();

        for (Future<String> future : futureTask) {
            System.out.println(future.get());
        }

    }
}
