package com.jdbc;

import java.sql.* ;

public class DataBaseConnection
{
	String DBDRIVER			= "com.mysql.jdbc.Driver" ;
	String DBURL			= "jdbc:mysql://localhost:3306/school?useunicode=true&characterencoding=utf8" ;
	String DBUSER			= "root" ;
	String DBPASSWORD		= "root" ;
	Connection conn			= null ;
	public DataBaseConnection()
	{
		try
		{  
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
			
		}
		catch (Exception e)
		{
		}
	}
	public Connection getConnection()
	{
		return this.conn ;
	}
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
		}
	}
	public static void main(String args[]){
		DataBaseConnection dc=new DataBaseConnection();
	}
};
