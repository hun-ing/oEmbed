package com.huning.oembed.config;

import ac.simons.oembed.OembedEndpoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huning.oembed.exception.ProviderDataLoadException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProviderManager {
	private Map<String, Provider> providerMap = new HashMap<>();

	@PostConstruct
	public void init() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ClassPathResource resource = new ClassPathResource("json/providers.json");
			byte[] jsonData = FileCopyUtils.copyToByteArray(resource.getInputStream());
			String jsonString = new String(jsonData, StandardCharsets.UTF_8);
			Provider[] providers = objectMapper.readValue(jsonString, Provider[].class);

			providerMap = Arrays.stream(providers)
							.collect(Collectors.toMap(Provider::getProviderName, Function.identity()));
		} catch (IOException e) {
			throw new ProviderDataLoadException(e);
		}
	}

	public List<OembedEndpoint> generateEndpoints() {
		return providerMap.values()
						.stream()
						.flatMap(provider -> provider.getOembedEndpoints().stream())
						.collect(Collectors.toList());
	}
}
