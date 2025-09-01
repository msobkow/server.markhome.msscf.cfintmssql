// Description: Java 11 MS SQL Server Developer Edition Jdbc DbIO implementation for CFInt.

/*
 *	server.markhome.msscf.CFInt
 *
 *	Copyright (c) 2020-2025 Mark Stephen Sobkow
 *	
 *
 *	Manufactured by MSS Code Factory 2.13
 */

package server.markhome.msscf.cfint.CFIntMSSql;

import java.lang.reflect.*;
import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import server.markhome.msscf.cfsec.CFSec.*;
import server.markhome.msscf.cfint.CFInt.*;
import server.markhome.msscf.cfsec.CFSecObj.*;
import server.markhome.msscf.cfint.CFIntObj.*;
import server.markhome.msscf.cfint.CFIntObj.*;
import server.markhome.msscf.cfint.CFIntSaxLoader.CFIntSaxLoader;

public class CFIntMSSqlSchema
	extends CFIntSchema
	implements ICFIntSchema
{
	protected Connection cnx;
	protected PreparedStatement stmtSelectNextISOCcyIdGen = null;
	protected PreparedStatement stmtSelectNextISOCtryIdGen = null;
	protected PreparedStatement stmtSelectNextISOLangIdGen = null;
	protected PreparedStatement stmtSelectNextISOTZoneIdGen = null;
	protected PreparedStatement stmtSelectNextServiceTypeIdGen = null;
	protected PreparedStatement stmtSelectNextMimeTypeIdGen = null;
	protected PreparedStatement stmtSelectNextURLProtocolIdGen = null;
	protected PreparedStatement stmtSelectNextClusterIdGen = null;
	protected PreparedStatement stmtSelectNextTenantIdGen = null;
	protected boolean inTransaction;
	protected PreparedStatement stmtBeginTransaction = null;

	public CFIntMSSqlSchema() {
		super();
		cnx = null;
		inTransaction = false;
		tableCluster = new CFIntMSSqlClusterTable( this );
		tableHostNode = new CFIntMSSqlHostNodeTable( this );
		tableISOCcy = new CFIntMSSqlISOCcyTable( this );
		tableISOCtry = new CFIntMSSqlISOCtryTable( this );
		tableISOCtryCcy = new CFIntMSSqlISOCtryCcyTable( this );
		tableISOCtryLang = new CFIntMSSqlISOCtryLangTable( this );
		tableISOLang = new CFIntMSSqlISOLangTable( this );
		tableISOTZone = new CFIntMSSqlISOTZoneTable( this );
		tableMajorVersion = new CFIntMSSqlMajorVersionTable( this );
		tableMimeType = new CFIntMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFIntMSSqlMinorVersionTable( this );
		tableSecApp = new CFIntMSSqlSecAppTable( this );
		tableSecDevice = new CFIntMSSqlSecDeviceTable( this );
		tableSecForm = new CFIntMSSqlSecFormTable( this );
		tableSecGroup = new CFIntMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFIntMSSqlSecGroupFormTable( this );
		tableSecGrpInc = new CFIntMSSqlSecGrpIncTable( this );
		tableSecGrpMemb = new CFIntMSSqlSecGrpMembTable( this );
		tableSecSession = new CFIntMSSqlSecSessionTable( this );
		tableSecUser = new CFIntMSSqlSecUserTable( this );
		tableService = new CFIntMSSqlServiceTable( this );
		tableServiceType = new CFIntMSSqlServiceTypeTable( this );
		tableSubProject = new CFIntMSSqlSubProjectTable( this );
		tableSysCluster = new CFIntMSSqlSysClusterTable( this );
		tableTSecGroup = new CFIntMSSqlTSecGroupTable( this );
		tableTSecGrpInc = new CFIntMSSqlTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFIntMSSqlTSecGrpMembTable( this );
		tableTenant = new CFIntMSSqlTenantTable( this );
		tableTld = new CFIntMSSqlTldTable( this );
		tableTopDomain = new CFIntMSSqlTopDomainTable( this );
		tableTopProject = new CFIntMSSqlTopProjectTable( this );
		tableURLProtocol = new CFIntMSSqlURLProtocolTable( this );
	}

	public CFIntMSSqlSchema( CFIntConfigurationFile conf ) {
		super( conf );
		cnx = null;
		inTransaction = false;
		tableCluster = new CFIntMSSqlClusterTable( this );
		tableHostNode = new CFIntMSSqlHostNodeTable( this );
		tableISOCcy = new CFIntMSSqlISOCcyTable( this );
		tableISOCtry = new CFIntMSSqlISOCtryTable( this );
		tableISOCtryCcy = new CFIntMSSqlISOCtryCcyTable( this );
		tableISOCtryLang = new CFIntMSSqlISOCtryLangTable( this );
		tableISOLang = new CFIntMSSqlISOLangTable( this );
		tableISOTZone = new CFIntMSSqlISOTZoneTable( this );
		tableMajorVersion = new CFIntMSSqlMajorVersionTable( this );
		tableMimeType = new CFIntMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFIntMSSqlMinorVersionTable( this );
		tableSecApp = new CFIntMSSqlSecAppTable( this );
		tableSecDevice = new CFIntMSSqlSecDeviceTable( this );
		tableSecForm = new CFIntMSSqlSecFormTable( this );
		tableSecGroup = new CFIntMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFIntMSSqlSecGroupFormTable( this );
		tableSecGrpInc = new CFIntMSSqlSecGrpIncTable( this );
		tableSecGrpMemb = new CFIntMSSqlSecGrpMembTable( this );
		tableSecSession = new CFIntMSSqlSecSessionTable( this );
		tableSecUser = new CFIntMSSqlSecUserTable( this );
		tableService = new CFIntMSSqlServiceTable( this );
		tableServiceType = new CFIntMSSqlServiceTypeTable( this );
		tableSubProject = new CFIntMSSqlSubProjectTable( this );
		tableSysCluster = new CFIntMSSqlSysClusterTable( this );
		tableTSecGroup = new CFIntMSSqlTSecGroupTable( this );
		tableTSecGrpInc = new CFIntMSSqlTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFIntMSSqlTSecGrpMembTable( this );
		tableTenant = new CFIntMSSqlTenantTable( this );
		tableTld = new CFIntMSSqlTldTable( this );
		tableTopDomain = new CFIntMSSqlTopDomainTable( this );
		tableTopProject = new CFIntMSSqlTopProjectTable( this );
		tableURLProtocol = new CFIntMSSqlURLProtocolTable( this );
		setDbSchemaName( conf.getDbDatabase() );
	}

	public CFIntMSSqlSchema( String argJndiName ) {
		super( argJndiName );
		cnx = null;
		inTransaction = false;
		tableCluster = new CFIntMSSqlClusterTable( this );
		tableHostNode = new CFIntMSSqlHostNodeTable( this );
		tableISOCcy = new CFIntMSSqlISOCcyTable( this );
		tableISOCtry = new CFIntMSSqlISOCtryTable( this );
		tableISOCtryCcy = new CFIntMSSqlISOCtryCcyTable( this );
		tableISOCtryLang = new CFIntMSSqlISOCtryLangTable( this );
		tableISOLang = new CFIntMSSqlISOLangTable( this );
		tableISOTZone = new CFIntMSSqlISOTZoneTable( this );
		tableMajorVersion = new CFIntMSSqlMajorVersionTable( this );
		tableMimeType = new CFIntMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFIntMSSqlMinorVersionTable( this );
		tableSecApp = new CFIntMSSqlSecAppTable( this );
		tableSecDevice = new CFIntMSSqlSecDeviceTable( this );
		tableSecForm = new CFIntMSSqlSecFormTable( this );
		tableSecGroup = new CFIntMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFIntMSSqlSecGroupFormTable( this );
		tableSecGrpInc = new CFIntMSSqlSecGrpIncTable( this );
		tableSecGrpMemb = new CFIntMSSqlSecGrpMembTable( this );
		tableSecSession = new CFIntMSSqlSecSessionTable( this );
		tableSecUser = new CFIntMSSqlSecUserTable( this );
		tableService = new CFIntMSSqlServiceTable( this );
		tableServiceType = new CFIntMSSqlServiceTypeTable( this );
		tableSubProject = new CFIntMSSqlSubProjectTable( this );
		tableSysCluster = new CFIntMSSqlSysClusterTable( this );
		tableTSecGroup = new CFIntMSSqlTSecGroupTable( this );
		tableTSecGrpInc = new CFIntMSSqlTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFIntMSSqlTSecGrpMembTable( this );
		tableTenant = new CFIntMSSqlTenantTable( this );
		tableTld = new CFIntMSSqlTldTable( this );
		tableTopDomain = new CFIntMSSqlTopDomainTable( this );
		tableTopProject = new CFIntMSSqlTopProjectTable( this );
		tableURLProtocol = new CFIntMSSqlURLProtocolTable( this );
	}

	public CFIntMSSqlSchema( Connection argCnx ) {
		super();
		cnx = argCnx;
		inTransaction = false;
		tableCluster = new CFIntMSSqlClusterTable( this );
		tableHostNode = new CFIntMSSqlHostNodeTable( this );
		tableISOCcy = new CFIntMSSqlISOCcyTable( this );
		tableISOCtry = new CFIntMSSqlISOCtryTable( this );
		tableISOCtryCcy = new CFIntMSSqlISOCtryCcyTable( this );
		tableISOCtryLang = new CFIntMSSqlISOCtryLangTable( this );
		tableISOLang = new CFIntMSSqlISOLangTable( this );
		tableISOTZone = new CFIntMSSqlISOTZoneTable( this );
		tableMajorVersion = new CFIntMSSqlMajorVersionTable( this );
		tableMimeType = new CFIntMSSqlMimeTypeTable( this );
		tableMinorVersion = new CFIntMSSqlMinorVersionTable( this );
		tableSecApp = new CFIntMSSqlSecAppTable( this );
		tableSecDevice = new CFIntMSSqlSecDeviceTable( this );
		tableSecForm = new CFIntMSSqlSecFormTable( this );
		tableSecGroup = new CFIntMSSqlSecGroupTable( this );
		tableSecGroupForm = new CFIntMSSqlSecGroupFormTable( this );
		tableSecGrpInc = new CFIntMSSqlSecGrpIncTable( this );
		tableSecGrpMemb = new CFIntMSSqlSecGrpMembTable( this );
		tableSecSession = new CFIntMSSqlSecSessionTable( this );
		tableSecUser = new CFIntMSSqlSecUserTable( this );
		tableService = new CFIntMSSqlServiceTable( this );
		tableServiceType = new CFIntMSSqlServiceTypeTable( this );
		tableSubProject = new CFIntMSSqlSubProjectTable( this );
		tableSysCluster = new CFIntMSSqlSysClusterTable( this );
		tableTSecGroup = new CFIntMSSqlTSecGroupTable( this );
		tableTSecGrpInc = new CFIntMSSqlTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFIntMSSqlTSecGrpMembTable( this );
		tableTenant = new CFIntMSSqlTenantTable( this );
		tableTld = new CFIntMSSqlTldTable( this );
		tableTopDomain = new CFIntMSSqlTopDomainTable( this );
		tableTopProject = new CFIntMSSqlTopProjectTable( this );
		tableURLProtocol = new CFIntMSSqlURLProtocolTable( this );
		try {
			cnx.setAutoCommit( false );
			cnx.rollback();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"CFIntMSSqlSchema-constructor",
				e );
		}
	}

	public Connection getCnx() {
		return( cnx );
	}

	public boolean isConnected() {
		final String S_ProcName = "isConnected";
		boolean retval;
		if( cnx == null ) {
			retval = false;
		}
		else {
			try {
				if( cnx.isClosed() ) {
					retval = false;
					cnx = null;
					releasePreparedStatements();
				}
				else {
					retval = true;
				}
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
		}
		return( retval );
	}

	public boolean connect() {
		final String S_ProcName = "connect";
		if( cnx != null ) {
			return( false );
		}

		if( configuration != null ) {
			try {
				Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			}
			catch( ClassNotFoundException e ) {
				throw new CFLibRuntimeException( getClass(),
					"connect",
					"Could not load MS SQL Server Developer Edition driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:sqlserver://" + dbServer
				+	":" + Integer.toString( dbPort ) + ";";
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
				setDbSchemaName( dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<connect>>",
					e );
			}
			Statement stmtUseDatabase = null;
			try {
				stmtUseDatabase = cnx.createStatement();
				stmtUseDatabase.executeUpdate( "use " + dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<useDatabase>>",
					e );
			}
			finally {
				if( stmtUseDatabase != null ) {
					try {
						stmtUseDatabase.close();
					}
					catch( SQLException e ) {
					}
					stmtUseDatabase = null;
				}
			}
			return( true );
		}
		if( ( ! isConnected() ) && ( jndiName != null ) ) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup( jndiName );
				if( ds == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get resolve DataSource \"" + jndiName + "\"" );
				}
				cnx = ds.getConnection();
				if( cnx == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get Connection from PooledConnection for ConnectionPoolDataSource \"" + jndiName + "\"" );
				}
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
			}
			catch( NamingException e ) {
				cnx = null;
				throw new CFLibRuntimeException( getClass(),
					S_ProcName + "<<jndiGetConnection>>",
					"NamingException " + e.getMessage(),
					e );
			}
			catch( SQLException e ) {
				cnx = null;
				inTransaction = false;
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<jndiGetConnection>>",
					e );
			}
			return( true );
		}
		throw new CFLibUsageException( getClass(),
			S_ProcName,
			"Neither configurationFile nor jndiName found, do not know how to connect to database" );
	}

	public boolean connect( String username, String password ) {
		final String S_ProcName = "connect";
		if( cnx != null ) {
			return( false );
		}
		if( ( username == null ) || ( username.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"username" );
		}
		if( password == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"password" );
		}
		if( configuration != null ) {
			try {
				Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			}
			catch( ClassNotFoundException e ) {
				throw new CFLibRuntimeException( getClass(),
					"connect",
					"Could not load MS SQL Server Developer Edition driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:sqlserver://" + dbServer
				+	":" + Integer.toString( dbPort ) + ";";
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
				setDbSchemaName( dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<connect>>",
					e );
			}
			Statement stmtUseDatabase = null;
			try {
				stmtUseDatabase = cnx.createStatement();
				stmtUseDatabase.executeUpdate( "use " + dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<useDatabase>>",
					e );
			}
			finally {
				if( stmtUseDatabase != null ) {
					try {
						stmtUseDatabase.close();
					}
					catch( SQLException e ) {
					}
					stmtUseDatabase = null;
				}
			}
			return( true );
		}
		if( ( ! isConnected() ) && ( jndiName != null ) ) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup( jndiName );
				if( ds == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get resolve DataSource \"" + jndiName + "\"" );
				}
				cnx = ds.getConnection();
				if( cnx == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get Connection from PooledConnection for ConnectionPoolDataSource \"" + jndiName + "\"" );
				}
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
			}
			catch( NamingException e ) {
				cnx = null;
				throw new CFLibRuntimeException( getClass(),
					S_ProcName + "<<jndiGetConnection>>",
					"NamingException " + e.getMessage(),
					e );
			}
			catch( SQLException e ) {
				cnx = null;
				inTransaction = false;
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<jndiGetConnection>>",
					e );
			}
			return( true );
		}
		throw new CFLibUsageException( getClass(),
			S_ProcName,
			"configurationFile not found, do not know how to connect to database" );
	}


	public boolean connect( String loginId, String password, String clusterName, String tenantName ) {
		final String S_ProcName = "connect-full";
		if( cnx != null ) {
			return( false );
		}
		if( ( loginId == null ) || ( loginId.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"loginId" );
		}
		if( password == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"password" );
		}
		if( configuration != null ) {
			try {
				Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			}
			catch( ClassNotFoundException e ) {
				throw new CFLibRuntimeException( getClass(),
					"connect",
					"Could not load MS SQL Server Developer Edition driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:sqlserver://" + dbServer
				+	":" + Integer.toString( dbPort ) + ";";
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
				setDbSchemaName( dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<connect>>",
					e );
			}
			Statement stmtUseDatabase = null;
			try {
				stmtUseDatabase = cnx.createStatement();
				stmtUseDatabase.executeUpdate( "use " + dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<useDatabase>>",
					e );
			}
			finally {
				if( stmtUseDatabase != null ) {
					try {
						stmtUseDatabase.close();
					}
					catch( SQLException e ) {
					}
					stmtUseDatabase = null;
				}
			}
			return( true );
		}
		if( ( ! isConnected() ) && ( jndiName != null ) ) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup( jndiName );
				if( ds == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get resolve DataSource \"" + jndiName + "\"" );
				}
				cnx = ds.getConnection();
				if( cnx == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get Connection from PooledConnection for ConnectionPoolDataSource \"" + jndiName + "\"" );
				}
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
			}
			catch( NamingException e ) {
				cnx = null;
				throw new CFLibRuntimeException( getClass(),
					S_ProcName + "<<jndiGetConnection>>",
					"NamingException " + e.getMessage(),
					e );
			}
			catch( SQLException e ) {
				cnx = null;
				inTransaction = false;
				throw new CFLibDbException( getClass(),
					S_ProcName + "<<jndiGetConnection>>",
					e );
			}
			return( true );
		}
		throw new CFLibUsageException( getClass(),
			S_ProcName,
			"configurationFile not found, do not know how to connect to database" );
	}

	public void disconnect( boolean doCommit ) {
		final String S_ProcName = "disconnect";
		if( cnx != null ) {
			try {
				if( ! cnx.isClosed() ) {
					if( doCommit ) {
						cnx.commit();
					}
					else {
						cnx.rollback();
					}
					releasePreparedStatements();
					cnx.close();
				}
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				cnx = null;
			}
		}
		releasePreparedStatements();
	}

	public boolean isTransactionOpen() {
		return( inTransaction );
	}

	public boolean beginTransaction() {
		if( inTransaction ) {
			return( false );
		}
		try {
			final String sql = "begin transaction";
			if( stmtBeginTransaction == null ) {
				stmtBeginTransaction = cnx.prepareStatement( sql );
			}
			stmtBeginTransaction.execute();
			inTransaction = true;
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"beginTransaction",
				e );
		}
		return( inTransaction );
	}

	public void commit() {
		try {
			cnx.commit();
			inTransaction = false;
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"commit",
				e );
		}
	}

	public void rollback() {
		try {
			if( cnx != null ) {
				cnx.rollback();
			}
			inTransaction = false;
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"rollback",
				e );
		}
	}

	public boolean isSystemUser( CFSecAuthorization Authorization ) {
		final String S_ProcName = "isSystemUser";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		CallableStatement stmtSecCheck = null;
		try {
			final String sql = "exec sp_is_system_user ?, ?";
			stmtSecCheck = cnx.prepareCall( sql );
			stmtSecCheck.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtSecCheck.setString( 2, Authorization.getSecUserId().toString() );
			stmtSecCheck.execute();
			int isAuthorized = stmtSecCheck.getInt( 1 );
			if( isAuthorized == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSecCheck != null ) {
				try {
					stmtSecCheck.close();
				}
				catch( SQLException e ) {
				}
				stmtSecCheck = null;
			}
		}
	}

	public boolean isClusterUser( CFSecAuthorization Authorization,
		long clusterId,
		String secGroupName )
	{
		final String S_ProcName = "isClusterUser";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		CallableStatement stmtSecCheck = null;
		try {
			final String sql = "exec sp_is_cluster_user ?, ?, ?, ?";
			stmtSecCheck = cnx.prepareCall( sql );
			stmtSecCheck.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtSecCheck.setLong( 2, clusterId );
			stmtSecCheck.setString( 3, secGroupName );
			stmtSecCheck.setString( 4, Authorization.getSecUserId().toString() );
			stmtSecCheck.execute();
			int isAuthorized = stmtSecCheck.getInt( 1 );
			if( isAuthorized == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSecCheck != null ) {
				try {
					stmtSecCheck.close();
				}
				catch( SQLException e ) {
				}
				stmtSecCheck = null;
			}
		}
	}

	public boolean isTenantUser( CFSecAuthorization Authorization,
		long tenantId,
		String secGroupName )
	{
		final String S_ProcName = "isTenantUser";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		CallableStatement stmtSecCheck = null;
		try {
			final String sql = "exec sp_is_tenant_user ?, ?, ?, ?";
			stmtSecCheck = cnx.prepareCall( sql );
			stmtSecCheck.registerOutParameter( 1, java.sql.Types.INTEGER );
			stmtSecCheck.setLong( 2, tenantId );
			stmtSecCheck.setString( 3, secGroupName );
			stmtSecCheck.setString( 4, Authorization.getSecUserId().toString() );
			stmtSecCheck.execute();
			int isAuthorized = stmtSecCheck.getInt( 1 );
			if( isAuthorized == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtSecCheck != null ) {
				try {
					stmtSecCheck.close();
				}
				catch( SQLException e ) {
				}
				stmtSecCheck = null;
			}
		}
	}

	public short nextISOCcyIdGen() {
		final String S_ProcName = "nextISOCcyIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		short nextId = -1;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_isoccyidgen";
			if( stmtSelectNextISOCcyIdGen == null ) {
				stmtSelectNextISOCcyIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextISOCcyIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextISOCcyIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextISOCcyIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextISOCcyIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOCcyIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public short nextISOCtryIdGen() {
		final String S_ProcName = "nextISOCtryIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		short nextId = -1;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_isoctryidgen";
			if( stmtSelectNextISOCtryIdGen == null ) {
				stmtSelectNextISOCtryIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextISOCtryIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextISOCtryIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextISOCtryIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextISOCtryIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOCtryIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public short nextISOLangIdGen() {
		final String S_ProcName = "nextISOLangIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		short nextId = -1;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_isolangidgen";
			if( stmtSelectNextISOLangIdGen == null ) {
				stmtSelectNextISOLangIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextISOLangIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextISOLangIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextISOLangIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextISOLangIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOLangIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public short nextISOTZoneIdGen() {
		final String S_ProcName = "nextISOTZoneIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		short nextId = -1;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_isotzoneidgen";
			if( stmtSelectNextISOTZoneIdGen == null ) {
				stmtSelectNextISOTZoneIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextISOTZoneIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextISOTZoneIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextISOTZoneIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextISOTZoneIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOTZoneIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public int nextServiceTypeIdGen() {
		final String S_ProcName = "nextServiceTypeIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		int nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_servicetypeidgen";
			if( stmtSelectNextServiceTypeIdGen == null ) {
				stmtSelectNextServiceTypeIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextServiceTypeIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextServiceTypeIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextServiceTypeIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextServiceTypeIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextServiceTypeIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public int nextMimeTypeIdGen() {
		final String S_ProcName = "nextMimeTypeIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		int nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_mimetypeidgen";
			if( stmtSelectNextMimeTypeIdGen == null ) {
				stmtSelectNextMimeTypeIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextMimeTypeIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextMimeTypeIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextMimeTypeIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextMimeTypeIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextMimeTypeIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public int nextURLProtocolIdGen() {
		final String S_ProcName = "nextURLProtocolIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		int nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_urlprotocolidgen";
			if( stmtSelectNextURLProtocolIdGen == null ) {
				stmtSelectNextURLProtocolIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextURLProtocolIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextURLProtocolIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextURLProtocolIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextURLProtocolIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextURLProtocolIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public long nextClusterIdGen() {
		final String S_ProcName = "nextClusterIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		long nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_clusteridgen";
			if( stmtSelectNextClusterIdGen == null ) {
				stmtSelectNextClusterIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextClusterIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextClusterIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextClusterIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextClusterIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextClusterIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public long nextTenantIdGen() {
		final String S_ProcName = "nextTenantIdGen";
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Not in a transaction" );
		}
		long nextId = -1;
		Statement stmtNext = null;
		ResultSet resultSet = null;
		try {
			final String sql = "exec sp_selnext_tenantidgen";
			if( stmtSelectNextTenantIdGen == null ) {
				stmtSelectNextTenantIdGen = cnx.prepareStatement( sql );
			}
			stmtSelectNextTenantIdGen.execute();
			boolean moreResults = true;
			while( resultSet == null ) {
				try {
					moreResults = stmtSelectNextTenantIdGen.getMoreResults();
				}
				catch( SQLException e ) {
					throw new CFLibDbException( getClass(),
						S_ProcName,
						e );
				}
				if( moreResults ) {
					try {
						resultSet = stmtSelectNextTenantIdGen.getResultSet();
					}
					catch( SQLException e ) {
					}
				}
				else if( -1 == stmtSelectNextTenantIdGen.getUpdateCount() ) {
					break;
				}
			}
			if( resultSet == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"resultSet" );
			}
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextTenantIdGen",
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public UUID nextSecSessionIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public UUID nextSecUserIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	/**
	 *	Import the contents of the specified file name
	 *	and file contents by applying a SAX Loader parse.
	 */
	public String fileImport( CFSecAuthorization auth, String fileName, String fileContent ) {
		final String S_ProcName = "fileImport";

		if( isTransactionOpen() ) {
			rollback();
		}

		try {
			beginTransaction();

			CFIntSaxLoader saxLoader = new CFIntSaxLoader();
			ICFIntSchemaObj schemaObj = new CFIntSchemaObj();
			schemaObj.setBackingStore( this );
			saxLoader.setSchemaObj( schemaObj );
			ICFSecClusterObj useCluster = schemaObj.getClusterTableObj().readClusterByIdIdx( auth.getSecClusterId() );
			ICFSecTenantObj useTenant = schemaObj.getTenantTableObj().readTenantByIdIdx( auth.getSecTenantId() );
			CFLibCachedMessageLog runlog = new CFLibCachedMessageLog();
			saxLoader.setLog( runlog );
			saxLoader.setUseCluster( useCluster );
			saxLoader.setUseTenant( useTenant );
			saxLoader.parseStringContents( fileContent );
			String logFileContent = runlog.getCacheContents();
			if( logFileContent == null ) {
				logFileContent = "";
			}

			commit();

			return( logFileContent );
		}
		catch( RuntimeException e ) {
			rollback();
			throw e;
		}
		catch( Error e ) {
			rollback();
			throw e;
		}
	}

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		final String S_ProcName = "releasePreparedStatements";
		if( stmtBeginTransaction != null ) {
			try {
				stmtBeginTransaction.close();
			}
			catch( SQLException e ) {
			}
			stmtBeginTransaction = null;
		}
		if( stmtSelectNextISOCcyIdGen != null ) {
			try {
				stmtSelectNextISOCcyIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextISOCcyIdGen = null;
		}
		if( stmtSelectNextISOCtryIdGen != null ) {
			try {
				stmtSelectNextISOCtryIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextISOCtryIdGen = null;
		}
		if( stmtSelectNextISOLangIdGen != null ) {
			try {
				stmtSelectNextISOLangIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextISOLangIdGen = null;
		}
		if( stmtSelectNextISOTZoneIdGen != null ) {
			try {
				stmtSelectNextISOTZoneIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextISOTZoneIdGen = null;
		}
		if( stmtSelectNextServiceTypeIdGen != null ) {
			try {
				stmtSelectNextServiceTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextServiceTypeIdGen = null;
		}
		if( stmtSelectNextMimeTypeIdGen != null ) {
			try {
				stmtSelectNextMimeTypeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextMimeTypeIdGen = null;
		}
		if( stmtSelectNextURLProtocolIdGen != null ) {
			try {
				stmtSelectNextURLProtocolIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextURLProtocolIdGen = null;
		}
		if( stmtSelectNextClusterIdGen != null ) {
			try {
				stmtSelectNextClusterIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextClusterIdGen = null;
		}
		if( stmtSelectNextTenantIdGen != null ) {
			try {
				stmtSelectNextTenantIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTenantIdGen = null;
		}

		if( ( tableCluster != null ) && ( tableCluster instanceof CFIntMSSqlClusterTable ) ) {
			CFIntMSSqlClusterTable table = (CFIntMSSqlClusterTable)tableCluster;
			table.releasePreparedStatements();
		}
		if( ( tableHostNode != null ) && ( tableHostNode instanceof CFIntMSSqlHostNodeTable ) ) {
			CFIntMSSqlHostNodeTable table = (CFIntMSSqlHostNodeTable)tableHostNode;
			table.releasePreparedStatements();
		}
		if( ( tableISOCcy != null ) && ( tableISOCcy instanceof CFIntMSSqlISOCcyTable ) ) {
			CFIntMSSqlISOCcyTable table = (CFIntMSSqlISOCcyTable)tableISOCcy;
			table.releasePreparedStatements();
		}
		if( ( tableISOCtry != null ) && ( tableISOCtry instanceof CFIntMSSqlISOCtryTable ) ) {
			CFIntMSSqlISOCtryTable table = (CFIntMSSqlISOCtryTable)tableISOCtry;
			table.releasePreparedStatements();
		}
		if( ( tableISOCtryCcy != null ) && ( tableISOCtryCcy instanceof CFIntMSSqlISOCtryCcyTable ) ) {
			CFIntMSSqlISOCtryCcyTable table = (CFIntMSSqlISOCtryCcyTable)tableISOCtryCcy;
			table.releasePreparedStatements();
		}
		if( ( tableISOCtryLang != null ) && ( tableISOCtryLang instanceof CFIntMSSqlISOCtryLangTable ) ) {
			CFIntMSSqlISOCtryLangTable table = (CFIntMSSqlISOCtryLangTable)tableISOCtryLang;
			table.releasePreparedStatements();
		}
		if( ( tableISOLang != null ) && ( tableISOLang instanceof CFIntMSSqlISOLangTable ) ) {
			CFIntMSSqlISOLangTable table = (CFIntMSSqlISOLangTable)tableISOLang;
			table.releasePreparedStatements();
		}
		if( ( tableISOTZone != null ) && ( tableISOTZone instanceof CFIntMSSqlISOTZoneTable ) ) {
			CFIntMSSqlISOTZoneTable table = (CFIntMSSqlISOTZoneTable)tableISOTZone;
			table.releasePreparedStatements();
		}
		if( ( tableMajorVersion != null ) && ( tableMajorVersion instanceof CFIntMSSqlMajorVersionTable ) ) {
			CFIntMSSqlMajorVersionTable table = (CFIntMSSqlMajorVersionTable)tableMajorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableMimeType != null ) && ( tableMimeType instanceof CFIntMSSqlMimeTypeTable ) ) {
			CFIntMSSqlMimeTypeTable table = (CFIntMSSqlMimeTypeTable)tableMimeType;
			table.releasePreparedStatements();
		}
		if( ( tableMinorVersion != null ) && ( tableMinorVersion instanceof CFIntMSSqlMinorVersionTable ) ) {
			CFIntMSSqlMinorVersionTable table = (CFIntMSSqlMinorVersionTable)tableMinorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableSecApp != null ) && ( tableSecApp instanceof CFIntMSSqlSecAppTable ) ) {
			CFIntMSSqlSecAppTable table = (CFIntMSSqlSecAppTable)tableSecApp;
			table.releasePreparedStatements();
		}
		if( ( tableSecDevice != null ) && ( tableSecDevice instanceof CFIntMSSqlSecDeviceTable ) ) {
			CFIntMSSqlSecDeviceTable table = (CFIntMSSqlSecDeviceTable)tableSecDevice;
			table.releasePreparedStatements();
		}
		if( ( tableSecForm != null ) && ( tableSecForm instanceof CFIntMSSqlSecFormTable ) ) {
			CFIntMSSqlSecFormTable table = (CFIntMSSqlSecFormTable)tableSecForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroup != null ) && ( tableSecGroup instanceof CFIntMSSqlSecGroupTable ) ) {
			CFIntMSSqlSecGroupTable table = (CFIntMSSqlSecGroupTable)tableSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupForm != null ) && ( tableSecGroupForm instanceof CFIntMSSqlSecGroupFormTable ) ) {
			CFIntMSSqlSecGroupFormTable table = (CFIntMSSqlSecGroupFormTable)tableSecGroupForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGrpInc != null ) && ( tableSecGrpInc instanceof CFIntMSSqlSecGrpIncTable ) ) {
			CFIntMSSqlSecGrpIncTable table = (CFIntMSSqlSecGrpIncTable)tableSecGrpInc;
			table.releasePreparedStatements();
		}
		if( ( tableSecGrpMemb != null ) && ( tableSecGrpMemb instanceof CFIntMSSqlSecGrpMembTable ) ) {
			CFIntMSSqlSecGrpMembTable table = (CFIntMSSqlSecGrpMembTable)tableSecGrpMemb;
			table.releasePreparedStatements();
		}
		if( ( tableSecSession != null ) && ( tableSecSession instanceof CFIntMSSqlSecSessionTable ) ) {
			CFIntMSSqlSecSessionTable table = (CFIntMSSqlSecSessionTable)tableSecSession;
			table.releasePreparedStatements();
		}
		if( ( tableSecUser != null ) && ( tableSecUser instanceof CFIntMSSqlSecUserTable ) ) {
			CFIntMSSqlSecUserTable table = (CFIntMSSqlSecUserTable)tableSecUser;
			table.releasePreparedStatements();
		}
		if( ( tableService != null ) && ( tableService instanceof CFIntMSSqlServiceTable ) ) {
			CFIntMSSqlServiceTable table = (CFIntMSSqlServiceTable)tableService;
			table.releasePreparedStatements();
		}
		if( ( tableServiceType != null ) && ( tableServiceType instanceof CFIntMSSqlServiceTypeTable ) ) {
			CFIntMSSqlServiceTypeTable table = (CFIntMSSqlServiceTypeTable)tableServiceType;
			table.releasePreparedStatements();
		}
		if( ( tableSubProject != null ) && ( tableSubProject instanceof CFIntMSSqlSubProjectTable ) ) {
			CFIntMSSqlSubProjectTable table = (CFIntMSSqlSubProjectTable)tableSubProject;
			table.releasePreparedStatements();
		}
		if( ( tableSysCluster != null ) && ( tableSysCluster instanceof CFIntMSSqlSysClusterTable ) ) {
			CFIntMSSqlSysClusterTable table = (CFIntMSSqlSysClusterTable)tableSysCluster;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroup != null ) && ( tableTSecGroup instanceof CFIntMSSqlTSecGroupTable ) ) {
			CFIntMSSqlTSecGroupTable table = (CFIntMSSqlTSecGroupTable)tableTSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGrpInc != null ) && ( tableTSecGrpInc instanceof CFIntMSSqlTSecGrpIncTable ) ) {
			CFIntMSSqlTSecGrpIncTable table = (CFIntMSSqlTSecGrpIncTable)tableTSecGrpInc;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGrpMemb != null ) && ( tableTSecGrpMemb instanceof CFIntMSSqlTSecGrpMembTable ) ) {
			CFIntMSSqlTSecGrpMembTable table = (CFIntMSSqlTSecGrpMembTable)tableTSecGrpMemb;
			table.releasePreparedStatements();
		}
		if( ( tableTenant != null ) && ( tableTenant instanceof CFIntMSSqlTenantTable ) ) {
			CFIntMSSqlTenantTable table = (CFIntMSSqlTenantTable)tableTenant;
			table.releasePreparedStatements();
		}
		if( ( tableTld != null ) && ( tableTld instanceof CFIntMSSqlTldTable ) ) {
			CFIntMSSqlTldTable table = (CFIntMSSqlTldTable)tableTld;
			table.releasePreparedStatements();
		}
		if( ( tableTopDomain != null ) && ( tableTopDomain instanceof CFIntMSSqlTopDomainTable ) ) {
			CFIntMSSqlTopDomainTable table = (CFIntMSSqlTopDomainTable)tableTopDomain;
			table.releasePreparedStatements();
		}
		if( ( tableTopProject != null ) && ( tableTopProject instanceof CFIntMSSqlTopProjectTable ) ) {
			CFIntMSSqlTopProjectTable table = (CFIntMSSqlTopProjectTable)tableTopProject;
			table.releasePreparedStatements();
		}
		if( ( tableURLProtocol != null ) && ( tableURLProtocol instanceof CFIntMSSqlURLProtocolTable ) ) {
			CFIntMSSqlURLProtocolTable table = (CFIntMSSqlURLProtocolTable)tableURLProtocol;
			table.releasePreparedStatements();
		}
	}

	public static String getQuotedString(String val) {
		if (val == null) {
			return ("null");
		}
		else {
			char c;
			StringBuilder quoted = new StringBuilder();
			quoted.append( "'" );
			int len = val.length();
			for (int i = 0; i < len; i++)
			{
				if (val.charAt( i ) == '\'')
				{
					quoted.append("''");
				}
				else if (val.charAt( i ) == '\\') {
					quoted.append("'||E'\\\\'||'");
				}
				else {
					c = val.charAt( i );
					if (   ( c == '0' )
						|| ( c == '1' )
						|| ( c == '2' )
						|| ( c == '3' )
						|| ( c == '4' )
						|| ( c == '5' )
						|| ( c == '6' )
						|| ( c == '7' )
						|| ( c == '8' )
						|| ( c == '9' )
						|| ( c == 'a' )
						|| ( c == 'b' )
						|| ( c == 'c' )
						|| ( c == 'd' )
						|| ( c == 'e' )
						|| ( c == 'f' )
						|| ( c == 'g' )
						|| ( c == 'h' )
						|| ( c == 'i' )
						|| ( c == 'j' )
						|| ( c == 'k' )
						|| ( c == 'l' )
						|| ( c == 'm' )
						|| ( c == 'n' )
						|| ( c == 'o' )
						|| ( c == 'p' )
						|| ( c == 'q' )
						|| ( c == 'r' )
						|| ( c == 's' )
						|| ( c == 't' )
						|| ( c == 'u' )
						|| ( c == 'v' )
						|| ( c == 'w' )
						|| ( c == 'x' )
						|| ( c == 'y' )
						|| ( c == 'z' )
						|| ( c == 'A' )
						|| ( c == 'B' )
						|| ( c == 'C' )
						|| ( c == 'D' )
						|| ( c == 'E' )
						|| ( c == 'F' )
						|| ( c == 'G' )
						|| ( c == 'H' )
						|| ( c == 'I' )
						|| ( c == 'J' )
						|| ( c == 'K' )
						|| ( c == 'L' )
						|| ( c == 'M' )
						|| ( c == 'N' )
						|| ( c == 'O' )
						|| ( c == 'P' )
						|| ( c == 'Q' )
						|| ( c == 'R' )
						|| ( c == 'S' )
						|| ( c == 'T' )
						|| ( c == 'U' )
						|| ( c == 'V' )
						|| ( c == 'W' )
						|| ( c == 'X' )
						|| ( c == 'Y' )
						|| ( c == 'Z' )
						|| ( c == ' ' )
						|| ( c == '\t' )
						|| ( c == '\r' )
						|| ( c == '\n' )
						|| ( c == '`' )
						|| ( c == '~' )
						|| ( c == '!' )
						|| ( c == '@' )
						|| ( c == '#' )
						|| ( c == '$' )
						|| ( c == '%' )
						|| ( c == '^' )
						|| ( c == '&' )
						|| ( c == '*' )
						|| ( c == '(' )
						|| ( c == ')' )
						|| ( c == '-' )
						|| ( c == '_' )
						|| ( c == '=' )
						|| ( c == '+' )
						|| ( c == '[' )
						|| ( c == ']' )
						|| ( c == '{' )
						|| ( c == '}' )
						|| ( c == '|' )
						|| ( c == ';' )
						|| ( c == ':' )
						|| ( c == '"' )
						|| ( c == '<' )
						|| ( c == '>' )
						|| ( c == ',' )
						|| ( c == '.' )
						|| ( c == '/' )
						|| ( c == '?' ))
					{
						quoted.append(c);
					}
					else {
//						Syslog.warn("\t\t\tReplacing invalid character '" + c + "' with space");
						quoted.append( ' ' );
					}
				}
			}
			quoted.append( "'" );
			return (quoted.toString());
			}
		}

	public static String getNullableString(ResultSet reader, int colidx) {
		try {
			String val = reader.getString( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( val );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFIntMSSqlSchema.class,
				"getNullableString",
				e );
		}
	}

	public static String getBlobString(byte[] val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( "'" + new String( Base64.encodeBase64( val ) ) + "'" );
		}
	}

	public static String getBoolString(Boolean val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			if( val ) {
				return( "'Y'" );
			}
			else {
				return( "'N'" );
			}
		}
	}

	public static String getBoolString(boolean val) {
		if( val ) {
			return( "'Y'" );
		}
		else {
			return( "'N'" );
		}
	}

	public static String getInt16String(Short val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt16String(short val) {
		return( Short.toString( val ) );
	}

	public static String getInt32String(Integer val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt32String(int val) {
		return( Integer.toString( val ) );
	}

	public static String getInt64String(Long val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt64String(long val) {
		return( Long.toString( val ) );
	}

	public static String getUInt16String(Integer val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getUInt16String(int val) {
		return( Integer.toString( val ) );
	}

	public static String getUInt32String(Long val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getUInt32String(long val) {
		return( Long.toString( val ) );
	}

	public static String getUInt64String(BigDecimal val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getFloatString(Float val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getFloatString(float val) {
		return( Float.toString( val ) );
	}

	public static String getDoubleString(Double val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getDoubleString(double val) {
		return( Double.toString( val ) );
	}

	public static String getNumberString(BigDecimal val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static Integer getNullableInt32(ResultSet reader, int colidx) {
		try {
			int val = reader.getInt( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Integer.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFIntMSSqlSchema.class,
				"getNullableInt32",
				e );
		}
	}

	public static Short getNullableInt16(ResultSet reader, int colidx) {
		try {
			short val = reader.getShort( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Short.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFIntMSSqlSchema.class,
				"getNullableInt64",
				e );
		}
	}

	public static Integer getNullableUInt16(ResultSet reader, int colidx) {
		try {
			int val = reader.getInt( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Integer.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFIntMSSqlSchema.class,
				"getNullableUInt16",
				e );
		}
	}

	public static Long getNullableUInt32(ResultSet reader, int colidx) {
		try {
			long val = reader.getLong( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Long.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFIntMSSqlSchema.class,
				"getNullableUInt32",
				e );
		}
	}

	public static BigDecimal getNullableUInt64(ResultSet reader, int colidx) {
		try {
			String strval = reader.getString( colidx );
			if( reader.wasNull() || ( strval == null ) || ( strval.length() <=0 ) ) {
				return(null);
			}
			else {
				BigDecimal retval = new BigDecimal( strval );
				return( retval );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFIntMSSqlSchema.class,
				"getNullableUInt64",
				e );
		}
	}

	public static Byte getNullableByte(ResultSet reader, int colidx) {
		try {
			byte val = reader.getByte( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Byte.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFIntMSSqlSchema.class,
				"getNullableByte",
				e );
		}
	}

	public static String getQuotedDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( " " );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( ":" );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getUuidString(UUID val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			return( "'" + val.toString() + "'" );
		}
	}

	public static Calendar convertDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 8 ) {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertDateString",
				"Value must be in YYYYMMDD format, \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && ((val.charAt( 4 ) >= '0') && (val.charAt( 4 ) <= '1'))
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '9'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '3'))
			 && ((val.charAt( 7 ) >= '0') && (val.charAt( 7 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 4, 6 ) );
			int day = Integer.parseInt( val.substring( 6, 8 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, 0 );
			retval.set( Calendar.MINUTE, 0 );
			retval.set( Calendar.SECOND, 0 );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
		}
		else {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertDateString",
				"Value must be in YYYYMMDD format, \"" + val + "\" is invalid" );
		}
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 8 ) {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTimeString",
				"Value must be in HH24:MI:SS format, \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '2'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && (val.charAt( 2 ) == ':')
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '5'))
			 && ((val.charAt( 4 ) >= '0') && (val.charAt( 4 ) <= '9'))
			 && (val.charAt( 5 ) == ':')
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '5'))
			 && ((val.charAt( 7 ) >= '0') && (val.charAt( 7 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int hour = Integer.parseInt( val.substring( 0, 2 ) );
			int minute = Integer.parseInt( val.substring( 3, 5 ) );
			int second = Integer.parseInt( val.substring( 6, 8 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, 2000 );
			retval.set( Calendar.MONTH, 0 );
			retval.set( Calendar.DAY_OF_MONTH, 1 );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
		}
		else {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTimeString",
				"Value must be in HH24:MI:SS format \"" + val + "\" is invalid" );
		}
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTimestampString",
				"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
		}
		else {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTimestampString",
				"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
		}
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTZDateString",
				"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
		}
		else {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTZDateString",
				"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
		}
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTZTimeString",
				"Value must be in YYYY-MM-DD HH24.MI.SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
		}
		else {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTZTimeString",
				"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
		}
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTZTimestampString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == ' ' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == ':' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == ':' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
		}
		else {
			throw new CFLibUsageException( CFIntMSSqlSchema.class,
				"convertTZTimestampString",
				"Value must be in YYYY-MM-DD HH24:MI:SS format \"" + val + "\" is invalid" );
		}
	}

	public static UUID convertUuidString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else {
			return( UUID.fromString( val ) );
		}
	}
}
