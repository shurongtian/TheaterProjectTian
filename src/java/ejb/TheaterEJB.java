package ejb;

import entities.Movies;
import entities.Screening;
import entities.Theater;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class TheaterEJB  {

    @PersistenceContext(unitName = "TheaterProjectV1PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Theater> findAllTheater() {
      return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
    }

    public List<Theater> findAllNearTheater(Theater theater) {
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
    }

    public Theater findTheaterById(int theaterid) {
                return em.createNamedQuery("Theater.findByTheaterid", Theater.class)
                .setParameter("theaterid", theaterid)
                .getSingleResult();     
    }
        public List<Movies> findMoviesByTheater(int theaterid) {
        return em.createNamedQuery("Theater.findAllMovies", Movies.class)
                .setParameter("theaterid", theaterid)
                .getResultList();
    }

    public List<Screening> findScreenings(int movieid, int theaterid) {
       return em.createNamedQuery("Movies.findScreenings", Screening.class)
                .setParameter("movieid", movieid)
               .setParameter("theaterid",theaterid)
                .getResultList();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Theater findTheaterByZip(String zipcode) {
        return em.createNamedQuery(zipcode, Theater.class).setParameter("zipcode", zipcode).getSingleResult();
    }

}