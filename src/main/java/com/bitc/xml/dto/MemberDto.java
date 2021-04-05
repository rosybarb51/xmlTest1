package com.bitc.xml.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// MemberDto라는 타입으로 클래스를 하나 만들어줌, 이따 xml 파일에 들어갈 것임. 
// xml 파일과 연동된다는 것을 알ㄹㅕ주기 위해 아래의 어노테이션 삽입
// 클래스 이름이 우리가 xml 파일에서 파싱하는 이름과 다른 경우 (아래처럼)가 있기 때문에 아래처럼 name을 xml 파일의 이름 그대로 지정해줘야한다.
@XmlRootElement(name="member")
public class MemberDto {

	private int no;
	private String name;
	private String gender;
	private String job;
	private String id;
	
//	import 시 javax.xml 로 임폴트하기
	@XmlElement
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
//	import 시 javax.xml.bind 로 임폴트하기
//	name은 혹시 몰라서 적어줬다, xml에서 쓰인 이름 그대로 적어줌
	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
}
