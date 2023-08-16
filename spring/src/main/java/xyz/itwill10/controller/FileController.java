package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.service.FileBoardService;

/* [순서-27] - [순서-26]까지 해도 업로드가 되지않음, 몇가지 환경설정이 필요함
 
	파일을 전달받아 서버 디렉토리에 업로드 처리하기 위한 방법
	1. commons-fileupload 라이브러리를 프로젝트 빌드 처리 - 메이븐: pom.xml
	=> [순서-28]-pom.xml - commons fileupload (MVNRESPOSITORY) 복붙 >> 주석2번
	
	2. Spring Bean Configuration File(servlet-context.xml)에 파일 업로드 처리 기능을 제공하는 클래스를 Spring Bean으로 등록
	=> [순서-29]-servlet-context.xml - beans:bean 엘리먼트 코드 작성

	3.MultipartHttpServletRequest 객체를 사용하여 [multipart/form-data] 형태로 전달된 값 또는 파일을 제공받아 처리
*/


//[순서-17] - FileController 클래스 생성
@Controller
@RequestMapping("/file")
@RequiredArgsConstructor //[순서-31]
public class FileController {
	//[순서-31] - WebApplicationContext 객체(스프링 컨테이너)를 제공받아 필드에 의존성 주입
	private final WebApplicationContext context; // - 필드에 적은 이유는 또 사용할 거기 때문
	
	//[순서-18]
	@RequestMapping(value="/upload1", method=RequestMethod.GET)
	public String uploadOne() {
		return "file/form_one"; //=> [순서-19] - file폴더 생성 >> form_one.jsp 파일 생성 
	}
	
	/* [순서-31] - [순서-20] 주석 후 새로 코드 작성 : 똑같은 이름의 파일을 업로드하면 덮어씌우기 때문에
	 	 
	  	[순서-20]
		
		요청 처리 메소드에 MultipartHttpServletRequest 인터페이스로 매개변수를 선언하면 Front Controller에게 MultipartHttpServletRequest 객체를 제공받아 사용 가능
		
		MultipartHttpServletRequest 객체 : [multipart/form-data] 형태로 전달된 값 또는 파일을 처리하기 위한 객체
	@RequestMapping(value="/upload1", method=RequestMethod.POST)
	public String uploadOne(MultipartHttpServletRequest request) throws IOException {
		/*
			전달값을 반환받아 저장
			MultipartHttpServletRequest.getParameter(String name) : 전달값을 문자열(String 객체)로 반환하는 메소드		
		
		String uploaderName=request.getParameter("uploaderName"); //전달값을 반환받아 저장, form_one.jsp에서 전달값이 uploadername이므로 이렇게 
		
		/*
			MultipartHttpServletRequest.getFile(String name) : 전달파일을 MultipartFile 객체로 반환하는 메소드
			=> MultipartFile 객체 : 사용자로부터 입력되어 전달된 파일정보를 저장하기 위한 객체
		
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		/*
			전달받은 파일에 대한 검증 작업 작성
			MultipartFile.isEmpty() : MultipartFile 객체에 저장된 파일정보가 없는 경우 [false]를 반환하고 파일정보가 있는 경우 [true]를 반환하는 메소드
		
		if(uploadFile.isEmpty()) {
			return "file/upload_fail"; //=>[순서-25] - upload_fail.jsp 파일 생성
		}
		
		//MultipartFile.getContentType() : MultipartFile 객체에 저장된 파일형태(MimeType)를 반환하는 메소드
		System.out.println("파일 형식 = "+uploadFile.getContentType());
		
		//MultipartFile.getBytes() : MultipartFile 객체에 저장된 전달파일을 원시데이타(byte 배열)로 반환하는 메소드
		System.out.println("파일 크기 = "+uploadFile.getBytes().length);
		
		//[순서-22] 
		String uploadDirectory=request.getServletContext().getRealPath("/resources/images/upload");
		System.out.println("uploadDirectory = "+uploadDirectory);
		
		/* [순서-23]
			
			전달파일을 서버 디렉토리에 저장하기 위해 파일정보가 저장된 File 객체 생성
			File 객체 : 시스템(서버)에 존재하는 파일정보를 저장하기 위한 객체
			MultipartFile.getOriginalFileName() : MultipartFile 객체에 저장된 전달파일의 이름을 반환하는 메소드
		
		String uploadFilename=uploadFile.getOriginalFilename(); //[순서-24]
		File file=new File(uploadDirectory, uploadFile.getOriginalFilename());
		
		//MultipartFile.transferTo(File file) : MultipartFile 객체에 저장된 전달파일을 File 객체의 시스템 파일(업로드 파일)로 전달하여 저장하는 메소드
		uploadFile.transferTo(file); //전달파일을 서버 디렉토리에 저장 - 업로드 처리 
		
		//[순서-24]
		request.setAttribute("uploaderName", uploaderName);
		request.setAttribute("uploadFileName", uploadFilename);
		
		return "file/upload_success";//=>[순서-26] - upload_success.jsp 파일 생성
	}
*/
	
	/* [순서-31]
	
		요청 처리 메소드의 매개변수를 사용하여 전달값 및 전달파일을 제공받아 사용 가능
		=> 전달값 및 전달파일의 이름이 같은 이름으로 매개변수 작성
		-문제점)전달파일의 이름이 서버 디렉토리에 저장된 파일의 이름과 같은 경우 전달파일로 덮어씌우기
		-해결법)전달파일의 이름을 서버 디렉터리에 없는 파일이름으로 변경하여 서버 디렉토리에 저장
	*/
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadOne(@RequestParam String uploaderName 
			, @RequestParam MultipartFile uploadFile, Model model) throws IOException { //@RequestParam어노테이션 사용해서 Strin uploaderName하면 String uploaderName메소드 삭제 가능
																						//@RequestParam어노테이션 사용해서 String uploadFile하면 MultipartFile객체 어쩌고도 삭제 가능
		//전달받은 파일에 대한 검증 작성
		if(uploadFile.isEmpty() || !uploadFile.getContentType().equals("image/jpeg")) {
			return "file/upload_fail";
		}
		
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload"); //직접 가져왔기때문에 request가 필요가 없음(@RequestParma어노테이션 사용했기때문) 
																									//근데 request가 있어야 반환받아서 가져올 수 있음
		
		/* [순서-32] 
		
			전달파일을 서버 디렉토리에 저장될 업로드 파일정보가 저장된 File 객체 생성
			=> 서버 디렉토리에 저장된 파일이름은 중복되지 않는 이름으로 사용되도록 변경
			
			UUID.randomUUID() : 36Byte의 문자열로 구현된 식별자를 생성하여 반환하는 메소드
		 */
		String uploadFilename=UUID.randomUUID()+"_"+uploadFile.getOriginalFilename();
		File file=new File(uploadDirectory, uploadFilename);
		
		//전달파일을 서버 디렉토리에 저장 - 업로드 처리
		uploadFile.transferTo(file);
		
		//문제는 request객체가 필요한데 대신에 model 객체 사용하면 됨 >> 매개변수에 @Model 작성 후 model.addAttribute어쩌고로 작성
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success_one";
	}
	
	// [순서-33] - 파일을 여러개 입력받아 업로드하는 거 해볼거임
	@RequestMapping(value="/upload2", method=RequestMethod.GET)
	public String uploadTwo() {
		return "file/form_two"; //=> [순서-34] - form_two.jsp 파일 생성 
	}
	
	/* [순서-35]
		전달파일이 여러개인 경우 매개변수를 List 인터페이스로 선언하여 전달파일이 저장된 MultipartFile 객체가 여러개 저장된 List 객체로 제공받아 처리
	*/
	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public String uploadTwo(@RequestParam String uploaderName
			, @RequestParam List<MultipartFile> uploadFileList, Model model) throws IOException {
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");

		//업로드 처리된 모든 파일의 이름을 저장하기 위한 List 객체 생성
		List<String> filanameList=new ArrayList<String>();

		for(MultipartFile multipartFile : uploadFileList) {
			if(multipartFile.isEmpty() || !multipartFile.getContentType().equals("image/jpeg")) {
				return "file/upload_fail";
			}

			String uploadFilename=UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
			File file=new File(uploadDirectory, uploadFilename);

			//전달파일을 서버 디렉토리에 저장 - 업로드 처리
			multipartFile.transferTo(file);

			//List 객체에 업로드 처리된 파일 이름을 추가하여 저장
			filanameList.add(uploadFilename);
		}

		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("filanameList", filanameList);		

		return "file/upload_success_two";
	}
	
	//[순서-45]
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String fileBoardWrite() {
		return "file/board_write"; //=> [순서-46] - board_write.jsp 파일 생성 및 코드 작성
	}
	
	//[순서-47] 
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String fileBoardWrite(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		if(fileBoard.getMultipartFile().isEmpty()) {
			return "file/board_write";//=>- board_write.jsp >> ${fileBoard.write}...
		}
		
		/*
			전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
			=> 다운로드 프로그램에서만 파일에 접근 가능하도록 /WEB-INF 폴더에 업로드 폴더 생성
		*/
		String uploadDirectory=context.getServletContext().getRealPath("/WEB-INF/upload");
		
		//사용자로부터 입력받아 전달받은 파일의 이름을 반환받아 Command 객체의 필드값 변경
		String origin=fileBoard.getMultipartFile().getOriginalFilename();
		fileBoard.setOrigin(origin);
		
		/*
			서버 디렉토리에 업로드 처리되어 저장된 파일의 이름을 반환받아 Command 객체의 필드값 변경
			=> 서버 디렉토리에 저장된 파일 이름은 중복되지 않도록 고유값 사용
			=> 중복되지 않는 고유값으로 시스템의 현재 날짜와 시간에 대한 정수값(TimeStamp)을 사용
		 */
		String upload=System.currentTimeMillis()+"";
		fileBoard.setUpload(upload);
		
		//파일 업로드 처리
		fileBoard.getMultipartFile().transferTo(new File(uploadDirectory, upload));
		
		//FILEBOARD 테이블에 행 삽입
		FileBoardService.addFileBoard(fileBoard);
		
		return "redirect:/file/list"; 
	}
	
	/*[순서-50] 
	@RequestMapping("/list")
	public String fileBoardList(Model model) {
		model.addAttribute("fileBoardList", FileBoardService.getFileBoardList());
		return "file/board_list"; //=> board_list.jsp 파일 생성 및 코드 작성
	}
	*/
	
	@RequestMapping("/list")
	public String fileBoardList(@RequestParam(defaultValue = "1") int pageNum, Model model) {
		//System.out.println("pageNum = "+pageNum);
		
		Map<String, Object> map=fileBoardService.getFileBoardList(pageNum);
		
		model.addAttribute("pager", map.get("pager"));
		model.addAttribute("fileBoardList", map.get("fileBoardList"));
		
		return "file/board_list";
	}
	
	@RequestMapping("/delete")
	public String fileBoardDelete(@RequestParam int idx) {
		FileBoard fileBoard=FileBoardService.getFileBoard(idx);
		String uploadDirectory=context.getServletContext().getRealPath("/WEB-INF/upload");
		//서버 디렉토리에 저장된 업로드 파일을 삭제 처리
		new File(uploadDirectory, fileBoard.getUpload()).delete();
		fileBoardService.removeFileBoard(idx);
		return "redirect:/file/list";
	}
	
	
	/* [순서-51]

		다운로드(Download) : 서버 디렉토리에 존재하는 파일을 클라이언트에게 전달하여 저장하는 기능
		요청 처리 메소드에 의해 반환되는 문자열(ViewName)로 다운로드 프로그램을 실행하여 서버 디렉토리에 저장된 파일을 클라이언트에게 전달하여 저장되도록 응답 처리
		=> BeanNameViewResolver 객체를 사용하여 반환되는 문자열(ViewName)로 특정 프로그램 실행하여 응답 처리
		=> Spring Bean Configuration File(servlet-context.xml)에 BeanNameViewResolver 클래스를 Spring Bean으로 등록
		=> 현재 사용중인 ViewResolver 객체(JSP 문서로 응답 처리)보다 먼저 실행될 수 있도록 우선순위를 설정
	*/
	@RequestMapping("/download")
	public String fileBoardDownload(@RequestParam int idx, Model model) {
		//[순서-53]
		FileBoard fileBoard=FileBoardService.getFileBoard(idx);
		
		//Model 객체를 이용하여 실행될 프로그램(Spring Bean)에서 사용될 객체를 속성값으로 저장하여 제공
		model.addAttribute("uploadDirectory", context.getServletContext().getRealPath("/WEB-INF/upload"));
		model.addAttribute("originalFilename", fileBoard.getOrigin());
		model.addAttribute("uploadFilename", fileBoard.getUpload());
		
		/*
			실행될 프로그램(Spring Bean)의 식별자(beanName) 반환
			=> 실행될 프로그램에 대한 클래스를 작성하여 Spring Bean Configuration File
			
			(servlet-context.xml)에 Spring Bean으로 등록 - 어노테이션 사용 가능
		*/
		return "fileDownload";
	}
}
