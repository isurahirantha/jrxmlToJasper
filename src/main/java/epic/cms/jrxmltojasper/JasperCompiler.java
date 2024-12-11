/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epic.cms.jrxmltojasper;

/**
 *
 * @author isura_s
 */
/**
 *
 * @author isura_s
 */
import java.io.File;
import java.util.Collection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/*
 * @author isura_s
 */
public class JasperCompiler {

	public static void main(String[] args) throws JRException {

		// Get currently running directory
		String currentPath = System.getProperty("user.dir");

		System.out.println("Current path is: " + currentPath);

		// Go to directory where all the reports are
		File rootDir = new File(currentPath + "/New folder/");

		// Get all *.jrxml files
		Collection<File> files = FileUtils.listFiles(rootDir,
				new RegexFileFilter("^(.*\\.jrxml)"), TrueFileFilter.INSTANCE);

		for (File file : files) {
			System.out.println("Compiling: " + file.getAbsolutePath());
			System.out.println("Output: " + file.getName() + ".jasper");
			// Actual compiling
			JasperCompileManager.compileReportToFile(file.getAbsolutePath(),
					"New folder/" + file.getName() + ".jasper");
			System.out.println("Compiling: completed!");
		}
	}
}

