import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Filkom_Mart {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        DateTimeFormatter formatterClock = DateTimeFormatter.ofPattern("HH.mm");
        String formattedDay = date.format(formatter);
        String formattedClock = date.format(formatterClock);
        Random r = new Random();
        int receiptNumber = r.nextInt(100000, 999999);
        int orderId = r.nextInt(100, 999);

        System.out.print("Nama Kasir : ");
        String kasir = in.nextLine();

        System.out.print("Jumlah barang yang dibeli: ");
        int n = in.nextInt();
        in.nextLine();

        String[] namaBarang = new String[n];
        int[] hargaBarang = new int[n];
        int[] jumlahBarang = new int[n];
        int subtotal = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nBarang ke-" + (i + 1));
            System.out.print("Nama barang: ");
            namaBarang[i] = in.nextLine();
            System.out.print("Harga satuan: ");
            hargaBarang[i] = in.nextInt();
            System.out.print("Jumlah: ");
            jumlahBarang[i] = in.nextInt();
            in.nextLine();

            subtotal += hargaBarang[i] * jumlahBarang[i];
        }

        double diskon = 0;
        if (subtotal >= 500000) {
            diskon = 0.2;
        } else if (subtotal >= 100000) {
            diskon = 0.1;
        } else if (subtotal >= 50000) {
            diskon = 0.05;
        }

        double potongan = subtotal * diskon;
        double totalBayar = subtotal - potongan;

        System.out.println("\nJumlah pembayaran: ");
        int bayar = in.nextInt();
        double kembali = bayar - totalBayar;


        System.out.println("           FILKOM-MART");
        System.out.println("        JL VETERAN MALANG");
        System.out.println("        TELP. 0341-577911");
        System.out.printf("%s   %s\n", formattedDay, formattedClock);
        System.out.println("Receipt Number : " + receiptNumber);
        System.out.println("Order ID       : FM" + orderId);
        System.out.println("Collected by   : " + kasir);
        System.out.println("=================================");
        for (int i = 0; i < n; i++) {
            double totalPerBarang = hargaBarang[i] * jumlahBarang[i];
            System.out.printf("%-15s\n%-10d x @%,.0f \t %,.0f\n",
                    namaBarang[i], jumlahBarang[i], (double) hargaBarang[i], totalPerBarang);
        }
        System.out.println("=================================");
        System.out.printf("Subtotal \t Rp. %,.0f\n", (double) subtotal);
        System.out.printf("Diskon %.0f%% \t -Rp. %,.0f\n", diskon * 100, potongan);
        System.out.println("=================================");
        System.out.printf("Total \t\t Rp %,.0f\n", totalBayar);
        System.out.printf("Bayar \t\t Rp %,.0f\n", (double) bayar);
        System.out.println("=================================");
        System.out.printf("Kembali \t Rp %,.0f\n", kembali);
        System.out.println("=================================");
        System.out.println("Terima Kasih Telah Berbelanja di");
        System.out.println("        FILKOM-MART");

        in.close();
    }
}
