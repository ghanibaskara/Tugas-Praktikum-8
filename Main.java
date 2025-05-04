public class Main {
    
    public static void main(String[] args) {
        //membuat array invoice masing masing karyawan dengan reference ke class Invoice
        //menggunakan constructor untuk menginisialisasi objek invoice
        Invoice[] invoicesKaryawan1 = {
            new Invoice("Beras", 2, 75000),
            new Invoice("Gula", 3, 15000),
            new Invoice("Minyak Goreng", 1, 30000)
        };

        //membuat array invoice masing masing karyawan dengan reference ke class Invoice
        //menggunakan constructor untuk menginisialisasi objek invoice
        Invoice[] invoicesKaryawan2 = {
            new Invoice("Tepung", 2, 12000),
            new Invoice("Telur", 2, 30000),
            new Invoice("Sabun", 3, 5000),
            new Invoice("Susu", 5, 10000)
        };
        
        //membuat objek karyawan dengan reference ke class Employee
        Employee karyawan1 = new Employee(12345, "John Doe", 300000, invoicesKaryawan1);
        Employee karyawan2 = new Employee(67890, "Dewi Lestari", 450000, invoicesKaryawan2);

        //membuat array karyawan dan invoice dengan menggunakan polimorfisme yaitu mereferensikan objek karyawan dan invoice ke interface Payable
        //membuat array karyawan dengan reference ke class Employee yang berisi objek karyawan1 dan karyawan2
        Payable[] karyawan = {karyawan1, karyawan2};
        //membuat array invoices dua dimensi dengan reference ke class Payable yang berisi objek array invoice dari masing masing karyawan yang diambil dari method getInvoices()
        Payable[][] invoices = {karyawan1.getInvoices(), karyawan2.getInvoices()};

        //menampilkan informasi masing masing karyawan serta invoice pengeluarannya dengan menggunakan for loop dan method toString() yang telah dioverride pada class Employee dan Invoice
        for (int i = 0; i < karyawan.length; i++) {
            System.out.println("Karyawan " + (i+1) + ": "); //menampilkan urutan nomor karyawan yang ditampilkan
            System.out.println(karyawan[i]); //print out objek karyawan dari array karyawan dengan menggunaakn method toString() yang telah dioverride pada class Employee
            System.out.println("==========================");
            System.out.println("Pengeluaran: ");
            //menggunakan for each untuk mengambil setiap objek invoice dari array invoices yang kemudian disimpan ke dalam variabel invoice
            for (Payable invoice: invoices[i]) {
                System.out.println((Invoice)invoice); //menggunakan casting untuk mengubah reference dari Payable ke Invoice agar bisa memanggil method toString() yang telah dioverride pada class Invoice
            }
            System.out.println("Total Pengeluaran: Rp." + ((Employee)karyawan[i]).getPayableAmount()); //menggunakan casting untuk mengubah reference dari Payable ke Employee agar bisa memanggil method getPayableAmount() yang telah dioverride pada class Employee
            System.out.println("Gaji Akhir: Rp." + ((Employee)karyawan[i]).getGajiBersih()); //menggunakan casting untuk mengubah reference dari Payable ke Employee agar bisa memanggil method getGajiBersih() yang telah dioverride pada class Employee
            System.out.println();
        }

        //menampilkan total pengeluaran karyawan 
        //deklarasikan variabel totalPengeluaran untuk menyimpan total pengeluaran karyawan
        int totalPengeluaran = 0;
        //menggunakan for each pada dimensi pertama array invoices (karena for each hanya mengambil dimensi pertama, sedangkan nilai setiap invoice ada di dimensi kedua)
        for (Payable[] invoice : invoices) {
            //menggunakan for each pada dimensi kedua array invoices untuk mengambil setiap objek invoice dari array invoices yang kemudian disimpan ke dalam variabel item
            for (Payable item : invoice) {
                //menambahkan nilai totalPengeluaran dengan memanggil method getPayableAmount() dari reference variabel item yang bertipe Payable yang dicasting ke Invoice agar bisa memanggil method getPayableAmount() yang telah dioverride pada class Invoice
                totalPengeluaran += ((Invoice)item).getPayableAmount();
            }
        }
        System.out.println("Total Pengeluaran Karyawan: Rp." + totalPengeluaran); //print out total pengeluaran karyawan

        //menampilkan total gaji karyawan
        //deklarasikan variabel totalGajiKaryawan untuk menyimpan total gaji karyawan
        int totalGajiKaryawan = 0;
        //menggunakan for each untuk mengambil setiap objek karyawan dari array karyawan yang kemudian disimpan ke dalam variabel employee
        for (Payable employee : karyawan) {
            //menambahkan nilai totalGajiKaryawan dengan memanggil method getSalaryPerMonth() dari reference variabel employee yang bertipe Payable yang dicasting ke Employee agar bisa memanggil method getSalaryPerMonth() yang telah dioverride pada class Employee
            totalGajiKaryawan += ((Employee)employee).getSalaryPerMonth();
        }
        System.out.println("Total Gaji Karyawan: Rp." + totalGajiKaryawan); //print out total gaji karyawan

        //menampilkan total gaji bersih karyawan
        //deklarasikan variabel totalGajiBersihKaryawan untuk menyimpan total gaji bersih karyawan
        int totalGajiBersihKaryawan = 0;
        //menggunakan for each untuk mengambil setiap objek karyawan dari array karyawan yang kemudian disimpan ke dalam variabel employee
        for (Payable employee : karyawan) {
            //menambahkan nilai totalGajiBersihKaryawan dengan memanggil method getGajiBersih() dari reference variabel employee yang bertipe Payable yang dicasting ke Employee agar bisa memanggil method getGajiBersih() yang telah dioverride pada class Employee
            totalGajiBersihKaryawan += ((Employee)employee).getGajiBersih();
        }
        System.out.println("Total Gaji Bersih Karyawan: Rp." + totalGajiBersihKaryawan); //print out total gaji bersih karyawan
        
        
    }
}
