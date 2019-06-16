package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.data.MessageData;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：springboot_demo_3</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年6月11日
 * @author xiangning
 * @since JDK1.8
 */
@RestController
@RequestMapping("/file")
@PropertySource({"classpath:/config/resource.properties"})
public class FileController {
	
	@Value("${upload.path}")
	private String filePath;
	

	@RequestMapping("/upload")
	public MessageData fileUpload(@RequestParam("file") MultipartFile multipartFile ,  HttpServletRequest request){
		MessageData<Map<String,String>> messageData = new MessageData<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		String name = multipartFile.getName();
		String originalFilename = multipartFile.getOriginalFilename();
		map.put("originalFilename", originalFilename);
		boolean empty = multipartFile.isEmpty();
		if(empty) {
			return MessageData.isError("上传文件为空");
		}
		if(originalFilename.lastIndexOf(".") == -1) {
			return MessageData.isError("文件格式错误");
		}
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
		
		String uuidName = UUID.randomUUID().toString() + suffix;
		
		File file = new File(filePath + uuidName);
		try {
			multipartFile.transferTo(file);
			messageData.setData(map);
			messageData.setMessage("文件上传成功");
			messageData.setCode(MessageData.SUCCESS);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			messageData.setCode(MessageData.ERROR);
			messageData.setMessage("文件上传失败" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			messageData.setMessage("文件上传失败" + e.getMessage());
			messageData.setCode(MessageData.ERROR);
		}
		return messageData;
	}
}
