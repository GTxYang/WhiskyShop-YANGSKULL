 package WhiskyShop.Service.User;

import org.springframework.stereotype.Service;

import WhiskyShop.Dto.PaginateDto;

@Service
public class PaginateServiceImpl implements IPaginateService {
	public PaginateDto GetInfoPaginate(int totalData, int limit, int currentPage) {
		PaginateDto paginate = new PaginateDto();
		paginate.setLimit(limit);
		paginate.setTotalPage(SetInfoTotalPage(totalData, limit));
		paginate.setCurrentPage(CheckCurrentPage(currentPage ,paginate.getTotalPage()));
		int start = FindStart(paginate.getCurrentPage(), limit);
		paginate.setStart(start);
		int end = FindEnd(paginate.getStart(), limit, totalData);
		paginate.setEnd(end);
		return paginate;
	}

	private int FindEnd(int start, int limit, int totalData) {
		return start + limit > totalData ? totalData : (start + limit) -1;
	}

	private int FindStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit) + 1;
	}

	private int SetInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	
	//Check này đề phòng ng dùng cố ý nhập trang mún tới là 1000 nhưng trang hiện có chỉ có 5 thì sẽ đẩy về trnag cuối cùng
	// Cũng như là user phá nhập trang là số âm thì sẽ trỏ về trnag đầu
	public int CheckCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}

}
