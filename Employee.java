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

    @Override
    public int getPayableAmount() {
        int totalInvoiceAmount = 0;
        for (Invoice invoice : invoices) {
            totalInvoiceAmount += invoice.getPayableAmount();
        }
        return totalInvoiceAmount;
    }

    public int getGajiBersih() {
        return salaryPerMonth - getPayableAmount();
    }
   

    @Override
    public String toString() {
        return String.format("Nama Karyawan: %s\n" +
                "No. Registrasi: %d\n" +
                "Gaji Per Bulan: Rp.%d",
                name, registrationNumber, salaryPerMonth);

    

    }
}
