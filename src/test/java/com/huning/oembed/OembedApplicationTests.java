package com.huning.oembed;

import ac.simons.oembed.OembedResponse;
import ac.simons.oembed.OembedService;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OembedApplicationTests {

	@Autowired
	private OembedService oembedService;

	@Test
	void contextLoads() {
		OembedResponse oembedResponse = oembedService.getOembedResponseFor("https://www.youtube.com/watch?v=dBD54EZIrZo").get();
		String authorName = oembedResponse.getAuthorName();
		System.out.println("authorName = " + authorName);
		String authorUrl = oembedResponse.getAuthorUrl();
		System.out.println("authorUrl = " + authorUrl);
		Long cacheAge = oembedResponse.getCacheAge();
		System.out.println("cacheAge = " + cacheAge);
		Integer height = oembedResponse.getHeight();
		System.out.println("height = " + height);
		String html = oembedResponse.getHtml();
		System.out.println("html = " + html);
		String providerName = oembedResponse.getProviderName();
		System.out.println("providerName = " + providerName);
		Integer thumbnailHeight = oembedResponse.getThumbnailHeight();
		System.out.println("thumbnailHeight = " + thumbnailHeight);
		String thumbnailUrl = oembedResponse.getThumbnailUrl();
		System.out.println("thumbnailUrl = " + thumbnailUrl);
		Integer thumbnailWidth = oembedResponse.getThumbnailWidth();
		System.out.println("thumbnailWidth = " + thumbnailWidth);
		String providerUrl = oembedResponse.getProviderUrl();
		System.out.println("providerUrl = " + providerUrl);
		String title = oembedResponse.getTitle();
		System.out.println("title = " + title);
		String type = oembedResponse.getType();
		System.out.println("type = " + type);
		String version = oembedResponse.getVersion();
		System.out.println("version = " + version);
		Integer width = oembedResponse.getWidth();
		System.out.println("width = " + width);
		String url = oembedResponse.getUrl();
		System.out.println("url = " + url);

	}

}
