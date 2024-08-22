package db;

import java.util.List;

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
			+ " WHERE  RN BETWEEN #{start} AND #{end}")
	List<BoardDto> getList(SearchDto searchDto);
	
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
			+ "							  AND  BOARD.TITLE like #{searchKeyword}"
			+ "                         ORDER  BY NUM DESC) E)"
			+ " WHERE  RN BETWEEN #{start} AND #{end}")
	List<BoardDto> getListByTitle(SearchDto searchDto);
	
	@Select("select count(*) from board where title like #{title}")
	int getCountByTitle(String title);
	
	
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
			+ "							  AND  BOARD.CONTENT like #{searchKeyword}"
			+ "                         ORDER  BY NUM DESC) E)"
			+ " WHERE  RN BETWEEN #{start} AND #{end}")
	List<BoardDto> getListByContent(SearchDto searchDto);
	
	@Select("select count(*) from board where content like #{content}")
	int getCountByContent(String content);
	
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
			+ "							  AND  MEMBER.NAME like #{searchKeyword}"
			+ "                         ORDER  BY NUM DESC) E)"
			+ " WHERE  RN BETWEEN #{start} AND #{end}")
	List<BoardDto> getListByWriterName(SearchDto searchDto);
	
	@Select("  SELECT  COUNT(*)"
			+ "  FROM  BOARD, MEMBER"
			+ " WHERE  BOARD.WRITER = MEMBER.MEMBERNO"
			+ "   AND  MEMBER.NAME LIKE #{writerName}")
	int getCountByWriterName(String writerName);
	
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
