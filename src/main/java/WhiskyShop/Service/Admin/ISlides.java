package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.stereotype.Service;

import WhiskyShop.Entity.Slides;

@Service
public interface ISlides {
		
	public List<Slides> getListSlides();
	
	public int InsertSlide(Slides slide);
	
	public int UpdateSlide(Slides slide);
	
	public int DeleteSlide(int id);
	
	public Slides FindSlideByID(int id);
	
}
