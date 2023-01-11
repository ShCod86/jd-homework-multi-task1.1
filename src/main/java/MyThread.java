class MyThread extends Thread {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("MyTreads");
        Thread thread1 = new Thread(group, new MyThread(), "Я поток 1.");
        Thread thread2 = new Thread(group, new MyThread(), "Я поток 2.");
        Thread thread3 = new Thread(group, new MyThread(), "Я поток 3.");
        Thread thread4 = new Thread(group, new MyThread(), "Я поток 4.");
        System.out.println("Создаю потоки...");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.sleep(15000);
        System.out.println("Завершаю потоки.");
        group.interrupt();



    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println(currentThread().getName() + " Всем привет!");
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", currentThread().getName());
        }
    }
}
