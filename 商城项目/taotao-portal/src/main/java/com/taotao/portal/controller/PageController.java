package com.taotao.portal.controller;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.taotao.portal.service.ContentService;

@Controller
public class PageController {
	@Autowired
	private ContentService contentService;

	@RequestMapping("/index")
	public String getIdex(Model model) {
		try {
			String s = contentService.getList();
			model.addAttribute("indexAd1", s);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/{page}")
	public String getPage(@PathVariable String page) {
		return page;
	}

}
