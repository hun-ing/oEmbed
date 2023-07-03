package com.huning.oembed.config;

import ac.simons.oembed.OembedEndpoint;
import ac.simons.oembed.OembedService;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OembedConfig {

	private final ProviderManager providerManager;

	@Bean
	public OembedService oembedService() {
		List<OembedEndpoint> oembedEndpoints = providerManager.generateEndpoints();
		HttpClient client = HttpClientBuilder.create().build();
		final OembedService oembedService = new OembedService(client, null, oembedEndpoints, "some-app");
		return oembedService;
	}
}
