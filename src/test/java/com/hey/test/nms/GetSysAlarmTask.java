//package com.hey.test.nms;
//
//import java.util.TimerTask;
//
//import com.zhtelecom.common.base.MyException;
//import com.zhtelecom.nms.framework.db.DBAPI;
//import com.zhtelecom.nms.framework.db.DBAPIImpl;
//
//
////��ʱ��ȡϵͳ�澯��ʱ����
//public class GetSysAlarmTask  extends TimerTask{
//
//	private String jobName = "";
//	private DBAPI dbapi = null;
//	private java.util.Date date;
//
//	public GetSysAlarmTask(String jobName) {
//		super();
//		this.jobName = jobName;
//		try {
//			dbapi = DBAPIImpl.getInstance();//��ʼ�����ݿ�
//		} catch (MyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void run() {
//	// 1 �ϴβ�ѯ��ǰʱ��
//	if(date==null){
//
//	}
//
//	//2  �ϴβ�ѯ��ǰʱ��
//	//3 �Ѹ澯��װ��ybzdalarm
//	System.out.println("��ȡftp��ַ���Ұ󶨳ɹ�");
//	System.out.println("��ȡ��ʱ�����ʱ��ͼ��");
//	System.out.println("����ftp�ļ�");
//	}
//}
