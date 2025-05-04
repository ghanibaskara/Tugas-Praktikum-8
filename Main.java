public class Main {
    
    public static void main(String[] args) {
        Invoice[] invoicesKaryawan1 = {
            new Invoice("Beras", 2, 75000),
            new Invoice("Gula", 3, 15000),
            new Invoice("Minyak Goreng", 1, 30000)
        };

        Invoice[] invoicesKaryawan2 = {
            new Invoice("Tepung", 2, 12000),
            new Invoice("Telur", 2, 30000),
            new Invoice("Sabun", 3, 5000),
            new Invoice("Susu", 5, 10000)
        };
        
        Employee karyawan1 = new Employee(12345, "John Doe", 300000, invoicesKaryawan1);
        Employee karyawan2 = new Employee(67890, "Dewi Lestari", 450000, invoicesKaryawan2);

        
        Payable[] karyawan = {karyawan1, karyawan2};
        Payable[][] invoices = {karyawan1.getInvoices(), karyawan2.getInvoices()};

        for (int i = 0; i < karyawan.length; i++) {
            System.out.println("Karyawan " + (i+1) + ": ");
            System.out.println(karyawan[i]);
            System.out.println("==========================");
            System.out.println("Pengeluaran: ");
            for (Payable invoice: invoices[i]) {
                System.out.println((Invoice)invoice); 
            }
            System.out.println("Total Pengeluaran: Rp." + ((Employee)karyawan[i]).getPayableAmount());
            System.out.println("Gaji Akhir: Rp." + ((Employee)karyawan[i]).getGajiBersih());
            System.out.println();
        }

        int totalPengeluaran = 0;
        for (Payable[] invoice : invoices) {
            for (Payable item : invoice) {
                totalPengeluaran += ((Invoice)item).getPayableAmount();
            }
        }
        System.out.println("Total Pengeluaran Karyawan: Rp." + totalPengeluaran);

        int totalGajiKaryawan = 0;
        for (Payable employee : karyawan) {
            totalGajiKaryawan += ((Employee)employee).getSalaryPerMonth();
        }
        System.out.println("Total Gaji Karyawan: Rp." + totalGajiKaryawan);

        int totalGajiBersihKaryawan = 0;
        for (Payable employee : karyawan) {
            totalGajiBersihKaryawan += ((Employee)employee).getGajiBersih();
        }
        System.out.println("Total Gaji Bersih Karyawan: Rp." + totalGajiBersihKaryawan);
        
        
    }
}
