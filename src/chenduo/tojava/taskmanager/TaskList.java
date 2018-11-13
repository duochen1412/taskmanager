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
        System.out.println("Do tasks in the list: " + index);
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
        System.out.println("Task has been add into task list!");
    }

    /**
     * Clear all task in task list
     */

    public void clearTask(){
        tasks.clear();
        System.out.println("Your task list is empty now!");
    }

    /**
     * Delete specified task in task list
      */
    public void deleteSpecTask(String line){
        int index = Integer.parseInt(line.substring("delete".length()).trim());
        tasks.remove(index-1);
        System.out.println("Task  " + index + "  has been deleted from list!");
    }

    /**
     * Modify the task content in task list
     */
    public void modifyContent(String line){
        String[] cmdStr = line.split("/setdesc",-1);
        String  content = cmdStr[1].trim();
        int index = Integer.parseInt(cmdStr[0].substring("modifyC ".length()).trim());
        this.tasks.get(index - 1).setContent(content);
        System.out.println("Task  " + index + "  has been changed!");
    }

    /**
     *
     * @param line
     */
    public void modifyDeadline(String line){
        String[] cmdStr = line.split("/setdeadline",-1);
        String  deadline = cmdStr[1].trim();
        int index = Integer.parseInt(cmdStr[0].substring("modifyD ".length()).trim());
        Task t = this.tasks.get(index - 1);
        if(t instanceof Deadline){
            ((Deadline) t).setDeadline(deadline);
            System.out.println("Task deadline  " + index + "  has been changed!");

        }
        else if (t instanceof Todo && !(t instanceof Deadline)){
            System.out.println("Sorry your chose a task without deadline");
        }
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
