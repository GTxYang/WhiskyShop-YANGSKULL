package WhiskyShop.Service.Admin;

import WhiskyShop.Entity.Categorys;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ICategoryAdmin {
	
	public List<Categorys> getListCategory();
	
	public Categorys getCategoryByID(int id);
	
	public int addCategory(Categorys category);
	
	public int updateCategory(Categorys category);
	
	public int deleteCategory(int id);
}
