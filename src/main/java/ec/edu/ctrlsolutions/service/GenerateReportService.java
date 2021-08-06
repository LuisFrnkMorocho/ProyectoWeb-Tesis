package ec.edu.ctrlsolutions.service;

import java.util.List;
import java.util.Map;

public interface GenerateReportService {
	
	byte[] generateReportBytes (Map<String, Object> parameterMap, String pathReporte, List<?> lista) throws Exception;
	 

}
