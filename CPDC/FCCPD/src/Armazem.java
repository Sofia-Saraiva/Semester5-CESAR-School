public class Armazem {
    private int estoque;
    private int capMax;

    public Armazem(int cap) {
        estoque = 0;
        capMax = cap;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public synchronized int retirar(int consumo) {
        if ((estoque - consumo) >= 0) {
            estoque -= consumo;
            System.out.println("   ARMAZEM(saida) -> Estoque Atual: "+estoque+" sacas");
            return 1;
        }
        System.out.println("   *** Armazem sem estoque! ***");
        return 0;
    }

    public synchronized int armazenar (int qtd) {
        if ((estoque + qtd) <= capMax) {
            estoque += qtd;
            System.out.println("   ARMAZEM(entrada) -> Estoque Atual: "+estoque+" sacas");
            return 1;
        }
        System.out.println("   ***Armazem com capacidade Maxima! ***");
        return 0;
    }
}

