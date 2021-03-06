package edu.tcu.gaduo.ihe.iti.xds_transaction.ebxml.rs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "RegistryError")
@XmlAccessorType (XmlAccessType.FIELD)
public class RegistryErrorType {
	@XmlAttribute(name = "codeContext")
	protected String codeContext;
	@XmlAttribute(name = "errorCode")
	protected String errorCode;
	@XmlAttribute(name = "location")
	protected String location;
	@XmlAttribute(name = "severity")
	protected String severity;
}
