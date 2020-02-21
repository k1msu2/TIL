package my.spring.springedu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.TeamMemberVO;
import vo.TeamVO;

@Controller
public class MyTeamController {

	@ResponseBody
	@RequestMapping(value = "/myteam/xml", produces = "application/xml; charset=utf-8")
	public TeamVO myTeamInXml() {
		TeamVO vo = new TeamVO();
		List<TeamMemberVO> myList = new ArrayList<TeamMemberVO>();
		TeamMemberVO myData = new TeamMemberVO();
		myData.setName("해림");
		myData.setNicName("팀의스파이더맨");
		myList.add(myData);
		myData = new TeamMemberVO();
		myData.setName("지원");
		myData.setNicName("팀의앤트맨");
		myList.add(myData);
		myData = new TeamMemberVO();
		myData.setName("수이");
		myData.setNicName("팀의캡틴");
		myList.add(myData);
		vo.setTeamName("자바스");
		vo.setTeamMember(myList);
		return vo;
	}

	@ResponseBody
	@RequestMapping(value = "/myteam/json", produces = "application/json; charset=utf-8")
	public TeamVO myTeamInJson() {
		TeamVO vo = new TeamVO();
		List<TeamMemberVO> myList = new ArrayList<TeamMemberVO>();
		TeamMemberVO myData = new TeamMemberVO();
		myData.setName("해림");
		myData.setNicName("팀의스파이더맨");
		myList.add(myData);
		myData = new TeamMemberVO();
		myData.setName("지원");
		myData.setNicName("팀의앤트맨");
		myList.add(myData);
		myData = new TeamMemberVO();
		myData.setName("수이");
		myData.setNicName("팀의캡틴");
		myList.add(myData);
		vo.setTeamName("자바스");
		vo.setTeamMember(myList);
		return vo;
	}
}
