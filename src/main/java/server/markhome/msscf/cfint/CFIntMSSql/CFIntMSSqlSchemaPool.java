// Description: Java 11 implementation of a SQL Server CFInt schema pool.

/*
 *	server.markhome.msscf.CFInt
 *
 *	Copyright (c) 2020-2025 Mark Stephen Sobkow
 *	
 *
 *	Manufactured by MSS Code Factory 2.13
 */

package server.markhome.msscf.cfint.CFIntMSSql;

import java.util.*;

import org.msscf.msscf.cflib.CFLib.*;
import server.markhome.msscf.cfsec.CFSec.*;
import server.markhome.msscf.cfint.CFInt.*;

public class CFIntMSSqlSchemaPool
extends CFIntSchemaPool
{
	public CFIntMSSqlSchemaPool() {
		setJndiName( "java:comp/env/CFINet31ConnectionPool" );
	}

	/**
	 *	You need to overload the implementation of newInstance() to return
	 *	connected instances of your backing store.
	 */
	public ICFIntSchema newInstance() {
		ICFIntSchema inst = new CFIntMSSqlSchema();
		return( inst );
	}
}
