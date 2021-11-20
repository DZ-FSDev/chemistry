package com.dz_fs_dev.chemistry.cli;

import java.awt.Color;
import java.io.IOException;

import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.DefaultChemObjectBuilder;
import org.openscience.cdk.depict.DepictionGenerator;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.inchi.InChIGeneratorFactory;
import org.openscience.cdk.inchi.InChIToStructure;
import org.openscience.cdk.interfaces.IAtomContainer;
import net.sf.jniinchi.INCHI_RET;

/**
 * Command-line InChI translator to PNG.
 *
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class InChItoPNG {
	public static void main(String[] args) {
		if(args.length > 1) {
			InChIToStructure intostruct;

			try {
				InChIGeneratorFactory factory = InChIGeneratorFactory.getInstance();

				intostruct = factory.getInChIToStructure(
						args[0], DefaultChemObjectBuilder.getInstance()
						);

				INCHI_RET ret = intostruct.getReturnStatus();
				if (ret == INCHI_RET.WARNING) {
					// Structure generated, but with warning message
					System.out.println("InChI warning: " + intostruct.getMessage());
				} else if (ret != INCHI_RET.OKAY) {
					// Structure generation failed
					throw new CDKException("Structure generation failed failed: " + ret.toString()
					+ " [" + intostruct.getMessage() + "]");
				}

				DepictionGenerator depictGen = new DepictionGenerator();
				IAtomContainer atomContainer;

				atomContainer = intostruct.getAtomContainer();
				atomContainer.setProperty(CDKConstants.TITLE, args[1]);

				depictGen.withSize(400, 500)
				.withFillToFit()
				.withMolTitle()
				.withTitleColor(Color.DARK_GRAY)
				.depict(atomContainer)
				.writeTo(args[1] + ".png");
			} catch (InvalidSmilesException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CDKException e) {
				e.printStackTrace();
			}
		}else if(args.length == 1 && args[0].equals("/?")){
			System.out.println("Expected argument list: InChI TITLE [SAVE_PATH]");
			System.out.println();
		}else {
			System.out.println("Invalid arguments were provided. Use /? for more information.");
		}
	}
}
