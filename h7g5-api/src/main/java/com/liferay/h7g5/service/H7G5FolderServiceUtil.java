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

import com.liferay.h7g5.model.H7G5Folder;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for H7G5Folder. This utility wraps
 * <code>com.liferay.h7g5.service.impl.H7G5FolderServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see H7G5FolderService
 * @generated
 */
public class H7G5FolderServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.h7g5.service.impl.H7G5FolderServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static H7G5Folder addMyCustomH7G5Folder(
		String description, String name) {

		return getService().addMyCustomH7G5Folder(description, name);
	}

	public static H7G5Folder addMyCustomH7G5FolderWithPermissionCheck(
			String description, String name)
		throws PortalException {

		return getService().addMyCustomH7G5FolderWithPermissionCheck(
			description, name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static H7G5FolderService getService() {
		return _service;
	}

	private static volatile H7G5FolderService _service;

}