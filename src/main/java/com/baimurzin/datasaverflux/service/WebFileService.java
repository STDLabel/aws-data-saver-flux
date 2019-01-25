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

import java.io.File;
import java.io.IOException;

public interface WebFileService {

    File downloadFileByUrl(String url) throws IOException;
}
