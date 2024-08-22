package db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class SearchDto {
	private int pageNo;
	private int listSize;
	private int start;
	private int end;
	private String searchBy;
	private String searchKeyword;

	public SearchDto(int pageNo, int listSize, String searchBy, String searchKeyword) {
		this.pageNo = pageNo;
		this.listSize = listSize;
		this.start = (pageNo - 1) * this.listSize + 1;
		this.end = pageNo * this.listSize;
		this.searchBy = searchBy;
		this.searchKeyword = searchKeyword;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
}