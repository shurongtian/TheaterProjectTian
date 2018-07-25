
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
        //this.theater = theater;
        return theaterEJB.findAllNearTheater(theater);
    }
    
      
    public String showCloseTheaters(Theater theater){
       
         this.theater=theater;
         return "ShowTheaters";
     }
    
    public String showCloseTheatersZip(){
        
        return "ShowTheaters";
    }

  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//          public String showMovies(Theater theater){
//         FacesContext fc = FacesContext.getCurrentInstance();
//      Map<String,String> params = 
//        fc.getExternalContext().getRequestParameterMap();
//      
//      int theaterid = Integer.parseInt(params.get("theaterid")); 
//      theater = theaterEJB.findTheaterById(theaterid);
//         return "ShowMovies";
//     }
//       public String showCloseMovies(Theater t){
//      FacesContext fc = FacesContext.getCurrentInstance();
//      Map<String,String> params = 
//        fc.getExternalContext().getRequestParameterMap();
//      String theaterId=  params.get("theater_id"); 
//      for(int i=0;i<50;i++){
//          System.out.println(theaterId);
//      }
////      theater= TheaterEJB.getMyTheater(theaterId);
//       
//         return "ShowMovies";
//     }
//      public List<Movies> getMovieList()
//    {
//  
//      
//        return theaterEJB.findAllMovies();
//    }
        
 

    
}
