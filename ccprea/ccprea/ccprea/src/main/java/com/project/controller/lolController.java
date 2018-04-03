package com.project.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.util.JsonReader;

@Controller
@RequestMapping("/lol")
public class lolController {

	@RequestMapping(value="/SummonerSearch")
	public String SummonerSearch(){
		
		
		return "lol/SummonerSearchView";
	}
	
	@RequestMapping(value="search")
	@ResponseBody
	public Map search(HttpServletRequest request
					  ,HttpServletResponse response
					  ,@RequestParam("api_key") String key
					  ,@RequestParam("id") String id) throws JSONException, IOException{
		String url = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/";

		
		url += id;
		url += "?api_key=" + key;
		
		System.out.println(JsonReader.readJsonFromUrl(url));
		
		Map map = (HashMap)JsonReader.readJsonFromUrl(url).toMap();
		
		return map;
		
	}
	
}
