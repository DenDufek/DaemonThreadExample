public class DaemonThreadExample {

    public static class MyDaemonThread extends Thread {
        public MyDaemonThread() {
            // Встановлюємо потік як daemon
            setDaemon(true);
        }

        @Override
        public void run() {
            // Логіка виконання в фоновому режимі
            for (int i = 1; i <= 5; i++) {
                System.out.println("Daemon Thread executing: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Створюємо демонічний потік
        MyDaemonThread daemonThread = new MyDaemonThread();

        // Запускаємо потік
        daemonThread.start();

        // Очікуємо деякий час, щоб вивід з демонічного потоку встиг вивестися
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread exiting");
    }
}
