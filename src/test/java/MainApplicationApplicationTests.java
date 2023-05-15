import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.example.Entities.Professor;
import org.example.Entities.Student;
import org.example.Repositories.ProfessorRepository;
import org.example.Repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainApplicationApplicationTests {
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void testCreateStudent(){
		Student student = new Student("Karim","bouaddi",5,4,"student");
		System.out.println("test : "+student);
		/*studentRepository.save(student);*/
	}
}
