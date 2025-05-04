//class invoice yang mengimplementasikan interface Payable
public class Invoice implements Payable {
    //atribut menyesuaikan kasus
    private String productName;
    private int quantity;
    private int pricePerItem;

    //constructor untuk menginisialisasi atribut
    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    //getter dan setter untuk mengakses dan memodifikasi atribut
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getPricePerItem() {
        return pricePerItem;
    }
    public void setPricePerItem(int pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    //override method dari interface Payable untuk menghitung total tagihan
    //menghitung total tagihan dengan mengalikan quantity dan pricePerItem
    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    //override method toString untuk menampilkan informasi invoice
    //menggunakan String.format untuk format output yang lebih rapi
    @Override
    public String toString() {
        return String.format("%-20s | %-8d | Rp.%-10d | Rp.%d", 
                        productName, quantity, pricePerItem, getPayableAmount());

}
}