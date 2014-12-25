package com.yoube.rs;
import javax.ws.rs.*;

import javax.ws.rs.core.*;
import java.sql.*;
import com.yoube.rs.dao.*;


@Path("/status")
public class ViStatus {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getStatus() {
        // Return some cliched textual content
        return "<p><b>Request received</b></p>";
    }
	@Path("/date")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getDataConn() throws Exception{
      PreparedStatement query=null;
      String myString=null;
      String yourString=null;
      Connection conn=null;
     
      try{
    	 conn=ConnDataSource.dataConn().getConnection();
    	 query=conn.prepareStatement("select SYSDATE AS DATEM from dual");
    	 ResultSet rs=query.executeQuery();
    	 
    	 while(rs.next()){
    		 myString=rs.getString("DATEM");
    	 }
    	 System.out.println(myString);
    	 query.close();
    	 yourString="<p>Today's Date"+myString+"</p>";
    	  
      }catch(Exception e){
    	  e.printStackTrace();
      }
      
      finally{
    	  if(conn!=null)
    		  conn.close();
      }
      
        return yourString;
    }
	
	
}
