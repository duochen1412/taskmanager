package chenduo.tojava.taskmanager;
/**
 * Represents deadline task. A <code>Deadline</code> task constructed by task description, status and date of deadline
 * @author Chen Duo
 * @since 20.10.2018
 */
public class Deadline extends Todo{
    private String deadlineDate;
    public Deadline(String content, String deadlineDate){
        super(content);
        this.deadlineDate=deadlineDate;
    }
    public Deadline(String content,boolean isDone, String deadlineDate){
        super(content, isDone);
        this.deadlineDate=deadlineDate;
    }

    /**
     * @return Description and Date.
     */
    public String getDescription(){
        if(this.isDone)
            return this.taskContent+"\n\tis done? Yes\n\tdo by: "+deadlineDate;
        else return this.taskContent+"\n\tis done? No\n\tdo by: "+deadlineDate;
    }

    /**
     * @return Date of deadline
     */
    public String getDeadlineDate(){return this.deadlineDate;}
}

