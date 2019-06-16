package windowbuilder.jtree.demo2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * �ű���Ϣ
 * @author catt
 *
 */
public class ScriptInfoData implements Serializable{

    /**
     * �ű�id
     */
    private Long id;

    /**
     * �ű�����
     */
    private Long scriptNo;

    /**
     * �ű�����
     */
    private String scriptName;

    /**
     * �汾��
     */
    private String versionNo;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * ¼����id
     */
    private Long createUserId;

    /**
     * �༭״̬
     */
    private boolean editFlag;

    /**
     * �༭��id
     */
    private Long editUserId;

    /**
     * �༭ʱ��
     */
    private Date editTime;

    /**
     * ɾ����ʶ
     */
    private boolean deleteFlag;

    /**
     * ��ǰ�汾
     */
    private boolean enable;
    

}
