package service;

import db.MemberDao;
import db.MemberDto;

public class MemberService {
	private MemberDao dao = MemberDao.getInstance();
	
    public boolean login(String id, String pw) {
    	MemberDto dto = dao.selectOneById(id);
    	System.out.println(dto);
    	return dto.getPw().equals(pw);
    }
    
    public int getNoForLogin(String id, String pw) {
    	MemberDto dto = dao.selectOneById(id);
    	int result = dto.getPw().equals(pw)?dto.getMemberNo():0;
    	return result;
    }
    
    public void join(String id, String pw, String name) {
    	MemberDto dto = new MemberDto();
    	dto.setId(id);
    	dto.setPw(pw);
    	dto.setName(name);
    	dao.join(dto);
    }
}
