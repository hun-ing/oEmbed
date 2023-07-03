package com.huning.oembed.config;

import ac.simons.oembed.OembedEndpoint;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Provider {
	@JsonProperty("provider_name")
	private String providerName;
	@JsonProperty("provider_url")
	private String providerUrl;
	private List<Endpoint> endpoints = new ArrayList<>();

	public List<OembedEndpoint> getOembedEndpoints() {
		return endpoints.stream()
						.map(Endpoint::createOembedEndpoint)
						.filter(Objects::nonNull)
						.peek(this::configureOembedEndpoint)
						.collect(Collectors.toList());
	}

	private void configureOembedEndpoint(OembedEndpoint oembedEndpoint) {
		List<String> urlSchemes = oembedEndpoint.getUrlSchemes();
		if (urlSchemes == null) {
			urlSchemes = Collections.singletonList(addSuffix(providerUrl));
		}
		oembedEndpoint.setUrlSchemes(generateRegexPatterns(urlSchemes));
		oembedEndpoint.setName(providerName);
	}

	private List<String> generateRegexPatterns(List<String> urlSchemes) {
		return urlSchemes.stream()
						.map(urlScheme -> urlScheme.replace(".", "\\.").replace("*", ".*"))
						.collect(Collectors.toList());
	}

	private String addSuffix(String str) {
		return str.endsWith("/") ? str + "*" : str + "/*";
	}
}

