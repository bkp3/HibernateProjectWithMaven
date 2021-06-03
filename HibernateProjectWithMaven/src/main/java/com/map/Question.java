package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int qustionId;
	private String question;

//	@OneToOne
//	@JoinColumn(name="a_id")
//	private Answer answer;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<Answer> answers;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int qustionId, String question, Answer answer) {
		super();
		this.qustionId = qustionId;
		this.question = question;
		// this.answer = answer;
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

//	public Answer getAnswer() {
//		return answer;
//	}
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}
//	
	public Question(int qustionId, String question, List<Answer> answers) {
		super();
		this.qustionId = qustionId;
		this.question = question;
		this.answers = answers;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
