package gr.uoa.di.ted.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="appartment")
public class Appartment {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="latitude", nullable=false)
	private double latitude;
	
	@Column(name="longitude", nullable=false)
	private double longitude;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owned_by_user")
    private User owner;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="access_through_pt", nullable=false)
	private String access_through_pt;
	
	@Column(name="max_no_renters", nullable=false)
	private int max_no_renters;
	
	@Column(name="base_rate", nullable=false)
	private double base_rate;
	
	@Column(name="base_rate_no_renters", nullable=false)
	private int base_rate_no_renters;
	
	@Column(name="extra_cost_per_renter", nullable=false)
	private double extra_cost_per_renter;
	
	@Column(name="general_rules", nullable=false)
	private String general_rules;
	
	@Column(name="no_beds", nullable=false)
	private int no_beds;
	
	@Column(name="no_baths", nullable=false)
	private int no_baths;
	
	@Column(name="no_bedrooms", nullable=false)
	private int no_bedrooms;
	
	@Column(name="living_room", nullable=false)
	private boolean living_room;
	
	@Column(name="size", nullable=false)
	private double size;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccess_through_pt() {
		return access_through_pt;
	}

	public void setAccess_through_pt(String access_through_pt) {
		this.access_through_pt = access_through_pt;
	}

	public int getMax_no_renters() {
		return max_no_renters;
	}

	public void setMax_no_renters(int max_no_renters) {
		this.max_no_renters = max_no_renters;
	}

	public double getBase_rate() {
		return base_rate;
	}

	public void setBase_rate(double base_rate) {
		this.base_rate = base_rate;
	}

	public int getBase_rate_no_renters() {
		return base_rate_no_renters;
	}

	public void setBase_rate_no_renters(int base_rate_no_renters) {
		this.base_rate_no_renters = base_rate_no_renters;
	}

	public double getExtra_cost_per_renter() {
		return extra_cost_per_renter;
	}

	public void setExtra_cost_per_renter(double extra_cost_per_renter) {
		this.extra_cost_per_renter = extra_cost_per_renter;
	}

	public String getGeneral_rules() {
		return general_rules;
	}

	public void setGeneral_rules(String general_rules) {
		this.general_rules = general_rules;
	}

	public int getNo_beds() {
		return no_beds;
	}

	public void setNo_beds(int no_beds) {
		this.no_beds = no_beds;
	}

	public int getNo_baths() {
		return no_baths;
	}

	public void setNo_baths(int no_baths) {
		this.no_baths = no_baths;
	}

	public int getNo_bedrooms() {
		return no_bedrooms;
	}

	public void setNo_bedrooms(int no_bedrooms) {
		this.no_bedrooms = no_bedrooms;
	}

	public boolean isLiving_room() {
		return living_room;
	}

	public void setLiving_room(boolean living_room) {
		this.living_room = living_room;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}
	
	

}
