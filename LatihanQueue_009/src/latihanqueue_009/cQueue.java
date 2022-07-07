/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanqueue_009;

/**
 *
 * @author JON
 */
public class cQueue {
    cData front,rear;
    int jumlah;
    
    cQueue(){
        System.out.println("Antrian Dibuat");
    }
    void enqueue(String a,String [][]b,int c,int d){  //tambah data dari belakang
        cData baru=new cData(a,b,c,d);
        if(front==null){                        //antrian kosong
            front=rear=baru;
        }else{
            rear.next=baru;
            baru.prev=rear;
            rear=baru;
        }
        jumlah++;
    }

    int dequeue(){                                           //hapus depan
        String nm="";
        String[][]bl=new String[3][3];
        int total=0;
        int u=0;
        if(jumlah==0){ 
            System.out.println("Antrian sudah kosong!");
        }
        else{
            u=front.antri;
            total=front.total;
            nm=front.nama;
            bl=front.pembelian;
            System.out.println("No.Urut Pesanan = ["+(u+1)+"]");
            System.out.println("Pesanan Atas Nama = "+nm);
            System.out.println("\n\t\t==PESANAN==");
            for (int i = 0; i < 3; i++) {
                if(bl[i][0]!=null){
                    System.out.println(bl[i][0]+"\t"+bl[i][1]+"\tRp."+bl[i][2]);
                }
            }
            if(front.next==null){ front=rear=null; }            //antrian = 1
            else{ front=front.next; front.prev=null; }          //antrian > 1
             jumlah--; 
        }
        return total;
    }

    void tampil(){
        System.out.println("==== DAFTAR ANTRIAN ====");
        System.out.println("No.Urut\t\tNama Pembeli");        
        String[][]bl=new String[3][3];
        for (cData t = front;t!= null;t=t.next) {
            bl=t.pembelian;
            System.out.println("["+(t.antri+1)+"]"+"\t\t"+t.nama);
            for (int i = 0; i < 3; i++) {
                if(bl[i][0]!=null){
                    System.out.println("\t"+bl[i][0]+"\t"+bl[i][1]+"\tRp."+bl[i][2]);
                }
            }

        }
        System.out.println("");
    }
}
