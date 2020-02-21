package dao;

public class PagingControl {
	public int lineCnt; // 한 화면에 구성하는 글 개수
	public int pageCnt; // 한 화면의 페이지 개수
	public int postCnt; // 요구 사항을 만족하는 글의 전체 개수
	public int pgNum; //현재 페이지 넘버
	
	//변수 초기화
	public PagingControl() {
		this.lineCnt = 5;
		this.pgNum = 1;
	}
	//글의 개수에 따른 페이지 개수 계산
	public int getPageCount() {
		return ((this.postCnt-1)/this.lineCnt)+1;
	}
	//각 화면별 시작 페이지 번호
	public int getPageStart() {
		return ((this.pgNum-1)/this.pageCnt)*this.pageCnt + 1;
	}

	// 각 화면별 종료 페이지 번호
	public int getPageEnd() {
		if(getPageCount()-1<this.postCnt) {
			return getPageStart() + getPageCount();
		} else {
			return getPageStart() + this.postCnt;
		}
	}
	// 이전 페이지들이 있으면 이미지 출력
	public boolean isPreDate() {
		if(getPageStart() != 1) 
			return true;
			return false;
	}
	// 다음 페이지들이 있으면 이미지 출력
	public boolean isNextData() {
		if(getPageEnd() < getPageCnt())
			return true;
			return false;
	}
	
	//시작 행 넘버
	public int getWritingStart() {
		return 0;//종료행넘버 - this.lineCnt + 1;
	}
	//종료 행 넘버
	public int getWritingEnd() {
		return this.pgNum * this.lineCnt;
	}
	
	public int getLineCnt() {
		return lineCnt;
	}
	public void setLineCnt(int lineCnt) {
		this.lineCnt = lineCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getPostCnt() {
		return postCnt;
	}
	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}
	public int getPgNum() {
		return pgNum;
	}
	public void setPgNum(int pgNum) {
		this.pgNum = pgNum;
	}
	
	@Override
	public String toString() {
		return "PagingControl [lineCnt=" + lineCnt + ", pageCnt=" + pageCnt + ", postCnt=" + postCnt + ", pgNum="
				+ pgNum + ", getPageCount()=" + getPageCount() + ", getPageStart()=" + getPageStart()
				+ ", getPageEnd()=" + getPageEnd() + ", isPreDate()=" + isPreDate() + ", isNextData()=" + isNextData()
				+ ", getWritingStart()=" + getWritingStart() + ", getWritingEnd()=" + getWritingEnd()
				+ ", getLineCnt()=" + getLineCnt() + ", getPageCnt()=" + getPageCnt() + ", getPostCnt()=" + getPostCnt()
				+ ", getPgNum()=" + getPgNum() + "]";
	}
}
