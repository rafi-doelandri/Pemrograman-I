/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

/**
 *
 * @author aryab
 */
import java.util.Scanner;

public class CekNilaidanKelulusan {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String grade;
        
        System.out.print("Input realisasi(total pertemuan kuliah): ");
        float realisasi = input.nextFloat();
        
        System.out.print("Input absensi: ");
        float absensi = input.nextFloat();
        
        System.out.print("Input nilai tugas: ");
        float tugas = input.nextFloat();
        
        System.out.print("Input nilai UTS: ");
        float uts = input.nextFloat();
        
        System.out.print("Input nilai UAS: ");
        float uas = input.nextFloat();
        
        input.close();
        
        float validasi = realisasi * 75/100;
        float total;
        
        if (absensi < validasi){
            float b_absensi = absensi/realisasi * 10;
            float b_tugas = tugas * 20/100;
            float b_uts = uts * 30/100;
            float b_uas = uas * 40/100;
            total = b_absensi + b_tugas + b_uts + b_uas;
            
            if(total > 55){
                total = 55;
            }
        }else{
            float b_absensi = absensi/realisasi * 10;
            float b_tugas = tugas * 20/100;
            float b_uts = uts * 30/100;
            float b_uas = uas * 40/100;
            total = b_absensi + b_tugas + b_uts + b_uas;
        }
        
        if (total >= 80){
            grade = "A";
        } else if (total >= 70){
            grade = "B";
        } else if (total >= 60){
            grade = "C";
        } else if (total >= 55){
            grade = "D";
        } else {
            grade = "E";
        }
        
        System.out.println("Kehadiran  : " + absensi + " dari realisasi: " + realisasi);
        System.out.println("Nilai Tugas: " + tugas);
        System.out.println("Nilai UTS  : " + uts);
        System.out.println("Nilai UAS  : " + uas);
        System.out.println("Total      : " + total);
        
        if (total >= 60){
            System.out.println("Selamat kamu lulus dengan grade " + grade);
        } else {
            System.out.println("Kamu tidak lulus, grade kamu " + grade);
        }
    }
}
