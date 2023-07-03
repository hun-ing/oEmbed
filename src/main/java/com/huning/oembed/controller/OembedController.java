package com.huning.oembed.controller;

import ac.simons.oembed.OembedResponse;
import ac.simons.oembed.OembedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class OembedController {

	private final OembedService oembedService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("oembed")
	@ResponseBody
	public ResponseEntity getOembedContents(@RequestParam String url) throws Exception {
		OembedResponse oembedResponse = oembedService.getOembedResponseFor(url).orElseThrow(() -> new IllegalArgumentException("허용되지 않는 주소입니다."));
		return ResponseEntity.status(HttpStatus.OK).body(oembedResponse);
	}
}
