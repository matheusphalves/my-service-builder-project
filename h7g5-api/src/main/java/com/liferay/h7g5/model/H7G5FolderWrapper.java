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

package com.liferay.h7g5.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link H7G5Folder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see H7G5Folder
 * @generated
 */
public class H7G5FolderWrapper
	extends BaseModelWrapper<H7G5Folder>
	implements H7G5Folder, ModelWrapper<H7G5Folder> {

	public H7G5FolderWrapper(H7G5Folder h7g5Folder) {
		super(h7g5Folder);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("h7g5FolderId", getH7g5FolderId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long h7g5FolderId = (Long)attributes.get("h7g5FolderId");

		if (h7g5FolderId != null) {
			setH7g5FolderId(h7g5FolderId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public H7G5Folder cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this h7g5 folder.
	 *
	 * @return the company ID of this h7g5 folder
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this h7g5 folder.
	 *
	 * @return the create date of this h7g5 folder
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this h7g5 folder.
	 *
	 * @return the description of this h7g5 folder
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this h7g5 folder.
	 *
	 * @return the group ID of this h7g5 folder
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the h7g5 folder ID of this h7g5 folder.
	 *
	 * @return the h7g5 folder ID of this h7g5 folder
	 */
	@Override
	public long getH7g5FolderId() {
		return model.getH7g5FolderId();
	}

	/**
	 * Returns the modified date of this h7g5 folder.
	 *
	 * @return the modified date of this h7g5 folder
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this h7g5 folder.
	 *
	 * @return the name of this h7g5 folder
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this h7g5 folder.
	 *
	 * @return the primary key of this h7g5 folder
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this h7g5 folder.
	 *
	 * @return the user ID of this h7g5 folder
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this h7g5 folder.
	 *
	 * @return the user name of this h7g5 folder
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this h7g5 folder.
	 *
	 * @return the user uuid of this h7g5 folder
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this h7g5 folder.
	 *
	 * @param companyId the company ID of this h7g5 folder
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this h7g5 folder.
	 *
	 * @param createDate the create date of this h7g5 folder
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this h7g5 folder.
	 *
	 * @param description the description of this h7g5 folder
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this h7g5 folder.
	 *
	 * @param groupId the group ID of this h7g5 folder
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the h7g5 folder ID of this h7g5 folder.
	 *
	 * @param h7g5FolderId the h7g5 folder ID of this h7g5 folder
	 */
	@Override
	public void setH7g5FolderId(long h7g5FolderId) {
		model.setH7g5FolderId(h7g5FolderId);
	}

	/**
	 * Sets the modified date of this h7g5 folder.
	 *
	 * @param modifiedDate the modified date of this h7g5 folder
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this h7g5 folder.
	 *
	 * @param name the name of this h7g5 folder
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this h7g5 folder.
	 *
	 * @param primaryKey the primary key of this h7g5 folder
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this h7g5 folder.
	 *
	 * @param userId the user ID of this h7g5 folder
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this h7g5 folder.
	 *
	 * @param userName the user name of this h7g5 folder
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this h7g5 folder.
	 *
	 * @param userUuid the user uuid of this h7g5 folder
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected H7G5FolderWrapper wrap(H7G5Folder h7g5Folder) {
		return new H7G5FolderWrapper(h7g5Folder);
	}

}