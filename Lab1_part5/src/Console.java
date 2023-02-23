import java.util.concurrent.atomic.AtomicBoolean;

public class Console {
    private final AtomicBoolean flag = new AtomicBoolean(false);

    public synchronized void PrintSymbol(char symbol, boolean condition){
        while (flag.get() != condition) {
            try {
                wait();
            }
            catch (InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.print(symbol);
        flag.set(!condition);
        notifyAll();
    }
}