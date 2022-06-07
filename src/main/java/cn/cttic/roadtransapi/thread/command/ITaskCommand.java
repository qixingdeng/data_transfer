package cn.cttic.roadtransapi.thread.command;


public interface ITaskCommand {
	
     TaskCommandStatus GetStatus();

     void Execute();

     void Stop();
          
     String GetName();
     
     void SysnExecute();
}
