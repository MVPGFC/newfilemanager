package com.gfc.newfilemanager.dmo.dto;

import java.util.ArrayList;
import java.util.List;

public class MessageShowView {
	
	public String getMsgstatus() {
		return msgstatus;
	}
	public void setMsgstatus(String msgstatus) {
		this.msgstatus = msgstatus;
	}
	public List<MessageShow> getMsgdatas() {
		if(msgdatas == null || msgdatas.isEmpty()){
			msgdatas = new ArrayList<MessageShow>() ;
		}
		return msgdatas;
	}
	public void setMsgdatas(List<MessageShow> msgdatas) {
		this.msgdatas = msgdatas;
	}
	public void addOneMsgdata(MessageShow msgdata) {
		if(this.msgdatas == null) {
			this.msgdatas = new ArrayList<MessageShow>();
		}
		this.msgdatas.add(msgdata);
	}
	
	private String msgstatus;
	private List<MessageShow> msgdatas;
}
