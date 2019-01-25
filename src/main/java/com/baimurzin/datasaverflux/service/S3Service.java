/*
 * Copyright 2018 by STDLabel. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of STDLabel. Use is subject to license terms.
 *
 * History:
 * V.Baimurzin 2019-01-23 Created
 */
package com.baimurzin.datasaverflux.service;

import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;

public interface S3Service {

    PutObjectResult uploadFile(String bucketName, String folder, String filename, File file);
}
