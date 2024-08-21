package db;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {
	@Select("select count(*) from board")
	int getCount();
	
	@Select(  "SELECT  *"
			+ "  FROM  (   SELECT  E.*, ROWNUM AS RN"
			+ "              FROM  (   SELECT  BOARD.NUM NUM,"
			+ "                                BOARD.WRITER WRITER,"
			+ "                                BOARD.TITLE TITLE,"
			+ "                                BOARD.CONTENT CONTENT,"
			+ "                                BOARD.REGTIME REGTIME,"
			+ "                                BOARD.HITS HITS,"
			+ "                                MEMBER.NAME NAME"
			+ "                          FROM  BOARD, MEMBER"
			+ "                         WHERE  BOARD.WRITER = MEMBER.MEMBERNO"
			+ "                         ORDER  BY NUM DESC) E)"
			+ " WHERE  RN BETWEEN #{start} AND #{listsize}")
	List<BoardDto> getList(Map<String, Integer> map);
	
	@Select(  " SELECT  BOARD.NUM NUM,"
			+ "			BOARD.WRITER WRITER,"
			+ "			BOARD.TITLE TITLE,"
			+ "			BOARD.CONTENT CONTENT,"
			+ "			BOARD.REGTIME REGTIME,"
			+ "			BOARD.HITS HITS,"
			+ "			MEMBER.NAME NAME"
			+ "	  FROM  BOARD, MEMBER"
			+ "	 WHERE  BOARD.WRITER = MEMBER.MEMBERNO"
			+ "	   AND	BOARD.NUM = #{num}")
	BoardDto getOne(int num);
	
	@Insert("insert into board values(seq_board.nextval, #{writer}, #{title}, #{content},"
			+ "			 #{regtime}, 0)")
	void insert(BoardDto dto);
	
	@Update("update board set title=#{title}, content=#{content}"
			+ "				where num = #{num}")
	void update(BoardDto dto);
	
	@Delete("delete from board where num=#{num}")
	void delete(int num);

	@Update("update board set hits = hits + 1 where num = #{num}")
	void incrementHits(int num);
}
