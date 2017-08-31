package com.coreoz.windmill.exporter.config;

import com.coreoz.windmill.exporter.exporters.excel.ExcelExporter;
import com.coreoz.windmill.exporter.exporters.excel.ExportExcelConfig;
import com.coreoz.windmill.exporter.exporters.excel.ExportExcelFileConfig;
import com.coreoz.windmill.exporter.exporters.excel.ExportExcelSheetConfig;

public class ExportRowsConfig<T> {

	private final Iterable<T> rows;
	private final ExportMapping<T> mapping;

	public ExportRowsConfig(Iterable<T> rows, ExportMapping<T> mapping) {
		this.mapping = mapping;
		this.rows = rows;
	}

	public ExcelExporter<T> asExcel() {
		return asExcel(ExportExcelConfig.of(ExportExcelSheetConfig.of(
			ExportExcelFileConfig.newFile()
		)));
	}

	public ExcelExporter<T> asExcel(ExportExcelConfig config) {
		return new ExcelExporter<>(rows, mapping, config);
	}

}
