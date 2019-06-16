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
		//����תjson
		User user = new User("tom",23,"�Ϻ�");
		String json = MAPPER.writeValueAsString(user);
		System.out.println(json);
		//jsonת����
		User uuser = MAPPER.readValue(json, User.class);
		System.out.println(uuser);
		
		//map<String,String>תjson
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("name", "jack");map.put("city", "beijin");
		String mjson = MAPPER.writeValueAsString(map);
		System.out.println(mjson);
		//jsonתmap<String,String>
		HashMap<String,String> mmap = MAPPER.readValue(mjson, HashMap.class);
		System.out.println(mmap);
		
		//map<String,User>תjson
		HashMap<String, User> umap = new HashMap<String, User>();
		umap.put(user.getName(), user);
		String mmjson = MAPPER.writeValueAsString(umap);
		System.out.println(mmjson);
		//jsonתmap<String,User>
		JavaType jvt = MAPPER.getTypeFactory().constructParametricType(HashMap.class,String.class,User.class);
        Map<String,User> urMap = MAPPER.readValue(mmjson, jvt);
        System.out.println(urMap);
		
		
		//list<String>תjson
		ArrayList<String> list = new ArrayList<String>();
		list.add("jack");
		list.add("tom");
		String ljson = MAPPER.writeValueAsString(list);
		System.out.println(ljson);
		//jsonתlist<String>
		ArrayList<String> sList = MAPPER.readValue(ljson, ArrayList.class);
		System.out.println(sList);
		
		//list<User>תjson
        List<User> ulist = new ArrayList<User>();
        ulist.add(user);
        String ujson = MAPPER.writeValueAsString(ulist);
        System.out.println(ujson);
        //jsonתlist<User>
        JavaType jt = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, User.class);
        List<User> urlist = MAPPER.readValue(ujson, jt);
        System.out.println(urlist);
		
	}

}
