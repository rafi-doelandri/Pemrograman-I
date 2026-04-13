import java.util.Scanner;

public class HitungNilai{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input Realisasi: ");
        float realisasi = input.nextFloat();

        System.out.print("Input kehadiran: ");
        float kehadiran = input.nextInt();

        System.out.print("Input nilai tugas: ");
        float tugas = input.nextFloat();

        System.out.print("Input nilai UTS: ");
        float uts = input.nextFloat();

        System.out.print("Input nilai UAS: ");
        float uas = input.nextFloat();

        input.close();

        float b_kehadiran = kehadiran/realisasi * 10;
        float b_tugas = tugas * 20/100;
        float b_uts = uts * 30/100;
        float b_uas = uas * 40/100;
        float total = b_kehadiran + b_tugas + b_uts + b_uas;

        System.out.println("Kehadiran: " + kehadiran + " dari realisasi: " + realisasi);
        System.out.println("Nilai Tugas: " + tugas);
        System.out.println("Nilai UTS: " + uts);
        System.out.println("Nilai UAS: " + uas);
        System.out.println("Total: " + total);
    }
}