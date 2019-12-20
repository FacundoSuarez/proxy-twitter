package com.flowics.proxy.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.StatusWithData;
import com.flowics.proxy.domain.twitter.Status;
import com.flowics.proxy.domain.twitter.User;
import com.flowics.proxy.repository.StatusRepository;
import com.flowics.proxy.services.StatusService;
import com.flowics.proxy.utils.RestService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private RestService restService;

	@Autowired
	private StatusRepository statusRepository;

	@Value("${twitter.statusUrl}")
	private String statusUrl;

//	@Value("${twitter.limitRecurrentRequest}")
//	private int limitRecurrentRequest;

	@Override
	public Status getStatus(String id) throws Exception {
		return checkConditions(id);
	}

	private Status checkConditions(String id) throws Exception {

		Optional<StatusWithData> statuswd = statusRepository.findOne(id);
		if (statuswd.isPresent()) {
			if (checkDiffTimestamp(statuswd.get().getLastUpdated())) {
				// if() //FIXME agrgegar validacion de cantidad de request por minuto
				updateOrCreateStatus(statuswd.get(), statuswd.get().getStatus());
				return statuswd.get().getStatus();
			}
			Status result =  (Status) restService.getMethod(statusUrl + id, Status.class);
			updateOrCreateStatus(statuswd.get(), result);
			return result;
		}			
		
		Status result =  (Status) restService.getMethod(statusUrl + id, Status.class);
		updateOrCreateStatus(new StatusWithData(), result);
		return result;
	}
	
	
	
	/**
	 * Crea o hace update de algun status.
	 * 
	 * 
	 */
	private void updateOrCreateStatus(StatusWithData statuswd, Status status) {
		statuswd.setLastUpdated(System.currentTimeMillis() / 1000);
		statuswd.setRequestCounter(statuswd.getRequestCounter() + 1);
		statuswd.setId(status.getId_str());
		statuswd.setStatus(status);
		statusRepository.updateStatus(statuswd);
	}

	/**
	 * Si la diferencia es mayor a 7 min devuelve true y deberia actualizar el
	 * status desde twitter
	 * 
	 */
	private boolean checkDiffTimestamp(Long lastupdated) {
		long diff = System.currentTimeMillis() / 1000 - lastupdated;
		if (diff > 420L) {
			return false;
		}
		return true; 
	}

	
}
