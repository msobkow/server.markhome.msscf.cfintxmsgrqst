
// Description: Java 11 XML Message SAX Response Record Element  for SecApp

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
 *	CFIntXMsgRqstSecAppRead XML SAX Element  implementation
 *	for SecApp.
 */
public class CFIntXMsgRqstSecAppRead
	extends CFLibXmlCoreElementHandler
{
	public CFIntXMsgRqstSecAppRead( CFIntXMsgRqst xmsgRqst ) {
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
			// Primary Key Attributes for Constant Enum support
			String attrClusterId = null;
			String attrSecAppId = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RqstSecAppRead" );

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
			CFSecSecAppPKey pkey = ((ICFIntSchema)schemaObj.getBackingStore()).getFactorySecApp().newPKey();

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
				else if( attrLocalName.equals( "ClusterId" ) ) {
					if( attrClusterId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrClusterId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "SecAppId" ) ) {
					if( attrSecAppId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSecAppId = attrs.getValue( idxAttr );
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
			if( ( attrClusterId == null ) || ( attrClusterId.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ClusterId" );
			}
			if( ( attrSecAppId == null ) || ( attrSecAppId.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SecAppId" );
			}

			// Get current context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			long natClusterId;
			natClusterId = Long.parseLong( attrClusterId );
			pkey.setRequiredClusterId( natClusterId );

			pkey.setRequiredClusterId( natClusterId );
			int natSecAppId;
			natSecAppId = Integer.parseInt( attrSecAppId );
			pkey.setRequiredSecAppId( natSecAppId );

			pkey.setRequiredSecAppId( natSecAppId );
			// Read the object and prepare the XML response
			ICFIntSecAppObj read = ((ICFIntSecAppObj)schemaObj.getSecAppTableObj().readSecApp( pkey, true ));
			if( read != null ) {
				String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
					+	"\t" + CFIntXMsgSecAppMessageFormatter.formatSecAppRspnSingleOpenTag()
					+	CFIntXMsgSecAppMessageFormatter.formatSecAppRspnDerivedRec( "\n\t\t", read.getSecAppBuff() ) + "\n"
					+	"\t" + CFIntXMsgSecAppMessageFormatter.formatSecAppRspnSingleCloseTag()
					+	schemaFormatter.formatRspnXmlPostamble();
				xmsgRqst.appendResponse( response );
			}
			else {
				String response = schemaFormatter.formatRspnXmlPreamble() + "\n"
					+	"\t" + CFIntXMsgSchemaMessageFormatter.formatRspnNoDataFound() + "\n"
					+	schemaFormatter.formatRspnXmlPostamble();
				xmsgRqst.appendResponse( response );
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
