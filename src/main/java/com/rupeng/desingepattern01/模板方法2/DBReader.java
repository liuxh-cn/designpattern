package com.rupeng.desingepattern01.模板方法2;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBReader {
	/**
	 * 创建连接
	 * protected 不希望别人调，只希望自己子类调用
	 * @return
	 */
	protected abstract Connection createConnection() throws SQLException;
	/**
	 * 处理结果
	 * @throws SQLException 
	 */
	protected abstract void processResultSet(ResultSet rs) throws SQLException;
	
	public void executeQuery(String sql, Object... objects){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = createConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objects.length;i++){
				ps.setObject(i+1, objects[i]);
			}
			rs = ps.executeQuery();
			processResultSet(rs);
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}finally{
			close(rs);
			close(ps);
			close(conn);
		}
	}
	
	private void close(AutoCloseable c){
		if(c != null){
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
