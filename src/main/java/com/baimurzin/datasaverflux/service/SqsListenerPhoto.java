/*
 * Copyright 2018 by HireRight, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of HireRight, Inc. Use is subject to license terms.
 *
 * History:
 * V.Baimurzin 2019-01-24 Created
 */
package com.baimurzin.datasaverflux.service;

import com.baimurzin.datasaverflux.dto.MessageInDto;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsListenerPhoto {

    @SqsListener("account-photo-to-upload.fifo")
    public void listen(MessageInDto messageInDto) {

    }
}
