package com.dz_fs_dev.chemistry.cli;

import org.openscience.cdk.fingerprint.HybridizationFingerprinter;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.similarity.Tanimoto;

import java.text.DecimalFormat;
import java.util.BitSet;

import org.openscience.cdk.exception.CDKException;

/**
 * Command-line SMILES similarity table generator. 
 * 
 * @author DZ-FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public class SmilesSimilarityScoreTable {
	public static void main(String[] args) {
		if(args.length > 1) {
			float[][] scoreTable = new float[args.length][args.length];
			SmilesParser smilesParser = new SmilesParser(SilentChemObjectBuilder.getInstance());

			for(int x = 0; x < args.length; x++)
				for(int y = x; y < args.length; y++) {
					if(x == y) {
						scoreTable[x][y]=1.0f;
						continue;
					}else {
						try {
							IAtomContainer atomContainer1 = smilesParser.parseSmiles(args[x]);
							IAtomContainer atomContainer2 = smilesParser.parseSmiles(args[y]);
							HybridizationFingerprinter fingerprinter = new HybridizationFingerprinter();
							BitSet bitset1 = fingerprinter.getFingerprint(atomContainer1);
							BitSet bitset2 = fingerprinter.getFingerprint(atomContainer2);
							scoreTable[x][y] = Tanimoto.calculate(bitset1, bitset2);
						} catch (CDKException e) {
							e.printStackTrace();
						}
					}
				}

			DecimalFormat decimalFormatter = new DecimalFormat("0.000");
			for(int x = 0; x < args.length; x++) {
				for(int y = 0; y < args.length; y++) {
					System.out.printf("\t%s", decimalFormatter.format(scoreTable[x][y]));
				}
				System.out.println();
			}
		}else if(args.length == 1 && args[0].equals("/?")){
			System.out.println("Expected argument list: SMILES1 [SMILES2] ...");
			System.out.println();
		}else {	
			System.out.println("Invalid arguments were provided. Use /? for more information.");
		}
	}
}
