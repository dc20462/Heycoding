package dto;

public class PageMaker {
	//페이징하는 클래스
	private int pageSize=10; //한 페이지 당 들어갈 데이터
	private int startPage; //한 블럭의 첫 번째 페이지
	private int endPage; 
	private int currPage=1; //현재페이지
	private int start; //한 페이지의 첫 번째 레코드
	private int totalCount;
	private boolean prev; //이전버튼
	private boolean next;
	
	public PageMaker(int currPage, int totalCount) { //생성자
		this.currPage=currPage;
		this.totalCount=totalCount;
		
		start=(currPage-1)*pageSize; //각 페이지의 시작 레코드 : 필드는 1번, 레코드는 0번부터
		endPage=(int)(Math.ceil(currPage/(double)pageSize)*pageSize); //currPage정수
		startPage=(endPage-pageSize)+1;
		int totalPage=(int)(Math.ceil(totalCount/(double)pageSize));  // 33/10.0 = 3.3 -> 4
		
		if(endPage>totalPage)
			endPage = totalPage;
		
		//이전, 다음 버튼
		prev=startPage==1?false:true; //startPage가 1이면 거짓(버튼 nohow), 아니면 참
		next=endPage<totalPage?true:false; 
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getStart() {
		return start;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}
	
	
}
