package com.bitc.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.xml.dto.MemberDto;
import com.bitc.xml.service.XmlService;

@Controller
public class XmlController {
	@Autowired
	private XmlService xmlService;

//	jaxb : 자에서 xml 데이터를 파싱하도록 도와주는 라이브러리
//	Marshal(마샬) : 자바 클래스를 XML 데이터로 변경
//	UnMarshal(언마샬) : XML 데이터를 자바 클래스로 변경
	
//	@XmlRootElement : xml 데이터에서 부모가 되는 태그를 뜻함
//	@XmlElement : xml 데이터에서 실제 데이터가 들어가 있는 태그를 뜻함
//	@XmlAttribute : xml 데이터에서 지정한 태그의 속성을 뜻함
	@RequestMapping(value="/file/xmlFile1", method=RequestMethod.GET)
	public ModelAndView xmlFile1() throws Exception { // 정확히는 ModelAndView이고, Object 로 해도됨
		
////		JAXB 라이브러리 사용 선언 -> 공식 사용법임, 이대로 써야함
////		아래는 new 사용하지 않고, 싱글톤 방식으로 내부에서 자기 자신의 객체를 선언해서 그것만 리턴해서 사용하는 방식
//		JAXBContext jc = JAXBContext.newInstance(MemberListDto.class);
//		
////		JAXB 라이브러리를 사용하여 XML 데이터를 자바 클래스 형태로 변환하는 언마샬 클래스 사용
////		여기까지 작성하고, 재실행 후 확인
//		Unmarshaller um = jc.createUnmarshaller();
//		
////		실제 데이터를 가져오기, 실제 unmarshal 작업, 즉 파싱작업을 함. 
////		unmarshal에 마우스 올려서 확인해보면, Object 타입임. -> XMl 형식은 지정된 형태가 없어서, 얘를 반환할 때 다른 형으로 반환하기가 애매함, 그래서 반환할 때 Object 타입으로 일단 반환하고, 실제 xml 파일 가져와서 파싱하기 위해서 문서를 확인한대로 우리가 형 변환을 해주는 것임.(MemberListDto 타입으로 형변환해서 )
////		==> 즉 기존에 제공된 xml 데이터를 기반으로 MemberListDto 클래스를 생성하였으므로 xml 파일을 파싱하여 가지고 온 데이터를 MemberListDto 클래스 타입으로 형변환하여 사용
////		Jaxb 라이블러리의 언마샬은 기본적으로 Object 타입으로 데이터를 반환함
//		MemberListDto memberList = (MemberListDto)um.unmarshal(new File("C://java102//memberlist.xml"));
////		List 타입으로 넣어서, MemberListDto에 있는 데이터를 다 가져온다. (xml 파일에서 memberlist 밑에 여러개의 member 가 있으므로, 리스트 형식으로 가져와서 사용한다.)
//		List<MemberDto> list = memberList.getMemberList();
//		
////		향상된 for 문
//		for (MemberDto member : list) {
////			콘솔 창에 띄우기 위해 작성
//			System.out.println("ID : " + member.getId());
//			System.out.println("NO : " + member.getNo());
//			System.out.println("Name : " + member.getName());
//			System.out.println("Gender : " + member.getGender());
//			System.out.println("Job : " + member.getJob());
//			System.out.println("---------------------------");
//		}
		
		ModelAndView mv = new ModelAndView("/file/xmlFile1");
		List<MemberDto> list = xmlService.getMemberList();
		mv.addObject("xmlDatas", list); 
		
		return mv; 
	}
	
	@ResponseBody // 이 어노테이션이 없으면, 아래에 return 된 부분을 데이터로 보는 게 아니라 html 파일을 찾는다. 그래서 오류난다. 조심!
	@RequestMapping(value="/file/xmlFile2", method=RequestMethod.POST)
	public Object xmlFile2() throws Exception {
		List<MemberDto> list = xmlService.getMemberList();
		
		return list;
	}
}




















