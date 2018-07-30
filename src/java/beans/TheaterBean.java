
package beans;

import ejb.TheaterEJB;
import entities.Movies;
import entities.Theater;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "theaterBean")
@RequestScoped
public class TheaterBean {

    @EJB
    private TheaterEJB theaterEJB;
    private Theater theater;
    private Movies movie;
    private String zipcode;
    List<String> zlist;//= 
    
    public String getZipcode() {
        return zipcode;
    }   
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public TheaterBean() {
    }
    public Theater getTheater() {
        return theater;
    }
    public void setTheater(Theater theater) {
        this.theater = theater;
    }  
    ////////////////////////////////////////////////////////////////////////////
    public List<String> zipcodeList(){
        List<Theater> tlist= new ArrayList<> ();
        tlist=theaterEJB.findAllTheater();
        zlist= new ArrayList<> ();
        for (Theater t: tlist){
            zlist.add(t.getZipcode());
        }
        return zlist;
    }

    public List<String> getZlist() {
        return zlist;
    }

    public void setZlist(List<String> zlist) {
        this.zlist = zlist;
    }
    
    public List<Theater> getTheaterList()
    {
        return theaterEJB.findAllTheater();
    }  
    
    public List<Theater> getShowTheaters() {
        return theaterEJB.findAllNearTheater(theater);
    }
    
      
    public String showCloseTheaters(Theater theater){
       
         this.theater=theater;
         return "ShowTheaters";
     }
    
    public String showCloseTheatersZip(){
        
        return "ShowTheaters";
    }

    
}
