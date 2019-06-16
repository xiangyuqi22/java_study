package j2ee.pattern.transferobject;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月19日
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
				//未实际删除
				return true;
			}
		}
		return false;
	}
	

}
