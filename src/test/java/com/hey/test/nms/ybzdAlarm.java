package com.hey.test.nms;


/**
 * �ǰ��Ǵ�澯����
 * @author MyPC
 *
 */


public class ybzdAlarm {
	
	 private String AssetNum;
	 private int Alarmlevel;
	 private int Alarmstatus;
	 private String SystemClass;
	 private String DevType;
	 private String SubTypes;
	 private String SubTypesNum;
	 private String IndexName;
	 private String RecoveryTime;
	 private String TriggerValue;

	public String getTriggerTime() {
		return TriggerTime;
	}

	public void setTriggerTime(String triggerTime) {
		TriggerTime = triggerTime;
	}

	private String TriggerTime;
	 private String ReturnValue;
	 
	 public String getAssetNum() {
		return AssetNum;
	}
	public void setAssetNum(String assetNum) {
		AssetNum = assetNum;
	}
	public int getAlarmlevel() {
		return Alarmlevel;
	}
	public void setAlarmlevel(int alarmlevel) {
		Alarmlevel = alarmlevel;
	}
	public int getAlarmstatus() {
		return Alarmstatus;
	}
	public void setAlarmstatus(int alarmstatus) {
		Alarmstatus = alarmstatus;
	}
	public String getSystemClass() {
		return SystemClass;
	}
	public void setSystemClass(String systemClass) {
		SystemClass = systemClass;
	}
	public String getDevType() {
		return DevType;
	}
	public void setDevType(String devType) {
		DevType = devType;
	}
	public String getSubTypes() {
		return SubTypes;
	}
	public void setSubTypes(String subTypes) {
		SubTypes = subTypes;
	}
	public String getSubTypesNum() {
		return SubTypesNum;
	}
	public void setSubTypesNum(String subTypesNum) {
		SubTypesNum = subTypesNum;
	}
	public String getIndexName() {
		return IndexName;
	}
	public void setIndexName(String indexName) {
		IndexName = indexName;
	}
	public String getRecoveryTime() {
		return RecoveryTime;
	}
	public void setRecoveryTime(String recoveryTime) {
		RecoveryTime = recoveryTime;
	}
	public String getTriggerValue() {
		return TriggerValue;
	}
	public void setTriggerValue(String triggerValue) {
		TriggerValue = triggerValue;
	}
	public String getReturnValue() {
		return ReturnValue;
	}
	public void setReturnValue(String returnValue) {
		ReturnValue = returnValue;
	}
	@Override
	public String toString() {
		return "ybzdAlarm [AssetNum=" + AssetNum + ", Alarmlevel=" + Alarmlevel + ", Alarmstatus=" + Alarmstatus
				+ ", SystemClass=" + SystemClass + ", DevType=" + DevType + ", SubTypes=" + SubTypes + ", SubTypesNum="
				+ SubTypesNum + ", IndexName=" + IndexName + ", RecoveryTime=" + RecoveryTime + ", TriggerValue="
				+ TriggerValue + ", ReturnValue=" + ReturnValue + "]";
	}


}
