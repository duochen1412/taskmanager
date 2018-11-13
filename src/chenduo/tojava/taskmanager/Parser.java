package chenduo.tojava.taskmanager;
/**
 * To convert string command to <Code>Task</Code> object
 * @author Chen Duo
 * @since 20.10.2018
 */
public class Parser {
    /**
     * Get command from input
     * @return command
     */
    public static String getCommandWord(String fullCommand){
        String command = fullCommand.trim().split(" ")[0].trim();
        return command;
    }

    /**
     * Convert String input to Todo type object
     * @return task <code>Todo</code> object
     * @throws TaskManagerException
     */
    public static Todo createTodo(String fullCommand)throws TaskManagerException{
        String description = fullCommand.substring("todo".length()).trim();
        if (description.isEmpty()){
            throw new TaskManagerException("Empty description for TODO");
        }
        Todo task = new Todo(description);
        return task;
    }

    /**
     * Convert String input to Deadline type object
     * @return task <code>Deadline</code> object
     * @throws TaskManagerException
     */
    public static Deadline createDeadline(String fullCommand)throws TaskManagerException{
        if(fullCommand.substring("deadline".length()).trim().isEmpty())
            throw new TaskManagerException("Empty description and date for DEADLINE");
        if(!fullCommand.contains("/by"))
            throw new TaskManagerException("Empty deadline date for DEADLINE");
        String[] cmdStr = fullCommand.split("/by",-1);
        if(cmdStr[1].isEmpty())
            throw new TaskManagerException("Empty deadline date for DEADLINE");
        String deadLine = cmdStr[1].trim();

        String desc = cmdStr[0].trim().substring("deadline".length()).trim();
        if (desc.isEmpty())
            throw new TaskManagerException("Empty description for DEADLINE");
       return new Deadline(desc,deadLine);
    }

}
