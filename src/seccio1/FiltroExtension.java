package seccio1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

public class FiltroExtension implements FilenameFilter {
	List<String> extensiones;

	FiltroExtension(List<String> extensiones) {
		this.extensiones = extensiones;
	}

	public boolean accept(File dir, String name) {
		for (String extension : extensiones) {
			if (name.endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
}
