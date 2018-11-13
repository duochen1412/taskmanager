package chenduo.tojava.taskmanager;
import java.io.*;
import java.util.*;
/**
 * To load data from file and save changes to file.
 * @author Chen Duo
 * @since 20.10.2018
 */
public class Storage {
    private static String path;
    public Storage(String path){
        this.path=path;
    }

    /**
     * Read file, create <code>Task</code> object and save object to Arraylist
     * @return <code>List<Task></code> object
     * @throws TaskManagerException
     */
    public static List<Task> load() throws TaskManagerException{
        List<Task> loadedTasks = new ArrayList<>();
        try {
            List<String> lines = getLines(path);
            for (String line : lines) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                loadedTasks.add(createTask(line));
            }
        }catch (FileNotFoundException e){
            throw new TaskManagerException(e.getMessage());
        }
        return loadedTasks;
    }

    /**
     * Read lines from file and save data to code>List<String></code>
     * @param filename of input file
     * @return <code>List<String></code>
     * @throws FileNotFoundException
     */
    private static List<String> getLines(String filename) throws FileNotFoundException{
        File tasksFile = new File(filename);
        List<String> lines = new ArrayList<>();
        Scanner rf= new Scanner(tasksFile);
        while(rf.hasNextLine()) {
            String line= rf.nextLine();
            lines.add(line);
        }
        rf.close();
        return lines;
    }

    /**
     * Create a new task from input string
     * @param line
     * @return Task
     */
    private static Task createTask(String line){
        String[] taskInfo = line.split("\\|");
        Task task;
        boolean isDone = (Integer.parseInt(taskInfo[1].trim())==1);
        if(taskInfo[0].trim().equals("D")) {
            task = new Deadline(taskInfo[2], isDone, taskInfo[3]);
        }else {
            task = new Todo(taskInfo[2], isDone);
        }
        return task;
    }

    /**
     * Save tasks to file from <code>List<Task/code>
     * @param tasks
     * @throws TaskManagerException
     */
    public static void save(List<Task> tasks)throws TaskManagerException{
        try {
            FileWriter fw=null;
            fw = new FileWriter("C:\\Users\\87215\\IdeaProjects\\src\\chenduo\\tojava\\taskmanager\\data\\tasks.txt", false);
            PrintWriter pw = new PrintWriter(fw);
            int isDone;
            for(Task t:tasks){
                if(t instanceof Deadline) {
                    Deadline td = (Deadline) t;
                    isDone =  td.isDone ? 1 : 0;
                    pw.println("D|" + isDone  + "|" + td.getContent() + "|" + td.getDeadlineDate());

                }else if(t instanceof Todo){
                    Todo tt = (Todo) t;
                    isDone =  tt.isDone ? 1 : 0;
                    pw.println("T|" + isDone  + "|" + tt.getContent());
                }
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            throw new TaskManagerException("problem encountered while writing data: " + e.getMessage());
        }
    }
}
