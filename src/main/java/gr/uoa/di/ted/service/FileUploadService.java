package gr.uoa.di.ted.service;

import java.util.List;

import gr.uoa.di.ted.model.FileUpload;

public interface FileUploadService{

	FileUpload findById(int id);
	List<FileUpload> findByEntityIdAndEntityType(int id, String type);
	void deleteById(int id);
	void saveFileUpload(FileUpload fileUpload);
}
