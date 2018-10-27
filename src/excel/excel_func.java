package excel;

public class excel_func {

	public	void set_excel(String file_name, String sheet_name, int x, int y,String value) {
		// TODO Auto-generated method stub
		excel_write test=new excel_write(file_name);
		test.set_value(sheet_name, x, y, value);
	}
	public	Object[][] get_excel_data(String file_name, String sheet_name) {
		// TODO Auto-generated method stub
		excel_read test=new excel_read(file_name);
		Object[][] result=null;
		result=test.get_sheet(sheet_name);
		test.excel_free();
		if (result == null)
			System.out.println("get file " + file_name + " sheet " + sheet_name +"failed!");
		return result;
	}

	public	Object[][] get_excel_data(String file_name, int sheet_index) {
		// TODO Auto-generated method stub
		excel_read test=new excel_read(file_name);
		Object[][] result=null;
		result=test.get_sheet(sheet_index);
		test.excel_free();
		if (result == null)
			System.out.println("get file " + file_name + " sheet " + sheet_index +"failed!");
		return result;
	}

}
