/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lembaga;

/**
 *
 * @author aryab
 */
class SMA implements Lembaga, Tingkat {
    String Name, Address, Phone, Level;
    
    public SMA(String Name, String Address, String Phone, String Level) {
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
        this.Level = Level;
    }
    
     public void setName(String Name) {
        this.Name = Name;
    }
    
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    public String getName() {
        return Name;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public String getPhone() {
        return Phone;
    }
    
    // Implementasi method dari interface Tingkat
    public void setLevel(String Level) {
        this.Level = Level;
    }
    
    public String getLevel() {
        return Level;
    }
    
    public String toString() {
        return "Name : " + Name + "\n" +
               "Level : " + Level + "\n" +
               "Address : " + Address + "\n" +
               "Phone : " + Phone + "\n" +
               "District : " + District + "\n" +
               "Province : " + Province;
    }
}
