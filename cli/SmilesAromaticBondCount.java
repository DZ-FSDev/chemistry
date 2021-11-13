package com.dz_fs_dev.chemistry.cli;

import org.openscience.cdk.aromaticity.Aromaticity;
import org.openscience.cdk.aromaticity.ElectronDonation;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.graph.CycleFinder;
import org.openscience.cdk.graph.Cycles;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.interfaces.IChemObjectBuilder;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;

/**
 * Command-line SMILES aromatic bond counter.
 *
 * @author DZ-FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public class SmilesAromaticBondCount {
	public static void main(String[] args) {
		if(args.length > 0) {
			IChemObjectBuilder chemBuilder = SilentChemObjectBuilder.getInstance();
			SmilesParser smiParser = new SmilesParser(chemBuilder);
			IAtomContainer atomContainer;

			try {
				atomContainer = smiParser.parseSmiles(args[0]);

				ElectronDonation model = ElectronDonation.daylight();
				CycleFinder cycles = Cycles.or(Cycles.all(), Cycles.all(6));
				Aromaticity aromaticity = new Aromaticity(model, cycles);

				boolean aromatic = aromaticity.apply(atomContainer);
				
				System.out.printf(aromatic ? "%s,%d" : "%s",
						args[0], aromaticity.findBonds(atomContainer).size());
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
