package com.dz_fs_dev.chemistry;

import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.depict.DepictionGenerator;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;
import java.awt.Color;
import java.io.IOException;

/**
 * Command-line SMILES translator to PNG. 
 * 
 * @author DZ-FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public class SmilesToPNG_CLI {
	public static void main(String[] args) {
		if(args.length > 1) {
			IChemObjectBuilder chemBuilder = SilentChemObjectBuilder.getInstance();
			SmilesParser smiParser = new SmilesParser(chemBuilder);
			DepictionGenerator depictGen = new DepictionGenerator();

			IAtomContainer atomContainer;
			try {
				atomContainer = smiParser.parseSmiles(args[0]);
				atomContainer.setProperty(CDKConstants.TITLE, args[1]);

				depictGen.withSize(200, 250)                 
				.withMolTitle()
				.withTitleColor(Color.DARK_GRAY);

				depictGen.depict(atomContainer)
				.writeTo(args[1] + ".png");
			} catch (InvalidSmilesException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CDKException e) {
				e.printStackTrace();
			}
		}else {

		}
	}
}
