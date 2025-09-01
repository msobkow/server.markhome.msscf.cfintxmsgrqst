
// Description: Java 11 XML Message SAX Response Delete By Index Element  for Service

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
 *	CFIntXMsgRqstServicePageBy XML SAX Element  implementation
 *	for Service.
 */
public class CFIntXMsgRqstServicePageByTypeIdx
	extends CFLibXmlCoreElementHandler
{
	public CFIntXMsgRqstServicePageByTypeIdx( CFIntXMsgRqst xmsgRqst ) {
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
			String attrServiceTypeId = null;
			String attrPriorClusterId = null;
			String attrPriorServiceId = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RqstServicePageByTypeIdx" );

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
				else if( attrLocalName.equals( "ServiceTypeId" ) ) {
					if( attrServiceTypeId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrServiceTypeId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PriorClusterId" ) ) {
					if( attrPriorClusterId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPriorClusterId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PriorServiceId" ) ) {
					if( attrPriorServiceId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPriorServiceId = attrs.getValue( idxAttr );
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
			if( ( attrServiceTypeId == null ) || ( attrServiceTypeId.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ServiceTypeId" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			int natServiceTypeId;
			natServiceTypeId = Integer.parseInt( attrServiceTypeId );

			Long natPriorClusterId;
			if( ( attrPriorClusterId == null ) || ( attrPriorClusterId.length() <= 0 ) ) {
				natPriorClusterId = null;
			}
			else {
				natPriorClusterId = Long.valueOf( Long.parseLong( attrPriorClusterId ) );
			}

			Long natPriorServiceId;
			if( ( attrPriorServiceId == null ) || ( attrPriorServiceId.length() <= 0 ) ) {
				natPriorServiceId = null;
			}
			else {
				natPriorServiceId = Long.valueOf( Long.parseLong( attrPriorServiceId ) );
			}

			// Page the objects
			List<ICFSecServiceObj> list = schemaObj.getServiceTableObj().pageServiceByTypeIdx( natServiceTypeId,
				natPriorClusterId,
				natPriorServiceId );
			String responseOpening = schemaFormatter.formatRspnXmlPreamble() + "\n"
				+	"\t" + CFIntXMsgServiceMessageFormatter.formatServiceRspnListOpenTag();
			xmsgRqst.appendResponse( responseOpening );
			Iterator<ICFSecServiceObj> iter = list.iterator();
			ICFSecServiceObj cur;
			String subxml;
			while( iter.hasNext() ) {
				cur = iter.next();
				subxml = CFIntXMsgServiceMessageFormatter.formatServiceRspnDerivedRec( "\n\t\t", cur.getServiceBuff() );
				xmsgRqst.appendResponse( subxml );
			}
			String responseClosing =
				 	"\n"
				+	"\t" + CFIntXMsgServiceMessageFormatter.formatServiceRspnListCloseTag()
				+	schemaFormatter.formatRspnXmlPostamble();
			xmsgRqst.appendResponse( responseClosing );
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
