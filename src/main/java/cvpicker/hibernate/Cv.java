/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvpicker.hibernate;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c"),
    @NamedQuery(name = "Cv.findById", query = "SELECT c FROM Cv c WHERE c.id = :id"),
    @NamedQuery(name = "Cv.findByTitle", query = "SELECT c FROM Cv c WHERE c.title = :title"),
    @NamedQuery(name = "Cv.findByDescription", query = "SELECT c FROM Cv c WHERE c.description = :description"),
    @NamedQuery(name = "Cv.findByTemplate", query = "SELECT c FROM Cv c WHERE c.template = :template")})
public class Cv implements Serializable {
    @Column(name = "views")
    private int views;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "template")
    private String template;

    public Cv() {
    }

    public Cv(Integer id) {
	this.id = id;
    }

    public Cv(Integer id, String template) {
	this.id = id;
	this.template = template;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getTemplate() {
	return template;
    }

    public void setTemplate(String template) {
	this.template = template;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (id != null ? id.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Cv)) {
	    return false;
	}
	Cv other = (Cv) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "cvpicker.hibernate.Cv[ id=" + id + " ]";
    }

    public int getViews() {
	return views;
    }

    public void setViews(int views) {
	this.views = views;
    }
}
