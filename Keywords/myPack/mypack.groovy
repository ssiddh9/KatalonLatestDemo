package myPack

import java.text.DateFormat
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class GTIN {
	public Pallet palletItem;

	@Keyword
	public String genGTIN(int firstDigit) {
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmm");
		Date date = new Date();
		String curDate = dateFormat.format(date);

		int GTINrand = Math.floor(Math.random() * 10000);

		String strGTINrand = "";



		if (GTINrand < 10) {
			strGTINrand = "000" + GTINrand;
		} else if (GTINrand < 100) {
			strGTINrand = "00" + GTINrand;
		} else if (GTINrand < 1000) {
			strGTINrand = "0" + GTINrand;
		} else {
			strGTINrand = "" + GTINrand;
		}

		String GTIN = firstDigit + curDate + strGTINrand;
		//		String GTIN = firstDigit + strGTINrand+ curDate ;

		//Integer[] indata = GTIN.split("");

		String [] sindata = GTIN.split("");
		int[] indata = new int[sindata.length]
		for(int i=0;i<sindata.length;i++) {

			indata[i]= Integer.parseInt(sindata[i])
			//	System.out.println( indata[i])
		}


		int ctrl = indata[12] + indata[10] + indata[8] + indata[6] + indata[4] + indata[2] + indata[0];
		ctrl = ctrl * 3;
		ctrl = ctrl + indata[1] + indata[3] + indata[5] + indata[7] + indata[9] + indata[11];
		ctrl = ctrl % 10;
		if (ctrl != 0) ctrl = 10 - ctrl;

		return GTIN + ctrl;
	}


	@Keyword
	public void genSOI() {
		DateFormat dateFormat = new SimpleDateFormat("ddHHmm");
		Date date = new Date();

		String curDate = dateFormat.format(date);
		int date2 = Integer.parseInt(curDate);
		date2 += 100000 > date2 ? 10000 : 0;
		GlobalVariable.ddhhmm = curDate;
		println("SOI: "+curDate)
	}

	/**
	 * Creates one parent case which can have multiple children cases with multiple bases each.
	 * P(C(Cn(Bm)))
	 * @param cases, number of children cases, has to be bigger than 0.
	 * @param bases. number of children bases for each case except the root case. 
	 * 
	 */
	@Keyword
	public Pallet generateItems(int cases, int bases){
		Pallet pallet = new Pallet();
		Case parentCase = new Case();
		addGlobalVariable("PalletGTIN", pallet.getGTIN());
		addGlobalVariable("CaseGTIN",parentCase.getGTIN());

		//Creates cases and bases for each created case
		int quickFix = 1;
		for(int i = 0; i<cases;i++){
			Case c = new Case();
			addGlobalVariable("CaseGTIN"+ quickFix,c.getGTIN());
			for(int j = 0; j<bases;j++){
				Base b = new Base();
				addGlobalVariable("BaseGTIN"+i,b.getGTIN());
				c.childrenBases.add(b);
				b.parent.add(c);
			}
			quickFix++;
			parentCase.childrenCases.add(c);
			c.parent.add(parentCase)
		}
		pallet.children.add(parentCase);
		parentCase.parent.add(pallet)
		palletItem = pallet;
		return pallet;
	}

	/**
	 * Multiple cases but one base. One parent case with child cases. One leaf node (base) at the end of the tree
	 * @param p, null on default, creates a new pallet. However, if you want to use existing pallet it is also possible.
	 * @param cases, number of cases desired
	 * @param c, Case object, null on default. 
	 * @return Pallet with the structure created. 
	 */
	@Keyword
	public Pallet genRI03_GenCasesForPallet(Pallet p, int cases, Case c){

		if(p == null){
			p = new Pallet();
		}

		if(c == null){
			Case parentCase = new Case();
			addGlobalVariable("PalletGTIN", p.getGTIN());
			addGlobalVariable("CaseGTIN",parentCase.getGTIN());
			c = new Case();
			addGlobalVariable("CaseGTIN" + cases--, c.getGTIN());
			parentCase.childrenCases.add(c);
			c.parentCase.add(parentCase)
			genRI03_GenCasesForPallet(p, cases--, c)
		}else if(cases >1 && c != null){
			Case c2 = new Case();
			addGlobalVariable("CaseGTIN" + cases--, c.getGTIN());
			c.childrenCases.add(c2);
			c2.parentCase.add(c);
			genRI03_GenCasesForPallet(p, cases--, c2)
		}else if(cases == 1 && c!=null){
			Base b = new Base();
			addGlobalVariable("BaseGTIN", b.getGTIN());
			c.childrenBases.add(b);
			b.parentCase.add(c);
		}

		return p;
	}

	/**
	 * Creates pallet-base structure. No middle case between. 
	 * @return
	 */
	@Keyword
	public Pallet gen_PalletBase(Pallet p, int bases){

		if(p == null){
			p = new Pallet();
			addGlobalVariable("PalletGTIN", p.getGTIN(),true);
		}

		for(int i = 0; i<bases;i++){
			Base b = new Base();
			addGlobalVariable("BaseGTIN" + i, b.getGTIN(),true);
//			addGlobalVariable("PalletGTIN" + i, p.getGTIN());
			p.childrenBases.add(b);
			b.parentPallet.add(p);
		}

		return p;
	}

	/**
	 * Adds bases to a case
	 * @param bases, number of bases
	 * @param c, current case object
	 * @return Case object with bases in it
	 */
	public Case addBasesToCase(int bases, Case c){
		for(int i = 0; i<bases;i++){
			Base b = new Base();
			addGlobalVariable("BaseGTIN" + i, b.getGTIN());
			c.childrenBases.add(b);
			b.parentCase.add(c);
		}
		return c;
	}

	/**
	 * Create structure for usual 3 level structure but with multiple bases
	 * @param bases, number of desired bases
	 * @return Pallet object with Case and all of the Base objects inside. 
	 */
	@Keyword
	public Pallet genPC_Multibase(int bases){
		Pallet pallet = new Pallet();
		Case parentCase = new Case();
		addGlobalVariable("PalletGTIN", pallet.getGTIN());
		addGlobalVariable("CaseGTIN",parentCase.getGTIN());

		for(int i = 0; i<bases; i++){
			Base b = new Base();
			addGlobalVariable("BaseGTIN"+i,b.getGTIN());
			parentCase.childrenBases.add(b);
			b.parentCase.add(parentCase);
		}

		parentCase.parent.add(pallet);
		return pallet;
	}

	@Keyword
	public def gen_base() {
		//Pallet pallet = new Pallet();
		//def b1
		//Base base = new Base();
		def b1= genGTIN(0);
		//for(int i = 0; i<bases; i++){

		//	addGlobalVariable("BaseGTIN",base.getGTIN(),true)
		//			c.childrenBases.add(b);
		//			b.parentCase.add(c);
		//b1=println(addGlobalVariable("BaseGTIN",base.getGTIN(),true));
		//}

		//parentCase.parent.add(pallet);
		return b1;

	}

	@Keyword
	public Pallet getPallet_ID37(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)
		addGlobalVariable("BaseGTIN",base.getGTIN(),true)

		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	@Keyword
	public Pallet getPallet_ID37_W(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)
		addGlobalVariable("BaseGTIN2",base.getGTIN(),true)

		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}


	//
	@Keyword
	public Pallet getPallet_ID41(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN1", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN1", case1.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	

	@Keyword
	public Pallet getPallet_ID41_1(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	@Keyword
	public Pallet getPallet_ID41_2(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN", pallet.getGTIN())
		addGlobalVariable("CaseGTIN", case1.getGTIN())


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}

	@Keyword
	public Pallet getPallet_ID66(int i){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN"+i, pallet.getGTIN())
		addGlobalVariable("CaseGTIN"+i, case1.getGTIN())


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}

	@Keyword
	public Pallet getPallet_ID66(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN", pallet.getGTIN())
		addGlobalVariable("CaseGTIN", case1.getGTIN())


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}

	@Keyword
	public Pallet getPallet_ID36(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN1", pallet.getGTIN(),true)
		//		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	@Keyword
	public Pallet getPallet_ID36_1(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN", pallet.getGTIN())
		//		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	@Keyword
	public Pallet getPallet_ID37PD(){

		//		Pallet pallet = new Pallet();
		//		Case case1 = new Case();
		//		Base base = new Base();
		//		Map map = (Map) GlobalVariable.Items;
		//		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		//		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)
		//		addGlobalVariable("BaseGTIN",map.get("BaseGTIN"),true)
		//
		//		case1.childrenBases.add(base);
		//		base.parentCase.add(case1);
		//		case1.parent.add(pallet);
		//		pallet.children.add(case1);
		Pallet p = new Pallet();
		p.genGTIN(2);
		Case c = new Case();
		c.genGTIN(1);
		//c.GTIN = GlobalVariable.Items.CaseGTIN.toString();
		p.children.add(c);
		c.parent.add(p);
		//			p = gtin.getPallet_ID37PD();
		//			Case c = new Case();
		Base b = new Base();
		Map map = (Map) GlobalVariable.Items;


		b.GTIN = GlobalVariable.Items.BaseGTIN.toString();
		//			p.GTIN = GlobalVariable.Items.PalletGTIN.toString();
		//			c.GTIN = GlobalVariable.Items.CaseGTIN.toString();
		c.childrenBases.add(b);
		b.parentCase.add(c);
		//p.childrenBases.add(b);
		//			b.parentPallet.add(p);
		addGlobalVariable("PalletGTIN", p.getGTIN(),true)
		addGlobalVariable("CaseGTIN", c.getGTIN(),true)
		addGlobalVariable("BaseGTIN",b.getGTIN(),true)
		println( GlobalVariable.Items.BaseGTIN.toString());


		return p;
	}

	//W Struct

	@Keyword
	public Pallet getPallet_ID49W(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();
		Base base2 = new Base()
		Map map = (Map) GlobalVariable.Items;
		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)
		addGlobalVariable("BaseGTIN",map.get("BaseGTIN"),true)
		addGlobalVariable("BaseGTIN2",map.get("BaseGTIN2"),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1)

		case1.childrenBases.add(base2);
		base2.parentCase.add(case1)

		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	//
	@Keyword
	public Pallet getPallet_ID49(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();
		Base base2 = new Base()

		addGlobalVariable("PalletGTIN2", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN2", case1.getGTIN(),true)
		addGlobalVariable("BaseGTIN",base.getGTIN(),true)
		addGlobalVariable("BaseGTIN2",base2.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1)

		case1.childrenBases.add(base2);
		base2.parentCase.add(case1)

		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	@Keyword
	public Pallet getPallet_ID49S1(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();
		Base base2 = new Base()
		Map map = (Map) GlobalVariable.Items;
		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)
		addGlobalVariable("BaseGTIN",base.getGTIN(),true)
		addGlobalVariable("BaseGTIN2",base2.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1)

		case1.childrenBases.add(base2);
		base2.parentCase.add(case1)

		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	@Keyword
	public Pallet getPallet_ID49S(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();
		Base base2 = new Base()

		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)
		addGlobalVariable("BaseGTIN",base.getGTIN(),true)
		//		addGlobalVariable("BaseGTIN2",base2.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1)

		case1.childrenBases.add(base2);
		base2.parentCase.add(case1)

		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}

	@Keyword
	public Pallet getPallet_ID51(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Case case2 = new Case();
		Base base = new Base()

		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN", case1.getGTIN(),true)
		addGlobalVariable("CaseGTIN1",case2.getGTIN(),true)
		addGlobalVariable("BaseGTIN",base.getGTIN(),true)


		case1.childrenCases.add(case2);
		case2.parentCase.add(case1)

		//		case2..add(base2);
		case2.childrenBases.add(base);
		base.parentCase.add(case2)

		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}
	
	@Keyword
	public Pallet getPallet_ID51_1(){
		Pallet pallet = new Pallet();
		Case case1 = new Case();
		Base base = new Base();

		addGlobalVariable("PalletGTIN1", pallet.getGTIN(),true)
		addGlobalVariable("CaseGTIN2", case1.getGTIN(),true)


		case1.childrenBases.add(base);
		base.parentCase.add(case1);
		case1.parent.add(pallet);
		pallet.children.add(case1);

		return pallet;
	}

	@Keyword
	public Pallet getPallet_ID39(){
		Pallet pallet = new Pallet();

		Base base = new Base()

		addGlobalVariable("PalletGTIN", pallet.getGTIN(),true)

		addGlobalVariable("BaseGTIN",base.getGTIN(),true)
		base.parent.add(pallet);
		pallet.children.add(base);

		return pallet;
	}



	@Keyword
	public void addGlobalVariable(String name, def value) {
		Map map = (Map) GlobalVariable.CIN_1;
		map.put(name, value);
		println(name + " " + map.get(name))
	}

	@Keyword
	public void addGlobalVariable(String name, def value, boolean notCIN_1) {
		Map map =(Map) GlobalVariable.Items;
		map.put(name, value);
		println(name + " " + map.get(name))
	}

	@Keyword
	public void addGlobalVariableCC(String name, def value, boolean notCIN_1) {
		Map map =(Map) GlobalVariable.ccitem;
		map.put(name, value);
		println(name + " " + map.get(name))
	}

	@Keyword
	public Map getGlobalVariableItems(){
		return (Map) GlobalVariable.CIN_1;
	}

}




public abstract class GTINReq {
	public String GTIN;
	public boolean expanded = false;

	public void genGTIN(int identifier){
		GTIN g = new GTIN();
		GTIN = g.genGTIN(identifier);
	}

	public String getGTIN() {
		return GTIN;
	}
}


public class Pallet extends GTINReq{
	public List<Case> children = new ArrayList<Case>();
	public List<Base> childrenBases = new ArrayList<Base>();

	public Pallet(){
		super.genGTIN(7);
		this.GTIN = super.GTIN;
		//		println("PalletGTIN = " + this.GTIN)
	}
}

public class Case extends GTINReq{
	public List<Base> childrenBases = new ArrayList<Base>();
	public List<Case> childrenCases = new ArrayList<Case>();
	public List<Pallet> parent = new ArrayList<Pallet>();
	public List<Case> parentCase = new ArrayList<Case>();

	public Case(){
		super.genGTIN(5);
		this.GTIN = super.GTIN;
		//		println("CaseGTIN = " + this.GTIN)
	}
}

public class Base extends GTINReq{
	public List<Base> parent = new ArrayList<Base>();
	public List<Case> parentCase = new ArrayList<Case>();
	public List<Pallet> parentPallet = new ArrayList<Pallet>();

	public Base(){
		super.genGTIN(0);
		this.GTIN = super.GTIN;
		//		println("BaseGTIN = " + this.GTIN)
	}


}

