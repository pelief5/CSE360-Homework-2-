import java.util.ArrayList;
import java.util.List;


public class Answers {
    private List<Answer> answersList;
    
    public Answers() {
        answersList = new ArrayList<>();
    }
    
  
    public boolean addAnswer(Answer a) {
        if (a.getText() == null || a.getText().trim().isEmpty()) {
            System.out.println("Error: Answer text cannot be empty.");
            return false;
        }
        answersList.add(a);
        System.out.println("Answer added successfully.");
        return true;
    }
    
   
    public boolean updateAnswer(int id, String newText) {
        for (Answer a : answersList) {
            if (a.getId() == id) {
                if (newText == null || newText.trim().isEmpty()) {
                    System.out.println("Error: Answer text cannot be empty.");
                    return false;
                }
                a.setText(newText);
                System.out.println("Answer updated successfully.");
                return true;
            }
        }
        System.out.println("Error: Answer not found.");
        return false;
    }
    
    
    public boolean removeAnswer(int id) {
        for (Answer a : answersList) {
            if (a.getId() == id) {
                answersList.remove(a);
                System.out.println("Answer removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Answer not found.");
        return false;
    }
    
  
    public List<Answer> getAnswersByQuestionId(int questionId) {
        List<Answer> result = new ArrayList<>();
        for (Answer a : answersList) {
            if (a.getQuestionId() == questionId) {
                result.add(a);
            }
        }
        return result;
    }
    
   
    public List<Answer> getAllAnswers() {
        return new ArrayList<>(answersList);
    }
}
