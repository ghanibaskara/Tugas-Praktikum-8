//class employee yang mengimplementasikan interface Payable
public class Employee implements Payable {
    //atribut menyesuaikan kasus
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    //constructor untuk menginisialisasi atribut
    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    //getter dan setter untuk mengakses dan memodifikasi atribut
    public int getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }
    public void setSalaryPerMonth(int salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }
    public Invoice[] getInvoices() {
        return invoices;
    }
    public void setInvoices(Invoice[] invoices) {
        this.invoices = invoices;
    }

    //override method dari interface Payable untuk menghitung total tagihan yang harus dibayar karyawan
    @Override
    public int getPayableAmount() {
        int totalInvoiceAmount = 0;
        for (Invoice invoice : invoices) { //iterasi menggunakan for each untuk setiap array invoice untuk mengambil setiap objek pada arrat invoices yang kemudian disimpan ke dalam variabel invoice
            //menghitung total tagihan dengan memanggil method getPayableAmount dari class Invoice yang akan ditambahkan ke variabel totalInvoiceAmount
            totalInvoiceAmount += invoice.getPayableAmount();
        }
        return totalInvoiceAmount;
    }

    //method untuk menghitung gaji bersih karyawan setelah dikurangi total tagihan 
    public int getGajiBersih() {
        //menghitung gaji bersih dengan mengurangi gaji per bulan dengan total tagihan yang harus dibayar
        return salaryPerMonth - getPayableAmount();
    }
   
    //override method toString untuk menampilkan informasi karyawan
    //menggunakan String.format untuk format output yang lebih rapi
    @Override
    public String toString() {
        return String.format("Nama Karyawan: %s\n" +
                "No. Registrasi: %d\n" +
                "Gaji Per Bulan: Rp.%d",
                name, registrationNumber, salaryPerMonth);

    

    }
}
