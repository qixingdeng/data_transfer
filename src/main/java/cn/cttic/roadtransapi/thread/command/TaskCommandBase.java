package cn.cttic.roadtransapi.thread.command;

import cn.cttic.roadtransapi.mgr.ThreadMgr;




public abstract class TaskCommandBase implements ITaskCommand {
    
    private TaskCommandStatus m_TaskCommandStatus = TaskCommandStatus.INIT;
     
    private Object Source = null;
    
    private Object Resource = null ;
    
    public TaskCommandStatus getM_TaskCommandStatus() {
		return m_TaskCommandStatus;
	}


	public void setM_TaskCommandStatus(TaskCommandStatus m_TaskCommandStatus) {
		this.m_TaskCommandStatus = m_TaskCommandStatus;
	}


	public Object getResource() {
		return Resource;
	}


	public void setResource(Object resource) {
		Resource = resource;
	}


	public TaskCommandBase()
    {
		
    }

   
	@Override
	public TaskCommandStatus GetStatus() {
		// TODO Auto-generated method stub
		return m_TaskCommandStatus;
	}



	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		 OnExecuteBegin();
         Run();
		 OnExceuted();
	}
	
	 public abstract void Run();


	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	protected  void OnExecuteBegin() 
    {
         m_TaskCommandStatus = TaskCommandStatus.RUNING;
    }
	
	 protected  void OnExceuted() 
     {
		
     }

	public Object getSource() {
		return Source;
	}

	public void setSource(Object source) {
		Source = source;
	}


	public String GetName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void SysnExecute() {
		// TODO Auto-generated method stub
		ThreadMgr.getInstance().ProcessBusi(this);
	}
	
}
