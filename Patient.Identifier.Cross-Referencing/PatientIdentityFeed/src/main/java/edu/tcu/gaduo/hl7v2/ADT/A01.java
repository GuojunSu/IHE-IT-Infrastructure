package edu.tcu.gaduo.hl7v2.ADT;

import java.io.IOException;

import org.apache.log4j.Logger;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v231.message.ADT_A01;
import edu.tcu.gaduo.ihe.hl7v231.info.MessageHeader;
import edu.tcu.gaduo.ihe.hl7v231.info.PatientIdentification;


public class A01 extends ADT {
    public static Logger logger = Logger.getLogger(A01.class);
	private ADT_A01 adt;
	
	/**
	 * ITI-08 transaction message, ADT^A01：住院病患掛號, Admit/visit notification
	 * @param pSegment
	 * @param mshSegment
	 */
	public A01(PatientIdentification pSegment, MessageHeader mshSegment) {
		try {
			adt = new ADT_A01();
			adt.initQuickstart("ADT", "A01", "P");
			mshSegment.setMsh(adt.getMSH());
			msh = mshSegment.getMsh();
			evn = adt.getEVN();
			evn = this.getEvn(evn);
			pSegment.setPid(adt.getPID());
			pid = pSegment.getPid();
			pv1 = adt.getPV1();
			pv1 = this.getPv1(pv1);
		} catch (HL7Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		StringBuffer bs = new StringBuffer();
		try {
			bs.append(Start_Block);
			bs.append(msh.encode()).append(Carriage_Return);
			bs.append(evn.encode()).append(Carriage_Return);
			bs.append(pid.encode()).append(Carriage_Return);
			bs.append(pv1.encode()).append(Carriage_Return);
			bs.append(End_Block).append(Carriage_Return);
		} catch (HL7Exception e) {
			e.printStackTrace();
		}
		return bs.toString();
	}
	
	public ADT_A01 getADT_A01(){
		return adt;
	}

}
