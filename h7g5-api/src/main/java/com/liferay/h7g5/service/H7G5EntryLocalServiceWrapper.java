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
 * Provides a wrapper for {@link H7G5EntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see H7G5EntryLocalService
 * @generated
 */
public class H7G5EntryLocalServiceWrapper
	implements H7G5EntryLocalService, ServiceWrapper<H7G5EntryLocalService> {

	public H7G5EntryLocalServiceWrapper() {
		this(null);
	}

	public H7G5EntryLocalServiceWrapper(
		H7G5EntryLocalService h7g5EntryLocalService) {

		_h7g5EntryLocalService = h7g5EntryLocalService;
	}

	@Override
	public com.liferay.h7g5.model.H7G5Entry addEntry(
		long h7g5FolderId, String description, String name) {

		return _h7g5EntryLocalService.addEntry(h7g5FolderId, description, name);
	}

	/**
	 * Adds the h7g5 entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5Entry the h7g5 entry
	 * @return the h7g5 entry that was added
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Entry addH7G5Entry(
		com.liferay.h7g5.model.H7G5Entry h7g5Entry) {

		return _h7g5EntryLocalService.addH7G5Entry(h7g5Entry);
	}

	/**
	 * Creates a new h7g5 entry with the primary key. Does not add the h7g5 entry to the database.
	 *
	 * @param h7g5EntryId the primary key for the new h7g5 entry
	 * @return the new h7g5 entry
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Entry createH7G5Entry(long h7g5EntryId) {
		return _h7g5EntryLocalService.createH7G5Entry(h7g5EntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5EntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the h7g5 entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5Entry the h7g5 entry
	 * @return the h7g5 entry that was removed
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Entry deleteH7G5Entry(
		com.liferay.h7g5.model.H7G5Entry h7g5Entry) {

		return _h7g5EntryLocalService.deleteH7G5Entry(h7g5Entry);
	}

	/**
	 * Deletes the h7g5 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry that was removed
	 * @throws PortalException if a h7g5 entry with the primary key could not be found
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Entry deleteH7G5Entry(long h7g5EntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5EntryLocalService.deleteH7G5Entry(h7g5EntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5EntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _h7g5EntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _h7g5EntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _h7g5EntryLocalService.dynamicQuery();
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

		return _h7g5EntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g5.model.impl.H7G5EntryModelImpl</code>.
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

		return _h7g5EntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g5.model.impl.H7G5EntryModelImpl</code>.
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

		return _h7g5EntryLocalService.dynamicQuery(
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

		return _h7g5EntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _h7g5EntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.h7g5.model.H7G5Entry fetchH7G5Entry(long h7g5EntryId) {
		return _h7g5EntryLocalService.fetchH7G5Entry(h7g5EntryId);
	}

	@Override
	public java.util.List<com.liferay.h7g5.model.H7G5Entry> findByH7G5FolderId(
		long h7g5FolderId) {

		return _h7g5EntryLocalService.findByH7G5FolderId(h7g5FolderId);
	}

	@Override
	public com.liferay.h7g5.model.H7G5Entry findByH_D_N(
			long h7g5FolderId, String description, String name)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return _h7g5EntryLocalService.findByH_D_N(
			h7g5FolderId, description, name);
	}

	@Override
	public com.liferay.h7g5.model.H7G5Entry findByKey(String key)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return _h7g5EntryLocalService.findByKey(key);
	}

	@Override
	public java.util.List<com.liferay.h7g5.model.H7G5Entry> findByName(
		String name) {

		return _h7g5EntryLocalService.findByName(name);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _h7g5EntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the h7g5 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.h7g5.model.impl.H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @return the range of h7g5 entries
	 */
	@Override
	public java.util.List<com.liferay.h7g5.model.H7G5Entry> getH7G5Entries(
		int start, int end) {

		return _h7g5EntryLocalService.getH7G5Entries(start, end);
	}

	/**
	 * Returns the number of h7g5 entries.
	 *
	 * @return the number of h7g5 entries
	 */
	@Override
	public int getH7G5EntriesCount() {
		return _h7g5EntryLocalService.getH7G5EntriesCount();
	}

	/**
	 * Returns the h7g5 entry with the primary key.
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry
	 * @throws PortalException if a h7g5 entry with the primary key could not be found
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Entry getH7G5Entry(long h7g5EntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5EntryLocalService.getH7G5Entry(h7g5EntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _h7g5EntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _h7g5EntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _h7g5EntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the h7g5 entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect H7G5EntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param h7g5Entry the h7g5 entry
	 * @return the h7g5 entry that was updated
	 */
	@Override
	public com.liferay.h7g5.model.H7G5Entry updateH7G5Entry(
		com.liferay.h7g5.model.H7G5Entry h7g5Entry) {

		return _h7g5EntryLocalService.updateH7G5Entry(h7g5Entry);
	}

	@Override
	public H7G5EntryLocalService getWrappedService() {
		return _h7g5EntryLocalService;
	}

	@Override
	public void setWrappedService(H7G5EntryLocalService h7g5EntryLocalService) {
		_h7g5EntryLocalService = h7g5EntryLocalService;
	}

	private H7G5EntryLocalService _h7g5EntryLocalService;

}