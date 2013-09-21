/**
 * 
 */
package com.gaduo.zk.model.iti_18;

import java.util.List;

import org.apache.axiom.om.OMElement;

import com.gaduo.ihe.utility.xml.XMLPath;
import com.gaduo.zk.model.code.Code;
import com.gaduo.zk.model.code.Codes;
import com.gaduo.zk.model.code.CodesImpl;

/**
 * @author Gaduo
 */
public class GetAll extends StoredQuery implements IParameter {

	private String patientId;
	private String documentEntryStatus;
	private String submissionSetStatus;
	private String folderStatus;
	private Code confidentialityCode;
	private Code formatCode;

	private Codes confidentialityCodeList;
	private Codes formatCodeList;

	public GetAll() {
		super();
		XMLPath codes = new XMLPath(getClass().getClassLoader()
				.getResourceAsStream("/com/gaduo/ihe/utility/resource/codes.xml"));
		setConfidentialityCodeList(new CodesImpl(codes, "confidentialityCode"));
		setFormatCodeList(new CodesImpl(codes, "formatCode"));
	}

	public List<OMElement> getParameters() {
		if (patientId != null) {
			super.list.add(super.addParameter("$patientId", patientId));
		} else {
			return null;
		}
		if (patientId != null) {
			super.list.add(super.addParameter("$XDSDocumentEntryStatus",
					documentEntryStatus));
		} else {
			return null;
		}
		if (patientId != null) {
			super.list.add(super.addParameter("$XDSSubmissionSetStatus",
					submissionSetStatus));
		} else {
			return null;
		}
		if (patientId != null) {
			super.list
					.add(super.addParameter("$XDSFolderStatus", folderStatus));
		} else {
			return null;
		}
		if (getFormatCode() != null) {
			Code code = this.getFormatCode();
			String value = code.getCode() + "^^" + code.getCodingScheme();
			super.list.add(super.addParameter("$XDSDocumentEntryFormatCode",
					value));
		}
		if (getConfidentialityCode() != null) {
			Code code = this.getConfidentialityCode();
			String value = code.getCode() + "^^" + code.getCodingScheme();
			super.list.add(super.addParameter(
					"$XDSDocumentEntryConfidentialityCode", value));
		}
		return super.list;
	}

	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDocumentEntryStatus() {
		return this.documentEntryStatus;
	}

	public void setDocumentEntryStatus(String documentEntryStatus) {
		this.documentEntryStatus = documentEntryStatus;
	}

	public String getSubmissionSetStatus() {
		return this.submissionSetStatus;
	}

	public void setSubmissionSetStatus(String submissionSetStatus) {
		this.submissionSetStatus = submissionSetStatus;
	}

	public String getFolderStatus() {
		return this.folderStatus;
	}

	public void setFolderStatus(String folderStatus) {
		this.folderStatus = folderStatus;
	}

	public Code getConfidentialityCode() {
		return this.confidentialityCode;
	}

	public void setConfidentialityCode(Code confidentialityCode) {
		this.confidentialityCode = confidentialityCode;
	}

	public Code getFormatCode() {
		return this.formatCode;
	}

	public void setFormatCode(Code formatCode) {
		this.formatCode = formatCode;
	}

	public List<Code> getConfidentialityCodeList() {
		return this.confidentialityCodeList.findAll();
	}

	public void setConfidentialityCodeList(CodesImpl confidentialityCodeList) {
		this.confidentialityCodeList = confidentialityCodeList;
	}

	public List<Code> getFormatCodeList() {
		return this.formatCodeList.findAll();
	}

	public void setFormatCodeList(CodesImpl formatCodeList) {
		this.formatCodeList = formatCodeList;
	}

}
