package db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
	@Select("select * from member where memberNo= #{memberNo}")
	MemberDto selectOneByNo(int memberNo);
	@Select("select * from member where id = #{id}")
	MemberDto selectOneById(String id);
	@Select("select * from member")
	List<MemberDto> selectAll();
	@Insert("insert into member values(seq_member.nextval, sysdate, #{name}, #{id}, #{pw})")
	int insertOne(MemberDto dto);
	@Update("update member set name = #{name}, pw=#{pw} where memberNo = #{memberNo}")
	int updateOne(int memberNo);
	@Delete("delete from member where memberNo = #{memberNo}")
	int deleteOne(int memberNo);
}
