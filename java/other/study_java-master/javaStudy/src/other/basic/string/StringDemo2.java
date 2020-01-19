package other.basic.string;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年1月7日
 * @author xiangning
 * @since JDK1.8
 */
public class StringDemo2 {
	
	
	public static void main(String[] args) {
		String sql = "   SELECT D.I_ENUM_VALUE,D.S_ENUM_MEANING,D.S_DATA_DOMAIN_ID,R.S_FIELD_NAME FROM T_ENUMERATE D,T_ENUMERATE_REL R WHERE D.S_ENUM_TYPE = R.S_ENUMERATE_NAME  order by r.s_field_name desc";
		sql = sql.trim().replaceAll(" +", " ");
		String tempSql = sql.toLowerCase();
		System.out.println(tempSql);
		String finalSql = getPagingSql("30",sql,tempSql,1,5);
		System.out.println(finalSql);
	}

	private static String getPagingSql(String rows,	String sql, String tempSQL, int page, int limit) {
		//格式化原始sql
		tempSQL = tempSQL.toLowerCase().trim().replaceAll(" +", " "); 
		StringBuilder pagingSql = new StringBuilder("select * from (");
		/**
		 * 1、在查询的sql后添加总条数
		 * 	如：
		 * 		select id from table
		 * 	转换成：
		 * 		select id,10 as 'iRecCount',10 as 'totalCount'
		 */
		StringBuilder orderBySql = new StringBuilder();
		StringBuilder part = new StringBuilder(", ");
		part.append(rows).append(" as \"iRecCount\", " )
			.append(rows).append(" as \"totalCount\" ");

		/**
		 * 1、判断是否有orderby
		 * 	如果有orderby，则直接使用orderby进行排序
		 * 	如果没有orderby，则默认使用第一个查询出的条件进行排序
		 */
		String orderby = sql.substring(7,tempSQL.indexOf(" from "));
		System.out.printf("orderby = {%s} \n",orderby);
		int indexOrderBy = tempSQL.lastIndexOf(" order by ");
		if(indexOrderBy != -1){
			orderby = sql.substring(indexOrderBy+10,sql.length());
			System.out.printf("orderby = {%s} \n",orderby);
			sql =  sql.substring(0,indexOrderBy);
			System.out.println("tempSQL = " + tempSQL);
		}else {
			orderby = orderby.substring(0,orderby.indexOf(","));
			System.out.printf("orderby = {%s} \n",orderby);
		}
		//创建排序，默认使用desc排序
		part.append(",rn=row_number() over(order by  ").append(orderby).append(" )");
		int index = tempSQL.indexOf(" from ");
		orderBySql.append(sql);
		orderBySql.insert(index, part);
		System.out.printf("orderBySql = {%s} \n",orderBySql);
		int start = ( page - 1 ) * limit + 1;
		int end = page*limit;
		pagingSql.append(orderBySql).append(") as t where t.rn between ").append(start).append(" and ").append(end);
		return pagingSql.toString();
	}
	
	
	

}
