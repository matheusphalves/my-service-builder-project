/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.h7g5.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link H7G5FolderService}.
 *
 * @author Brian Wing Shun Chan
 * @see H7G5FolderService
 * @generated
 */
public class H7G5FolderServiceWrapper
	implements H7G5FolderService, ServiceWrapper<H7G5FolderService> {

	public H7G5FolderServiceWrapper() {
		this(null);
	}

	public H7G5FolderServiceWrapper(H7G5FolderService h7g5FolderService) {
		_h7g5FolderService = h7g5FolderService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _h7g5FolderService.getOSGiServiceIdentifier();
	}

	@Override
	public H7G5FolderService getWrappedService() {
		return _h7g5FolderService;
	}

	@Override
	public void setWrappedService(H7G5FolderService h7g5FolderService) {
		_h7g5FolderService = h7g5FolderService;
	}

	private H7G5FolderService _h7g5FolderService;

}