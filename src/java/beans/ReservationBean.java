/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.TheaterEJB;
import entities.Reservation;
import entities.Screening;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author 
 */
@Named(value = "reservationBean")
@SessionScoped
public class ReservationBean implements Serializable{

    @EJB
    private TheaterEJB theaterEJB;

    
    private Screening screening;
    private Reservation reservation= new Reservation();
    private int numberSeats;

    private String expiryMonth;
    private String expiryYear;
    private String securityCode;
    private String result;
    

    
    public String showReservationPage(Screening screening){
        this.screening=screening;
        return "ShowReservationPage";
    }
    
    public String addPurchase(){
        Date date= new Date();

        
reservation.setPurchasetimedate(new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(date));
    theaterEJB.persist(reservation);
    result= "Transaction approved"+" for "+numberSeats+" seats."+"Your total was $"+numberSeats*10+ ". "+" Current time: "+reservation.getPurchasetimedate()
            +" Thank you "+reservation.getCustomerfname()+" "+reservation.getCustomerlname()+" for your business!";
    return "Confirmation";
        
    }


    public String getResult(){
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TheaterEJB getTheaterEJB() {
        return theaterEJB;
    }

    public void setTheaterEJB(TheaterEJB theaterEJB) {
        this.theaterEJB = theaterEJB;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

   public int getNumberSeats() {
       return numberSeats;
   }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    
   
    public ReservationBean() {
    }
    
}
