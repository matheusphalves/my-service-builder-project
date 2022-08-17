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

import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing H7G5Entry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class H7G5EntryCacheModel
	implements CacheModel<H7G5Entry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof H7G5EntryCacheModel)) {
			return false;
		}

		H7G5EntryCacheModel h7g5EntryCacheModel = (H7G5EntryCacheModel)object;

		if (h7g5EntryId == h7g5EntryCacheModel.h7g5EntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, h7g5EntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{h7g5EntryId=");
		sb.append(h7g5EntryId);
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
		sb.append(", h7g5FolderId=");
		sb.append(h7g5FolderId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", key=");
		sb.append(key);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public H7G5Entry toEntityModel() {
		H7G5EntryImpl h7g5EntryImpl = new H7G5EntryImpl();

		h7g5EntryImpl.setH7g5EntryId(h7g5EntryId);
		h7g5EntryImpl.setGroupId(groupId);
		h7g5EntryImpl.setCompanyId(companyId);
		h7g5EntryImpl.setUserId(userId);

		if (userName == null) {
			h7g5EntryImpl.setUserName("");
		}
		else {
			h7g5EntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			h7g5EntryImpl.setCreateDate(null);
		}
		else {
			h7g5EntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			h7g5EntryImpl.setModifiedDate(null);
		}
		else {
			h7g5EntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		h7g5EntryImpl.setH7g5FolderId(h7g5FolderId);

		if (description == null) {
			h7g5EntryImpl.setDescription("");
		}
		else {
			h7g5EntryImpl.setDescription(description);
		}

		if (key == null) {
			h7g5EntryImpl.setKey("");
		}
		else {
			h7g5EntryImpl.setKey(key);
		}

		if (name == null) {
			h7g5EntryImpl.setName("");
		}
		else {
			h7g5EntryImpl.setName(name);
		}

		h7g5EntryImpl.resetOriginalValues();

		return h7g5EntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		h7g5EntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		h7g5FolderId = objectInput.readLong();
		description = objectInput.readUTF();
		key = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(h7g5EntryId);

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

		objectOutput.writeLong(h7g5FolderId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long h7g5EntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long h7g5FolderId;
	public String description;
	public String key;
	public String name;

}