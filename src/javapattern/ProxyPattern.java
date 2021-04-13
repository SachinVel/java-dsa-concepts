package javapattern;

class CommandExecutor{	
	protected void execute(String command) {
		System.out.println("Command : "+command+" is executed");
	}
}
class CommandExecutorProxy extends CommandExecutor{
	
	public void execute(String command,String user) {
		if(user.equals("admin") ) {
			super.execute(command);
		}else {
			System.out.println("Not authorised");
		}
	}
}
public class ProxyPattern {
	public static void main(String[] args) {
		CommandExecutorProxy executor = new CommandExecutorProxy();		
		executor.execute("rm -r *", "john");
	}
}
