package com.barofarm.meat;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BaroFarmController {

	@Inject
	IF_BaroFarmService bfservice;
	
	@GetMapping
	public String main() {
		
		return "insertview";
	}
	
	@GetMapping("/insert")
	public String insert(BaroFarmVo bfvo) throws Exception {
		System.out.println("controller insert test");
		System.out.println(bfvo.toString());
		
		bfservice.insert(bfvo);
		return "redirect:viewall";
	}
	
	@GetMapping("/viewall")
	public String viewall(Model model) throws Exception {
		List<BaroFarmVo> select=bfservice.select();
		
		System.out.println(select.size() + "건 가져옴");
		model.addAttribute("selectlist",select);		
		return "viewall";
	}
	
	@GetMapping("/del")
	public String delete(@RequestParam("delete") String delno) throws Exception {
		System.out.println("controller delete TEST 삭제할 번호: " + delno);
		
		bfservice.delete(delno);		
		return "redirect:viewall";
	}
	
	@GetMapping("/modify")
	public String updata(@RequestParam("updata") String updata, Model model) throws Exception {
		System.out.println("controller updata TEST 수정할번호: " + updata);
		BaroFarmVo vo = bfservice.updata(updata);
		System.out.println("수정할 글 번호 확인");
		System.out.println(vo.toString());
		model.addAttribute("updata", vo);		
		
		return "updata";
	}
	
	@GetMapping("/updata")
	public String updatasave(@ModelAttribute BaroFarmVo vo) throws Exception {
		bfservice.updatasave(vo);
		
		return "redirect:viewall";
	}
	
	@GetMapping("/order")
	public String order() {
		
		return "orderDelivery";
	}
	


	
	

}
