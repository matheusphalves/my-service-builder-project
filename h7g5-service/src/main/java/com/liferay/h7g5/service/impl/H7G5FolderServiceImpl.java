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

package com.liferay.h7g5.service.impl;


import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import com.liferay.h7g5.service.base.H7G5FolderServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.h7g5.model.H7G5Folder;

import org.osgi.service.component.annotations.Component;
import java.util.Objects;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ohqiwtsfhl",
		"json.web.service.context.path=H7G5Folder"
	},
	service = AopService.class
)
public class H7G5FolderServiceImpl extends H7G5FolderServiceBaseImpl {
	public H7G5Folder addMyCustomH7G5Folder(String description, String name) {
		System.out.println(
				"Invoking H7G5FolderServiceImpl#addMyCustomH7G5Folder(" +
						description + ", " + name + ")");

		H7G5Folder h7g5Folder = h7g5FolderLocalService.createH7G5Folder(
				System.currentTimeMillis());

		h7g5Folder.setDescription(description);
		h7g5Folder.setName(name);

		h7g5FolderLocalService.addH7G5Folder(h7g5Folder);

		return h7g5Folder;
	}

	public H7G5Folder addMyCustomH7G5FolderWithPermissionCheck(
			String description, String name)
			throws PortalException {

		User user = getUser();

		if (!Objects.equals(user.getEmailAddress(), "test@liferay.com")) {
			throw new PrincipalException("You are not test@liferay.com");
		}

		return addMyCustomH7G5Folder(description, name);
	}

}