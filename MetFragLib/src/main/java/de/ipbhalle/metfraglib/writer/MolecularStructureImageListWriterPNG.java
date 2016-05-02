package de.ipbhalle.metfraglib.writer;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.ipbhalle.metfraglib.interfaces.IList;
import de.ipbhalle.metfraglib.interfaces.IWriter;
import de.ipbhalle.metfraglib.list.DefaultList;
import de.ipbhalle.metfraglib.parameter.Constants;

public class MolecularStructureImageListWriterPNG implements IWriter {

	public boolean write(IList list, String filename, String path) {
		if(list.getNumberElements() == 0) {
			System.out.println("Warning: No image in the given list. Nothing to write.");
			return true;
		}
		if(list.getNumberElements() > 1) {
			System.out.println("Warning: Number images greater one. Writing only first image of the given list.");
		}
		RenderedImage molecularStructureImage = (RenderedImage)((DefaultList)list).getElement(0);
		try {
			File imageFile = new File(path + Constants.OS_SPECIFIC_FILE_SEPARATOR + filename + ".png");
			if(ImageIO.write(molecularStructureImage, "png", imageFile))
				return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean write(RenderedImage molecularStructureImage, String filename, String path) {
		try {
			File imageFile = new File(path + Constants.OS_SPECIFIC_FILE_SEPARATOR + filename + ".png");
			if(ImageIO.write(molecularStructureImage, "png", imageFile))
				return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void nullify() {
		// TODO Auto-generated method stub
		
	}

}