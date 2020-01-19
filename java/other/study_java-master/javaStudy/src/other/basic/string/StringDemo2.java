package other.basic.string;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2020��1��7��
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
		//��ʽ��ԭʼsql
		tempSQL = tempSQL.toLowerCase().trim().replaceAll(" +", " "); 
		StringBuilder pagingSql = new StringBuilder("select * from (");
		/**
		 * 1���ڲ�ѯ��sql�����������
		 * 	�磺
		 * 		select id from table
		 * 	ת���ɣ�
		 * 		select id,10 as 'iRecCount',10 as 'totalCount'
		 */
		StringBuilder orderBySql = new StringBuilder();
		StringBuilder part = new StringBuilder(", ");
		part.append(rows).append(" as \"iRecCount\", " )
			.append(rows).append(" as \"totalCount\" ");

		/**
		 * 1���ж��Ƿ���orderby
		 * 	�����orderby����ֱ��ʹ��orderby��������
		 * 	���û��orderby����Ĭ��ʹ�õ�һ����ѯ����������������
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
		//��������Ĭ��ʹ��desc����
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
