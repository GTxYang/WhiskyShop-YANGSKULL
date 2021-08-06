package WhiskyShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.CategorysDao;
import WhiskyShop.Entity.Categorys;

@Service
public class CategoryAdminServiceImpl implements ICategoryAdmin {

	@Autowired
	CategorysDao categoryDao;
	
	public List<Categorys> getListCategory() {
		return categoryDao.getDataCategory();
	}

	
	public int addCategory(Categorys category) {
		return categoryDao.addCategory(category);
	}

	
	public Categorys getCategoryByID(int id) {
		return  categoryDao.getCategoryByID(id);
	}

	
	public int updateCategory(Categorys category) {
		return categoryDao.updateCategory(category);
	}

	public int deleteCategory(int id) {
		return categoryDao.deleteCategory(id);
	}

}
