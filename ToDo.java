import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * This class implements ToDo's that can which can be stored in an instance of the ToDoList class
 */
public class ToDo {

public boolean _isDone; 
public String _category; 
public String _priority;
public LocalDate _deadline; 
public String _name;

/**
 * First construcor
 * Parameters set the values for class fields: 
 * @param task
 * @param category
 * @param priority
 */
public ToDo(String task, String category, String priority)
{
    this.setTask(task);
    setCategory(category);

    if (isValidPriority(priority))
    {
        setPriority(priority);
    }
    else 
    {
        _priority = null;
        System.out.println("Choose a priority of 1 (low), 2 (medium) or 3 (high)!");
    }
}
/**
 * Second constructor with deadline parameter 
 * @param task
 * @param category
 * @param priority
 * @param deadline
 */
public ToDo(String task, String category, String priority, String deadline)
{
    this(task, category, priority); //calls the preceding construcor with given arguments 
    setDeadline(deadline);
}
    
/**
 * Third contrucor to just set the name  
 * @param task the name 
 */
public ToDo(String task)
{
    setTask(task);
}


public String toString()
{
    return ""+ _name + " (" + getPriority() + " priority)";
}

/**
 * Checks whether a given String is a valid priority. Priorities can only be "low", "medium" or "high" (not case sensititve).
 * 
 * @param priority string to check
 * @return true if valid, else false
 */
public boolean isValidPriority(String priority)
{
    String[] strings = {"low", "medium", "high"};

    for (String string : strings)
    {
        if (priority.equalsIgnoreCase(string))
        {
            return true;
        }
    }
    return false;
}

/**
 * Sets the ToDo's priority
 * @param priority the priority 
 */
public void setPriority(String priority)
{
    if (isValidPriority(priority))
    {
        _priority = priority.toLowerCase();
    }
    else
    {
        System.out.println("Invalid priotiy! \n Valid prioties: \n low \n medium \n high \n Prioity was set to null!");
    }
}

/**
 * Checks off a task
 */
public void checkOff()
{
    _isDone = true;
}

/**
 * Sets the name for the ToDo
 * @param task the name 
 */
public void setTask(String task)
{
    if (task != null && !task.isEmpty()) // Check if the String is empty or null
    {
        int length = task.length(); 
        if (length <= 20 && length >= 2) // Check if the String has the appropriate length 
        {
            _name = task.toLowerCase(); 
        }
        else 
        {
            System.out.println("Invalid name for the task!");
        }
    }
    else 
    {
        System.out.println("Invalid name for the task!");
    }
}

/**
 * Sets the ToDo's category 
 * @param category the category 
 */
public void setCategory(String category)
{
    if (category != null && !category.isEmpty()) // Check if the String is empty or null
    {
        int length = category.length(); 
        if (length <= 20 && length >= 2) // Check if the String has the appropriate length 
        {
            this._category = category.toLowerCase(); 
        }
    }
    else 
    {
        System.out.println("Invalid name for the category!");
    }
}

/**
 * Sets the deadline for the ToDo
 * @param deadline the deadline 
 */
public void setDeadline(String deadline) {
    if (deadline != null && !deadline.isEmpty()) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate parsedDeadline = LocalDate.parse(deadline, formatter);

            // Check if the deadline has been exceeded
            if (parsedDeadline.isBefore(LocalDate.now())) {
                System.out.println("The deadline has been exceeded!");
            } else {
                _deadline = parsedDeadline;
            }
        } catch (Exception e) {
            System.out.println("Invalid date format for the deadline!");
        }
    } else {
        // No deadline specified
        _deadline = null;
    }
}

/**
 * Gets the ToDo's deadline 
 * @return
 */
public LocalDate getDeadline()
{
    return _deadline;
}

/**
 * Gets the ToDo's category
 */
public String getCategory()
{
    return _category;
}

/**
 * Gets the ToDo's name
 * @return the name
 */
public String getTask()
{
    return _name;
}

/**
 * Gets the ToDo's priority
 * @return the priority 
 */
public String getPriority()
{
    return _priority;
}
}
