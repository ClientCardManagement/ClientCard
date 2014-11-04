package com.ClientCardManagement.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ClientCardManagement.model.TrnNc;

import jxl.*;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

public class Excel {
	public static String[] head = { "公司名", "公司名（英名）", "公司(拼音)", "部门名", "职务",
			"姓名【姓】", "姓名【名】", "姓名【姓】【拼音】", "姓名【名】【拼音】", "邮政编码(1)", "住所(1)［省］",
			"住所(1)［市］", "住所(1)［区］", "住所(1)［地址］", "TEL-1(1)", "TEL-2(1)",
			"FAX(1)", "手机号(1)", "e-mail(1)", "URL(1)", "邮政编码(2)", "住所(2)［省］",
			"住所(2)［市］", "住所(2)［区］", "住所(2)［地址］", "TEL-1(2)", "TEL-2(2)",
			"FAX(2)", "手机号(2)", "e-mail(2)", "URL(2)", "重要度区分", "职业区分", "关系区分",
			"性別区分", "血型区分", "生日（年）", "生日（月）", "生日（日）", "备忘录", "行业名", "成立年月",
			"资本金", "员工数", "证券代码", "法人代表姓名", };
	public String dirPath;
	public String OutPutPath;
	public String fileName = "output.xls";

	public String getDirPath() {
		return dirPath;
	}

	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}

	public String getOutPutPath() {
		return dirPath + fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void exportCardExcel(String[] head, List<TrnNc> list)
			throws IOException, RowsExceededException, WriteException {

		WritableWorkbook workbook = Workbook.createWorkbook(new File(
				getOutPutPath()));
		WritableSheet sheet = workbook.createSheet("First Sheet", 0);

		Label label;
		int N = head.length;
		for (int i = 0; i < N; i++) {
			// 第一个坐标为X
			label = new Label(i, 0, head[i]);
			sheet.addCell(label);
		}

		// list不为空
		if (list != null) {
			// M为对象数目
			int M = list.size();
			List<Label> oneRowLabels;
			for (int i = 1; i <= M; i++) {
				oneRowLabels = addObjectToLables(i, list.get(i - 1));
				// label = new Label(j, i, head[j] + " :" + j + " - " + i);
				for (Label l : oneRowLabels) {
					sheet.addCell(l);
				}
			}
		}
		workbook.write();
		workbook.close();
	}

	private List<Label> addObjectToLables(int row, TrnNc obj) {
		// "公司名", "公司名（英名）", "公司(拼音)",
		// "部门名", "职务", "姓名【姓】", "姓名【名】",
		// "姓名【姓】【拼音】","姓名【名】【拼音】","邮政编码(1)",
		// "住所(1)［省］","住所(1)［市］","住所(1)［区］",
		// "住所(1)［地址］","TEL-1(1)","TEL-2(1)",
		// "FAX(1)","手机号(1)","e-mail(1)",
		// "URL(1)","邮政编码(2)","住所(2)［省］",
		// "住所(2)［市］","住所(2)［区］",
		// "住所(2)［地址］","TEL-1(2)","TEL-2(2)",
		// "FAX(2)","手机号(2)","e-mail(2)",
		// "URL(2)","重要度区分","职业区分",
		// "关系区分","性別区分","血型区分",
		// "生日（年）","生日（月）","生日（日）",
		// "备忘录","行业名","成立年月",
		// "资本金","员工数","证券代码","法人代表姓名",
		if (obj == null) {
			return null;
		}
		int col = 0;
		List<Label> list = new ArrayList<Label>();
		list.add(new Label(col++, row, obj.getComjnam()));
		list.add(new Label(col++, row, obj.getComenam()));
		list.add(new Label(col++, row, obj.getComjnamkn()));
		list.add(new Label(col++, row, obj.getPostnam()));
		list.add(new Label(col++, row, obj.getOffposi()));
		list.add(new Label(col++, row, obj.getFirstnam()));
		list.add(new Label(col++, row, obj.getSecdnam()));
		list.add(new Label(col++, row, obj.getFirstnamkn()));
		list.add(new Label(col++, row, obj.getSecdnamkn()));
		list.add(new Label(col++, row, obj.getPostalnum1()));
		list.add(new Label(col++, row, obj.getAdsadmindiv1()));
		list.add(new Label(col++, row, obj.getAdstown1()));
		list.add(new Label(col++, row, obj.getAdsstrtnum1()));
		list.add(new Label(col++, row, obj.getAdsbuild1()));
		list.add(new Label(col++, row, obj.getTelfist1()));
		list.add(new Label(col++, row, obj.getTelsecd1()));
		list.add(new Label(col++, row, obj.getFax1()));
		list.add(new Label(col++, row, obj.getMobiletel1()));
		list.add(new Label(col++, row, obj.getEmail1()));
		list.add(new Label(col++, row, obj.getUrl1()));
		list.add(new Label(col++, row, obj.getPostalnum2()));
		list.add(new Label(col++, row, obj.getAdsadmindiv2()));
		list.add(new Label(col++, row, obj.getAdstown2()));
		list.add(new Label(col++, row, obj.getAdsstrtnum2()));
		list.add(new Label(col++, row, obj.getAdsbuild2()));
		list.add(new Label(col++, row, obj.getTelfist2()));
		list.add(new Label(col++, row, obj.getTelsecd2()));
		list.add(new Label(col++, row, obj.getFax2()));
		list.add(new Label(col++, row, obj.getMobiletel2()));
		list.add(new Label(col++, row, obj.getEmail2()));
		list.add(new Label(col++, row, obj.getUrl2()));
		if (obj.getImptantkub() == null) {
			list.add(new Label(col++, row, ""));
		} else {
			list.add(new Label(col++, row, obj.getImptantkub().toString()));
		}
		list.add(new Label(col++, row, obj.getJobkub()));
		list.add(new Label(col++, row, obj.getRelationkub()));
		list.add(new Label(col++, row, obj.getSexkub()));
		list.add(new Label(col++, row, obj.getBlodkub()));
		list.add(new Label(col++, row, obj.getBirthdayy()));
		list.add(new Label(col++, row, obj.getBirthdaym()));
		list.add(new Label(col++, row, obj.getBirthdayd()));
		list.add(new Label(col++, row, obj.getMemo()));
		list.add(new Label(col++, row, obj.getBustypnam()));
		list.add(new Label(col++, row, obj.getFondym()));
		if (obj.getCapital() == null) {
			list.add(new Label(col++, row, ""));
		} else {
			list.add(new Label(col++, row, obj.getCapital().toString()));
		}
		if (obj.getEmplonum() == null) {
			list.add(new Label(col++, row, ""));
		} else {
			list.add(new Label(col++, row, obj.getEmplonum().toString()));
		}
		list.add(new Label(col++, row, obj.getBondcode()));
		list.add(new Label(col++, row, obj.getReptannam()));
		return list;
	}

	public static void main(String args[]) {
		Excel excel = new Excel();
		// String[] head = {"A","B","C","D","F","G","H",};
		try {
			excel.exportCardExcel(Excel.head, null);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
