package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.SlidesDao;
import WhiskyShop.Entity.Slides;

@Service
public class SlidesServiceImpl implements ISlides {

	@Autowired
	SlidesDao slideDao;

	
	public List<Slides> getListSlides() {
		return slideDao.getDataSlides();
	}

	public int InsertSlide(Slides slide) {
		return slideDao.InsertSlide(slide);
	}

	public int UpdateSlide(Slides slide) {
		return slideDao.UpdateSlide(slide);
	}

	public int DeleteSlide(int id) {
		return slideDao.DeleteSlide(id);
	}

	
	public Slides FindSlideByID(int id) {
		return slideDao.FindSlideByID(id);
	}

}
