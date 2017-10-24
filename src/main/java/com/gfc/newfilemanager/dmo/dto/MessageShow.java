package com.gfc.newfilemanager.dmo.dto;

public class MessageShow {

	public MessageShow(){}
	
	public MessageShow(String title, String info){
		this.title = title;
		this.info = info;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getExceptionStack() {
		return exceptionStack;
	}

	public void setExceptionStack(String exceptionStack) {
		this.exceptionStack = exceptionStack;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj){  
            return true;  
        }  
        if(!(obj instanceof MessageShow)  ){  
            return false;  
        }  
        final MessageShow messageShow = (MessageShow)obj;    
        if(getTitle().equals(messageShow.getTitle()) && getInfo().equals(messageShow.getInfo())){  
            return true;  
        }
        return false; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	private String title;
	private String info;
	private String exceptionStack;
	
}
