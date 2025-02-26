public class Produtor implements Runnable {
    private  int codigo;
    private int qtdSacasColheita;
    private int intervaloProd;
    private Armazem deposito;
    private int totalProduzido;

    public Produtor( int cod, int qtd_sacas, int intervalo, Armazem dep){
        codigo = cod;
        qtdSacasColheita = qtd_sacas;
        intervaloProd = intervalo;
        deposito = dep;
        totalProduzido = 0;
    }
    public void run(){
        int y = 0;
        for(int i = 0; i<10;i++) {
            synchronized (deposito) {
                while (deposito.armazenar(qtdSacasColheita) == 0) {
                    try {
                        deposito.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                totalProduzido += qtdSacasColheita;
                System.out.println("Fazendeiro: "+codigo+", Total Produzido:"+totalProduzido+"\n");
                deposito.notifyAll();
            }
            try {
                Thread.sleep(intervaloProd);
            } catch( InterruptedException exception ) {
                System.err.println( exception.toString() );
            }
        }
    }
}


