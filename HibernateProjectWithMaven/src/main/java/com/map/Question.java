package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@Column(name="question_id")
	private int qustionId;
	private String question;
	
	@OneToOne
	@JoinColumn(name="a_id")
	private Answer answer;
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int qustionId, String question, Answer answer) {
		super();
		this.qustionId = qustionId;
		this.question = question;
		this.answer = answer;
	}
	public int getQustionId() {
		return qustionId;
	}
	public void setQustionId(int qustionId) {
		this.qustionId = qustionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	
	

}
