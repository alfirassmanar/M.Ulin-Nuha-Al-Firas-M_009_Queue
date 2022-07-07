/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanqueue_009;

/**
 *
 * @author JON
 */
public class cData {
    String nama;
    String [][] pembelian = new String [3][3];
    int total;
    int antri;
    cData next,prev;
    
    cData(String a,String [][] b,int c,int d){
        nama=a;pembelian=b;total=c;antri=d;
        System.out.println("Pesanan anda sedang dibuatkan");
        System.out.println("Total Pembelian Anda : "+total);
    }
    
    
}