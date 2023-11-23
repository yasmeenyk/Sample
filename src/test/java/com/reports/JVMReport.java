package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.base.BaseClass;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport extends BaseClass {
	public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {
		File reportloc = new File(getProjectPath()+getProperty("jvmpath"));
		Configuration con = new Configuration(reportloc, "Demo Playwright Framework");
		con.addClassifications("platform","windows 10");
		con.addClassifications("sprint", "1");
		con.addClassifications("Author","Yasmeen");
		
		List<String> list = new LinkedList<String>();
		list.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(list, con);
		builder.generateReports();
		
	}

}
