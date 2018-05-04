package com.hey.test.nms;


import java.util.TimerTask;



public class SendDataTask extends  TimerTask{
	
	private String jobName = "";
	public SendDataTask(String jobName) { 
		super(); 
		this.jobName = jobName; 
	}
	
	@Override 
	public void run() { 
	// 1 ������ftp��ַ
	//2   ���÷��͵�ʱ����
	//3 �Լ���ҵ���߼�
	System.out.println("��ȡftp��ַ���Ұ󶨳ɹ�");
	System.out.println("��ȡ��ʱ�����ʱ��ͼ��");
	System.out.println("����ftp�ļ�");
	} 

}
