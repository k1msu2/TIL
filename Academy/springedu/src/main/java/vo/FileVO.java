package vo;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private String name;
	// 전송된 multipart된 데이터가 자동으로 저장됨(uploadFile로 쿼리전송되었을 경우)
	private MultipartFile uploadFile;
	// 여러파일을 전송받을 경우에는 배열로 만들어서 쓰면 된다. 
	private MultipartFile[] uploadFile2;

	public MultipartFile getUploadFile() {		
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public MultipartFile[] getUploadFile2() {
		return uploadFile2;
	}
	public void setUploadFile2(MultipartFile[] uploadFile2) {
		this.uploadFile2 = uploadFile2;
	}
}
