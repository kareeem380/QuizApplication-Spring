package ujfaA.springQuiz.dto;

import java.util.List;

public interface QuestionDTO {
	
	long getId();
	CreatedBy getCreatedBy();
	String getQuestionText();
	String getCorrectAnswer();
	List<String> getAnswers();
	
	public interface CreatedBy {
		String getUsername();
	}

}
