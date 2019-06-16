package other.basic.java.bean;

import java.util.Comparator;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��23��
 * @author xiangning
 * @since JDK1.8
 */
public class User{
	
	private Long id;
	
	private String name;
	
	private String username;
	
	private String nickName;
	
	private String gender;
	
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public static User getUser() {
		User user = new User();
		user.setName("���");
		user.setId(1000L);
		user.setAge(40);
		user.setNickName("��̫��");
		user.setUsername("libai");
		user.setGender("��");
		return user;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", nickName=" + nickName + ", gender="
				+ gender + ", age=" + age + "]";
	}
	
	

}
