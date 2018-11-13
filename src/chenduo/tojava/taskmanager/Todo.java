package chenduo.tojava.taskmanager;
/**
 * Represents deadline task. A <code>Todo</code> task constructed by task description and status.
 * @author Chen Duo
 * @since 20.10.2018
 */
public class Todo extends Task{
    public Todo(String taskContent){
        super(taskContent);
    }
    public Todo(String taskContent, boolean isDone){
        super(taskContent, isDone);
    }

    /**
     * Print description of content and status of a task
     * @return description of task
     */
    public String getDescription(){
        if(this.isDone)
            return this.taskContent+"\n\tis done? Yes";
        else return this.taskContent+"\n\tis done? No";
    }

}
