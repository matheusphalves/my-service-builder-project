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

import com.liferay.h7g5.exception.NoSuchH7G5EntryException;
import com.liferay.h7g5.service.base.H7G5EntryServiceBaseImpl;
import com.liferay.h7g5.service.H7G5EntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.portal.aop.AopService;

import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ohqiwtsfhl",
		"json.web.service.context.path=H7G5Entry"
	},
	service = AopService.class
)
public class H7G5EntryServiceImpl extends H7G5EntryServiceBaseImpl {

	public H7G5Entry addEntry(long h7g5FolderId, String description, String name) throws PortalException {
		_checkEmailAddress();
		return h7g5EntryLocalService.addEntry(h7g5FolderId, description, name);

	}
	public H7G5Entry findByH_D_N(
			long h7g5FolderId, String description, String name) throws NoSuchH7G5EntryException, PortalException{
		_checkEmailAddress();
		return h7g5EntryLocalService.findByH_D_N(h7g5FolderId, description, name);
	}

	public List<H7G5Entry> findByH7G5FolderId(long h7g5FolderId) throws PortalException{
		_checkEmailAddress();
		return h7g5EntryLocalService.findByH7G5FolderId(h7g5FolderId);
	}

	public H7G5Entry findBykey(String key) throws NoSuchH7G5EntryException, PortalException{
		_checkEmailAddress();
		return h7g5EntryLocalService.findByKey(key);
	}

	public List<H7G5Entry> findByName(String name) throws PortalException{
		_checkEmailAddress();
		return h7g5EntryLocalService.findByName(name);
	}

	private void _checkEmailAddress() throws PortalException {
		User user = getUser();

		if (!Objects.equals(user.getEmailAddress(), "test@liferay.com")) {
			throw new PrincipalException("You are not test@liferay.com");
		}
	}
}