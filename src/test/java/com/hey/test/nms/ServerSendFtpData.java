package com.hey.test.nms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


//????????
public class ServerSendFtpData {
	
	//???????
	 public static void createXSSH() throws IOException {
	        //??????????
	        HSSFWorkbook HSSFWorkbook = new HSSFWorkbook();
	        //??????????
	        HSSFSheet sheet =  HSSFWorkbook.createSheet("alarm");
//	        HSSFSheet sheet2 =  HSSFWorkbook.createSheet("系统分类字典");
	        //????У?????????
	        HSSFRow header=sheet.createRow(0);
//	        HSSFRow header2=sheet2.createRow(0);
	        header.createCell(0).setCellValue("资产编号");
	        header.createCell(1).setCellValue("告警等级");
	        header.createCell(2).setCellValue("告警状态");
	        header.createCell(3).setCellValue("系统分类");
	        header.createCell(4).setCellValue("设备类型");
	        header.createCell(5).setCellValue("子类型");
	        header.createCell(6).setCellValue("子类型编号");
	        header.createCell(7).setCellValue("指标名称");
	        header.createCell(8).setCellValue("恢复时间");
	        header.createCell(9).setCellValue("触发值");
	        header.createCell(10).setCellValue("恢复值");
//	        header2.createCell(0).setCellValue("系统分类");
//	        header2.createCell(1).setCellValue("系统分类名");

	        FileOutputStream fos= new FileOutputStream("alarm.xlsx");

	        HSSFWorkbook.write(fos);
	        fos.close();
	    }
	 
	 
	 
	 	//???????
	    public static void addData(List<ybzdAlarm> dataList,String path) throws IOException {

	      FileInputStream fs = new FileInputStream("alarm.xlsx");

	        HSSFWorkbook HSSFWorkbook = new HSSFWorkbook(fs);
	        //?????????
	       Sheet sheet= HSSFWorkbook.getSheet("alarm");
//	       Sheet sheet2= HSSFWorkbook.getSheet("系统分类字典");
	       //????????????
	       int num = sheet.getLastRowNum();
	        System.out.println(num);

//	        List<Map> list = new ArrayList<>();
//			for(int i=0;i<15;i++){
//				list.add(i,getMap(i));
//			}
//	        for (int i=0;i<list.size();i++){
//				HSSFRow row2= (HSSFRow) sheet2.createRow(i+1);
//				row2.createCell(0).setCellValue(list.get(i).get("系统分类").toString());
//				row2.createCell(1).setCellValue(list.get(i).get("系统分类名").toString());
//			}
			for(int i=0;i<dataList.size();i++){
				HSSFRow row= (HSSFRow) sheet.createRow(i+1);
				row.createCell(0).setCellValue(dataList.get(i).getAssetNum());
				row.createCell(1).setCellValue(dataList.get(i).getAlarmlevel());
				row.createCell(2).setCellValue(dataList.get(i).getAlarmstatus());
				row.createCell(3).setCellValue(dataList.get(i).getSystemClass());
				row.createCell(4).setCellValue(dataList.get(i).getDevType());
				row.createCell(5).setCellValue(dataList.get(i).getSubTypes());
				row.createCell(6).setCellValue(dataList.get(i).getSubTypesNum());
				row.createCell(7).setCellValue(dataList.get(i).getIndexName());
				row.createCell(8).setCellValue(dataList.get(i).getTriggerTime());
				row.createCell(9).setCellValue(dataList.get(i).getRecoveryTime());
				row.createCell(10).setCellValue(dataList.get(i).getTriggerValue());
				row.createCell(11).setCellValue(dataList.get(i).getReturnValue());
			}
	        int num1 = sheet.getLastRowNum();
	        System.out.println(num1);
//	        FileOutputStream fos= new FileOutputStream("C:\\Users\\er\\Desktop\\test1\\alarm.xlsx");
	        FileOutputStream fos= new FileOutputStream(path);
	        HSSFWorkbook.write(fos);
	        fos.close();
	    }
	    
	    public static void main(String[] args) throws Exception {
			createXSSH();
//			List<Map> list = new ArrayList<>(16);
//			Map map = new HashMap();
//			for(int i=0;i<list.size();i++){
//
//				list.add(i,getMap(i));
//			}
			ybzdAlarm alarm = new ybzdAlarm();
			alarm.setAlarmlevel(4);
			alarm.setAlarmstatus(1);
			alarm.setAssetNum("#1011");
			alarm.setDevType("Fiber");
			alarm.setIndexName("LineLoss");
			alarm.setRecoveryTime(null);
			alarm.setReturnValue(null);
			alarm.setSubTypes(null);
			alarm.setSubTypesNum(null);
			alarm.setTriggerValue("exception");
			alarm.setSystemClass("Fiber");
			alarm.setTriggerTime("2017-10-01 18:01:59");

			List<ybzdAlarm> dataList = new ArrayList<>();
			dataList.add(0,alarm);
			addData(dataList,"");
		}

//		public static Map getMap(int i){
//	 	Map map = new HashMap();
//	 		switch (i){
//				case 0: map.put("系统分类","VideoSurveillanceTerminal");
//						map.put("系统分类名","视频监控终端运行信息");
//					break;
//				case 1: map.put("系统分类","VariableMessageBoard");
//					map.put("系统分类名","可变情报板运行信息");
//					break;
//				case 2: map.put("系统分类","TrafficVolumeSurverStation");
//					map.put("系统分类名","交通量调查站");
//					break;
//				case 3: map.put("系统分类","VehicleInspection");
//					map.put("系统分类名","车检器运行信息");
//					break;
//				case 4: map.put("系统分类","WeatherMonitoringDevice");
//					map.put("系统分类名","气象监测设备运行信息");
//					break;
//				case 5: map.put("系统分类","BridgeHealthMonitoring");
//					map.put("系统分类名","桥梁健康监测设备运行信息");
//					break;
//				case 6: map.put("系统分类","TunnelElectromechanical");
//					map.put("系统分类名","隧道机电设备运行信息");
//					break;
//				case 7: map.put("系统分类","Waterlevel");
//					map.put("系统分类名","水位监测终端运行信息");
//					break;
//				case 8: map.put("系统分类","Telemetry");
//					map.put("系统分类名","遥感遥测终端运行信息");
//					break;
//				case 9: map.put("系统分类","Terminals");
//					map.put("系统分类名","车载终端运行信息");
//					break;
//				case 10: map.put("系统分类","Handset");
//					map.put("系统分类名","手持终端运行信息");
//					break;
//				case 11: map.put("系统分类","Fiber");
//					map.put("系统分类名","光纤资源运行信息");
//					break;
//				case 12: map.put("系统分类","TransmissionDevice");
//					map.put("系统分类名","传输设备运行信息");
//					break;
//				case 13: map.put("系统分类","NetworkDevice");
//					map.put("系统分类名","网络设备运行信息");
//					break;
//				case 14: map.put("系统分类","MachineRoom");
//					map.put("系统分类名","机房物理环境运行信息");
//					break;
//			}
//			return map;
//		}
	 
	    
	    
	    
	 
	
}
