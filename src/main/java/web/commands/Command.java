package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{

    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database)
    {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand("index"));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("finishpage", new FinishCommand("finishpage"));
        commands.put("orderpage", new CommandUnprotectedPage("orderpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("employee", new EmployeeCommand("employeepage","employee"));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("adminpage", new AdminCommand("adminpage", "admin"));
        commands.put("managefsp", new ManageFSPCommand("managefsppage", "employee"));
        commands.put("takefsp", new TakeFSPCommand("managefsppage", "employee"));
        commands.put("print", new PrintCommand("printpage", "employee"));
    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;
}
