package com.dz_fs_dev.chemistry.cli;

import java.io.IOException;

import org.openscience.cdk.config.Elements;
import org.openscience.cdk.config.Isotopes;
import org.openscience.cdk.interfaces.IIsotope;

/**
 * Command-line display of atomic properties given an element.
 *
 * @author DZ-FSDev
 * @since 17.0.1
 * @version 0.0.5
 */
public class ElementProperties {
	public static void main(String[] args) {
		if(args.length > 0) {
			Elements element = Elements.valueOf(args[0]);
			System.out.println(element.name());
			System.out.println("Atomic Number:\t" + element.number());
			System.out.println("Symbol:\t" + element.symbol());
			System.out.println("Group:\t" + element.group());
			System.out.println("Period:\t" + element.period());
			System.out.println("Metal:\t" + Elements.isMetal(element.number()));
			System.out.println("Electronegativity:\t" + element.electronegativity());
			System.out.println("Covalent Radius:\t" + element.covalentRadius());
			System.out.println("VDW Radius:\t" + element.vdwRadius());
			
			IIsotope isotope;
			try {
				isotope = Isotopes.getInstance().getMajorIsotope(element.symbol());
				System.out.println("Isotope:\t" + element.symbol() + isotope.getMassNumber());
				System.out.println("Natural Abundance:\t" + isotope.getNaturalAbundance());
				System.out.println("Mass:\t" + isotope.getExactMass());
			} catch (IOException e) {
				System.out.println("Isotope Data Not Available");
				//e.printStackTrace();
			}
			
		}else if(args.length == 1 && args[0].equals("/?")){
			System.out.println("Expected argument list: element [mass number]"); //TODO
			System.out.println();
		}else {
			System.out.println("Invalid arguments were provided. Use /? for more information.");
		}
	}
}
