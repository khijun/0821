package db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapConfig;

public class MemberDao {
	SqlSession session;
	MemberMapper mm;
	private static MemberDao dao = new MemberDao();
	
	public MemberDao() {
		session = SqlMapConfig.getSqlMapInstance().openSession(true);
		mm = session.getMapper(MemberMapper.class);
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public MemberDto selectOneByNo(int memberNo) {
		return null;
	}
	
	public MemberDto selectOneById(String id) {
		return mm.selectOneById(id);
	}
	
	public List<MemberDto> selectAll(){
		return mm.selectAll();
	}
	
	public void join(MemberDto dto) {
		mm.insertOne(dto);
	}
}
