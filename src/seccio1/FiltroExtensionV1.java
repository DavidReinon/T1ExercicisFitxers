package seccio1;

import java.io.File;
import java.io.FilenameFilter;

public class FiltroExtensionV1 implements FilenameFilter {
	String extension;

	FiltroExtensionV1(String extension) {
		this.extension = extension;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
}
