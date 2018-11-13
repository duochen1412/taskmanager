package chenduo.tojava.taskmanager;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
/**
 * Conduct test for command <code>todo</code> and <code>deadline</code>
 * @author Chen Duo
 * @since 20.10.2018
 */
public class ParserTest {

    @Test
    public void getCommandWord() {
        assertEquals("todo", Parser.getCommandWord("todo read book"));
        assertEquals("deadline", Parser.getCommandWord("deadline return book /by next Friday"));
        assertEquals("exit", Parser.getCommandWord("exit"));
        assertEquals("xyz", Parser.getCommandWord("   xyz   ")); // leading and trailing spaces
    }

    /**
     * @throws TaskManagerException
     */
    @Test
    public void createTodo() throws TaskManagerException {
        Todo actual = Parser.createTodo("todo read book");
        Todo expected = new Todo("read book");
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * @throws TaskManagerException
     */
    @Test
    public void createDeadline() throws  TaskManagerException {
        Deadline actualDLTask = Parser.createDeadline("deadline read book /by Monday");
        Deadline expectedDLTask = new Deadline("read book","Monday");
        assertEquals(expectedDLTask.toString(), actualDLTask.toString());
    }

}