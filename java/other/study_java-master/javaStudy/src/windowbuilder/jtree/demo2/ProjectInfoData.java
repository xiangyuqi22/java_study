package windowbuilder.jtree.demo2;


import java.io.Serializable;
import java.util.List;


/**
 * 项目（模块）信息
 * @author catt
 *
 */
public class ProjectInfoData implements Serializable {

    /**
     * 项目id
     */
    private Long id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 父节点
     */
    private String parentId;

    /**
     * 脚本列表
     */
    private List<ScriptInfoData> scriptInfoData;
}
