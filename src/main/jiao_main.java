package main;

import excel.excel_func;

@SuppressWarnings("serial")
public class jiao_main extends jiao_gui{

	public jiao_main() {
		// TODO Auto-generated constructor stub
		run();
	}
	public void run() {
		excel_func excel_fun = new excel_func();
		Object excel_data[][] = excel_fun.get_excel_data_by_name(excel_file_path, "喷播植草护坡");
		int rows = excel_data.length;
		int cols = excel_data[0].length;

		String head_name = null;
		int index = -1;
		for (int i = 0; i < cols; i++) {
			if (excel_data[0][i] != null)
				head_name = String.valueOf(excel_data[0][i]);
			else
				continue;
			if ("里程位置".equals(head_name)) {
				index = i;
				break;
			}

		}

		String str = null;
		
		for (int i = 1; i < rows; i++) {
			if (excel_data[i] == null)
				continue;

			if (excel_data[i][index] != null)
				str = String.valueOf(excel_data[i][index]);
			else
				continue;
			
			set_value(str, "路基工程");
		}

	}
	
	public void set_value(String name, String str) {
		String _str = str.replace("段", "");
		excel_func excel_fun = new excel_func();
		String path = excel_list_path + "\\" + name + ".xls";
		Object excel_data[][] = excel_fun.get_excel_data_by_name(path, "检验单");
		if (excel_data == null)
			return;
		int rows = excel_data.length;

		for (int i = 0; i < rows; i++) {
			if (excel_data[i] == null)
				continue;
			int cols = excel_data[i].length;
			for (int j = 0; j < cols; j++) {
				if (excel_data[i][j] == null)
					continue;
				if (str.equals(String.valueOf(excel_data[i][j]))) {
					excel_fun.set_excel(path, "检验单", i+1, j+1, _str);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new jiao_main();

	}

}
