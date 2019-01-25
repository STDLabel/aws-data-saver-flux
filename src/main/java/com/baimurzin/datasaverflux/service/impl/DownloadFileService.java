/*
 * Copyright 2018 by STDLabel. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of STDLabel. Use is subject to license terms.
 *
 * History:
 * V.Baimurzin 2019-01-23 Created
 */
package com.baimurzin.datasaverflux.service.impl;

import com.baimurzin.datasaverflux.service.WebFileService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class DownloadFileService implements WebFileService {

    @Override
    public File downloadFileByUrl(String url) throws IOException {
        final File temp;
        temp = File.createTempFile("tempFile", Long.toString(System.nanoTime()));
        FileUtils.copyURLToFile(new URL(url), temp);
        return temp;
    }
}
