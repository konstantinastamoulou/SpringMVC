package gr.uoa.di.ted.dao;

import java.util.List;

import gr.uoa.di.ted.model.FileUpload;

public interface FileUploadDao {

	FileUpload findById(int id);
	
	List<FileUpload> findByEntityId(int id);
	
	void save(FileUpload fu);
	
	void deleteById(int id);

}
