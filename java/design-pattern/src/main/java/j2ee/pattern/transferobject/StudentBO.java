package j2ee.pattern.transferobject;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��19��
 * @author xiangning
 * @since JDK1.8
 */
public class StudentBO {
	
	private List<StudentVO> lists ;
	public StudentBO() {
		lists = new ArrayList<>();
		{
			StudentVO studentVO = new StudentVO("libai", 1001);
			lists.add(studentVO);
		}
		{
			StudentVO studentVO = new StudentVO("dufu", 1002);
			lists.add(studentVO);
		}
	}
	
	public List<StudentVO> getStudentVOs(){
		return lists;
	}
	
	public void addStudentVO(StudentVO studentVO) {
		lists.add(studentVO);
	}
	
	public boolean updateStudentVO(StudentVO studentVO) {
		System.out.println("j2ee.pattern.transferobject.StudentBO.updateStudentVO(StudentVO)");
		return true;
	}
	
	public boolean deleteStudentVO(int rollNo) {
		for (StudentVO studentVO : lists) {
			if(rollNo == studentVO.getRollNo()) {
				//δʵ��ɾ��
				return true;
			}
		}
		return false;
	}
	

}
