package com.bitc.xml.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.bitc.xml.dto.MemberDto;
import com.bitc.xml.dto.MemberListDto;

@Service
public class XmlServiceImpl implements XmlService{

	@Override
	public List<MemberDto> getMemberList() throws Exception {
	
	
//	JAXB 라이브러리 사용 선언 -> 공식 사용법임, 이대로 써야함
	JAXBContext jc = JAXBContext.newInstance(MemberListDto.class);
	
//	JAXB 라이브러리를 사용하여 XML 데이터를 자바 클래스 형태로 변환하는 언마샬 클래스 사용
	Unmarshaller um = jc.createUnmarshaller();
	
//	실제 데이터를 가져오기, 실제 unmarshal 작업, 즉 파싱작업을 함. 
//	Jaxb 라이블러리의 언마샬은 기본적으로 Object 타입으로 데이터를 반환함
	MemberListDto memberList = (MemberListDto)um.unmarshal(new File("C://java102//memberlist.xml"));
//	List 타입으로 넣어서, MemberListDto에 있는 데이터를 다 가져온다. (xml 파일에서 memberlist 밑에 여러개의 member 가 있으므로, 리스트 형식으로 가져와서 사용한다.)
	List<MemberDto> list = memberList.getMemberList();
	
//	for (MemberDto member : list) {
//	콘솔 창에 띄워서 데이터 확인용
//	System.out.println("ID : " + member.getId());
//	System.out.println("NO : " + member.getNo());
//	System.out.println("Name : " + member.getName());
//	System.out.println("Gender : " + member.getGender());
//	System.out.println("Job : " + member.getJob());
//	System.out.println("---------------------------");
//	}
	
	return list;
	
	}
}
























