public class Customer {

    //class attributes
    private static int id = 1;
    private int custID = 0;
    private String firstName ="";
    private String lastName = "";
    private String address = "";
    private String phone = ""; //assume no country code
    private String startDate = "";
    private boolean exists = false;

    //array to hold customers
    public static Customer[] custArr = new Customer[10];
    public static int arrCounter = 0;

    //constructors
    public Customer(){
    }
    public Customer(String fn, String ln, String a, String p, String d){
        for(int i = 0; i<arrCounter; i++) {
            if (custArr[i].firstName.equals(fn) && custArr[i].phone.equals(p)) {   //checks if this product already exists and throws an exception if it does
                exists = true;
            }
        }
        if(!exists) {
            exists = false;
            custID = id++;
            firstName = fn;
            lastName = ln;
            address = a;
            phone = p;
            startDate = d;
            custArr[arrCounter] = this;
            arrCounter++;
        }
        else{
            System.out.println("This customer already exists in our system");
        }
    }

    public void printCustomer(){
        System.out.println("Customer " + custID + "\n\tName: " + firstName + " " + lastName
        + "\n\tAddress: " + address + "\n\tPhone: " + phone + "\n\tStart date: " + startDate);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;                         //throw exception if no good
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    //getters

    public String getStartDate() {
        return startDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getCustID() {
        return custID;
    }

    public int getSize(){return arrCounter;}
}
