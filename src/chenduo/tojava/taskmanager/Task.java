package chenduo.tojava.taskmanager;
/**
 * Super class of <code>Deadline</code> and <code>Todo</code>
 * @author Chen Duo
 * @since 20.10.2018
 */
public class Task {
    protected String taskContent;
    protected boolean isDone;
    public Task(){};
    public Task(String content){
        this.taskContent=content;
        this.isDone=false;
    }
    public Task(String content,boolean isDone){
        this.taskContent=content;
        this.isDone=isDone;
    }
    public String getDescription(){
        return this.taskContent;
    }

    /**
     * Set value of attribute <code>isDone </code>
     * @param isDone
     */
    public void setDone(boolean isDone){
        this.isDone = isDone;
    }
    public String getContent(){return this.taskContent;}
    /**
     * Delete value of attribute <code>delete </code>
     * @param remove
     */
    public void remove(){

    }

    /**
     * Overrides <code>toString</code> method
     * @return String
     */
    public String toString(){
        return this.getDescription();
    }
}
