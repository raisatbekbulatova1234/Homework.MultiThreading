import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private int count = 0;
    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        Thread.currentThread().setName(name);
        try {
            while (!Thread.currentThread().isInterrupted()) {

                count++;
                System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");

                Thread.sleep(3000);

            }
        } catch (InterruptedException e) {

        } finally {
            System.out.println(Thread.currentThread().getName() + " завершён.");
        }

        return Thread.currentThread().getName() + " вывел сообщения " + count + " раз.";
    }
}
