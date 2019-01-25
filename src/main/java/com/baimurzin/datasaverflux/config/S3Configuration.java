/*
 * Copyright 2018 by STDLabel. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of STDLabel. Use is subject to license terms.
 *
 * History:
 * V.Baimurzin 2019-01-23 Created
 */
package com.baimurzin.datasaverflux.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSqs
public class S3Configuration {

    private static final Logger log = LoggerFactory.getLogger(S3Configuration.class);

    String bucketName = "data-saver-flux-inst";

    @Bean
    public AmazonS3 amazonS3() {
        String AWS_ACCESS_KEY_ID = System.getenv("AWS_ACCESS_KEY_ID");
        String AWS_SECRET_ACCESS_KEY = System.getenv("AWS_SECRET_ACCESS_KEY");

        log.info("Property read access Key = " + AWS_ACCESS_KEY_ID);
        log.info("Property read secret key = " + AWS_SECRET_ACCESS_KEY);

        AWSCredentials awsCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.US_EAST_1)
                .build();
        return s3client;
    }

}
