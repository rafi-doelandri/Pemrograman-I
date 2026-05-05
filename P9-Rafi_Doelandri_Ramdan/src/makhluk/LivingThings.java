/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package makhluk;

/**
 *
 * @author aryab
 */
abstract class LivingThings {
    public void breath(){
        System.out.println("Bernafas melalui hidung.");
    }
    
    public void eat(){
        System.out.println("Makan melalui mulu.");
    }
    
    public abstract void walk();
}
