package com.logreader;

import static org.junit.Assert.*;

import org.junit.Test;

import com.extfilereader.ReaderMain;

public class ReaderMainTest {
	
	@Test
	public void testLoadAppProperties_PropertyJDBCDriverAvailable() {
		ReaderMain.LoadAppProperties();
		assertTrue(ReaderMain.properties.getProperty("hsqldbJDBCDriver")!=null);
	}
	
	@Test
	public void testLoadAppProperties_PropertyConnectionStringAvailable() {
		ReaderMain.LoadAppProperties();
		assertTrue(ReaderMain.properties.getProperty("dbConnectionString")!=null);
	}

}
