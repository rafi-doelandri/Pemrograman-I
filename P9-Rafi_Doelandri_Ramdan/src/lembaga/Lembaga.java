/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lembaga;

/**
 *
 * @author aryab
 */
public interface Lembaga {
    String Province = "Banten";
    String District = "Tanggerang Selatan";
    
    public void setName(String Name);
    public void setAddress(String Address);
    public void setPhone(String Phone);
    public String getName();
    public String getAddress();
    public String getPhone();
}
