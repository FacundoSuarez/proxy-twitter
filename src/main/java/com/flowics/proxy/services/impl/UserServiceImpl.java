package com.flowics.proxy.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.UserWithData;
import com.flowics.proxy.domain.twitter.User;
import com.flowics.proxy.repository.UserRepository;
import com.flowics.proxy.services.UserService;
import com.flowics.proxy.utils.RestService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestService restService;

	@Autowired
	private UserRepository userRepository;

	@Value("${twitter.userUrl}")
	private String userUrl;
	
	@Value("${twitter.refreshLimitUser}")
	private Long refreshLimit;

	@Override
	public User getUser(String id) throws Exception {
		return checkConditions(id);
	}

	private User checkConditions(String id) throws Exception {

		Optional<UserWithData> userwd = userRepository.findOne(id);
		if (userwd.isPresent()) {
			if (checkDiffTimestamp(userwd.get().getLastUpdated())) {
				// if() //FIXME agrgegar validacion de cantidad de request por minuto
				updateOrCreateUser(userwd.get(), userwd.get().getUser());
				return userwd.get().getUser();
			}
			User result = (User) restService.getMethod(userUrl + id, User.class);
			updateOrCreateUser(userwd.get(), result);
			return result;
		}

		User result = (User) restService.getMethod(userUrl + id, User.class);
		updateOrCreateUser(new UserWithData(), result);
		return result;
	}

	/**
	 * Crea o hace update de algun user.
	 * 
	 * 
	 */
	private void updateOrCreateUser(UserWithData userwd, User user) {
		userwd.setLastUpdated(System.currentTimeMillis() / 1000);
		userwd.setRequestCounter(userwd.getRequestCounter() + 1);
		userwd.setId(user.getId_str());
		userwd.setUser(user);
		userRepository.updateUser(userwd);
	}

	/**
	 * Si la diferencia es mayor a lo configurado devuelve true y deberia actualizar el
	 * user desde twitter
	 * 
	 */
	private boolean checkDiffTimestamp(Long lastupdated) {
		long diff = System.currentTimeMillis() / 1000 - lastupdated;
		if (diff > refreshLimit) {
			return false;
		}
		return true;
	}
}
