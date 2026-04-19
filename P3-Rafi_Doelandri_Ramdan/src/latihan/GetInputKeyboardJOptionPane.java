/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

/**
 *
 * @author aryab
 */

import javax.swing.JOptionPane;
public class GetInputKeyboardJOptionPane {
    public static void main(String[] args){
        String nama, msg;
        
        nama = JOptionPane.showInputDialog("Ketik nama anda: ");
        msg = "Hello " + nama + "\nLanjutkan belajarnya pasti menjadi programmer Java !";
        
        JOptionPane.showMessageDialog(null, msg);
    }
}
