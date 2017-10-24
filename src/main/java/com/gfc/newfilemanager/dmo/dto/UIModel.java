package com.gfc.newfilemanager.dmo.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UIModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**权限数据*/
	private Set<String> privilege = new HashSet<String>();
	
	/**业务数据*/
	private Object data;
	
	/**下拉列表*/
	private Map<String,Map<String,String>> dropDown = new HashMap<String, Map<String,String>>();//Object一般为Map<String,String>
	
	/**下拉列表*/
	private Map<String,Object> dropDownMap = new HashMap<String, Object>();//Object一般为Map<String,String>
	
	
	/**操作成功失败信息以及原因*/
	private MessageShowView msgView;

    /**默认选中的数据*/
    private Object checkedDefaultArray;

    /**封装统计求和对象*/
    private Object sumStatisticObject;

    public Object getCheckedDefaultArray() {
        return checkedDefaultArray;
    }

    public void setCheckedDefaultArray(Object checkedDefaultArray) {
        this.checkedDefaultArray = checkedDefaultArray;
    }

    public Set<String> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Set<String> privilege) {
		this.privilege = privilege;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public MessageShowView getMsgView() {
		return msgView;
	}

	public void setMsgView(MessageShowView msgView) {
		this.msgView = msgView;
    }

    public Object getSumStatisticObject() {
        return sumStatisticObject;
    }

    public void setSumStatisticObject(Object sumStatisticObject) {
        this.sumStatisticObject = sumStatisticObject;
    }

	public Map<String, Map<String, String>> getDropDown() {
		return dropDown;
	}

	public void setDropDown(Map<String, Map<String, String>> dropDown) {
		this.dropDown = dropDown;
	}

	public Map<String, Object> getDropDownMap() {
		return dropDownMap;
	}

	public void setDropDownMap(Map<String, Object> dropDownMap) {
		this.dropDownMap = dropDownMap;
	}

	
}
