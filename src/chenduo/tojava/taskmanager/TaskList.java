package chenduo.tojava.taskmanager;
import java.util.*;
/**
 * Represents task list and actions
 * @author Chen Duo
 * @since 20.10.2018
 */
public class TaskList {
    private List<Task> tasks;
    public TaskList(){}
    public TaskList(List<Task> tasks){
        this.tasks=tasks;
    }

    /**
     * Update task status
     * @param line
     */
    public void markAsDone(String line) {
        int index = Integer.parseInt(line.substring("done".length()).trim());
        this.tasks.get(index - 1).setDone(true);
        System.out.println("Do tasks in the list: " + tasks.size());
    }

    /**
     * Print all tasks from list
     */
    public void printTasks() {
        System.out.println("tasks.size() "+tasks.size());
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + tasks.get(i).getDescription());
        }
    }

    /**
     * Add new task to task list
     * @param t <code>Task</code> object
     */
    public void addTask(Task t){
        tasks.add(t);
    }

    /**
     * Clear all task in task list
     */

    public void clearTask(){
            tasks.clear();}

    /**
     * Delete specified task in task list
      */
    public void deleteSpecTask(){
        int index = Integer.parseInt(line.substring("done".length()).trim());
        this.tasks.get(index - 1).remove();
    }

    /**
     * Save task list to file.
     * @throws TaskManagerException
     */
    public void saveTasks() throws TaskManagerException{
        try {
            Storage.save(tasks);
        }catch (TaskManagerException e){
            throw new TaskManagerException(e.getMessage());
        }
    }


}
