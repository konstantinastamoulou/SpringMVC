package gr.uoa.di.ted.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="file_upload")
public class FileUpload {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name="file_name", nullable=false)
    private String filename;
	
	@Lob 
	@Basic(fetch = FetchType.LAZY)
	@NotEmpty
	@Column(name="file_data", nullable=false)
    private byte[] data;
	
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="entity_id")
	private int entity_id;

	@Column(name="mime_type", nullable=false)
	private String mime_type;
	
	@Column(name="entity_type", nullable=false)
	private String entity_type;
	
	public String getMime_type() {
		return mime_type;
	}

	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}

	public int getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(int entity_id) {
		this.entity_id = entity_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntity_type() {
		return entity_type;
	}

	public void setEntity_type(String entity_type) {
		this.entity_type = entity_type;
	}
	
	

}
