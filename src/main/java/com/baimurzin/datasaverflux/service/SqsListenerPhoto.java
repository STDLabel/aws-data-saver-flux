/*
 * Copyright 2019 by STDLabel. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of STDLabel. Use is subject to license terms.
 *
 * History:
 * V.Baimurzin 2019-01-24 Created
 */
package com.baimurzin.datasaverflux.service;

import com.baimurzin.datasaverflux.config.S3Constant;
import com.baimurzin.datasaverflux.dto.MessageInDto;
import com.baimurzin.datasaverflux.service.impl.DownloadFileService;
import com.baimurzin.datasaverflux.service.impl.S3InstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class SqsListenerPhoto {


    private final static Logger log = LoggerFactory.getLogger(SqsListenerPhoto.class);


    private final DownloadFileService downloadFileService;

    private final S3InstService s3InstService;

    public SqsListenerPhoto(DownloadFileService downloadFileService, S3InstService s3InstService) {
        this.downloadFileService = downloadFileService;
        this.s3InstService = s3InstService;
    }

    @SqsListener(value = "account-photo-to-upload.fifo", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void listen(MessageInDto messageInDto) throws IOException {
        log.info("Message got: ", messageInDto);
        File file = downloadFileService.downloadFileByUrl(messageInDto.getUrl());
        s3InstService.uploadFile(S3Constant.BUCKET_NAME,
                messageInDto.getAccountName(),
                messageInDto.getPhotoCode() + ".jpg",
                file);
        file.delete();
        log.info("file uploaded for account " + messageInDto.getAccountName());
    }
}
