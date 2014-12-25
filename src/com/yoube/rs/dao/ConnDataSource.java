package com.yoube.rs.dao;


import javax.naming.*;
import javax.sql.*;
import com.yoube.rs.*;

public class ConnDataSource {

	private static DataSource ConnDataSource=null;
	
	private static Context context=null;
	
	public static DataSource dataConn() { 
		
		if (ConnDataSource!=null){
			return ConnDataSource;
		}
		try{
			if(context==null){
				context = new InitialContext();
				
			}
			ConnDataSource  = (DataSource)context.lookup("OracleLocal");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return ConnDataSource;
		
	}
	
	
}
