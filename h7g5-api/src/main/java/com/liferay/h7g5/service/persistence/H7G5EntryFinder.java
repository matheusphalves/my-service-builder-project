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

package com.liferay.h7g5.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface H7G5EntryFinder {

	public java.util.List<com.liferay.h7g5.model.H7G5Entry> findByFolderId(
		long folderId);

	public java.util.List<com.liferay.h7g5.model.H7G5Entry> findByHDN(
		long entryFolderId, String entryDescription, String entryName);

	public com.liferay.h7g5.model.H7G5Entry findByKey(String entryKey);

	public java.util.List<com.liferay.h7g5.model.H7G5Entry> findByName(
		String entryName);

}