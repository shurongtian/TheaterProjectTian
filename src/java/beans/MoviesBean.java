/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author 
 */
import ejb.TheaterEJB;
import entities.Movies;
import entities.Screening;
import entities.Theater;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 
 */
@Named(value = "moviesBean")
@SessionScoped
public class MoviesBean implements Serializable {

    @EJB
    private TheaterEJB theaterEJB;
    private Theater theater;
    private Movies movie;
    private Screening screening;

    public MoviesBean() {

    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {

        this.theater = theater;
    }

    ////////////////////////////////////////////////////////////////////////////
    public String showMovies(Theater theat) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        int theaterid=theat.getTheaterid();
        theater = theaterEJB.findTheaterById(theaterid);
        return "ShowMovies";
    }

    public List<Movies> getMoviesList() {
            System.out.println(theater.getTheatername());
        int theaterid = theater.getTheaterid();
        return theaterEJB.findMoviesByTheater(theaterid);
    }

    public String showScreenings(Movies movie) {
        this.movie = movie;
        return "ShowScreenings";
    }

    public List<Screening> getShowScreeningInfo() {
        int movieid = movie.getMovieid();
        int theaterid = theater.getTheaterid();
        return theaterEJB.findScreenings(movieid, theaterid);

    }

}
