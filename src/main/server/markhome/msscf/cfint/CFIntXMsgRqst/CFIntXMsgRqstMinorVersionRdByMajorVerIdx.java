
// Description: Java 11 XML Message SAX Response Delete By Index Element  for MinorVersion

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
 *	CFIntXMsgRqstMinorVersionRdBy XML SAX Element  implementation
 *	for MinorVersion.
 */
public class CFIntXMsgRqstMinorVersionRdByMajorVerIdx
	extends CFLibXmlCoreElementHandler
{
	public CFIntXMsgRqstMinorVersionRdByMajorVerIdx( CFIntXMsgRqst xmsgRqst ) {
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
			String attrTenantId = null;
			String attrMajorVersionId = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "RqstMinorVersionRdByMajorVerIdx" );

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
				else if( attrLocalName.equals( "TenantId" ) ) {
					if( attrTenantId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTenantId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "MajorVersionId" ) ) {
					if( attrMajorVersionId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrMajorVersionId = attrs.getValue( idxAttr );
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
			if( ( attrMajorVersionId == null ) || ( attrMajorVersionId.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"MajorVersionId" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			long natTenantId;
			natTenantId = Long.parseLong( attrTenantId );

			long natMajorVersionId;
			natMajorVersionId = Long.parseLong( attrMajorVersionId );

			// Read the objects
			List<ICFIntMinorVersionObj> list = schemaObj.getMinorVersionTableObj().readMinorVersionByMajorVerIdx( natTenantId,
				natMajorVersionId );
			String responseOpening = schemaFormatter.formatRspnXmlPreamble() + "\n"
				+	"\t" + CFIntXMsgMinorVersionMessageFormatter.formatMinorVersionRspnListOpenTag();
			xmsgRqst.appendResponse( responseOpening );
			Iterator<ICFIntMinorVersionObj> iter = list.iterator();
			ICFIntMinorVersionObj cur;
			String subxml;
			while( iter.hasNext() ) {
				cur = iter.next();
				subxml = CFIntXMsgMinorVersionMessageFormatter.formatMinorVersionRspnDerivedRec( "\n\t\t", cur.getMinorVersionBuff() );
				xmsgRqst.appendResponse( subxml );
			}
			String responseClosing =
				 	"\n"
				+	"\t" + CFIntXMsgMinorVersionMessageFormatter.formatMinorVersionRspnListCloseTag()
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
