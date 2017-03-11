package com.seda.qoe.dto.questionary;

public class QuestionarySearchDTO {

	private String questionarySearchAttribute;
	
	public QuestionarySearchDTO(){}

	public String getQuestionarySearchAttribute() {
		return questionarySearchAttribute;
	}

	public void setQuestionarySearchAttribute(String questionarySearchAttribute) {
		this.questionarySearchAttribute = questionarySearchAttribute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((questionarySearchAttribute == null) ? 0
						: questionarySearchAttribute.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof QuestionarySearchDTO))
			return false;
		QuestionarySearchDTO other = (QuestionarySearchDTO) obj;
		if (questionarySearchAttribute == null) {
			if (other.questionarySearchAttribute != null)
				return false;
		} else if (!questionarySearchAttribute
				.equals(other.questionarySearchAttribute))
			return false;
		return true;
	}
	
}
