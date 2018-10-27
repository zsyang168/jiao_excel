package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import excel.excel_func;

@SuppressWarnings("serial")
public class jiao_main extends jiao_gui {

	public jiao_main() {
		// TODO Auto-generated constructor stub
		// 确认按钮的监听器
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run();
			}

		});
	}

	public void run() {
		excel_func excel_fun = new excel_func();
		Object excel_data[][] = excel_fun.get_excel_data(source_name, source_sheet);
		if(excel_data == null)
			return;
		
		int rows = excel_data.length;
		int cols = excel_data[0].length;

		String head_name = null;
		int index = -1;
		for (int i = 0; i < cols; i++) {
			if (excel_data[0][i] != null)
				head_name = String.valueOf(excel_data[0][i]);
			else
				continue;
			if (source_key.equals(head_name)) {
				index = i;
				break;
			}

		}

		if(index == -1)
			return;
		
		if(module == MODULE.CLONE)
		{
			Location location = get_location();
			String str = null;
			for (int i = 1; i < rows; i++) {
				setProgressString(i*100/rows,i*100/rows+"%");
				if (excel_data[i] == null)
					continue;

				if (excel_data[i][index] != null)
					str = String.valueOf(excel_data[i][index]);
				else
					continue;
				
				file_clone(str,location);
			}
			setProgressString(100,"100% done!");
		}
		else if(module == MODULE.ALTER)
		{
			String str = null;
			for (int i = 1; i < rows; i++) {
				setProgressString(i*100/rows,i*100/rows+"%");
				if (excel_data[i] == null)
					continue;

				if (excel_data[i][index] != null)
					str = String.valueOf(excel_data[i][index]);
				else
					continue;
				
				file_alter(str);
			}
			setProgressString(100,"100% done!");
		}
		

		

	}

	public void file_clone(String str ,Location location)
	{
		String _str = str.replace(src_key, dst_key);

		String dest="result\\"+str+".xls";
		tools.copy_file(sample_name, dest);
		
		write_data data = new write_data();
		data.file_name = dest;
		data.sheet_name = sample_sheet;
		data.value = _str;
		data.location = location;
		
		set_value(data);	
	}
	
	public void file_alter(String str)
	{
		String _str = str.replace(src_key, dst_key);
		String dest=str+".xls";
		
		Location location = get_location(dest);
		
		write_data data = new write_data();
		data.file_name = dest;
		data.sheet_name = sample_sheet;
		data.value = _str;
		data.location = location;
		
		set_value(data);	
	}
	
	public Location get_location()
	{
		excel_func excel_fun = new excel_func();
		Object excel_data[][] = excel_fun.get_excel_data(sample_name, sample_sheet);
		if (excel_data == null)
			return null;
		int rows = excel_data.length;

		for (int i = 0; i < rows; i++) {
			if (excel_data[i] == null)
				continue;
			int cols = excel_data[i].length;
			for (int j = 0; j < cols; j++) {
				if (excel_data[i][j] == null)
					continue;
				if (sample_key.equals(String.valueOf(excel_data[i][j]))) {
					return new Location(i+1,j);
				}
			}
		}
		return null;
	}
	
	public Location get_location(String name)
	{
		excel_func excel_fun = new excel_func();
		Object excel_data[][] = excel_fun.get_excel_data(name, sample_sheet);
		if (excel_data == null)
			return null;
		int rows = excel_data.length;

		for (int i = 0; i < rows; i++) {
			if (excel_data[i] == null)
				continue;
			int cols = excel_data[i].length;
			for (int j = 0; j < cols; j++) {
				if (excel_data[i][j] == null)
					continue;
				if (sample_key.equals(String.valueOf(excel_data[i][j]))) {
					return new Location(i+1,j+1);
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new jiao_main();

	}

	public boolean set_value(write_data data) {
		
		File file = new File(data.file_name);
		if(!file.exists())
			return false;
		
		boolean flag = true;
		try {
			FileInputStream fs = new FileInputStream(data.file_name); //
			POIFSFileSystem ps = new POIFSFileSystem(fs); // 使用POI提供的方法得到excel的信息
			HSSFWorkbook wb = new HSSFWorkbook(ps);
			HSSFSheet sheet = wb.getSheet(data.sheet_name); // 获取到工作表，因为一个excel可能有多个工作表
			FileOutputStream out = new FileOutputStream(data.file_name);

			HSSFRow row = sheet.getRow(data.location.x);
			HSSFCell cell = row.getCell(data.location.y);
			System.out.println(data.value);
			cell.setCellValue(data.value); // 更改值,如add

			wb.setForceFormulaRecalculation(true);
			out.flush(); // 缓冲
			wb.write(out); // 数据写入
			out.close();// 关闭输出流
			wb.close();
			fs.close();// 关闭输入流
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据更新失败！\n" + e, "提示", JOptionPane.WARNING_MESSAGE);
		}
		return flag;
	}
}
