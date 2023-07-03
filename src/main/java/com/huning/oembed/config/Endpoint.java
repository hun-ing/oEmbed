package com.huning.oembed.config;

import ac.simons.oembed.OembedEndpoint;
import ac.simons.oembed.OembedResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Data
public class Endpoint {
	private List<String> schemes;
	private String url;
	private boolean discovery;
	private List<String> formats;

	private String getUrl(String format) {
		return url.contains(".xml") ? null : url.replace("{format}", format);
	}

	public OembedEndpoint createOembedEndpoint() {
		return Optional.ofNullable(getUrl(OembedResponse.Format.json.toString()))
						.map(url -> {
							OembedEndpoint endpoint = new OembedEndpoint();
							endpoint.setFormat(OembedResponse.Format.json);
							endpoint.setEndpoint(url);
							Optional.ofNullable(schemes).ifPresent(endpoint::setUrlSchemes);
							return endpoint;
						})
						.orElse(null);
	}
}
