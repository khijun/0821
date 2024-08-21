package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.*;

import db.BoardDao;
import db.BoardDto;

public class BoardService {

	private BoardDao dao = BoardDao.getInstance();
    private static final int listSize = 5;
    private static final int paginationSize = 3;

    public List<BoardDto> getMsgList(int pageNo) {
    	Map<String, Integer> param = new HashMap<String, Integer>();
    	param.put("start", (pageNo-1) * listSize+1);
    	param.put("listsize", pageNo * listSize);
    	return dao.selectList(param);
    }

    public ArrayList<Pagination> getPagination(int pageNo) {

        ArrayList<Pagination> pgnList = new ArrayList<Pagination>();

        int numRecords = dao.getNumRecords();
        int numPages = (int)Math.ceil((double)numRecords / listSize);

        int firstLink = ((pageNo - 1) / paginationSize)
                        * paginationSize + 1;
        int lastLink = firstLink + paginationSize - 1;
        if (lastLink > numPages) {
            lastLink = numPages;
        }

        if (firstLink > 1) {
            pgnList.add(
                   new Pagination("이전", pageNo - paginationSize, false));
        }

        for (int i = firstLink; i <= lastLink; i++) {
            pgnList.add(new Pagination("" + i, i, i == pageNo));
        }

        if (lastLink < numPages) {
            int tmpPageNo = pageNo + paginationSize;
            if (tmpPageNo > numPages) {
                tmpPageNo = numPages;
            }
            pgnList.add(new Pagination("다음", tmpPageNo, false));
        }

        return pgnList;
    }


    public BoardDto getMsg(int num) {
        BoardDto dto = dao.selectOne(num);

        dto.setTitle(dto.getTitle().replace (" ",  "&nbsp;"));
        dto.setContent(dto.getContent().replace(" ",  "&nbsp;")
                                       .replace("\n", "<br>"));

        return dto;
    }

    public BoardDto getMsgForWrite(int num) {
        return dao.selectOne(num);
    }

    public void writeMsg(int writer, String title, String content)
            throws Exception {

        if (writer == 0||
        	title   == null || title.length()   == 0 ||
            content == null || content.length() == 0) {
        	System.out.println("에러남?");
           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        BoardDto dto = new BoardDto();
        dto.setWriter(writer);
        dto.setTitle  (title  );
        dto.setContent(content);

        dao.insertOne(dto);
    }

    public void updateMsg(
            String title, String content, int num)
                    throws Exception {

        if (num == 0||
        	title   == null || title.length()   == 0 ||
            content == null || content.length() == 0) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        BoardDto dto = new BoardDto();
        dto.setNum    (num    );
        dto.setTitle  (title  );
        dto.setContent(content);

        dao.updateOne(dto);
    }

    public void deleteMsg(int num) {
        dao.deleteOne(num);
    }
}