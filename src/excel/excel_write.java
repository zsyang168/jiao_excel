package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_write {
	File excel_file;
	FileInputStream fs;
	Workbook wb;
	Sheet sheet;
	
	String excel_data[][];

	// 构造函数
	public excel_write(String file_name) {
		// 初始化数据
		excel_file = null;
		fs = null;
		wb = null;
		excel_init(file_name);
	}

	private void excel_init(String file_name) {
		// 检查文件类型
		int iIndex = file_name.lastIndexOf(".");
		String ext = (iIndex < 0) ? "" : file_name.substring(iIndex + 1).toLowerCase();
		if (!"xls,xlsx".contains(ext) || "".contains(ext)) {
			System.out.println("文件类型不是EXCEL！");
			return;
		}
		// 打开文件
		try {
			excel_file = new File(file_name);
			if (!excel_file.exists())
				return;
			// 获取表格数据输入流
			fs = new FileInputStream(excel_file);
			// 获取EXCEL表
			if (ext.equals("xls"))
				wb = new HSSFWorkbook(fs);
			else
				wb = new XSSFWorkbook(fs);
			// 关闭流
			fs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 以表名读取数据
	public void set_value(String name,int x, int y, String value) {
		if (null == wb)
			return;
		System.out.println("here");
		Sheet sheet = wb.getSheet(name);
		if (null == sheet)
			return;
		set_data(x,y,value);
	}
	
	public void set_data(int x, int y, String value) {

		try {
			System.out.println(x +" " + y);
			Row row = sheet.getRow(x);
			if (row != null) {
				Cell cell = row.getCell(y);
				cell.setCellValue(value);
				FileOutputStream out = new FileOutputStream(excel_file);
				wb.write(out);
				out.flush();
				out.close();
				wb.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
