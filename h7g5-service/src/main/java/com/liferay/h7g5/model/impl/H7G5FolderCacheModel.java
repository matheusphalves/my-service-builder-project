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

package com.liferay.h7g5.model.impl;

import com.liferay.h7g5.model.H7G5Folder;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing H7G5Folder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class H7G5FolderCacheModel
	implements CacheModel<H7G5Folder>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof H7G5FolderCacheModel)) {
			return false;
		}

		H7G5FolderCacheModel h7g5FolderCacheModel =
			(H7G5FolderCacheModel)object;

		if (h7g5FolderId == h7g5FolderCacheModel.h7g5FolderId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, h7g5FolderId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{h7g5FolderId=");
		sb.append(h7g5FolderId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public H7G5Folder toEntityModel() {
		H7G5FolderImpl h7g5FolderImpl = new H7G5FolderImpl();

		h7g5FolderImpl.setH7g5FolderId(h7g5FolderId);
		h7g5FolderImpl.setGroupId(groupId);
		h7g5FolderImpl.setCompanyId(companyId);
		h7g5FolderImpl.setUserId(userId);

		if (userName == null) {
			h7g5FolderImpl.setUserName("");
		}
		else {
			h7g5FolderImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			h7g5FolderImpl.setCreateDate(null);
		}
		else {
			h7g5FolderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			h7g5FolderImpl.setModifiedDate(null);
		}
		else {
			h7g5FolderImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			h7g5FolderImpl.setDescription("");
		}
		else {
			h7g5FolderImpl.setDescription(description);
		}

		if (name == null) {
			h7g5FolderImpl.setName("");
		}
		else {
			h7g5FolderImpl.setName(name);
		}

		h7g5FolderImpl.resetOriginalValues();

		return h7g5FolderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		h7g5FolderId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(h7g5FolderId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long h7g5FolderId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public String name;

}