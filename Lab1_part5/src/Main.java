public class Main {
    public static void main(String[] args) {

        Console console = new Console();
        OutputThread thread1 = new OutputThread(50, '|', false, console);
        OutputThread thread2 = new OutputThread(50, '-', true, console);

        thread1.start();
        thread2.start();
    }
}