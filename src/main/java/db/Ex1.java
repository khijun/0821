package db;

public class Ex1 {
	public static void main(String[] args) {
		BoardDao dao = BoardDao.getInstance();
		System.out.println(dao.getNumRecordsByContent("%내용%"));
		System.out.println(dao.getNumRecordsByWriterName("%홍%"));
		
	}
}
