package fi.softala.jee.aanestys.dao;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.jee.aanestys.bean.Aani;
import fi.softala.jee.aanestys.bean.AaniImpl;

@Repository
public class AaniDAOImpl implements AaniDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Aani Aani) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int AaniID) {
		// TODO Auto-generated method stub
		
	}

	public Aani get(int AaniInt) {
		String sql = "SELECT * FROM Aani WHERE AaniID="+AaniInt+";";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Aani>() {
			
			public Aani extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Aani aa = new AaniImpl();
					aa.setAaniID(rs.getInt("AaniID"));
					aa.setAanestysID(rs.getInt("AanestysID"));
					aa.setVaihtoehtoID(rs.getInt("VaihtoehtoID"));
					return aa;
				}
				return null;
			}
		});
		
	}

	public List<Aani> lista() {
		String sql = "SELECT * FROM Aani;";
		List<Aani> aaniLista = jdbcTemplate.query(sql, new RowMapper<Aani>(){
		
			public Aani mapRow(ResultSet rs, int rowNum) throws SQLException {
				Aani aa = new AaniImpl();
			
				aa.setAaniID(rs.getInt("AaniID"));
				aa.setAanestysID(rs.getInt("AanestysID"));
				aa.setVaihtoehtoID(rs.getInt("VaihtoehtoID"));
			
				return aa;
	
			}
		
		});
		return aaniLista;
	

	}
}