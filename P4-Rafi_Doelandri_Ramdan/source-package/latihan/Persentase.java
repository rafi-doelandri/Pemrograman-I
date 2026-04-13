import java.util.Scanner;

public class Persentase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input pengeluaran makan: ");
        float makan = input.nextFloat();

        System.out.print("Input pengeluaran transport: ");
        float transport = input.nextFloat();
        
        System.out.print("Input pengeluaran belanja: ");
        float belanja = input.nextFloat();

        input.close();

        float total = makan + transport + belanja;
        float p_makan = (makan / total) * 100;
        float p_transport = (transport / total) * 100;
        float p_belanja = (belanja / total) * 100;

        System.out.println("Persentase makan: " + p_makan);
        System.out.println("Persentase transport: " + p_transport);
        System.out.println("Persentase belanja: " + p_belanja);
    }
}
