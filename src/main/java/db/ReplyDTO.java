package db;

public class ReplyDTO {
	private int replyNo;
	private String regdate;
	private boolean updated;
	private String content;
	private int boardNo;
	private int memberNo;
	
	public ReplyDTO(int replyNo, String regdate, boolean updated, String content, int boardNo, int memberNo) {
		this.replyNo = replyNo;
		this.regdate = regdate;
		this.updated = updated;
		this.content = content;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
	}
	public ReplyDTO(String content, int boardNo, int memberNo) {	// insert용
		this(0, "", false, content, boardNo, memberNo);
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	
}
