/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

/**
 *
 * @author aryab
 */
public class StudentRecord {
    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    
    private static int studentCount;
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public double getScienceGrade() {
        return scienceGrade;
    }

    /**
     * Menghitung rata-rata dari tiga nilai.
     * @return rata-rata mathGrade, englishGrade, dan scienceGrade
     */
    public double getAverage() {
        double result = 0;
        result = (mathGrade + englishGrade + scienceGrade) / 3;
        return result;
    }

    /**
     * Static method: mengambil jumlah object StudentRecord yang sudah dibuat.
     * @return nilai studentCount
     */
    public static int getStudentCount() {
        return studentCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public void setEnglishGrade(double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public void setScienceGrade(double scienceGrade) {
        this.scienceGrade = scienceGrade;
    }
    
    /**
     * Versi 1: Menerima parameter String (nama).
     * Menampilkan nama, alamat, dan umur siswa.
     */
    
    public void print(String temp) {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }

    /**
     * Versi 2: Menerima 3 parameter double (nilai pelajaran).
     * Menampilkan nama, dan ketiga nilai siswa.
     */
    
    public void print(double eGrade, double mGrade, double sGrade) {
        System.out.println("Name: " + name);
        System.out.println("Math Grade: " + mGrade);
        System.out.println("English Grade: " + eGrade);
        System.out.println("Science Grade: " + sGrade);
    }
}
