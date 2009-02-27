package net.nanopool.dummy;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

/**
 * A dummy that throws UnsupportedOperationException on every method call.
 * @author cvh
 */
public class DummyConnection implements Connection {

    public Statement createStatement() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PreparedStatement prepareStatement(String arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CallableStatement prepareCall(String arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String nativeSQL(String arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAutoCommit(boolean arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getAutoCommit() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void commit() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void rollback() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void close() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isClosed() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DatabaseMetaData getMetaData() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setReadOnly(boolean arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isReadOnly() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCatalog(String arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getCatalog() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setTransactionIsolation(int arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getTransactionIsolation() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SQLWarning getWarnings() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clearWarnings() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Statement createStatement(int arg0, int arg1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setHoldability(int arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getHoldability() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Savepoint setSavepoint() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Savepoint setSavepoint(String arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void rollback(Savepoint arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void releaseSavepoint(Savepoint arg0) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Clob createClob() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Blob createBlob() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public NClob createNClob() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SQLXML createSQLXML() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isValid(int timeout) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getClientInfo(String name) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Properties getClientInfo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
