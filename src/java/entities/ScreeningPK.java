/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Invalidquantum
 */
@Embeddable
public class ScreeningPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SCREENINGID")
    private int screeningid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private int movieid;

    public ScreeningPK() {
    }

    public ScreeningPK(int screeningid, int movieid) {
        this.screeningid = screeningid;
        this.movieid = movieid;
    }

    public int getScreeningid() {
        return screeningid;
    }

    public void setScreeningid(int screeningid) {
        this.screeningid = screeningid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) screeningid;
        hash += (int) movieid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScreeningPK)) {
            return false;
        }
        ScreeningPK other = (ScreeningPK) object;
        if (this.screeningid != other.screeningid) {
            return false;
        }
        if (this.movieid != other.movieid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ScreeningPK[ screeningid=" + screeningid + ", movieid=" + movieid + " ]";
    }
    
}
