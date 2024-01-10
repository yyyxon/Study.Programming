package kr.co.sist.controller.day1204;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class FileUploadController {
	
	@GetMapping("/day1204/file_upload_frm.do")
	public String uploadFrm() {
		return "day1204/upload_frm";
	}
	
	@PostMapping("/day1204/upload_process.do")
	public String uploadProcess(HttpServletRequest request, Model model) {
		File saveDir = new File("E:/dev/workspace-spring/mvc_prj/src/main/webapp/upload");
		int maxSize = 1024*1024*30; //최대 파일 업로드 사이즈는 10Mbyte
		
		try {
			//파일 업로드 수행
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), 
					maxSize, "UTF-8", new DefaultFileRenamePolicy());
			File chkFile = new File(saveDir.getAbsoluteFile() + "/" + mr.getFilesystemName("file"));
			model.addAttribute("fileResultFlag", true);
			model.addAttribute("fileName", mr.getOriginalFileName("file"));
			model.addAttribute("uploader", mr.getParameter("uploader"));
			model.addAttribute("fileSize", chkFile.length());
			
			if(chkFile.length() > (1024*1024*10)) {
				model.addAttribute("fileResultFlag", false);
				chkFile.delete(); //사이즈 초과시 파일 삭제
			}//end if
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "day1204/upload_process";
	}
	
}
