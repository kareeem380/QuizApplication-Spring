package ujfaA.springQuiz.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.UniqueElements;

import lombok.AccessLevel;
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

	@Transient
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private int hash;
	@Transient
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private boolean hashIsZero;
	
	
	public Question() {
	}
	
	@Override
	public String toString() {
		return questionText;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if ( ! (obj instanceof Question))
			return false;
		Question otherQ = (Question) obj;
		if ( ! this.questionText.equals(otherQ.questionText))
			return false;
		/* Check if answers are the same - irrelevant of order. */
		return new HashSet<>(this.answers).equals(new HashSet<>(otherQ.answers));
	}

	@Override
	public int hashCode() {
		
		int h = hash;
		if (h == 0 && !hashIsZero) {
			h = questionText.hashCode();
			for (String ans : answers) {
				h += ans.hashCode();
			}
			if (h == 0) {
				hashIsZero = true;
			} else {
				hash = h;
			}
		}
		return h;
	}

}
