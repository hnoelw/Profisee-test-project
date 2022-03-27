public class SalesPerson {

    //class attributes
    private static int id = 1;
    private int SalesPersonID;
    private String FirstName = "";
    private String LastName = "";
    private String address = "";
    private String phone = "";       //Making the assumption that they do not include a country code
    private String startDate = "";
    private String terminationDate = "";
    private String manager = "";
    private double earnedComm = 0;
    private boolean exists = false;

    //array of Salespeople
    public static SalesPerson[] peopleArr = new SalesPerson[10];
    public static int arrCounter = 0;

    //constructors
    public SalesPerson(){
    }
    public SalesPerson(String fn, String ln, String a, String p, String sd, String td, String m){
        for(int i = 0; i<arrCounter; i++) {
            if (peopleArr[i].FirstName.equals(fn) && peopleArr[i].phone == p) {   //checks if this product already exists and throws an exception if it does
                exists = true;
            }
        }
        if(!exists) {
            exists = false;
            SalesPersonID = id++;
            FirstName = fn;
            LastName = ln;
            address = a;
            phone = p;
            startDate = sd;
            terminationDate = td;
            manager = m;
            peopleArr[arrCounter] = this;
            arrCounter++;
        }
        else{
            System.out.println("This salesperson already exists in our system.");
        }
    }

    //prints info about a salesPerson
    public void printSalesPerson(){
        System.out.println("Salesperson "+ SalesPersonID + "\n\tName: " + FirstName + " " + LastName
        + "\n\tAddress: " + address + "\n\tPhone number: " + phone + "\n\tStart date: " + startDate + "\n\tTermination date: "
        + terminationDate + "\n\tManager: " + manager + "\n\tEarned commission: $" + earnedComm);
    }

    public void earnCommission(int prodID, String salesDate){
        Product p = new Product();
        double price = p.prodArray[prodID-1].getSale_Price();
        double comm = p.prodArray[prodID-1].getCommission_Percent();

        double discountPercent = 0;
        Discount d = new Discount();
        for(int i = 0; i<d.getSize(); i++){
            if(d.discArr[i].getProdID() == prodID) {
                if (d.discArr[i].discountValid(salesDate)) {
                    if (d.discArr[i].getPercentage() > discountPercent) {
                        discountPercent = d.discArr[i].getPercentage();
                    }
                }
            }
        }
        earnedComm+=(price - (price*discountPercent))*comm;             //their commission is based off of the price after discount
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
                                                    //throw exception if no good
        this.phone = phone;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    //getters

    public String getPhone() {
        return phone;
    }

    public int getSalesPersonID() {
        return SalesPersonID;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getManager() {
        return manager;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public double getEarnedComm() {
        return earnedComm;
    }
    public int getSize(){return arrCounter;}
}