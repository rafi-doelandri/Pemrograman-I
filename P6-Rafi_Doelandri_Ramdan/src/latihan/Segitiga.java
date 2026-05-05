/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

/**
 *
 * @author aryab
 */
public class Segitiga {
    private double tinggi;
    private double alas;
    
    public void setTinggi(double tinggi){this.tinggi = tinggi;}
    public void setAlas(double alas){this.alas = alas;}
    
    public double getTinggi(){return tinggi;}
    public double getAlas(){return alas;}
    
    public double getLuas(){return (this.tinggi * this.alas *0.5);}
    
    public static void main(String[] args){
        Segitiga S[] = new Segitiga[2];
        Byte i;
        
        S[0] = new Segitiga();
        S[1] = new Segitiga();
        
        S[0].setTinggi(12.0);
        S[0].setAlas(8.0);
        
        S[1].setTinggi(11.23);
        S[1].setAlas(7.7);
        
        for(i=0;i<2;i++){
            System.out.println("Segitiga ke-" + (i+1));
            System.out.println("Tinggi = " + S[i].getTinggi());
            System.out.println("Alas = " + S[i].getAlas());
            System.out.println("Luas Segitiga = " + S[i].getLuas());
            System.out.println();
        }
    }
}
