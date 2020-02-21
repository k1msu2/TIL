package my.spring.springedu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.MyGroupModel;
import vo.MyMainModel;
import vo.MyModel;
import vo.XmlVO;

@Controller
public class ResponseBodyController {
	//{id} 동적으로 가져올수 있음
	@RequestMapping(value = "/body/text/{id}", produces = "text/plain; charset=utf-8")
	@ResponseBody //뷰를 안거치고 컨트롤러가 직접 클라이언트한테 응답하겠다
	//produces 속성 중요 - 컨트롤러가 직접 응답하는 것을 명시 "text/plain; charset=utf-8"
	public String getByIdInTEXT(@PathVariable String id) { //"/body/text/{id} 에서 id가져와서 매개변수에 씀
		// text/plain으로 요청해서
		return "<h1>It returns the string directly from the controller : " + id + "</h1>";
	}

	@RequestMapping(value = "/body/htmltext/{id}", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String getByIdInHTMLTEXT(@PathVariable String id) {
		return "<h1>It returns the HTML directly from the controller : " + id + "</h1>";
	}
	
	@RequestMapping(value = "/body/json/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getByIdInJSON(@PathVariable String id) {
		String s = "{ \"name\" : \"ROSE\", \"num\":5, \"id\" : \""+id+"\"}";
		return s;
	}
	
	//jackson-databind
	@RequestMapping(value = "/body/json1/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public MyModel getByIdInJSON1(@PathVariable String id) {
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);		
		return my;
	}	
	
	@RequestMapping(value = "/body/json2/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<MyModel> getByIdInJSON2(@PathVariable String id) {
		List<MyModel> list = new ArrayList<MyModel>();
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		my = new MyModel();
		my.setFlowerName("LILY");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		return list;
	}

	
	@RequestMapping(value = "/body/json3/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<MyMainModel> getByIdInJSON3(@PathVariable String id) {
		ArrayList<MyMainModel> list = new ArrayList<>();
		ArrayList<MyGroupModel> list2 = new ArrayList<>();
		ArrayList<MyGroupModel> list2_1 = new ArrayList<>();
		ArrayList<MyModel> list3 = new ArrayList<>();
		ArrayList<MyModel> list3_1 = new ArrayList<>();
		MyModel my1 = new MyModel();
		my1.setFlowerName("AAA");
		my1.setNum(5);
		my1.setId(id);
		MyModel my2 = new MyModel();
		my2.setFlowerName("BBB");
		my2.setNum(5);
		my2.setId(id);
		MyModel my3 = new MyModel();
		my3.setFlowerName("BBB");
		my3.setNum(5);
		my3.setId(id);
		MyModel my4 = new MyModel();
		my4.setFlowerName("CCC");
		my4.setNum(5);
		my4.setId(id);
		MyModel my5 = new MyModel();
		my5.setFlowerName("DDD");
		my5.setNum(5);
		my5.setId(id);
		list3.add(my1);
		list3.add(my2);
		list3_1.add(my3);
		list3_1.add(my4);
		list3_1.add(my5);
		MyGroupModel mgm1 = new MyGroupModel();
		mgm1.setCategory("요가");
		mgm1.setMyModellist(list3);
		MyGroupModel mgm2 = new MyGroupModel();
		mgm2.setCategory("수영");
		mgm2.setMyModellist(list3_1);
		list2.add(mgm1);
		list2_1.add(mgm2);
		MyMainModel mmm1 = new MyMainModel();
		mmm1.setYear("2019");
		mmm1.setGrouplist(list2);
		MyMainModel mmm2 = new MyMainModel();
		mmm2.setYear("2018");
		mmm2.setGrouplist(list2_1);
		list.add(mmm1);
		list.add(mmm2);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value = "/body/json4/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<HashMap<String, String>> getByIdInJSON4(@PathVariable String id) {
		List<HashMap<String, String>> list = new ArrayList<>();
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("aa", "10");
		map1.put("bb", "20");
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("cc", "30");
		map2.put("dd", "40");
		
		list.add(map1);
		list.add(map2);
		return list;
	}

	@RequestMapping(value = "/body/xml1/{id}", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public MyModel getByIdInXML1(@PathVariable String id) {
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);
		return my;
	}

	
	@RequestMapping(value = "/body/xml2/{id}", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public XmlVO getByIdInXML4(@PathVariable String id) {
		XmlVO vo = new XmlVO();
		ArrayList<MyModel> list = new ArrayList<MyModel>();
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		my = new MyModel();
		my.setFlowerName("LILY");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		vo.setList(list);
		return vo;
	}	
	@RequestMapping(value = "/getJSON1", 
			      produces = "application/json; charset=utf-8")
	@ResponseBody
	public String test1(String id) {		
		String s = "{ \"result\" : \"ㅋㅋ1"+id+"\"}";
		return s;
	}
	@RequestMapping(value = "/getJSON2", 
		      produces = "application/json; charset=utf-8")
	@ResponseBody
	public HashMap<String, String> test2(String id) {		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "ㅋㅋ2"+id);
		return map;
	}

}
