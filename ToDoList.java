import java.util.*;

public class ToDoList {

    public String _name;
    private ArrayList<ToDo> _toDoList;
    private Iterator<ToDo> _iterator;

    /**
     * First constructor initiates an empty ToDo List with a custom name
     * @param name the list's name 
     */
    public ToDoList(String name)
    {
        _name = name; 
        _toDoList = new ArrayList<ToDo>();
        _iterator = _toDoList.iterator();
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

    public void checkOffTask(ToDo task)
    {
        task.checkOff();
        _toDoList.remove(task);  
        System.out.println(task + "was removed from " + this._name + "!");   
        System.out.println("\n");
    }

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

    public void moveToTop(ToDo toDo)
    {
        ToDo toDoTemp = _toDoList.get(_toDoList.indexOf(toDo));
        _toDoList.remove(toDo);
        _toDoList.add(_toDoList.size() - 1, toDoTemp);
    }

    public void moveToBottom(ToDo toDo)
    {
        ToDo toDoTemp = _toDoList.get(_toDoList.indexOf(toDo));
        _toDoList.remove(toDo);
        _toDoList.add(0, toDoTemp);
    }
    
    public void printList()
    {
        for (int i = 0; i < _toDoList.size(); i++)
        {
            System.out.println(i + 1 + ". " + _toDoList.get(i));
        }
        System.out.println("\n");
    }

    public void moveToPosition(ToDo toDo, int position) 
    {
        if (position >= 0 && position < _toDoList.size()) {
            _toDoList.remove(toDo);
            _toDoList.add(position, toDo);
        } else {
            System.out.println("Invalid position!");
            System.out.println("\n");
        }
    }

    public static void main(String[] args)
    {
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

        firstList.printList();
        firstList.sortList();

        firstList.moveToBottom(first);
        firstList.printList();

    }
}

