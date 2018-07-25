/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Invalidquantum
 */
@Entity
@Table(name = "SCREENING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Screening.findAll", query = "SELECT s FROM Screening s")
    , @NamedQuery(name = "Screening.findByScreeningid", query = "SELECT s FROM Screening s WHERE s.screeningPK.screeningid = :screeningid")
    , @NamedQuery(name = "Screening.findByTheaterid", query = "SELECT s FROM Screening s WHERE s.theaterid = :theaterid")
    , @NamedQuery(name = "Screening.findByMovieid", query = "SELECT s FROM Screening s WHERE s.screeningPK.movieid = :movieid")
    , @NamedQuery(name = "Screening.findByShowtime", query = "SELECT s FROM Screening s WHERE s.showtime = :showtime")
    , @NamedQuery(name = "Screening.findByScreen", query = "SELECT s FROM Screening s WHERE s.screen = :screen")
    , @NamedQuery(name = "Screening.findByAuditorium", query = "SELECT s FROM Screening s WHERE s.auditorium = :auditorium")})
public class Screening implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ScreeningPK screeningPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATERID")
    private int theaterid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SHOWTIME")
    private String showtime;
    @Size(max = 20)
    @Column(name = "SCREEN")
    private String screen;
    @Size(max = 25)
    @Column(name = "AUDITORIUM")
    private String auditorium;

    public Screening() {
    }

    public Screening(ScreeningPK screeningPK) {
        this.screeningPK = screeningPK;
    }

    public Screening(ScreeningPK screeningPK, int theaterid, String showtime) {
        this.screeningPK = screeningPK;
        this.theaterid = theaterid;
        this.showtime = showtime;
    }

    public Screening(int screeningid, int movieid) {
        this.screeningPK = new ScreeningPK(screeningid, movieid);
    }

    public ScreeningPK getScreeningPK() {
        return screeningPK;
    }

    public void setScreeningPK(ScreeningPK screeningPK) {
        this.screeningPK = screeningPK;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (screeningPK != null ? screeningPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Screening)) {
            return false;
        }
        Screening other = (Screening) object;
        if ((this.screeningPK == null && other.screeningPK != null) || (this.screeningPK != null && !this.screeningPK.equals(other.screeningPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Screening[ screeningPK=" + screeningPK + " ]";
    }
    
}
