package com.game.review.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.review.service.GameRegService;

@Controller
public class testController {

	@Autowired
	GameRegService gameRegService;

	@PostMapping("/test1")
	@ResponseBody
	public Map<String, Object> test(@RequestBody HashMap<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();
        // 응답 데이터 셋팅
		System.out.println("param>>>>" + param.toString());
		
        result.put("code", "0000");
		return result;
	}

}
