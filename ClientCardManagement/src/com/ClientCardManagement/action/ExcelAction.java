package com.ClientCardManagement.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.service.TrnNcService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ClientCardManagement.util.Excel;

@Controller
@Scope("prototype")
public class ExcelAction extends ActionSupport {
	@Resource
	private TrnNcService service;
	private String ids;
	private String path;
	private String fileName;
	private String dirPath = getRealPath();
	private InputStream excelStream;

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getFileName() {
		return fileName;
	}

	public String exportExcel() throws RowsExceededException, WriteException,
			IOException {
		if (!ids.equals("") && ids != null) {
			Excel excel = new Excel();
			excel.setDirPath(dirPath);
			excel.exportCardExcel(Excel.head, service.getList(ids));
			fileName = excel.getFileName();
			path = excel.getOutPutPath();
		}
		return SUCCESS;
	}

	public String getRealPath() {
		ActionContext ctx = ActionContext.getContext();
		ServletContext sc = (ServletContext) ctx
				.get(ServletActionContext.SERVLET_CONTEXT);
		return sc.getRealPath("/");
	}

	public InputStream getExcelStream() throws FileNotFoundException {
		File f = new File(path);
		excelStream = new FileInputStream(f);
		return excelStream;
	}
}
