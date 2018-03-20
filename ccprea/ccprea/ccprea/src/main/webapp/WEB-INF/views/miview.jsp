<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.io.*" %>

<%@ page import = "com.tobesoft.platform.*" %>
<%@ page import = "com.tobesoft.platform.data.*" %>
<%!
	public String rsGet(ResultSet rs, String id) throws Exception{
		
		if(rs.getString(id) == null)
			return "";
		else
			return rs.getString(id);
	}
%>
<%
	 VariableList v1 = new VariableList();
	 DatasetList d1 = new DatasetList();

%>

<%
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.5:1521:XE","giantstudy","gs123");
	stmt = conn.createStatement();
	
	try{
		
		//String name = request.getParameter("name");
		String SQL;
		
		SQL = "select * from B_EMPLOYEE";
		rs = stmt.executeQuery(SQL);
%>




<%
	Dataset ds = new Dataset("b_sign");
	ds.addColumn("EMP_NUM", ColumnInfo.CY_COLINFO_INT, 20);
	ds.addColumn("EMP_NAME", ColumnInfo.CY_COLINFO_STRING, 20);
	ds.addColumn("BIRTH_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
	ds.addColumn("ADDRESS", ColumnInfo.CY_COLINFO_STRING, 20);
	ds.addColumn("ENTRY_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
	ds.addColumn("LEAVE_DAY", ColumnInfo.CY_COLINFO_DATE, 20);
	ds.addColumn("PASSWORD", ColumnInfo.CY_COLINFO_STRING, 20);
	ds.addColumn("RANK_SEQ", ColumnInfo.CY_COLINFO_INT, 20);
	ds.addColumn("DEPARTMENT_NUM", ColumnInfo.CY_COLINFO_INT, 20);
	
	
	while(rs.next()){
		int row = ds.appendRow();
		ds.setColumn(row, "EMP_NUM", rsGet(rs,"EMP_NUM"));
		ds.setColumn(row, "EMP_NAME", rsGet(rs,"EMP_NAME"));
		ds.setColumn(row, "BIRTH_DAY", rsGet(rs,"BIRTH_DAY"));
		ds.setColumn(row, "ADDRESS", rsGet(rs,"ADDRESS"));
		ds.setColumn(row, "ENTRY_DAY", rsGet(rs,"ENTRY_DAY"));
		ds.setColumn(row, "LEAVE_DAY", rsGet(rs,"LEAVE_DAY"));
		ds.setColumn(row, "PASSWORD", rsGet(rs,"PASSWORD"));
		ds.setColumn(row, "RANK_SEQ", rsGet(rs,"RANK_SEQ"));
		ds.setColumn(row, "DEPARTMENT_NUM", rsGet(rs,"DEPARTMENT_NUM"));
	}
	
	d1.addDataset(ds);
	
	v1.addStr("ErrorCode", "0");
	v1.addStr("ErrorMsg", "SUCC");
	
	}catch(Exception ex){
		v1.addStr("ErrorCode", "-1");
		v1.addStr("ErrorMsg", ex.getMessage());
	}
%>
<%

	if(stmt != null) try{stmt.close();}catch(Exception e1){}
	if(conn != null) try{conn.close();}catch(Exception e1){}
	
%>


<%
	out.clearBuffer();
	PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "euc-kr");
	pRes.sendData(v1,d1);
%>