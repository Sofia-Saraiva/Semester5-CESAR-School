public class Main {
    public static void main(String[] args) {
        Armazem amz = new Armazem(300);
        Thread p1 = new Thread(new Produtor(101, 15, 1, amz));
        Thread p2 = new Thread(new Produtor(102, 15, 10, amz));

        Thread c1 = new Thread(new Consumidor(201, 20, 100, amz));
        Thread c2 = new Thread(new Consumidor(202, 10, 10, amz));

        p1.start();
        p2.start();
        c1.start();
        c2.start();

    }

}