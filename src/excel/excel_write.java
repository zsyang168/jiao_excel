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
	// ���캯��
	public excel_write(String data[][], String file_name) {
		// ��ʼ������
		excel_file = null;
		fs = null;
		wb = null;
		excel_data = data;
	}

	public void write_data() {
		
		// ��һ��������һ��webbook����Ӧһ��Excel�ļ�
		HSSFWorkbook wb = new HSSFWorkbook();
		// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
		HSSFSheet sheet = wb.createSheet("Sheet1");
		// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(1);
		// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // �±߿�
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// ��߿�
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// �ϱ߿�
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// �ұ߿�
		// ���ñ�ͷ
		cell.setCellValue("");
		cell.setCellStyle(style);
		// �ϲ���һ������Ԫ��
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 1);
		sheet.addMergedRegion(region);
		RegionUtil.setBorderBottom(1, region, sheet, wb);
		RegionUtil.setBorderLeft(1, region, sheet, wb);
		RegionUtil.setBorderRight(1, region, sheet, wb);
		RegionUtil.setBorderTop(1, region, sheet, wb);
		// ��ͷ
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
		// д������
		HSSFCellStyle Astyle = wb.createCellStyle();
		Astyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ
		Astyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // ����һ�����и�ʽ
		for (int i = 0; i < excel_data.length; i++) {
			// ���ȸ���
			row = sheet.createRow(i + 2);
			cell = row.createCell(0);
			for (int j = 0; j < excel_data[i].length; j++) {
				cell.setCellValue(excel_data[i][j]);
				cell.setCellStyle(Astyle);
				cell = row.createCell(j + 1);
				sheet.autoSizeColumn(j); // �Զ������п�
			}
		}
		
		try {
			FileOutputStream fout = new FileOutputStream(excel_file);
			wb.write(fout);
			fout.close();
			
		} catch (Exception e) {
			// ���ȸ���


		}
	}
	/**
	 * �رձ������
	 */
	private void destory(Workbook wb, FileInputStream fs) {
		// �رձ�
		if (wb != null)
			try {
				wb.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		// �ر�������
		if (fs != null)
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
