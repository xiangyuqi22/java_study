package windowbuilder.jtree.demo2;


import java.io.Serializable;
import java.util.List;


/**
 * ��Ŀ��ģ�飩��Ϣ
 * @author catt
 *
 */
public class ProjectInfoData implements Serializable {

    /**
     * ��Ŀid
     */
    private Long id;

    /**
     * ��Ŀ����
     */
    private String name;

    /**
     * ���ڵ�
     */
    private String parentId;

    /**
     * �ű��б�
     */
    private List<ScriptInfoData> scriptInfoData;
}
