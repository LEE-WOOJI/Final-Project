package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dto.ChalBasicDTO;
import kh.spring.service.ChalService;

@RequestMapping("/chal/")
@Controller
public class ChalController {
   @Autowired
   ChalService cservice;
   
   //1.전체 리스트
   //처음 리스트에 들어왔을 때
   @RequestMapping("list")
   public String chalList(Model model) {
      int start = 1;
      int end = start + 5;
      List<ChalBasicDTO> list = cservice.listBound(start, end);
      System.out.println(list.get(0).getStartDate());
      model.addAttribute("list",list);
      return "/chal/chalList";
   }
   
   //더보기 버튼을 눌렀을 때
   @ResponseBody
   @RequestMapping(value = "more", produces = "text/html;charset=utf8")
   public String chalMore(int moreNum) {
      int start = moreNum;
      int end = start + 5;
      System.out.println(end);
      List<ChalBasicDTO> list = cservice.listBound(start, end); //7~12까지의 챌린지 정보를 dto리스트로 담아 list에 저장
      Gson glist = new Gson(); 
      String result = glist.toJson(list); //json으로 변환
      return result;
   }
   
   //검색 버튼을 눌렀을 때
   @RequestMapping("search")
   public String chalSearch(String option, String searchText, Model model) {
      System.out.println(option + ":" + searchText);
      int start = 1;
      int end = start + 2;
      if(option.equals("name")) {
         List<ChalBasicDTO> klist = cservice.searchK(start, end, searchText);
         model.addAttribute("option",option);
         model.addAttribute("searchText",searchText);
         model.addAttribute("list",klist);
      }else if(option.equals("tag")) {
         List<ChalBasicDTO> tlist = cservice.searchT(start, end, searchText);
         model.addAttribute("option",option);
         model.addAttribute("searchText",searchText);
         model.addAttribute("list",tlist);
      }else if(option.equals("day")) {
         List<ChalBasicDTO> dlist = cservice.searchD(start, end, searchText);
         model.addAttribute("option",option);
         model.addAttribute("searchText",searchText);
         model.addAttribute("list",dlist);
      }
      return "/chal/chalListSearch";
   }
   
   //검색더보기 버튼을 눌렀을 때
      @ResponseBody
      @RequestMapping(value = "searchMore", produces = "text/html;charset=utf8")
      public String searchMore(String opt, String key,int moreNum) {
         int start = moreNum;
         int end = start + 2;
         Gson glist = new Gson();
         String result = null;
         System.out.println(end);
         System.out.println(opt + ":" + key);
         if(opt.equals("name")) {
            List<ChalBasicDTO> klist = cservice.searchK(start, end, key);
            System.out.println(key);
            result = glist.toJson(klist);
         }else if(opt.equals("tag")) {
            List<ChalBasicDTO> tlist = cservice.searchT(start, end, key);
            result = glist.toJson(tlist);
         }else if(opt.equals("day")) {
            List<ChalBasicDTO> dlist = cservice.searchD(start, end, key);
            result = glist.toJson(dlist);
         }
         return result;
      }
   
   //카테고리 1.건강
   @RequestMapping("health")
   public String chalHealth(Model model) {
	   String category = "건강";
	   List<ChalBasicDTO> list = cservice.listCategory(category);
	   model.addAttribute("category",category);
	   model.addAttribute("list",list);
	   return "/chal/chalCategory";
   }
   //카테고리 2.취미
   @RequestMapping("hobby")
   public String chalHobby(Model model) {
	   String category = "취미";
	   List<ChalBasicDTO> list = cservice.listCategory(category);
	   model.addAttribute("category",category);
	   model.addAttribute("list",list);
	   return "/chal/chalCategory";
   }
   //카테고리 3.금융
   @RequestMapping("finance")
   public String chalFinance(Model model) {
	   String category = "금융";
	   List<ChalBasicDTO> list = cservice.listCategory(category);
	   model.addAttribute("category",category);
	   model.addAttribute("list",list);
	   return "/chal/chalCategory";
   }
   //카테고리 4.공부
   @RequestMapping("study")
   public String chalStudy(Model model) {
	   String category = "공부";
	   List<ChalBasicDTO> list = cservice.listCategory(category);
	   model.addAttribute("category",category);
	   model.addAttribute("list",list);
	   return "/chal/chalCategory";
   }
   //카테고리 5.생활
   @RequestMapping("life")
   public String chalLife(Model model) {
	   String category = "생활";
	   List<ChalBasicDTO> list = cservice.listCategory(category);
	   model.addAttribute("category",category);
	   model.addAttribute("list",list);
	   return "/chal/chalCategory";
   }
   //카테고리 6.펫/환경
   @RequestMapping("pet")
   public String chalPet(Model model) {
	   String category = "펫/에코";
	   List<ChalBasicDTO> list = cservice.listCategory(category);
	   model.addAttribute("category",category);
	   model.addAttribute("list",list);
	   return "/chal/chalCategory";
   }
   
   //정렬
   @ResponseBody
   @RequestMapping(value = "filter", produces = "text/html;charset=utf8")
   public String filter(String category, String filter, Model model) {
	   System.out.println(category + ":" + filter);
	   Gson glist = new Gson();
	   List<ChalBasicDTO> list = cservice.categoryFilter(category, filter);
	   System.out.println(list.get(0).getChalName() + list.size());
	   String result = glist.toJson(list);
	   return result;
   }
   
}

