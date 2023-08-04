package xyz.itwill10.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill10.dto.Member;

//[순서-20] - JoinController 클래스 생성

@Controller
public class JoinController {
	//회원정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join_form"; //=>[순서-21] - join_form.jsp 파일 생성
	}
	
	/* [순서-22]
	  
		전달값(회원정보)을 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
		=> 전달값과 같은 이름의 매개변수를 선언하여 전달값을 제공받아 요청 처리 메소드에서 사용 
		=> 매개변수에 @RequestParam 어노테이션을 사용하여 전달값의 이름과 매개변수의 이름이 다른 경우 400 에러코드 발생되도록 작성
	
	(join(매개변수) 매개변수와 join_form.jsp의 전달값의 이름은 똑같이 씀(Param사용) => Request Scope 속성값으로 저장할 건데 Model을 사용하면 됨.) 
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "join_display";
	}
	*/
	
	/* [순서-24] - RequestParam이라는 어노테이션 대신에 ModelAttribute 어노테이션 사용 시 모델값을 전달값으로 사용하지 않아도 됨
 
		전달값(회원정보)을 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
		=> 전달값과 같은 이름의 매개변수를 선언하여 전달값을 제공받아 요청 처리 메소드에서 사용
		=> 매개변수에 @RequestParam 어노테이션 대신 @ModelAttribute 어노테이션 사용 가능
		
		@ModelAttribute : 객체(값)을 뷰에게 제공하기 위한 어노테이션
		=> @ModelAttribute 어노테이션을 메소드에 사용하면 메소드의 반환값을 요청 처리 클래스의 모든 요청 처리 메소드의 뷰에게 제공
		=> @ModelAttribute 어노테이션을 매개변수에 사용하면 매개변수에 저장된 값을 현재 요청 처리 메소드의 뷰에게 제공 
		  - Model 객체를 사용하지 않고 뷰에게 필요한 객체(값)을 속성값으로 제공 
		
		value 속성 : 뷰에서 속성값을 사용하기 위한 속성명을 속성값으로 설정
		=> 다른 속성이 없는 경우 속성값만 설정 가능
		
		@RequestMapping(value = "/join", method = RequestMethod.POST)
		public String join(@ModelAttribute(value="id") String id, @ModelAttribute("passwd") String passwd
				, @ModelAttribute("name") String name, @ModelAttribute("email") String email) {
			return "join_display";
	}
	*/
	
	/* [순서-27] - JoinController 클래스의 [순서-24] 주석 처리 후 메소드 및 코드 Member 객체(10패키지) 
	(join() 괄호 안에 값을 저장하는 패키지 하나 만들어 볼게유~ =>[xyz.itwill10.dto])
		
		전달값(회원정보)을 제공받아 VO 클래스의 객체 필드값으로 저장하여 Request Scope 속성값으로 저장하고 속성값을 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		
		//VO(DTO) 클래스로 객체 생성하여 매개변수에 저장된 전달값으로 필드값 변경
		Member member=new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);
		
		//model.addAttribute("member", member);
		
		
			Model.addAttribute(Object attributeValue) : 객체를 속성값을 저장하여 뷰에게 제공하는 메소드 - Request Scope
			=> 매개변수에 속성값을 사용할 수 있는 속성명을 전달하지 않으면 속성값으로 저장되는 객체의 자료형(클래스)의 이름을 속성명으로 사용 
		  	- 첫문자는 소문자로 변환되어 사용
			=> 속성값이 원시값(Wrapper 객체) 또는 문자열(String 객체)는 반드시 속성명을 설정
		
		model.addAttribute(member);
		
		return "join_display";
	}
		*/
	
	/* [순서-29] - 따로 dto 클래스 객체와 model 객체 필요없이 만드는 방법

		요청 처리 메소드에 VO(STO) 클래스로 매개변수를 작성하면 Front Controller는 VO(DTO)클래스로 객체를 생성하여 매개변수에 저장되도록 저장
		=> 페이지 요청시 전달값과 같은 이름의 필드에 전달값을 제공받아 저장하여 매개변수에 메소드의 뷰에세 사용될 수 있도록 제공

		Command 객체 : 전달값을 제공받아 필드에 저장된 객체로 속성값으로 저장되어 요청 처리 메소드의 뷰에서 사용될 수 있도록 제공
		=> Command 객체를 저장하기 위한 매개변수에 @ModelAttribute 어노테이션 사용
		=> @ModelAttribute 어노테이션을 생략해도 자동으로 @ModelAttribute 어노테이션이 설정된 것과 동일하게 처리됨
		=>  @ModelAttribute 어노테이션의 value 속성을 생략하면 Command 객체의 자료형(클래스)을 속성명으로 자동 설정 - 첫문자는 소문자로 변환
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute Member member) { //전달값들을 한꺼번에 Member 객체의 필드값으로 객체로 저장
		return "join_display";
	}
	 */
	
	/* [순서-31]
	 
		@ModelAttribute 어노테이션의 value 속성을 사용하여 뷰에게 제공될 속성값의 속성명을 변경 가능
		
		@RequestMapping(value = "/join", method = RequestMethod.POST)
		public String join(@ModelAttribute("mem") Member member, Model model) {
			if(member.getId().equals("abc123")) {//아이디가 중복된 경우
				model.addAttribute("message", "이미 사용중인 아이디를 입력 하였습니다");
				return "join_form";
			}
			return "join_display";
		}		
	*/
	
	/* [순서-34] - -member라는 클래스가 없을 경우(테이블의 값들을 저장할때하는 방법)) - ex) 게시판형태
	  (=> 이럴땐 map을 써야함, map이라는 자료형을 사용한 매개변수를 만들고 제네릭은 string으로 하고 model.addattribute라고 해서 "mem"이라는 이름으로 map 객체 저장
	  	, @RequestParam 어노테이션 꼭 사용해야함)
	
		요청 처리 메소드의 매개변수를 Map 인터페이스로 작성하면 Front Controller는 Map(HashMap) 객체를 생성하여 매개변수에 저장되도록 제공
		=> 페이지 요청시 모든 전달값을 Map 객체의 엔트리로 추가하여 매개변수에 Map 객체를 저장
		=> Map 객체에는 전달값의 이름을 맵키(MapKey - String)로 제공받고 전달값은 맵값 (MapValue - String)로 제공받아 엔트리로 추가 
		=> 매개변수에 전달값이 저장된 Map 객체를 저장하기 위해서는 반드시 매개변수에 @RequestParam 어노테이션을 사용
	*/
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("mem", map);
		return "join_display";
	}
	
	/* [순서-35] 
		
		똑같은 이름으로 전달된 값이 있을때 처리하는 방법
	*/
	@RequestMapping(value="/sam_param", method=RequestMethod.GET)
	public String input() {
		return "same_form"; //=>[순서-36] - same_form.jsp 파일 생성
	}
	
	/* [순서-37] - 매개변수를 만드는 데 배열로 만듦
	
		같은 이름으로 전달된 값이 있는 경우 배열을 저장할 수 있는 
	*/
	@RequestMapping(value="/sam_param", method=RequestMethod.POST)
	public String input(@RequestParam String[] food) {
		return "same_display"; //=>[순서-38] - same_display.jsp 파일 생성
	}
}
