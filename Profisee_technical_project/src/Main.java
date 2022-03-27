import java.util.Scanner;
public class Main {
    public static void main(String [] args){

        Product p1 = new Product("Bike", "REI", "Red", 30.5, 50, 6, 0.15);
        Product p2 = new Product("Wheel", "Schwinn", "Small", 15, 30, 10, 0.10);
        SalesPerson sp1 = new SalesPerson("Hailey", "Walker", "2800 Esquire Cir","4045551234","03/27/2022", "", "Patrick Mize");
        SalesPerson sp2 = new SalesPerson("Big", "Bird", "123 Sesame Street", "1234567890", "01/17/2006", "02/27/2006", "Elmo");
        Customer c1 = new Customer("Jake", "Jones", "345 Mockingbird Lane", "7709317456", "06/24/1999");
        Customer c2 = new Customer("Shawn", "Spencer", "6 Santa Barbara Ave", "5784125963", "10/06/2019");
        Customer c3 = new Customer("Juliet", "O'hara", "45 Psychic blvd", "3624875912", "05/12/2000");
        Sale s1 = new Sale(1, 2, 3, "04/23/2020");
        Sale s2 = new Sale(2, 1, 1, "07/22/2010");
        Discount d1 = new Discount(1, "03/30/2020", "01/01/2022", 0.12);
        Discount d2 = new Discount(2, "08/20/2010", "10/01/2010", 0.3);

        Scanner sc = new Scanner(System.in);
        Scanner scNum = new Scanner(System.in);
        int input = 0;
        do{
            System.out.println("What would you like to do?\n\t1 - Display salespersons\n\t2 - Update a salesperson\n\t3 - Display products" +
                    "\n\t4 - Update a product\n\t5 - Display customers\n\t6 - Display sales\n\t7 - Create a sale\n\t8 - Display quarterly salesperson commission report"
            +"\nEnter -1 to quit");
            input = scNum.nextInt();
            switch (input){
                case 1:                                     //display salesperson
                    for(int i = 0; i<sp1.getSize(); i++){
                        sp1.peopleArr[i].printSalesPerson();
                    }
                    break;
                case 2:                                     //update salesperson
                    System.out.print("Enter their ID number: ");
                    int id = scNum.nextInt();
                    System.out.println("What would you like to update?\n\t1 - First name\n\t2 - Last name" +
                            "\n\t3 - Address\n\t4 - Phone number\n\t5 - Start date\n\t6 - Termination date\n\t" +
                            "7 - Manager");
                    int updateInput = sc.nextInt();
                    switch (updateInput){
                        case 1:
                            System.out.println("What is the person's first name?");
                            String n = sc.next();
                            sp1.peopleArr[id-1].setFirstName(n);
                            break;
                        case 2:
                            System.out.println("What is the person's last name?");
                            String l = sc.next();
                            sp1.peopleArr[id-1].setLastName(l);
                            break;
                        case 3:
                            System.out.println("What is the person's address?");
                            String a = sc.next();
                            sp1.peopleArr[id-1].setAddress(a);
                            break;
                        case 4:
                            System.out.println("What is the person's phone number?");
                            String p = sc.next();
                            sp1.peopleArr[id-1].setPhone(p);
                            break;
                        case 5:
                            System.out.println("When did the person start working?");
                            String sd = sc.next();
                            sp1.peopleArr[id-1].setStartDate(sd);
                            break;
                        case 6:
                            System.out.println("When was the person terminated?");
                            String td = sc.next();
                            sp1.peopleArr[id-1].setTerminationDate(td);
                            break;
                        case 7:
                            System.out.println("Who is the person's manager?");
                            String m = sc.next();
                            sp1.peopleArr[id-1].setManager(m);
                            break;
                    }
                    break;
                case 3:                                             //display products
                    for(int i = 0; i< p1.getSize(); i++){
                        p1.prodArray[i].printProduct();
                    }
                    break;
                case 4:                                             //update product
                    System.out.print("Enter the product ID number: ");
                    int Pid = scNum.nextInt();
                    System.out.println("What would you like to update?\n\t1 - Name\n\t2 - Manufacturer" +
                            "\n\t3 - Style\n\t4 - Purchase price\n\t5 - Sale price\n\t6 - Quantity on hand\n\t" +
                            "7 - Commission percentage");
                    int prodInput = sc.nextInt();
                    switch (prodInput){
                        case 1:
                            System.out.println("What is the product name?");
                            String n = sc.next();
                            p1.prodArray[Pid-1].setName(n);
                            break;
                        case 2:
                            System.out.println("Who is the product's manufacturer?");
                            String m = sc.next();
                            p1.prodArray[Pid-1].setManufacturer(m);
                            break;
                        case 3:
                            System.out.println("What is the product's style?");
                            String s = sc.next();
                            p1.prodArray[Pid-1].setStyle(s);
                            break;
                        case 4:
                            System.out.println("What is the product's purchase price?");
                            double p = scNum.nextDouble();
                            p1.prodArray[Pid-1].setPurchase_Price(p);
                            break;
                        case 5:
                            System.out.println("What is the product's sale price?");
                            double sp = scNum.nextDouble();
                            p1.prodArray[Pid-1].setSale_Price(sp);
                            break;
                        case 6:
                            System.out.println("What is the product's quantity on hand?");
                            int q= scNum.nextInt();
                            p1.prodArray[Pid-1].setQty_On_Hand(q);
                            break;
                        case 7:
                            System.out.println("What is the product's commission percentage?");
                            double cp = scNum.nextDouble();
                            p1.prodArray[Pid-1].setCommission_Percent(cp);
                            break;
                    }
                    break;
                case 5:                                                         //display customers
                    for(int i = 0; i<c1.getSize(); i++){
                        c1.custArr[i].printCustomer();
                    }
                    break;
                case 6:                                                         //display sales
                    for(int i = 0; i<s1.getSize(); i++){
                        s1.saleArr[i].printSale();
                    }
                    break;
                case 7:                                                         //create new sale
                    System.out.println("What is the product ID?");
                    int i = scNum.nextInt();
                    System.out.println("What is the salesperson's ID?");
                    int s = scNum.nextInt();
                    System.out.println("What is the customer's ID?");
                    int c = scNum.nextInt();
                    System.out.println("What is the date of the sale?");
                    String d = sc.next();
                    Sale sale1 = new Sale(i, s, c, d);
                    break;
                case 8:                                                         //display commissions report
                    System.out.println(commissionReport());
                    break;
            }
        }while(input!=-1);
    }

    public static String commissionReport(){
        SalesPerson s = new SalesPerson();
        String report = "";
        for(int i = 0; i<s.arrCounter; i++){
            report+= s.peopleArr[i].getFirstName() + " " + s.peopleArr[i].getLastName() + "\n\tCommissions: $" + s.peopleArr[i].getEarnedComm() +"\n";
        }
        return report;
    }
}
