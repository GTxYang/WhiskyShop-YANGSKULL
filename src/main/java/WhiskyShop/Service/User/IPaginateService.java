package WhiskyShop.Service.User;

import org.springframework.stereotype.Service;

import WhiskyShop.Dto.PaginateDto;

@Service
public interface IPaginateService {
	public PaginateDto GetInfoPaginate(int totalData, int limit, int currentPage) ;
	
}
