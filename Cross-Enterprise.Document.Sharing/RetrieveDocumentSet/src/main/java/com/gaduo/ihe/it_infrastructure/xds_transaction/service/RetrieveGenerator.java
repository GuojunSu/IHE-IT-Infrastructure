package com.gaduo.ihe.it_infrastructure.xds_transaction.service;

import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.log4j.Logger;

import com.gaduo.ihe.it_infrastructure.xds_transaction.service._interface.XDSTransactionGenerator;
import com.gaduo.ihe.utility.AxiomUtil;
import com.gaduo.ihe.utility._interface.IAxiomUtil;

public class RetrieveGenerator implements XDSTransactionGenerator {
	public static Logger logger = Logger.getLogger(RetrieveGenerator.class);
	private IAxiomUtil axiom = null;

	@SuppressWarnings("unchecked")
	public OMElement execution(OMElement request) {
		OMElement element = null;
		axiom = new AxiomUtil();
		OMElement RetrieveDocumentSetRequest = axiom.createOMElement(
				"RetrieveDocumentSetRequest", "urn:ihe:iti:xds-b:2007", "");
		Iterator<OMElement> iterator = request.getChildrenWithName(new QName("DocumentUniqueId"));
		while (iterator.hasNext()) {
			OMElement next = iterator.next();
			OMElement DocumentRequest = axiom.createOMElement(
					"DocumentRequest", "urn:ihe:iti:xds-b:2007", "");

			element = request
					.getFirstChildWithName(new QName("RepositoryUniqueId"));
			String repositoryUniqueId = element.getText();
			OMElement RepositoryUniqueId = axiom.createOMElement(
					"RepositoryUniqueId", "urn:ihe:iti:xds-b:2007", "");
			RepositoryUniqueId.setText(repositoryUniqueId);
			DocumentRequest.addChild(RepositoryUniqueId);

			element = request
					.getFirstChildWithName(new QName("HomeCommunityId"));
			String homeCommunityId = element.getText();
			if (!homeCommunityId.equals("")) {
				OMElement HomeCommunityId = axiom.createOMElement(
						"HomeCommunityId", "urn:ihe:iti:xds-b:2007", "");
				HomeCommunityId.setText(homeCommunityId);
				DocumentRequest.addChild(HomeCommunityId);
			}
			OMElement DocumentUniqueId = axiom.createOMElement(
					"DocumentUniqueId", "urn:ihe:iti:xds-b:2007", "");
			DocumentUniqueId.setText(next.getText());
			DocumentRequest.addChild(DocumentUniqueId);
			RetrieveDocumentSetRequest.addChild(DocumentRequest);
		}
		logger.trace(RetrieveDocumentSetRequest);
		return RetrieveDocumentSetRequest;
	}
}
