package de.ipbhalle.metfraglib.parameter;

import java.lang.reflect.Method;
import java.util.Vector;

import org.apache.log4j.Level;
import org.openscience.cdk.interfaces.IAtomContainer;

import de.ipbhalle.metfraglib.additionals.MoleculeFunctions;
import de.ipbhalle.metfraglib.assigner.FragmentToTandemMassPeakAssigner;
import de.ipbhalle.metfraglib.fragmenter.TopDownNeutralLossFragmenter;
import de.ipbhalle.metfraglib.fragmenterassignerscorer.TopDownFragmenterAssignerScorer;
import de.ipbhalle.metfraglib.interfaces.IDatabase;
import de.ipbhalle.metfraglib.list.DefaultPeakList;
import de.ipbhalle.metfraglib.peaklistreader.FilteredTandemMassPeakListReader;
import de.ipbhalle.metfraglib.writer.MolecularStructureImageListWriterPNG;

public class Constants {

	public static final Vector<Double> 		MONOISOTOPIC_MASSES 		= 	new Vector<Double>();
	public static final Vector<String> 		ELEMENTS 					= 	new Vector<String>();
	public static final Vector<String> 		ADDUCT_NAMES				= 	new Vector<String>();
	public static final Vector<Double> 		ADDUCT_MASSES				= 	new Vector<Double>();
	public static final Vector<Integer> 		ADDUCT_NOMINAL_MASSES		= 	new Vector<Integer>();
	public static final Vector<Boolean> 		ADDUCT_CHARGES				= 	new Vector<Boolean>();
	
	public static final Double 				PROTON_MASS 				= 	1.007276;
	
	public static final int C_INDEX = 1;
	public static final int H_INDEX = 25;
	public static final int D_INDEX = 19;
	
	/*
	 * important: isotopical labelled compounds must be located before there
	 * monoisotopic element e.g. [13C] must be located before C
	 */
	static {
		ELEMENTS.add("[13C]");	MONOISOTOPIC_MASSES.add(13.00335);
		ELEMENTS.add("C"); 		MONOISOTOPIC_MASSES.add(12.00000);
		ELEMENTS.add("Al"); 	MONOISOTOPIC_MASSES.add(26.98154);
		ELEMENTS.add("Am"); 	MONOISOTOPIC_MASSES.add(243.0614);
		ELEMENTS.add("Ar"); 	MONOISOTOPIC_MASSES.add(39.96238);
		ELEMENTS.add("As"); 	MONOISOTOPIC_MASSES.add(74.92160);
		ELEMENTS.add("At"); 	MONOISOTOPIC_MASSES.add(209.9871);
		ELEMENTS.add("Au"); 	MONOISOTOPIC_MASSES.add(196.9666);
		ELEMENTS.add("B"); 		MONOISOTOPIC_MASSES.add(11.00931);
		ELEMENTS.add("Ba"); 	MONOISOTOPIC_MASSES.add(137.9052);
		ELEMENTS.add("Bi"); 	MONOISOTOPIC_MASSES.add(208.9804);
		ELEMENTS.add("Br"); 	MONOISOTOPIC_MASSES.add(78.91834);
		ELEMENTS.add("Ca"); 	MONOISOTOPIC_MASSES.add(39.96259);
		ELEMENTS.add("Cd"); 	MONOISOTOPIC_MASSES.add(113.9034);
		ELEMENTS.add("Ce"); 	MONOISOTOPIC_MASSES.add(139.9054);
		ELEMENTS.add("Cl"); 	MONOISOTOPIC_MASSES.add(34.96885);
		ELEMENTS.add("Co"); 	MONOISOTOPIC_MASSES.add(58.93320);
		ELEMENTS.add("Cr"); 	MONOISOTOPIC_MASSES.add(51.94051); 
		ELEMENTS.add("Cu"); 	MONOISOTOPIC_MASSES.add(62.92960);
		ELEMENTS.add("D"); 		MONOISOTOPIC_MASSES.add(2.014102);
		ELEMENTS.add("F"); 		MONOISOTOPIC_MASSES.add(18.99840);
		ELEMENTS.add("Fe"); 	MONOISOTOPIC_MASSES.add(55.93494);
		ELEMENTS.add("Ga"); 	MONOISOTOPIC_MASSES.add(68.92558);
		ELEMENTS.add("Gd"); 	MONOISOTOPIC_MASSES.add(157.9241);
		ELEMENTS.add("Ge"); 	MONOISOTOPIC_MASSES.add(73.92118);
		ELEMENTS.add("H"); 		MONOISOTOPIC_MASSES.add(1.007825);
		ELEMENTS.add("He"); 	MONOISOTOPIC_MASSES.add(4.002603);
		ELEMENTS.add("Hg"); 	MONOISOTOPIC_MASSES.add(201.9706);
		ELEMENTS.add("I"); 		MONOISOTOPIC_MASSES.add(126.9045);
		ELEMENTS.add("In"); 	MONOISOTOPIC_MASSES.add(114.9039);
		ELEMENTS.add("K"); 		MONOISOTOPIC_MASSES.add(38.96371);
		ELEMENTS.add("Li"); 	MONOISOTOPIC_MASSES.add(7.016004);
		ELEMENTS.add("Mg"); 	MONOISOTOPIC_MASSES.add(23.98504);
		ELEMENTS.add("Mn"); 	MONOISOTOPIC_MASSES.add(54.93805);
		ELEMENTS.add("Mo"); 	MONOISOTOPIC_MASSES.add(97.90541);
		ELEMENTS.add("[15N]");	MONOISOTOPIC_MASSES.add(15.00011); 
		ELEMENTS.add("N"); 		MONOISOTOPIC_MASSES.add(14.00307);
		ELEMENTS.add("Na"); 	MONOISOTOPIC_MASSES.add(22.98977);
		ELEMENTS.add("Ne"); 	MONOISOTOPIC_MASSES.add(19.99244);
		ELEMENTS.add("Ni"); 	MONOISOTOPIC_MASSES.add(57.93535);
		ELEMENTS.add("[18O]");	MONOISOTOPIC_MASSES.add(17.99916);
		ELEMENTS.add("O"); 		MONOISOTOPIC_MASSES.add(15.99491);
		ELEMENTS.add("P"); 		MONOISOTOPIC_MASSES.add(30.97376);
		ELEMENTS.add("Pb"); 	MONOISOTOPIC_MASSES.add(207.9766);
		ELEMENTS.add("Po"); 	MONOISOTOPIC_MASSES.add(208.9824);
		ELEMENTS.add("Pt"); 	MONOISOTOPIC_MASSES.add(194.9648);
		ELEMENTS.add("Ra"); 	MONOISOTOPIC_MASSES.add(226.0254);
		ELEMENTS.add("Rb"); 	MONOISOTOPIC_MASSES.add(84.91179);
		ELEMENTS.add("Re"); 	MONOISOTOPIC_MASSES.add(186.9558);
		ELEMENTS.add("Ru"); 	MONOISOTOPIC_MASSES.add(101.9043);
		ELEMENTS.add("S"); 		MONOISOTOPIC_MASSES.add(31.97207);
		ELEMENTS.add("Sb"); 	MONOISOTOPIC_MASSES.add(120.9038);
		ELEMENTS.add("Se"); 	MONOISOTOPIC_MASSES.add(79.91652);
		ELEMENTS.add("Si"); 	MONOISOTOPIC_MASSES.add(27.97693);
		ELEMENTS.add("Sn"); 	MONOISOTOPIC_MASSES.add(119.9022);
		ELEMENTS.add("Tc"); 	MONOISOTOPIC_MASSES.add(97.90722);
		ELEMENTS.add("Te"); 	MONOISOTOPIC_MASSES.add(129.9062);
		ELEMENTS.add("Ti"); 	MONOISOTOPIC_MASSES.add(47.94795);
		ELEMENTS.add("Tl"); 	MONOISOTOPIC_MASSES.add(204.9744);
		ELEMENTS.add("U"); 		MONOISOTOPIC_MASSES.add(238.0508);
		ELEMENTS.add("V"); 		MONOISOTOPIC_MASSES.add(50.94396);
		ELEMENTS.add("W"); 		MONOISOTOPIC_MASSES.add(183.9509);
		ELEMENTS.add("Y"); 		MONOISOTOPIC_MASSES.add(88.90585);
		ELEMENTS.add("Zn"); 	MONOISOTOPIC_MASSES.add(63.92915);
		ELEMENTS.add("Zr"); 	MONOISOTOPIC_MASSES.add(89.90470); 
	}

	public static final Vector<Boolean> 	POSITIVE_IONISATION = new Vector<Boolean>();
	public static final Vector<Double> 	POSITIVE_IONISATION_MASS_DIFFERENCE = new Vector<Double>();

	/*
	 * some important masses
	 */
	public static final Double 				HYDROGEN_MASS 												= 	MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf(new String("H")));
	public static final Double 				ELECTRON_MASS 												= 	0.00054858;

	static {
		/*
		 * mass deviations for MODE property
		 * - [M-H]- 	-> 		- proton mass
		 * - [M]		-> 		+/- zero
		 * - [M+H]+		->		+ proton mass
		 */
		ADDUCT_NAMES.add("");		ADDUCT_MASSES.add(0.0);								ADDUCT_NOMINAL_MASSES.add(0);	ADDUCT_CHARGES.add(true);
		ADDUCT_NAMES.add("-H");		ADDUCT_MASSES.add(-1.0 * Constants.HYDROGEN_MASS);	ADDUCT_NOMINAL_MASSES.add(-1);	ADDUCT_CHARGES.add(false);
		ADDUCT_NAMES.add("+H");		ADDUCT_MASSES.add(Constants.HYDROGEN_MASS);			ADDUCT_NOMINAL_MASSES.add(1);	ADDUCT_CHARGES.add(true);
		ADDUCT_NAMES.add("-D");		ADDUCT_MASSES.add(-1.0 * MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("D")));			ADDUCT_NOMINAL_MASSES.add(-2);	ADDUCT_CHARGES.add(false);
		ADDUCT_NAMES.add("+D");		ADDUCT_MASSES.add(MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("D")));					ADDUCT_NOMINAL_MASSES.add(2);	ADDUCT_CHARGES.add(true);
		
		/*
		 * ToDo
		 */
		//positive
		ADDUCT_NAMES.add("+NH4");		ADDUCT_MASSES.add(Constants.HYDROGEN_MASS * 4.0 + MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("N")));	ADDUCT_NOMINAL_MASSES.add(18);	ADDUCT_CHARGES.add(true);
		ADDUCT_NAMES.add("+Na");		ADDUCT_MASSES.add(MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("Na")));									ADDUCT_NOMINAL_MASSES.add(23);	ADDUCT_CHARGES.add(true);
		ADDUCT_NAMES.add("+K");			ADDUCT_MASSES.add(MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("K")));									ADDUCT_NOMINAL_MASSES.add(39);	ADDUCT_CHARGES.add(true);
		ADDUCT_NAMES.add("+CH3OH+H");	ADDUCT_MASSES.add(33.033489);																		ADDUCT_NOMINAL_MASSES.add(33);	ADDUCT_CHARGES.add(true);
		
		//negative
		ADDUCT_NAMES.add("+Cl");		ADDUCT_MASSES.add(MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("Cl")));																									ADDUCT_NOMINAL_MASSES.add(35);	ADDUCT_CHARGES.add(false);
		ADDUCT_NAMES.add("+HCOO");		ADDUCT_MASSES.add(Constants.HYDROGEN_MASS + MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("C")) + MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("O")) * 2.0);					ADDUCT_NOMINAL_MASSES.add(45);	ADDUCT_CHARGES.add(false);
		ADDUCT_NAMES.add("+CH3COO");	ADDUCT_MASSES.add(Constants.HYDROGEN_MASS * 3.0 + MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("C")) * 2.0 + MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf("O")) * 2.0);		ADDUCT_NOMINAL_MASSES.add(59);	ADDUCT_CHARGES.add(false);
		
		ADDUCT_NAMES.add("+ACN+H");		ADDUCT_MASSES.add(42.033823);		ADDUCT_NOMINAL_MASSES.add(42);	ADDUCT_CHARGES.add(true);
		ADDUCT_NAMES.add("+ACN+Na");	ADDUCT_MASSES.add(64.015765);		ADDUCT_NOMINAL_MASSES.add(64);	ADDUCT_CHARGES.add(true);
		ADDUCT_NAMES.add("+2ACN+H");	ADDUCT_MASSES.add(83.060370);		ADDUCT_NOMINAL_MASSES.add(83);	ADDUCT_CHARGES.add(true);
		
		
		
		/*
		 * mass deviations for CHARGE property
		 * positive 	->		- electron mass
		 * negative 	->		+ electron mass
		 */
		POSITIVE_IONISATION.add(true);		POSITIVE_IONISATION_MASS_DIFFERENCE.add(	-1.0 * Constants.ELECTRON_MASS	);	
		POSITIVE_IONISATION.add(false);		POSITIVE_IONISATION_MASS_DIFFERENCE.add(	Constants.ELECTRON_MASS			);
	}

	public static final Double				DEFAULT_BOND_ENERGY											=	348.0; //C-C bond
	public static final String 				OS_SPECIFIC_FILE_SEPARATOR 									= 	System.getProperty("file.separator");
	public static final Double 				DEFAULT_NUMBER_OF_DIGITS_AFTER_ROUNDING 					= 	5d;
	public static final Double 				DEFAULT_MAXIMUM_RELATIVE_INTENSITY 							= 	999.0;
	public static final String				OS_TEMP_DIR													=	System.getProperty("java.io.tmpdir");
	public static final String				OS_LINE_SEPARATOR											=	System.getProperty("line.separator");
	public static final DefaultPeakList 		DEFAULT_PEAK_LIST											= 	null;
	public static final Byte 					DEFAULT_MAXIMUM_TREE_DEPTH 									= 	2;
	public static final Double 				DEFAULT_MIN_MASS_DEV_FOR_FRAGMENT_GENERATION				= 	5.0;
	public static final Byte 					DEFAULT_MAXIMUM_NUMBER_OF_TOPDOWN_FRAGMENT_ADDED_TO_QUEUE 	= 	2;
	public static final Double 				DEFAULT_DATABASE_SEARCH_RELATIVE_MASS_DEV 					= 	10.0; //searchppm
	public static final Double 				DEFAULT_FRAGMENT_PEAK_RELATIVE_MASS_DEV 					= 	10.0; //ppm
	public static final Double 				DEFAULT_FRAGMENT_PEAK_ABSOLUTE_MASS_DEV 					= 	0.01;
	public static final Boolean 				DEFAULT_CONSIDER_HYDROGEN_MASS_DIFFERENCE 					= 	true;
	public static final Double 				DEFAULT_MINIMUM_ABSOLUTE_PEAK_INTENSITY 					= 	0.0;
	public static final Double				DEFAULT_MINIMUM_FRAGMENT_MASS_LIMIT							=	0.0;
	public static final Double				DEFAULT_PRECURSOR_NEUTRAL_MASS								=	null;
	public static final Double				DEFAULT_DATABASE_RELATIVE_MASS_DEVIATION					=	null;
	public static final String 				DEFAULT_PRECURSOR_MOLECULAR_FORMULA							=	null;
	public static final String 				DEFAULT_PRECURSOR_DATABASE_IDS								=	null;
	public static final String 				DEFAULT_PEAK_LIST_PATH										=	null;
	public static final Integer				DEFAULT_PRECURSOR_ION_TYPE 									= 	1;

	public static final Integer 			DEFAULT_STRUCTURE_IMAGE_WIDTH 								= 	200;
	public static final Integer 			DEFAULT_STRUCTURE_IMAGE_HEIGHT 								= 	200;
	public static final Double 			DEFAULT_STRUCTURE_STROKE_RATIO 								=	1.0;
	public static final Boolean 			DEFAULT_POSITIVE_IONISATION_MODE 							= 	true;
	public static final Byte 				DEFAULT_NUMBER_THREADS 										= 	(byte)1;

	public static final String			DEFAULT_METFRAG_PEAK_LIST_READER							= 	FilteredTandemMassPeakListReader.class.getName();
	public static final String			DEFAULT_METFRAG_ASSIGNER_SCORER								= 	TopDownFragmenterAssignerScorer.class.getName();
	public static final Double[]			DEFAULT_METFRAG_SCORE_WEIGHTS								=	{1.0};	
	
	public static final String[]			DEFAULT_METFRAG_POST_PROCESSING_CANDIDATE_FILTER			=	{};
	public static final String[]			DEFAULT_METFRAG_PRE_PROCESSING_CANDIDATE_FILTER				=	{"UnconnectedCompoundFilter", "IsotopeFilter"};
	public static final String[] 			DEFAULT_METFRAG_CANDIDATE_WRITER 							= 	{"XLS"};
	public static final String 			DEFAULT_METFRAG_DATABASE_TYPE								=	"KEGG";		
	public static final String 			DEFAULT_METFRAG_FRAGMENTER_TYPE								=	TopDownNeutralLossFragmenter.class.getName();
	public static final String 			DEFAULT_METFRAG_ASSIGNER_TYPE								=	FragmentToTandemMassPeakAssigner.class.getName();
	public static final String[] 			DEFAULT_METFRAG_SCORE_TYPES									=	{VariableNames.METFRAG_FRAGMENTER_SCORE_NAME};	

	public static final String			DEFAULT_METFRAG_IMAGE_WRITER								=	MolecularStructureImageListWriterPNG.class.getName();		
	public static final String 			DEFAULT_BOND_ENERGY_FILE_PATH								=	null;
	public static final Level				DEFAULT_LOG_LEVEL											=	Level.INFO;
	public static final Boolean			DEFAULT_METFRAG_UNIQUE_FRAGMENT_MATCHES						=	false;

	/*
	 * 
	 */
	public static final IDatabase			DEFAULT_DATABASE_OBJECT											=	null;
	public static final String			DEFAULT_DATABASE_IDENTIFIER										=	null;
	public static final Boolean			DEFAULT_ENABLE_DEUTERIUM										=	false;
	public static final String[]			DEFAULT_SCORE_NAMES_NOT_TO_SCALE								=	{"IndividualMoNAScore", "HDFragmentPairScore", "SimScore"};
	
	/*
	 * retention time models
	 */
	public static final Double 				DEFAULT_EXPERIMENTAL_RETENTION_TIME_VALUE						=	null;
	public static final String 				DEFAULT_LOG_P_VALUE_NAME 										= 	"UserLogP";
	public static final Double 				DEFAULT_RETENTION_TIME_STANDARD_DEVIATION_NORMAL_DISTRIBUTION 	= 	1.5;
	public static final Double 				DEFAULT_RETENTION_TIME_CORRELATION_ATOMCONTAINER_VALUE 			= 	(double)Integer.MAX_VALUE;
	public static final Integer 				DEFAULT_NUMBER_RANDOM_SPECTRA						 			= 	1000;
	public static final String				DEFAULT_MASSBANK_URL											=	"http://www.massbank.jp/";
	public static final String				DEFAULT_MASSBANK_RECORD_CACHE_DIRECTORY							=	"/vol/massbank/Cache/";

	/*
	 * constants for local database connection
	 */
	public static final String 				DEFAULT_LOCAL_DATABASE_COMPOUND_TABLE		= 	"compounds";
	public static final String 				DEFAULT_LOCAL_DATABASE_SERVER_IP			= 	"127.0.0.1";
	public static final String 				DEFAULT_LOCAL_DATABASE_MASS_COLUMN			= 	"monoisotopicmass";
	public static final String 				DEFAULT_LOCAL_DATABASE_FORMULA_COLUMN		= 	"formula";
	public static final String 				DEFAULT_LOCAL_DATABASE_INCHI_COLUMN			=	"inchi";
	public static final String 				DEFAULT_LOCAL_DATABASE_INCHIKEY1_COLUMN		=	"inchikey1";
	public static final String 				DEFAULT_LOCAL_DATABASE_INCHIKEY2_COLUMN		= 	"inchikey2";
	public static final String 				DEFAULT_LOCAL_DATABASE_CID_COLUMN			= 	"cid";
	public static final String 				DEFAULT_LOCAL_DATABASE_SMILES_COLUMN		= 	"smiles";
	public static final String 				DEFAULT_LOCAL_DATABASE						=	null;
	public static final String 				DEFAULT_LOCAL_DATABASE_USER					=	null;
	public static final String 				DEFAULT_LOCAL_DATABASE_PASSWORD				=	null;
	public static final String 				DEFAULT_LOCAL_DATABASE_PORT_NUMBER			=	null;
	
	/*
	 * 
	 *			Functions
	 *
	 *
	 *
	 *
	 */
	/*
	public static Double getIonisationTypeMassCorrection(Integer precursorIonType, boolean positiveIonisation) {
		if(precursorIonType != 0) return ADDUCT_MASSES.get(ADDUCT_NOMINAL_MASSES.indexOf(precursorIonType));
		return POSITIVE_IONISATION_MASS_DIFFERENCE.get(POSITIVE_IONISATION.indexOf(positiveIonisation));
	}
	*/
	
	public static Double getIonisationTypeMassCorrection(Integer precursorIonTypeIndex, boolean positiveIonisation) {
		return ADDUCT_MASSES.get(precursorIonTypeIndex) + POSITIVE_IONISATION_MASS_DIFFERENCE.get(POSITIVE_IONISATION.indexOf(positiveIonisation));
	}
	
	public static Double getMonoisotopicMassOfAtom(String atom) {
		return MONOISOTOPIC_MASSES.get(ELEMENTS.indexOf(atom));
	}

	public static Double getMonoisotopicMassOfAtom(int atomIndex) {
		return MONOISOTOPIC_MASSES.get(atomIndex);
	}

	public static String getIonisationTypeNameByNominalMassDifference(int nominalMassDifference) {
		return ADDUCT_NAMES.get(ADDUCT_NOMINAL_MASSES.indexOf(nominalMassDifference));
	}
	
	public static boolean getIonisationChargeNameByNominalMassDifference(int nominalMassDifference) {
		return ADDUCT_CHARGES.get(ADDUCT_NOMINAL_MASSES.indexOf(nominalMassDifference));
	}
	
	
	public static final Vector<Method> METHODS = new Vector<Method>();
	public static final Vector<String> METHOD_NAMES = new Vector<String>();

	public static final String[] EXCHANGEABLE_DEUTERIUM_POSITIONS = new String[] { "O", "N", "S" };
	
	/*
	 * methods for retention time models
	 * still needs to be implemented
	 */
	static {
		METHOD_NAMES.add("CDK_XLOGP");	
		METHOD_NAMES.add("CDK_ALOGP");	
		try {
			METHODS.add(MoleculeFunctions.class.getMethod("getCDKXLogValue", new Class[] {IAtomContainer.class}));
			METHODS.add(MoleculeFunctions.class.getMethod("getCDKALogValue", new Class[] {IAtomContainer.class}));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
