import javax.naming.SizeLimitExceededException;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Discount{

    private static int id = 1;
    private int discountID = 0;
    private int prodID = 0;
    private String startDate = "";
    private String endDate = "";
    private double percentage = 0;  //in decimal form
    public boolean isValidToday = false;

    //getting today's date and converting to a string
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    Date today = Calendar.getInstance().getTime();
    String todayDate = df.format(today);

    //array of discounts
    public static Discount[] discArr = new Discount[10];
    public static int arrCounter = 0;

    //constructors
    public Discount(){
    }
    public Discount(int pID, String sd, String ed, double p){
        discountID = id++;
        prodID = pID;
        startDate = sd;
        endDate = ed;
        percentage = p;
        isValidToday = this.discountValid(todayDate);
        discArr[arrCounter] = this;
        arrCounter++;
    }
    public boolean discountValid(String todayDate){       //every date is MM/DD/YYYY
        if(startDate.equals("") || endDate.equals("")){                 //checks that it is not an empty string
            return false;
        }
        Integer startYear = Integer.valueOf(startDate.substring(6,10));
        Integer startMonth = Integer.valueOf(startDate.substring(0,2));
        Integer startDay = Integer.valueOf(startDate.substring(3, 5));
        Integer endYear = Integer.valueOf(endDate.substring(6,10));
        Integer endMonth = Integer.valueOf(endDate.substring(0,2));
        Integer endDay = Integer.valueOf(endDate.substring(3, 5));
        Integer todayYear = Integer.valueOf(todayDate.substring(6,10));
        Integer todayMonth = Integer.valueOf(todayDate.substring(0,2));
        Integer todayDay = Integer.valueOf(todayDate.substring(3, 5));
        if(startYear>todayYear){
            return false;
        }
        else if(endYear<todayYear){
            return false;
        }
        else if(startYear == todayYear){
            if(startMonth >todayMonth){
                return false;
            }
            else if(startMonth == todayMonth){
                if(startDay>todayDay){
                    return false;
                }
                else{
                    if(endYear>todayYear){
                        return true;
                    }
                    else if (endYear == todayYear){
                        if(endMonth<todayMonth){
                            return false;
                        }
                        else{
                            if(endMonth == todayMonth){
                                if(endDay<todayDay){
                                    return false;
                                }
                                else{
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    //setters

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    //getters
    public String getStartDate() {
        return startDate;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getDiscountID() {
        return discountID;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getProdID() {
        return prodID;
    }

    public int getSize(){return arrCounter;}
}
