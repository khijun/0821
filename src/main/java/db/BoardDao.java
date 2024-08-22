package db;

import java.time.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapConfig;

public class BoardDao {

	SqlSession session;
	private BoardMapper bm;
	private static BoardDao dao = new BoardDao();
	
    private BoardDao() {
    	session = SqlMapConfig.getSqlMapInstance().openSession(true);
    	bm = session.getMapper(BoardMapper.class);
    }
    
    public static BoardDao getInstance() {
    	return dao;
    }
    // 현재 시간을 문자열 형태로 반환
    private String getCurrentTime() {
        return LocalDate.now() + " " +
               LocalTime.now().toString().substring(0, 8);
    }

    // 게시글 갯수 얻기
    public int getNumRecords() {
        return bm.getCount();
    }
    
    public int getNumRecordsByTitle(String title) {
    	return bm.getCountByTitle(title);
    }
    
    public int getNumRecordsByContent(String content) {
    	return bm.getCountByContent(content);
    }
    
    public int getNumRecordsByWriterName(String writerName) {
    	return bm.getCountByWriterName(writerName);
    }

    // 게시글 리스트 읽기
    public List<BoardDto> selectList(SearchDto searchDto) {
        return bm.getList(searchDto);
    }

    public BoardDto selectOne(int num) {
    	return bm.getOne(num);
    }
    
    public List<BoardDto> selectByTitle(SearchDto searchDto){
    	return bm.getListByTitle(searchDto);
    }
    
    public List<BoardDto> selectByContent(SearchDto searchDto){
    	return bm.getListByContent(searchDto);
    }
    
    public List<BoardDto> selectByWriterName(SearchDto searchDto){
    	return bm.getListByWriterName(searchDto);
    }
    
    public void insertOne(BoardDto dto) {
    	dto.setRegtime(getCurrentTime());
    	bm.insert(dto);
    }

    // DTO에 담긴 내용으로 게시글 데이터 업데이트
    public void updateOne(BoardDto dto) {
    	bm.update(dto);
    }

    // 지정된 글 번호의 레코드 삭제
    public void deleteOne(int num) {
    	bm.delete(num);
    }
    public void incrementHits(int num) {
    	bm.incrementHits(num);
    }
}