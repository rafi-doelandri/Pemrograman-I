/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lembaga;

/**
 *
 * @author aryab
 */
public class LembagaPendidikan {
    public static void main(String args[]){
        University unpam = new University(
            "Universitas Pamulang",
            "Jl. Surya Kencana No.1",
            "+62 21 7412566",
            "Universitas"
        );
        
        // Membuat object SMA
        SMA sman2 = new SMA(
            "SMAN 2 Kota Tangerang Selatan",
            "Jl. Raya Puspiptek Muncul",
            "+62 21",
            "SLTA"
        );
        
        System.out.println("Informasi Lembaga Pendidikan :\n" + unpam.toString());
        System.out.println();
        System.out.println("Informasi Lembaga Pendidikan :\n" + sman2.toString());
    }
}
