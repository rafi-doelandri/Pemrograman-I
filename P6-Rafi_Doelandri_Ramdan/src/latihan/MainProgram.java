/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

/**
 *
 * @author aryab
 */
public class MainProgram {
    public static void main(String[] args){
        StudentRecord annaRecord = new StudentRecord();
        
        annaRecord.setName("Anna");
        annaRecord.setAddress("Philippines");
        annaRecord.setAge(15);
        annaRecord.setMathGrade(80.0);
        annaRecord.setEnglishGrade(95.5);
        annaRecord.setScienceGrade(100.0);
        
        System.out.println("=== Print Versi 1 ===");
        annaRecord.print(annaRecord.getName());
        
        System.out.println();
        
        System.out.println("=== Print Versi 2 ===");
        annaRecord.print(
            annaRecord.getEnglishGrade(),
            annaRecord.getMathGrade(),
            annaRecord.getScienceGrade()
        );
        
        System.out.println();

        System.out.println("Rata-rata nilai: " + annaRecord.getAverage());
    }
}
