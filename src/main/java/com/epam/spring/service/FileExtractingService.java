package com.epam.spring.service;

import com.epam.spring.exception.CommonUtilException;
import com.epam.spring.exception.ServiceException;
import com.epam.spring.plan.DownloadPlan;
import com.epam.spring.util.FileCommonUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Component
public class FileExtractingService {
  private Map<ExtractFormats, BiConsumer<byte[], DownloadPlan.LoadPathConfig>> extractingFunctionsMap;

  public FileExtractingService() {
    extractingFunctionsMap = new HashMap<>();
    extractingFunctionsMap.put( ExtractFormats.ZIP, ( bytes, loadPathConfig ) -> {
      try {
        FileCommonUtil.extractFilesFromZipArchiveByteArray( bytes, loadPathConfig.getLoadedFiles(),
          loadPathConfig.getDestPrefix() );
      } catch ( CommonUtilException e ) {
        throw new ServiceException( e );
      }
    } );
    extractingFunctionsMap.put( ExtractFormats.TAR, ( bytes, loadPathConfig ) -> {
      try {
        FileCommonUtil.extractFilesFromTarArchiveByteArray( bytes, loadPathConfig.getLoadedFiles(),
          loadPathConfig.getDestPrefix() );
      } catch ( CommonUtilException e ) {
        throw new ServiceException( e );
      }
    } );
  }

  public BiConsumer<byte[], DownloadPlan.LoadPathConfig> getExtractFunction( ExtractFormats extractFormat ) {
    return extractingFunctionsMap.getOrDefault( extractFormat, ( bytes, loadPathConfig ) -> {
      //empty
    } );
  }

  public enum ExtractFormats {
    ZIP, TAR
  }
}
