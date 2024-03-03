import java.time.LocalDate;

public class DeadlineToDo extends ToDo {

    public LocalDate _deadline; 
    
    public DeadlineToDo(String task, String category, String priority, LocalDate deadline)
    {
        super(task, category, priority);
        this._deadline = deadline;
    }

    
}
