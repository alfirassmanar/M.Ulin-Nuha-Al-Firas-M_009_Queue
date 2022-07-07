package latihanqueue_009;
//skrip --> pembeli memesan makanan, memberikan nama untuk antrian, lalu mendapatkan nomor antrian 
/*fitur --> 1. pesan makanan == input: menu makanan, nama pemesan || output: total pembelian, nomor antrian 
            2. menampilkan antrian == menampilkan antrian yang ada.
            3. panggil antrian == memanggil antrian sesuai nomor urutan, melakukan pembayaran. 
            4. keluar
*/
import java.util.Scanner;

public class LatihanQueue_009 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        cQueue urut=new cQueue();
        //variabel
        String[] menu={"Nasi Goreng Ayam","Nasi Goreng Seafood","Nasi Goreng Kambing"};
        int [] hmn={10000,8000,12000};
        int pilih=0;
        int antri=0;
        int total=0;
        int paid;
        //program
        do{
            System.out.println("==== SELAMAT DATANG ====");
            System.out.println("    1. Create");
            System.out.println("    2. Read Antrian");
            System.out.println("    3. Call Antrian");
            System.out.println("    4. Done");
            System.out.print("Pilih = ");
            pilih=sc.nextInt();
            System.out.println("============================\n");
            switch(pilih){
                case 1:
                    total=0;
                    String [][] tampung=new String [3][3];
                    System.out.println("==== PESAN ====");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println("["+(i+1)+"] "+menu[i]+"\t Rp."+hmn[i]);
                    }
                    int input;
                    int z=0;
                    do{
                        System.out.print("Nomor Menu (0 = Selesai) = "); input=sc.nextInt();
                        if(input>3){
                            System.out.println("input salah!");
                        }else if(input!=0){
                            int ganti=0;
                            System.out.print("Porsi = "); int p=sc.nextInt();
                            ganti=hmn[input-1]*p;
                            tampung[z][0]=menu[input-1];
                            tampung[z][1]=Integer.toString(p);
                            tampung[z][2]=Integer.toString(ganti);
                            total=total+ganti;
                            z++;
                        }else if(input==0){
                            System.out.println("\n               ============");
                            System.out.println("               PESANAN ANDA ");
                            System.out.println("               ============");
                            System.out.println("Nama Makanan\t\tPorsi\tHarga");
                            for (int i = 0; i < z; i++) {
                                if(tampung[i]!=null){
                                    System.out.println(tampung[i][0]+"\t"+tampung[i][1]+"\tRp."+tampung[i][2]);
                                }
                            }
                            System.out.println("            \t\tTotal = Rp."+total);
                            System.out.print("\nPesanan Atas Nama = ");String nama = sc.next();
                            System.out.println("NOMOR PESANAN ANDA = "+(antri+1));
                            urut.enqueue(nama, tampung, total, antri);
                            System.out.println("#############################\n");
                            antri++;
                        }
                    }while(input!=0);
                    break;
                case 2:
                    urut.tampil();
                    break;
                case 3:
                    System.out.println("==== PANGGILAN ANTRIAN ====");
                    int bayar=urut.dequeue();
                    System.out.println("Total Pembelian = Rp."+bayar);
                    do{
                        paid=0;
                        System.out.print("Uang Diterima   = Rp.");paid=sc.nextInt();
                    }while(paid<bayar);
                    System.out.println("Uang Kembalian  = Rp."+(paid-bayar));
                    System.out.println("==Terimakasih Atas Kunjungannya==");
                    break;
                case 4:
                    break;
            }
        }while(pilih!=4);
    }
}