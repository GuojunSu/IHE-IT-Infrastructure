package com.gaduo.ihe.it_infrastructure.xds_transaction.dao;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;

import com.gaduo.ihe.constants.StoredQueryConstants;


public class GetDocumentsAndAssociations extends StoredQuery {
	public GetDocumentsAndAssociations(String queryUUID, OMElement request) {
		super(queryUUID);

		@SuppressWarnings("unchecked")
		Iterator<OMElement> ParameterList = request
				.getChildrenWithName(new QName("Parameter"));
		while (ParameterList.hasNext()) {
			OMElement p = ParameterList.next();
			OMElement slot = null;
			String Parameter = p.getAttributeValue(new QName("name"));
			if (Parameter != null) {
				if(this.isContainParameter(Parameter)){
					slot = this.addSlot(p);
				}
				if (slot != null) {
					addParameters(slot);
				}
			}
		}
	}
	
	protected void setParameterSet(){
		this.ParameterSet.put(StoredQueryConstants.DE_ENTRY_UUID, "O,M");/*XDSDocumentEntryEntryUUID*/
		this.ParameterSet.put(StoredQueryConstants.DE_UNIQUE_ID, "O,M");/*XDSDocumentEntryUniqueId*/
	}
}
