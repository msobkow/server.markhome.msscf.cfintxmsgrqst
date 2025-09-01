
// Description: Java 11 XML Message SAX Response Record Element  for MinorVersion

/*
 *	server.markhome.msscf.CFInt
 *
 *	Copyright (c) 2020-2025 Mark Stephen Sobkow
 *	
 *
 *	Manufactured by MSS Code Factory 2.13
 */

package server.markhome.msscf.cfint.CFIntXMsgRqst;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import org.msscf.msscf.cflib.CFLib.*;
import server.markhome.msscf.cfsec.CFSec.*;
import server.markhome.msscf.cfint.CFInt.*;
import server.markhome.msscf.cfsec.CFSecObj.*;
import server.markhome.msscf.cfint.CFIntObj.*;
import server.markhome.msscf.cfint.CFIntXMsg.*;

/*
 *	CFIntXMsgRqstMinorVersionDelete XML SAX Element  implementation
 *	for MinorVersion.
 */
public class CFIntXMsgRqstMinorVersionDelete
	extends CFLibXmlCoreElementHandler
{
	public CFIntXMsgRqstMinorVersionDelete( CFIntXMsgRqst xmsgRqst ) {
		super( xmsgRqst );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		CFIntXMsgSchemaMessageFormatter schemaFormatter = null;
		try {
			// Common XML Attributes
			String	attrId = null;
			String	attrRevision = null;
			// Primary Key Attributes for Constant Enum support
			String attrTenantId = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RqstMinorVersionDelete" );

			CFIntXMsgRqst xmsgRqst = (CFIntXMsgRqst)getParser();
			if( xmsgRqst == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			schemaFormatter = xmsgRqst.getSchemaMessageFormatter();

			ICFIntSchemaObj schemaObj = xmsgRqst.getSchemaObj();
			if( schemaObj == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate a PKey buffer for the parsed information
			CFIntMinorVersionPKey pkey = ((ICFIntSchema)schemaObj.getBackingStore()).getFactoryMinorVersion().newPKey();

			// Extract Attributes
			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Id" ) ) {
					if( attrId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Revision" ) ) {
					if( attrRevision != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrRevision = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TenantId" ) ) {
					if( attrTenantId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					throw new CFLibUnrecognizedAttributeException( getClass(),
						S_ProcName,
						getParser().getLocationInfo(),
						attrLocalName );
				}
			}

			// Ensure that required attributes have values
			if( ( attrTenantId == null ) || ( attrTenantId.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TenantId" );
			}
			if( ( attrId == null ) || ( attrId.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Id" );
			}
			if( ( attrRevision == null ) || ( attrRevision.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Revision" );
			}

			// Get current context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			long natTenantId;
			natTenantId = Long.parseLong( attrTenantId );
			pkey.setRequiredTenantId( natTenantId );

			pkey.setRequiredTenantId( natTenantId );
			long natId;
			natId = Long.parseLong( attrId );
			pkey.setRequiredId( natId );

			pkey.setRequiredId( natId );
			int natRevision = Integer.parseInt( attrRevision );
			// Delete the object
			ICFIntMinorVersionObj read = ((ICFIntMinorVersionObj)schemaObj.getMinorVersionTableObj().readMinorVersion( pkey ));
			if( read != null ) {
				if( read.getMinorVersionBuff().getRequiredRevision() > natRevision ) {
					throw new CFLibCollisionDetectedException( getClass(),
						S_ProcName,
						"Collision detected preparing to delete MinorVersion" );
				}
				else {
					ICFIntMinorVersionEditObj editBuff = (ICFIntMinorVersionEditObj)read.beginEdit();
					if( editBuff != null ) {
						editBuff.deleteInstance();
						editBuff = null;
						String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
							+	"\t" + CFIntXMsgMinorVersionMessageFormatter.formatMinorVersionRspnDeleted() +	"\n"
							+	schemaFormatter.formatRspnXmlPostamble();
						((CFIntXMsgRqst)getParser()).appendResponse( response );
					}
					else {
						throw new CFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"read.beginEdit()" );
					}
				}
			}
			else {
				String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
					+	"\t" + CFIntXMsgSchemaMessageFormatter.formatRspnNoDataFound() +	"\n"
					+	schemaFormatter.formatRspnXmlPostamble();
				((CFIntXMsgRqst)getParser()).appendResponse( response );
			}
		}
		catch( RuntimeException e ) {
			CFIntXMsgRqst xmsgRqst = ((CFIntXMsgRqst)getParser());
			schemaFormatter = xmsgRqst.getSchemaMessageFormatter();
			String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
				+	"\t" + CFIntXMsgSchemaMessageFormatter.formatRspnException( "\n\t\t\t", e )
				+	"\n"
				+	schemaFormatter.formatRspnXmlPostamble();
			xmsgRqst.resetResponse();
			xmsgRqst.appendResponse( response );
			xmsgRqst.setCaughtException( true );
		}
		catch( Error e ) {
			CFIntXMsgRqst xmsgRqst = ((CFIntXMsgRqst)getParser());
			schemaFormatter = xmsgRqst.getSchemaMessageFormatter();
			String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
				+	"\t" + CFIntXMsgSchemaMessageFormatter.formatRspnException( "\n\t\t\t", e )
				+	"\n"
				+	schemaFormatter.formatRspnXmlPostamble();
			xmsgRqst.resetResponse();
			xmsgRqst.appendResponse( response );
			xmsgRqst.setCaughtException( true );
		}
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
	}
}
