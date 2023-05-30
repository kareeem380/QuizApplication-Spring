package ujfaA.springQuiz.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.UniqueElements;
import lombok.Getter;
import lombok.Setter;


@Entity @EntityListeners(AuditingEntityListener.class)
@Table(name="questions")
@Getter @Setter
public class Question{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id")
	private long id;
	
	@CreatedBy
	@ManyToOne(targetEntity = User.class, optional = false)
	@JoinColumn(name="created_by_user", referencedColumnName = "user_id", nullable = false)
	private User createdBy;

	@NotBlank
	@Column(nullable = false)
	private String questionText;
	
	@Column(nullable = false)
	private String correctAnswer;
	@NotEmpty()
	@UniqueElements(message = "Questions kif-kif ")
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
	@OrderColumn(name = "ordinal", columnDefinition = "tinyint") 
	@Column(name = "answer", nullable = false)
	private List<@NotBlank String> answers = new ArrayList<String>();

	@Transient
	private int selectedAnswerIndex;



	public Question() {
	}
	
	@Override
	public String toString() {
		return questionText;
	}




}
