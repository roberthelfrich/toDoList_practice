import java.util.*;

public class ToDoList {

    public String _name;
    private ArrayList<ToDo> _toDoList;
    private ArrayList<ToDo> _doneList = new ArrayList<ToDo>();

    /**
     * First constructor initiates an empty ToDo List with a custom name
     * @param name the list's name 
     */
    public ToDoList(String name)
    {
        this._name = name; 
        this._toDoList = new ArrayList<ToDo>();
    }

    /**
     * Second constructor allows for creation of a ToDo List while also adding the first ToDo
     * @param name the list's name 
     * @param toDo the first ToDo to be added
     */
    public ToDoList(String name, ToDo toDo)
    {
        this(name);
        _toDoList.add(toDo);
    }

    /**
     * Method to return all the tasks that have already been completed
     * @return ArrayList with all the completed tasks 
     */
    public ArrayList<ToDo> getCompletedTasks()
    {
        return this._doneList;
    }
    
    /**
     * Helper Method to check whether or not a task has already been completed
     */
    public boolean isDone(ToDo toDo)
    {
        if (toDo != null)
        {
            return toDo.getStatus();
        }
        return false;
    }

    /**
     * Adds any amount of tasks to the list
     * @param toDos tasks to be added
     */
    public void addTask(ToDo toDo)
    {
        if (toDo != null)
        {
            _toDoList.add(toDo);
            System.out.println(toDo + " added to " + this._name + "!");
        }
        else 
        {
            System.out.println("Task coudn't be added!");
            System.out.println("\n");
        }
    }

    /**
     * Method to check off a task and remove it from the ToDoList
     * @param task task to be checked off 
     */
    public void checkOffTask(ToDo task)
    {
        if (!isDone(task))
        {
            task.checkOff();
            _toDoList.remove(task);  
            System.out.println(task + " was removed from " + this._name + "!");   
            System.out.println("\n");
            _doneList.add(task);
        }
        else
        {
            System.out.println("'" + task + "' has already been completed!");
        }
    }

    /**
     * Method to sort the ToDoList from 'high' (top) to 'low' (bottom)
     */
    public void sortList() {
        if (_toDoList.size() > 0 && _toDoList != null) 
        {
            ArrayList<ToDo> high = new ArrayList<>();
            ArrayList<ToDo> medium = new ArrayList<>();
            ArrayList<ToDo> low = new ArrayList<>();
            for (ToDo toDo : _toDoList)
            {
                if (toDo.getPriority().equals("low"))
                {
                    low.add(toDo);
                }
                else if (toDo.getPriority().equals("medium"))
                {
                    medium.add(toDo);
                }
                else if (toDo.getPriority().equals("high"))
                {
                    high.add(toDo);
                }
            }
            _toDoList.clear();
            copyOver(high, _toDoList);
            copyOver(medium, _toDoList);
            copyOver(low, _toDoList);
            System.out.println(_name + " is now sorted: ");
            printList();
        } 
        else 
        {
            System.out.println(this._name + " is empty!");
            System.out.println("\n");
        }
    }

    /**
     * Helper method for the sortList() method
     * Copies contents from listOne into listTwo and clears listOne after
     * @param listOne
     * @param listTwo
     */
    public void copyOver(ArrayList<ToDo> listOne, ArrayList<ToDo> listTwo)
    {
        if (listOne != null && listTwo != null && listOne.size() >= 0 && listTwo.size() >= 0)
        {
            for (ToDo toDo : listOne)
            {
                listTwo.add(toDo);
            }
            listOne.clear();
        }
        else
        {
            System.out.println("At least one of the given lists is empty or non existent!");
            System.out.println("\n");
        }
    }

    /**
     * Method to print a formatted version of the ToDo List to the console 
     */
    public void printList()
    {
        for (int i = 0; i < _toDoList.size(); i++)
        {
            System.out.println(i + 1 + ". " + _toDoList.get(i));
        }
        System.out.println("\n");
    }

    /**
     * Method to move a specific ToDo to any position within the ToDo List
     * @param toDo
     * @param position actual position within the ToDoList, not the index! 
     */
    public void moveToPosition(ToDo toDo, int position) 
    {
        if (!isDone(toDo))
        {
            if (position > 0 && position < _toDoList.size() + 1) {
                _toDoList.remove(toDo);
                _toDoList.add(position - 1, toDo);
            } else {
                System.out.println("Invalid position!");
                System.out.println("\n");
            }
        }
        else
        {
            System.out.println("'" + toDo + "' has already been completed!");
        }
        
    }

    public static void main(String[] args)
    {
        // ToDos for testing 
        ToDo first = new ToDo("Cook Dinner", "faMily", "medium");
        ToDo second = new ToDo("Do Homework", "school", "high", "2024-09-25");
        ToDo third = new ToDo("Grab Coffee", "friends", "low");
        ToDo fourth = new ToDo("Do Dishes", "family", "medium");
        ToDo fifth = new ToDo("Pack Bag" ,"School", "low");
        ToDo sixth = new ToDo("Buy Flowers" ,"Relationship", "high");
        ToDo seventh = new ToDo("Research Recipes" ,"family", "medium");

        ToDoList firstList = new ToDoList("Test List");

        firstList.addTask(first);
        firstList.addTask(second);
        firstList.addTask(third);
        firstList.addTask(fourth);
        firstList.addTask(fifth);
        firstList.addTask(sixth);
        firstList.addTask(seventh);

        firstList.sortList();
        //firstList.checkOffTask(second);

        //print out category for each toDo
        for (ToDo toDo : firstList._toDoList)
        {
            System.out.println("'" + toDo.getTask()+ "'" + " falls under the category: " + toDo.getCategory());
        }
        System.out.println("\n");
        
        firstList.printList();

        first.setPriority("uninteresting");
        first.setPriority("high");
        firstList.moveToPosition(first, 3);
        firstList.moveToPosition(third, 3);
        firstList.printList();

        firstList.checkOffTask(second);
        firstList.checkOffTask(second);
        firstList.checkOffTask(second);


        System.out.println(firstList.getCompletedTasks() + "\n");
        firstList.printList();
    }
}

