package com.seda.qoe.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Formatter;

import javax.persistence.Entity;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.mapping.MappedSuperclass;

public class HibernateExporter {

//	private String dialect;
//	private String entityPackage;
//
//	private boolean generateCreateQueries = true;
//	private boolean generateDropQueries = false;
//
//	private Configuration hibernateConfiguration;
//
//	public HibernateExporter(String dialect, String entityPackage) {
//		this.dialect = dialect;
//		this.entityPackage = entityPackage;
//
//		hibernateConfiguration = createHibernateConfig();
//	}
//
//	public void export(OutputStream out, boolean generateCreateQueries,
//			boolean generateDropQueries) {
//
//		Dialect hibDialect = Dialect.getDialect(hibernateConfiguration
//				.getProperties());
//		try {
//			PrintWriter writer = new PrintWriter(out);
//
//			if (generateCreateQueries) {
//				String[] createSQL = hibernateConfiguration
//						.generateSchemaCreationScript(hibDialect);
//				write(writer, createSQL, FormatStyle.DDL.getFormatter());
//			}
//			if (generateDropQueries) {
//				String[] dropSQL = hibernateConfiguration
//						.generateDropSchemaScript(hibDialect);
//				write(writer, dropSQL, FormatStyle.DDL.getFormatter());
//			}
//			writer.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//		}
//	}
//
//	public void export(File exportFile) throws FileNotFoundException {
//
//		export(new FileOutputStream(exportFile), generateCreateQueries,
//				generateDropQueries);
//	}
//
//	public void exportToConsole() {
//
//		export(System.out, generateCreateQueries, generateDropQueries);
//	}
//
//	private void write(PrintWriter writer, String[] lines,
//			org.hibernate.engine.jdbc.internal.Formatter formatter) {
//
//		for (String string : lines)
//			writer.println(formatter.format(string) + ";");
//	}
//
//	private Configuration createHibernateConfig() {
//
//		hibernateConfiguration = new Configuration();
//
//		final Reflections reflections = new Reflections(entityPackage);
//		for (Class<?> cl : reflections
//				.getTypesAnnotatedWith(MappedSuperclass.class)) {
//			hibernateConfiguration.addAnnotatedClass(cl);
//		}
//		for (Class<?> cl : reflections.getTypesAnnotatedWith(Entity.class)) {
//			hibernateConfiguration.addAnnotatedClass(cl);
//		}
//		hibernateConfiguration.setProperty(AvailableSettings.DIALECT, dialect);
//		return hibernateConfiguration;
//	}
//
//	public boolean isGenerateDropQueries() {
//		return generateDropQueries;
//	}
//
//	public void setGenerateDropQueries(boolean generateDropQueries) {
//		this.generateDropQueries = generateDropQueries;
//	}
//
//	public Configuration getHibernateConfiguration() {
//		return hibernateConfiguration;
//	}
//
//	public void setHibernateConfiguration(Configuration hibernateConfiguration) {
//		this.hibernateConfiguration = hibernateConfiguration;
//	}
}
