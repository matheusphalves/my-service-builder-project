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
 * Provides a wrapper for {@link H7G5FolderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see H7G5FolderLocalService
 * @generated
 */
public class H7G5FolderLocalServiceWrapper
	implements H7G5FolderLocalService, ServiceWrapper<H7G5FolderLocalService> {

	public H7G5FolderLocalServiceWrapper() {
		this(null);
	}

	public H7G5FolderLocalServiceWrapper(
		H7G5FolderLocalService h7g5FolderLocalService) {

		_h7g5FolderLocalService = h7g5FolderLocalService;
	}

	/**
	 * Adds the h7g5 folder to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5Folder the h7g5 folder
	 * @return the h7g5 folder that was added
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Folder addH7G5Folder(
		com.liferay.h7g5.model.H7G5Folder h7g5Folder) {

		return _h7g5FolderLocalService.addH7G5Folder(h7g5Folder);
	}

	/**
	 * Creates a new h7g5 folder with the primary key. Does not add the h7g5 folder to the database.
	 *
	 * @param h7g5FolderId the primary key for the new h7g5 folder
	 * @return the new h7g5 folder
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Folder createH7G5Folder(
		long h7g5FolderId) {

		return _h7g5FolderLocalService.createH7G5Folder(h7g5FolderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5FolderLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the h7g5 folder from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5Folder the h7g5 folder
	 * @return the h7g5 folder that was removed
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Folder deleteH7G5Folder(
		com.liferay.h7g5.model.H7G5Folder h7g5Folder) {

		return _h7g5FolderLocalService.deleteH7G5Folder(h7g5Folder);
	}

	/**
	 * Deletes the h7g5 folder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder that was removed
	 * @throws PortalException if a h7g5 folder with the primary key could not be found
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Folder deleteH7G5Folder(long h7g5FolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5FolderLocalService.deleteH7G5Folder(h7g5FolderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5FolderLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _h7g5FolderLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _h7g5FolderLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _h7g5FolderLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _h7g5FolderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g5.model.impl.H7G5FolderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _h7g5FolderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g5.model.impl.H7G5FolderModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _h7g5FolderLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _h7g5FolderLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _h7g5FolderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.h7g5.model.H7G5Folder fetchH7G5Folder(
		long h7g5FolderId) {

		return _h7g5FolderLocalService.fetchH7G5Folder(h7g5FolderId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _h7g5FolderLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the h7g5 folder with the primary key.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder
	 * @throws PortalException if a h7g5 folder with the primary key could not be found
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Folder getH7G5Folder(long h7g5FolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5FolderLocalService.getH7G5Folder(h7g5FolderId);
	}

	/**
	 * Returns a range of all the h7g5 folders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g5.model.impl.H7G5FolderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 folders
	 * @param end the upper bound of the range of h7g5 folders (not inclusive)
	 * @return the range of h7g5 folders
	 */
	@Override
	public java.util.List<com.liferay.h7g5.model.H7G5Folder> getH7G5Folders(
		int start, int end) {

		return _h7g5FolderLocalService.getH7G5Folders(start, end);
	}

	/**
	 * Returns the number of h7g5 folders.
	 *
	 * @return the number of h7g5 folders
	 */
	@Override
	public int getH7G5FoldersCount() {
		return _h7g5FolderLocalService.getH7G5FoldersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _h7g5FolderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _h7g5FolderLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5FolderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the h7g5 folder in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5FolderLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5Folder the h7g5 folder
	 * @return the h7g5 folder that was updated
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Folder updateH7G5Folder(
		com.liferay.h7g5.model.H7G5Folder h7g5Folder) {

		return _h7g5FolderLocalService.updateH7G5Folder(h7g5Folder);
	}

	@Override
	public H7G5FolderLocalService getWrappedService() {
		return _h7g5FolderLocalService;
	}

	@Override
	public void setWrappedService(
		H7G5FolderLocalService h7g5FolderLocalService) {

		_h7g5FolderLocalService = h7g5FolderLocalService;
	}

	private H7G5FolderLocalService _h7g5FolderLocalService;

}