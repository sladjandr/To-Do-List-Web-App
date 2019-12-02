package todolist.web.app.ToDoListWebApp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDoItem {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String text;
	private Date date;
	
	public ToDoItem() {

	}
	
	public ToDoItem(Long id, String title, String text, Date date) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = date;
	}
	
	public ToDoItem(String title, String text, Date date) {
		this.title = title;
		this.text = text;
		this.date = date;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
