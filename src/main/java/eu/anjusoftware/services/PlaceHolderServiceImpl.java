package eu.anjusoftware.services;

import static org.springframework.http.HttpMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import eu.anjusoftware.dtos.PlaceHolder;

@Service
public class PlaceHolderServiceImpl implements PlaceHolderService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${service.placeholderUrl}")
	private String url;

	@Override
	public List<PlaceHolder> findAll() {
		return restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<PlaceHolder>>() {
		}).getBody();
	}

}
