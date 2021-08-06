package WhiskyShop.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import WhiskyShop.Entity.Slides;
import WhiskyShop.Service.Admin.SlidesServiceImpl;

@Controller
@RequestMapping("/admin/")
public class SlidesController extends BaseAdminController {

	@Autowired
	ServletContext context;

	@Autowired
	SlidesServiceImpl slideService;

	@GetMapping("Slides")
	public ModelAndView Index(@RequestParam(value = "status", required = false) String status) {
		_mvShare.addObject("status", status);
		_mvShare.addObject("listSlide", slideService.getListSlides());
		_mvShare.setViewName("admin/slides/listSlide");
		return _mvShare;
	}

	@GetMapping("addSlides")
	public ModelAndView Get_AddSlide() {
		Slides slide = new Slides();
		_mvShare.addObject("slide", slide);
		_mvShare.setViewName("admin/slides/addSlide");
		return _mvShare;
	}

	@PostMapping("addSlides")
	public String Post_AddUser(@ModelAttribute("slide") Slides slide, ModelMap model,
			MultipartHttpServletRequest request) {
		String path_save = context.getRealPath("/assets/user/images/slide/");
		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next());
		String name_file = mpf.getOriginalFilename();

		File file_save = new File(path_save + name_file);
		try {
			mpf.transferTo(file_save);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		slide.setImg(name_file);
		int insert = slideService.InsertSlide(slide);
		if (insert > 0) {
			model.addAttribute("status", "thành công");
			return "redirect:Slides";
		} else {
			model.addAttribute("error", "thất bại");
			return "admin/slides/addSlide";
		}
	}

	@PostMapping("deleteSlide")
	public ModelAndView DeleteSlide(@RequestParam("id") int id, ModelMap model) {
		int delete = slideService.DeleteSlide(id);
		if (delete > 0) {
			model.addAttribute("status", "thành công");
		} else {
			model.addAttribute("status", "thất bại");
		}

		_mvShare.setViewName("redirect:Slides");
		return _mvShare;
	}

	@GetMapping("editSlide")
	public ModelAndView Get_EditSlide(@RequestParam("id") int id) {
		Slides slide = slideService.FindSlideByID(id);
		_mvShare.addObject("slide", slide);
		_mvShare.setViewName("admin/slides/addSlide");
		return _mvShare;
	}

	@PostMapping("editSlide")
	public String Post_EditSlide(@ModelAttribute("slide") Slides slide, ModelMap model,MultipartHttpServletRequest request) {
		String path_save = context.getRealPath("/assets/user/images/slide/");
		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next());
		String name_file = mpf.getOriginalFilename();

		File file_save = new File(path_save + name_file);
		try {
			mpf.transferTo(file_save);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		slide.setImg(name_file);
		int update = slideService.UpdateSlide(slide);
		if (update > 0) {
			model.addAttribute("status", "thành công");
			return "redirect:Slides";
		}else {
			model.addAttribute("status", "thất bại");
			return "admin/slides/addSlide";
		}

		
	}

}
