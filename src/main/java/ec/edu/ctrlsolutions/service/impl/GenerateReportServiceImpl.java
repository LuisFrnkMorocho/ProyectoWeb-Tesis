package ec.edu.ctrlsolutions.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ec.edu.ctrlsolutions.service.GenerateReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class GenerateReportServiceImpl implements GenerateReportService {

	public byte[] generateReportBytes (Map<String, Object> parameterMap,  String pathReporte, List<?> lista) throws Exception {
		try {
			                       
                        JasperPrint jasperPrint = JasperFillManager.fillReport(pathReporte,parameterMap, new JRBeanCollectionDataSource(lista));
			return JasperExportManager.exportReportToPdf(jasperPrint);						
		} catch (OutOfMemoryError ex) {			
			throw new Exception("Error generando el reporte: "
					+ ex.getMessage());
		} catch (JRException ex) {			
			throw new Exception("Error generando el reporte: "
					+ ex.getMessage(), ex);
		} 

	}

}
