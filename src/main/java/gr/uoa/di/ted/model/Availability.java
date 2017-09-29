package gr.uoa.di.ted.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="availability")
public class Availability {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_from", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date_from;
	
	@Column(name="date_to", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date_to;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "about_appartment")
    private Appartment appartment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate_from() {
		return date_from;
	}

	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}

	public Date getDate_to() {
		return date_to;
	}

	public void setDate_to(Date date_to) {
		this.date_to = date_to;
	}

	public Appartment getAppartment() {
		return appartment;
	}

	public void setAppartment(Appartment appartment) {
		this.appartment = appartment;
	}
	
	
}
