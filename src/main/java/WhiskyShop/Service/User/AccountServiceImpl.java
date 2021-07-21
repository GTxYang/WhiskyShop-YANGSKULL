package WhiskyShop.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WhiskyShop.Dao.AccountDao;
import WhiskyShop.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountDao accountDao;

	public int createAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
		return accountDao.createAccount(user);
	}

	@Override
	public Users FindUserByUsername(String username) {

		return accountDao.FindUserByUsername(username);
	}

}
