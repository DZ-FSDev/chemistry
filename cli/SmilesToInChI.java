package com.dz_fs_dev.chemistry.cli;

import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.inchi.InChIGenerator;
import org.openscience.cdk.inchi.InChIGeneratorFactory;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IChemObjectBuilder;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;

import net.sf.jniinchi.INCHI_RET;

/**
 * Command-line SMILES translator to InChI.
 *
 * @author DZ-FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public class SmilesToInChI {
	public static void main(String[] args) {
		if(args.length > 0) {
			IChemObjectBuilder chemBuilder = SilentChemObjectBuilder.getInstance();
			SmilesParser smiParser = new SmilesParser(chemBuilder);
			IAtomContainer atomContainer;

			try {
				atomContainer = smiParser.parseSmiles(args[0]);
				
				InChIGeneratorFactory factory = InChIGeneratorFactory.getInstance();
				InChIGenerator generator = factory.getInChIGenerator(atomContainer);
				if (generator.getReturnStatus() == INCHI_RET.OKAY)
					System.out.println(generator.getInchi());
			} catch (InvalidSmilesException e) {
				e.printStackTrace();
			} catch (CDKException e) {
				e.printStackTrace();
			}
		}else if(args.length == 1 && args[0].equals("/?")){
			System.out.println("Expected argument list: SMILES");
			System.out.println();
		}else {
			System.out.println("Invalid arguments were provided. Use /? for more information.");
		}
	}
}
