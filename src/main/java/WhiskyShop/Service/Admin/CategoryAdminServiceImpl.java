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
	
	@Override
	public List<Categorys> getListCategory() {
		return categoryDao.getDataCategory();
	}

	@Override
	public int addCategory(Categorys category) {
		return categoryDao.addCategory(category);
	}

	@Override
	public Categorys getCategoryByID(int id) {
		return  categoryDao.getCategoryByID(id);
	}

	@Override
	public int updateCategory(Categorys category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	public int deleteCategory(int id) {
		return categoryDao.deleteCategory(id);
	}

}
