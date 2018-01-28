package com.example.s151304064;



public class Note {

	private Long id;
	private String title;
	private String content;
	
	
	public Note(){
		
	}
	public String toString(){
		return "Note [id="+id+", title="+title+", content="+content+"]";
	}
	public Note(Long id,String name,String number){
		this.id=id;
		this.content=name;
		this.content=number;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
