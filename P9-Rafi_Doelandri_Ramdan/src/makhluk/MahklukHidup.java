/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package makhluk;

/**
 *
 * @author aryab
 */
public class MahklukHidup {
    public static void main(String args[]){
        Human manusia = new Human();
        Cat kucing = new Cat();
        
        System.out.println("=== Manusia ===");
        manusia.breath();
        manusia.eat();
        manusia.walk();
        
        System.out.println();
        
        System.out.println("==- Kucing ===");
        kucing.breath();
        kucing.eat();
        kucing.walk();
    }
}
