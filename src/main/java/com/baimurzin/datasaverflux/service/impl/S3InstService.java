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

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.baimurzin.datasaverflux.service.S3Service;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class S3InstService implements S3Service {

    private final AmazonS3 clientAmazonS3;

    public S3InstService(AmazonS3 clientAmazonS3) {
        this.clientAmazonS3 = clientAmazonS3;
    }

    @Override
    public PutObjectResult uploadFile(String bucketName, String folder, String filename, File file) {
        PutObjectResult putObjectResult = clientAmazonS3.putObject(new PutObjectRequest(bucketName, folder + "/" + filename, file));
        return putObjectResult;
    }

}
