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

import com.liferay.h7g5.service.base.H7G5EntryLocalServiceBaseImpl;
import com.liferay.h7g5.exception.NoSuchH7G5EntryException;
import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.h7g5.model.H7G5Entry",
	service = AopService.class
)
public class H7G5EntryLocalServiceImpl extends H7G5EntryLocalServiceBaseImpl {

	public H7G5Entry findByH_D_N(
			long h7g5FolderId, String description, String name) throws  NoSuchH7G5EntryException{
		return h7g5EntryPersistence.findByH_D_N(h7g5FolderId, description, name);
	}

	public List<H7G5Entry> findByH7G5FolderId(long h7g5FolderId) {
		return h7g5EntryPersistence.findByH7G5FolderId(h7g5FolderId);
	}

	public H7G5Entry findByKey(String key) throws NoSuchH7G5EntryException {
		return h7g5EntryPersistence.findByKey(key);
	}
	public List<H7G5Entry> findByName(String name) {
		return h7g5EntryPersistence.findByName(name);
	}

	@Override
	public H7G5Entry addEntry(
			long h7g5FolderId, String description, String name)	{
		H7G5Entry h7g5Entry = h7g5EntryLocalService.createH7G5Entry(
				System.currentTimeMillis());
		h7g5Entry.setName(name);
		h7g5Entry.setDescription(description);
		h7g5Entry.setKey("key-" + name);
		h7g5Entry.setH7g5FolderId(h7g5FolderId);
		h7g5EntryLocalService.addH7G5Entry(h7g5Entry);
		return h7g5Entry;
	}
}