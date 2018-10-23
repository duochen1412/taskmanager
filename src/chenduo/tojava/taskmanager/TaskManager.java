package chenduo.tojava.taskmanager;
import java.lang.*;

/**
 * To get input command from user run command accordingly
 * @author Chen Duo
 * @since 20.10.2018
 */
public class TaskManager {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public TaskManager(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (TaskManagerException e) {
            ui.showToUser("Problem reading file. Starting with an empty task list");
            tasks = new TaskList();
        }
    }
    public TaskManager(){}

    public void run() {
        ui.printWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readUserCommand();
                String commandWord = Parser.getCommandWord(fullCommand);
                switch (commandWord) {
                    case "exit":  isExit = true; break;
                    case "": isExit = true;break;
                    case "print":tasks.printTasks();break;
                    case "todo": tasks.addTask(Parser.createTodo(fullCommand));break;
                    case "deadline":tasks.addTask(Parser.createDeadline(fullCommand));break;
                    case "done":tasks.markAsDone(fullCommand);break;
                    case "cleartask":tasks.clearTask();break;
                    default: ui.printError("Unknown command! please try again");
                }
            } catch (TaskManagerException e) {
                ui.printError(e.getMessage());
            }
        }
        try{
            tasks.saveTasks();
        }catch (TaskManagerException e) {
            ui.printError(e.getMessage());
        }
        exit();
    }
    private static void exit(){
        System.out.println("Bye!");
    }

    public void runTest(){
        ParserTest test = new ParserTest();
        test.getCommandWord();
        try {
            test.createDeadline();
            test.createTodo();
        }catch (TaskManagerException e) {
            ui.printError(e.getMessage());
        }
        finally {
            ui.showToUser("Pass");
        }
    }

    public static void main(String[] args) {
       //new TaskManager().runTest();
        new TaskManager("C:\\Users\\87215\\IdeaProjects\\src\\chenduo\\tojava\\taskmanager\\data\\tasks.txt").run();
    }
}
