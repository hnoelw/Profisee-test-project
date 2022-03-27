public class Sale {
    private static int id = 1;
    private int saleID = 1;
    private int productID = 0;
    private int salesPersonID = 0;
    private int custID = 0;
    private String salesDate = "";
    private double price = 0;

    //to access arrays of other classes
    Product p = new Product();
    SalesPerson sp = new SalesPerson();
    Customer c = new Customer();

    public static Sale[] saleArr = new Sale[10];
    public static int arrCounter = 0;

    double discountPercent = 0;
    Discount d = new Discount();

    public Sale(){}
    public Sale(int p, int s, int c, String sd){
        saleID = id++;
        productID = p;
        salesPersonID = s;
        custID = c;
        salesDate = sd;
        this.p.prodArray[productID-1].setQty_On_Hand(this.p.prodArray[productID-1].getQty_On_Hand()-1); //really long but just reduces quantity on hand by one
        this.sp.peopleArr[salesPersonID-1].earnCommission(productID, salesDate);   //updates salesperson's commissions

        for(int i = 0; i<d.getSize(); i++){
            if(d.discArr[i].getProdID() == productID && d.discArr[i].discountValid(salesDate)){
                if(d.discArr[i].getPercentage()>discountPercent){
                    discountPercent = d.discArr[i].getPercentage();
                }
            }
        }
        price = (this.p.prodArray[productID-1].getSale_Price());
        price-= (discountPercent*price);

        saleArr[arrCounter] = this;
        arrCounter++;
    }

    public void printSale(){
        System.out.println("Sale " + saleID + "\n\tSale date: " + salesDate + "\n\tProduct: " + p.prodArray[productID-1].getName() + "\n\tSalesperson: " + sp.peopleArr[salesPersonID-1].getFirstName() + " "
                + sp.peopleArr[salesPersonID-1].getLastName()+"\n\tCustomer: " + c.custArr[custID-1].getFirstName() + " " + c.custArr[custID-1].getLastName() +"\n\tPrice (including discount): " + price + "\n\tCommission:" +(p.prodArray[productID-1].getCommission_Percent()*price));
    }
    public int getSize(){return arrCounter;}

    public String getSalesDate() {
        return salesDate;
    }
}
