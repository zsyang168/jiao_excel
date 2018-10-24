package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class excel_write {
	File excel_file;
	FileInputStream fs;
	Workbook wb;

	String excel_data[][];
	// 构造函数
	public excel_write(String data[][], String file_name) {
		// 初始化数据
		excel_file = null;
		fs = null;
		wb = null;
		excel_data = data;
	}

	public void write_data() {
		
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("Sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(1);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		// 设置表头
		cell.setCellValue("");
		cell.setCellStyle(style);
		// 合并第一二个单元格
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 1);
		sheet.addMergedRegion(region);
		RegionUtil.setBorderBottom(1, region, sheet, wb);
		RegionUtil.setBorderLeft(1, region, sheet, wb);
		RegionUtil.setBorderRight(1, region, sheet, wb);
		RegionUtil.setBorderTop(1, region, sheet, wb);
		// 表头
		for (int i = 0; i < 2; i++) {
			cell = row.createCell((short) (4 * i + 2));
			cell.setCellValue("");
			cell.setCellStyle(style);
			region = new CellRangeAddress(0, 0, 4 * i + 2, 4 * i + 5);
			sheet.addMergedRegion(region);
			RegionUtil.setBorderBottom(1, region, sheet, wb);
			RegionUtil.setBorderLeft(1, region, sheet, wb);
			RegionUtil.setBorderRight(1, region, sheet, wb);
			RegionUtil.setBorderTop(1, region, sheet, wb);
		}
		// 写入数据
		HSSFCellStyle Astyle = wb.createCellStyle();
		Astyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		Astyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式
		for (int i = 0; i < excel_data.length; i++) {
			// 进度更新
			row = sheet.createRow(i + 2);
			cell = row.createCell(0);
			for (int j = 0; j < excel_data[i].length; j++) {
				cell.setCellValue(excel_data[i][j]);
				cell.setCellStyle(Astyle);
				cell = row.createCell(j + 1);
				sheet.autoSizeColumn(j); // 自动调整列宽
			}
		}
		
		try {
			FileOutputStream fout = new FileOutputStream(excel_file);
			wb.write(fout);
			fout.close();
			
		} catch (Exception e) {
			// 进度更新


		}
	}
	/**
	 * 关闭表格连接
	 */
	private void destory(Workbook wb, FileInputStream fs) {
		// 关闭表
		if (wb != null)
			try {
				wb.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 关闭数据流
		if (fs != null)
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
