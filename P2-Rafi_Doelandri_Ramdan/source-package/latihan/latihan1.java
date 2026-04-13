import java.util.Scanner;
public class latihan1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nama; int usia;

        System.out.print("input nama: ");
        nama = input.nextLine();
        System.out.print("input usia: ");
        usia = input.nextInt();
        input.close();

        System.out.println("nama: " + nama);
        System.out.println("usia: " + usia);
    }
}