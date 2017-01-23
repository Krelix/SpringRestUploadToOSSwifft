package com.github.krelix.main;

import com.github.krelix.Storage.StorageController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;

/**
 * Created by brizarda on 18/01/2017.
 */
@RestController
@MultipartConfig(fileSizeThreshold = 100 * 1024 * 1024)
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    /**
     * REST Service
     * Takes into parameters a file to upload, then calls the storage to saave it.
     * Returns a JSON containing the ID of the file.
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(name = "file") MultipartFile file)
            throws IOException {
        final String fileUrl = (new StorageController()).uploadDocument(file.getBytes(), "test");
        LOGGER.info("New file URL : {}", fileUrl);
        return "{\"fileUrl\":\""+fileUrl+"\"}";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalErrorExceptionHandler(Exception e) {
        System.out.println("Error caught : " + e.getLocalizedMessage());
        e.printStackTrace();
        return "{\"message\":\"" + e.getLocalizedMessage() + "\"}";
    }
}
