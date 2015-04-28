package martins.diogo;

public class Main {

    public static void main(String[] args) {
        Produto p = new Produto("ABC123", "Melancia", 140.00);

        try {
            System.out.println(p.precoParaQtde(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
