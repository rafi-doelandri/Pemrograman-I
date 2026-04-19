/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

/**
 *
 * @author aryab
 */

import java.text.*;
import java.util.*;
public class FormatAngkaLokal {
    public static void main(String[] args){
        double angka = 83233463.342245;
        double desimal = 0.902235643;
        
        NumberFormat NumberFormatterGermany = NumberFormat.getNumberInstance(Locale.GERMANY);
        NumberFormat CurrFormatterGermany = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        NumberFormat PercentFormatterGermany = NumberFormat.getPercentInstance(Locale.GERMANY);
        
        String NumberStrGermany = NumberFormatterGermany.format(angka);
        String CurrStrGermany = CurrFormatterGermany.format(angka);
        String PercentStrGermany = PercentFormatterGermany.format(desimal);
        
        System.out.println("double angka = " + angka + " berformat number: " + NumberStrGermany);
        System.out.println("double angka = " + angka + " berformat currency: " + CurrStrGermany);
        System.out.println("double angka = " + desimal + " berformat percent: " + PercentStrGermany);
        System.out.println();
        System.out.println();
        
        NumberFormat NumberFormatterUS = NumberFormat.getNumberInstance(Locale.US);
        NumberFormat CurrFormatterUS = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat PercentFormatterUS = NumberFormat.getPercentInstance(Locale.US);
        
        System.out.println("double angka = " + angka + " berformat number: " + NumberFormatterUS.format(angka));
        System.out.println("double angka = " + angka + " berformat currency: " + CurrFormatterUS.format(angka));
        System.out.println("double angka = " + desimal + " berformat percent: " + PercentFormatterUS.format(desimal));
    }
}
