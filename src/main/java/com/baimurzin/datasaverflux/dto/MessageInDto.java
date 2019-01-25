/*
 * Copyright 2018 by STDLabel. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of STDLabel. Use is subject to license terms.
 *
 * History:
 * V.Baimurzin 2019-01-24 Created
 */
package com.baimurzin.datasaverflux.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageInDto {
    private String accountName;
    private String photoCode;
    private String url;

    public MessageInDto() {
    }

    @JsonCreator
    public MessageInDto(
            @JsonProperty("account") String accountName,
            @JsonProperty("code") String photoCode,
            @JsonProperty("url") String url) {
        this.accountName = accountName;
        this.photoCode = photoCode;
        this.url = url;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhotoCode() {
        return photoCode;
    }

    public void setPhotoCode(String photoCode) {
        this.photoCode = photoCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MessageInDto{" +
                "accountName='" + accountName + '\'' +
                ", photoCode='" + photoCode + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
