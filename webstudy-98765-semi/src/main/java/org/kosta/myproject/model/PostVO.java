package org.kosta.myproject.model;

public class PostVO {
	private long no;
	private String title;
	private String content;
	private long hits;
	private String timePosted;
	private MemberVO memberVO;

	public PostVO() {
		super();
	}

	public PostVO(long no, String title, String content, long hits, String timePosted, MemberVO memberVO) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.timePosted = timePosted;
		this.memberVO = memberVO;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public String getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "PostVO [no=" + no + ", title=" + title + ", content=" + content + ", hits=" + hits + ", timePosted="
				+ timePosted + ", memberVO=" + memberVO + "]";
	}

}
