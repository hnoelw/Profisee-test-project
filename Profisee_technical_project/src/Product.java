public class Product {

    //class attributes
    private static int id = 1;
    private int Product_ID;
    private String name = "";
    private String manufacturer = "";
    private String style = "";
    private double purchase_Price = 0;
    private double sale_Price = 0;
    private int qty_On_Hand = 0;
    private double commission_Percent = 0;  //should be entered as a decimal
    private boolean exists = false;

    //array to hold products
    public static Product[] prodArray = new Product[10];          //small for the purposes of this sample but we could do an arraylist or other data structure for the real thing
    public static int arrCounter = 0;

    //constructors
    public Product(){
        Product_ID = 0;
        name = "";
        manufacturer = "";
        style = "";
        this.setPurchase_Price(0);
        this.setSale_Price(0);
        this.setQty_On_Hand(0);
        this.setCommission_Percent(0);
    }

    public Product(String n, String m, String s, double pp, double sp, int q, double cp){
        for(int i = 0; i<arrCounter; i++) {
            if (prodArray[i].name.equals(n) && prodArray[i].manufacturer.equals(m) && prodArray[i].style.equals(s)) {   //checks if this product already exists
                exists = true;
            }
        }
        if(!exists) {
            exists = false;
            Product_ID = id++;
            name = n;
            manufacturer = m;
            style = s;
            this.setPurchase_Price(pp);
            this.setSale_Price(sp);
            this.setQty_On_Hand(q);
            this.setCommission_Percent(cp);
            prodArray[arrCounter] = this;
            arrCounter++;
        }
        else{
            System.out.println("That product already exists in our system.");
        }
    }

    //prints all info about a product
    public void printProduct(){
        System.out.println("Product "+ Product_ID + "\n\tName: "+name + "\n\tManufacturer: " + manufacturer
        + "\n\tStyle: " + style + "\n\tPurchase price: $" + purchase_Price + "\n\tSale price: $" + sale_Price
        + "\n\tQuantity on hand: " + qty_On_Hand + "\n\tCommission percentage: " + (100*commission_Percent) + "%");
        //insert whether or not there is a current discount
    }

    //setters
    public void setName(String n){
        name = n;
    }
    public void setManufacturer(String m){
        manufacturer = m;
    }
    public void setStyle(String s){
        style = s;
    }
    public void setPurchase_Price(double p){
        if(p>=0){
            purchase_Price = p;
        }
        else{
            System.out.println("Purchase price was not set to your value because it was invalid. Please try again.");   //throw exception instead
        }
    }
    public void setSale_Price(double p){
        if(p>=0){
            sale_Price = p;
        }
        else{
            System.out.println("Sale price was not set to your value because it was invalid. Please try again.");       //throw exception instead
        }
    }
    public void setQty_On_Hand(int q){
        if(q>=0){
            qty_On_Hand = q;
        }
        else{
            System.out.println("Quantity on hand was not set to your value because it was invalid. Please try again."); //throw exception instead
        }
    }
    public void setCommission_Percent(double c){
        if(c>=0){
            if(c>1){
                commission_Percent = c*100;
            }
            else {
                commission_Percent = c;
            }
        }
        else{
            System.out.println("Commission percentage was not set to your value because it was invalid. Please try again.");//throw exception instead
        }
    }

    //getters
    public int getProduct_ID() {
        return Product_ID;
    }

    public double getCommission_Percent() {
        return commission_Percent;
    }

    public double getPurchase_Price() {
        return purchase_Price;
    }

    public double getSale_Price() {
        return sale_Price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getQty_On_Hand() {
        return qty_On_Hand;
    }

    public String getStyle() {
        return style;
    }
    public int getSize(){return arrCounter;}
}
