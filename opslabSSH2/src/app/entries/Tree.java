package app.entries;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/***
 * @function:
 * 		树形选项是的映射实体
 *
 */
@Data
public class Tree {

	//业务主键ID
	@Getter @Setter private Integer id;

	//叶子节点ID
	@Getter @Setter private String  treeId;

	//叶子节点名称
	@Getter @Setter private String  treeName;

	//父节点ID
	@Getter @Setter private String  parentId;

	//是否叶子节点
	private boolean isLeaf;

	//是否有效
	private boolean isValid;

	//节点类型ID
	@Getter @Setter private String  treeTypeId;

	//节点类型名称
	@Getter @Setter private String  treeTypeName;

	//根节点Id
	@Getter @Setter private String  rootId;

	//根节点名称
	@Getter @Setter private String  rootName;

	//全名称
	@Getter @Setter private String  allName;

	//子节点集合
	@Getter @Setter List<Tree> child;

	public void setIsLeaf(boolean b){
		this.isLeaf =b;
	}

	public boolean getIsLeaf(){
		return this.isLeaf;
	}

	public void setIsValid(boolean b){
		this.isValid = b;
	}

	public boolean getIsValid(){
		return this.isValid;
	}
}
