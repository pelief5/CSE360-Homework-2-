import java.util.ArrayList;
import java.util.List;


public class Questions {
    private List<Question> questionsList;
    
    public Questions() {
        questionsList = new ArrayList<>();
    }
    
   
    public boolean addQuestion(Question q) {
        if (q.getText() == null || q.getText().trim().isEmpty()) {
            System.out.println("Error: Question text cannot be empty.");
            return false;
        }
      
        for (Question existing : questionsList) {
            if (existing.getText().equalsIgnoreCase(q.getText())) {
                System.out.println("Error: Duplicate question.");
                return false;
            }
        }
        questionsList.add(q);
        System.out.println("Question added successfully.");
        return true;
    }
    
   
    public boolean updateQuestion(int id, String newText, String newCategory) {
        for (Question q : questionsList) {
            if (q.getId() == id) {
                if (newText == null || newText.trim().isEmpty()) {
                    System.out.println("Error: Question text cannot be empty.");
                    return false;
                }
               
                for (Question other : questionsList) {
                    if (other.getId() != id && other.getText().equalsIgnoreCase(newText)) {
                        System.out.println("Error: Duplicate question text.");
                        return false;
                    }
                }
                q.setText(newText);
                q.setCategory(newCategory);
                System.out.println("Question updated successfully.");
                return true;
            }
        }
        System.out.println("Error: Question not found.");
        return false;
    }
    
    
    public boolean removeQuestion(int id) {
        for (Question q : questionsList) {
            if (q.getId() == id) {
                questionsList.remove(q);
                System.out.println("Question removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Question not found.");
        return false;
    }
    
   
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questionsList);
    }
    
    
    public Question getQuestionById(int id) {
        for (Question q : questionsList) {
            if (q.getId() == id)
                return q;
        }
        return null;
    }
    
   
    public List<Question> searchQuestions(String keyword) {
        List<Question> result = new ArrayList<>();
        for (Question q : questionsList) {
            if (q.getText().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(q);
            }
        }
        return result;
    }
}
