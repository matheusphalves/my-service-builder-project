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

import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for H7G5Entry. This utility wraps
 * <code>com.liferay.h7g5.service.impl.H7G5EntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see H7G5EntryService
 * @generated
 */
public class H7G5EntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.h7g5.service.impl.H7G5EntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static H7G5Entry addEntry(
			long h7g5FolderId, String description, String name)
		throws PortalException {

		return getService().addEntry(h7g5FolderId, description, name);
	}

	public static List<H7G5Entry> findByH7G5FolderId(long h7g5FolderId)
		throws PortalException {

		return getService().findByH7G5FolderId(h7g5FolderId);
	}

	public static H7G5Entry findByH_D_N(
			long h7g5FolderId, String description, String name)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException,
			   PortalException {

		return getService().findByH_D_N(h7g5FolderId, description, name);
	}

	public static H7G5Entry findBykey(String key)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException,
			   PortalException {

		return getService().findBykey(key);
	}

	public static List<H7G5Entry> findByName(String name)
		throws PortalException {

		return getService().findByName(name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static H7G5EntryService getService() {
		return _service;
	}

	private static volatile H7G5EntryService _service;

}