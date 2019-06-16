package com.mote.jackson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JackSonDemo {
	
	private static ObjectMapper MAPPER = new ObjectMapper();
	
	public static void main(String[] args) throws Exception {
		//对象转json
		User user = new User("tom",23,"上海");
		String json = MAPPER.writeValueAsString(user);
		System.out.println(json);
		//json转对象
		User uuser = MAPPER.readValue(json, User.class);
		System.out.println(uuser);
		
		//map<String,String>转json
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("name", "jack");map.put("city", "beijin");
		String mjson = MAPPER.writeValueAsString(map);
		System.out.println(mjson);
		//json转map<String,String>
		HashMap<String,String> mmap = MAPPER.readValue(mjson, HashMap.class);
		System.out.println(mmap);
		
		//map<String,User>转json
		HashMap<String, User> umap = new HashMap<String, User>();
		umap.put(user.getName(), user);
		String mmjson = MAPPER.writeValueAsString(umap);
		System.out.println(mmjson);
		//json转map<String,User>
		JavaType jvt = MAPPER.getTypeFactory().constructParametricType(HashMap.class,String.class,User.class);
        Map<String,User> urMap = MAPPER.readValue(mmjson, jvt);
        System.out.println(urMap);
		
		
		//list<String>转json
		ArrayList<String> list = new ArrayList<String>();
		list.add("jack");
		list.add("tom");
		String ljson = MAPPER.writeValueAsString(list);
		System.out.println(ljson);
		//json转list<String>
		ArrayList<String> sList = MAPPER.readValue(ljson, ArrayList.class);
		System.out.println(sList);
		
		//list<User>转json
        List<User> ulist = new ArrayList<User>();
        ulist.add(user);
        String ujson = MAPPER.writeValueAsString(ulist);
        System.out.println(ujson);
        //json转list<User>
        JavaType jt = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, User.class);
        List<User> urlist = MAPPER.readValue(ujson, jt);
        System.out.println(urlist);
		
	}

}
