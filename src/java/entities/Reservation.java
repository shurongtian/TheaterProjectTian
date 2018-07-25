/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Invalidquantum
 */
@Entity
@Table(name = "RESERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findByReservationid", query = "SELECT r FROM Reservation r WHERE r.reservationid = :reservationid")
    , @NamedQuery(name = "Reservation.findByCustomerfname", query = "SELECT r FROM Reservation r WHERE r.customerfname = :customerfname")
    , @NamedQuery(name = "Reservation.findByCustomerlname", query = "SELECT r FROM Reservation r WHERE r.customerlname = :customerlname")
    , @NamedQuery(name = "Reservation.findByCustomeremail", query = "SELECT r FROM Reservation r WHERE r.customeremail = :customeremail")
    , @NamedQuery(name = "Reservation.findByPurchasetimedate", query = "SELECT r FROM Reservation r WHERE r.purchasetimedate = :purchasetimedate")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RESERVATIONID")
    private Integer reservationid;
    @Size(max = 25)
    @Column(name = "CUSTOMERFNAME")
    private String customerfname;
    @Size(max = 25)
    @Column(name = "CUSTOMERLNAME")
    private String customerlname;
    @Size(max = 50)
    @Column(name = "CUSTOMEREMAIL")
    private String customeremail;
    @Size(max = 50)
    @Column(name = "PURCHASETIMEDATE")
    private String purchasetimedate;

    public Reservation() {
    }

    public Reservation(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public Integer getReservationid() {
        return reservationid;
    }

    public void setReservationid(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public String getCustomerfname() {
        return customerfname;
    }

    public void setCustomerfname(String customerfname) {
        this.customerfname = customerfname;
    }

    public String getCustomerlname() {
        return customerlname;
    }

    public void setCustomerlname(String customerlname) {
        this.customerlname = customerlname;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getPurchasetimedate() {
        return purchasetimedate;
    }

    public void setPurchasetimedate(String purchasetimedate) {
        this.purchasetimedate = purchasetimedate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationid != null ? reservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationid == null && other.reservationid != null) || (this.reservationid != null && !this.reservationid.equals(other.reservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservation[ reservationid=" + reservationid + " ]";
    }
    
}
