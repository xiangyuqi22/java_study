package windowbuilder.jtree.demo2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 脚本信息
 * @author catt
 *
 */
public class ScriptInfoData implements Serializable{

    /**
     * 脚本id
     */
    private Long id;

    /**
     * 脚本编码
     */
    private Long scriptNo;

    /**
     * 脚本名称
     */
    private String scriptName;

    /**
     * 版本号
     */
    private String versionNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 录制人id
     */
    private Long createUserId;

    /**
     * 编辑状态
     */
    private boolean editFlag;

    /**
     * 编辑人id
     */
    private Long editUserId;

    /**
     * 编辑时间
     */
    private Date editTime;

    /**
     * 删除标识
     */
    private boolean deleteFlag;

    /**
     * 当前版本
     */
    private boolean enable;
    

}
