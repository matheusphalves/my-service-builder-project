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

import com.liferay.h7g5.model.H7G5Folder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the h7g5 folder service. This utility wraps <code>com.liferay.h7g5.service.persistence.impl.H7G5FolderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see H7G5FolderPersistence
 * @generated
 */
public class H7G5FolderUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(H7G5Folder h7g5Folder) {
		getPersistence().clearCache(h7g5Folder);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, H7G5Folder> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<H7G5Folder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<H7G5Folder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<H7G5Folder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<H7G5Folder> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static H7G5Folder update(H7G5Folder h7g5Folder) {
		return getPersistence().update(h7g5Folder);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static H7G5Folder update(
		H7G5Folder h7g5Folder, ServiceContext serviceContext) {

		return getPersistence().update(h7g5Folder, serviceContext);
	}

	/**
	 * Caches the h7g5 folder in the entity cache if it is enabled.
	 *
	 * @param h7g5Folder the h7g5 folder
	 */
	public static void cacheResult(H7G5Folder h7g5Folder) {
		getPersistence().cacheResult(h7g5Folder);
	}

	/**
	 * Caches the h7g5 folders in the entity cache if it is enabled.
	 *
	 * @param h7g5Folders the h7g5 folders
	 */
	public static void cacheResult(List<H7G5Folder> h7g5Folders) {
		getPersistence().cacheResult(h7g5Folders);
	}

	/**
	 * Creates a new h7g5 folder with the primary key. Does not add the h7g5 folder to the database.
	 *
	 * @param h7g5FolderId the primary key for the new h7g5 folder
	 * @return the new h7g5 folder
	 */
	public static H7G5Folder create(long h7g5FolderId) {
		return getPersistence().create(h7g5FolderId);
	}

	/**
	 * Removes the h7g5 folder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder that was removed
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	public static H7G5Folder remove(long h7g5FolderId)
		throws com.liferay.h7g5.exception.NoSuchH7G5FolderException {

		return getPersistence().remove(h7g5FolderId);
	}

	public static H7G5Folder updateImpl(H7G5Folder h7g5Folder) {
		return getPersistence().updateImpl(h7g5Folder);
	}

	/**
	 * Returns the h7g5 folder with the primary key or throws a <code>NoSuchH7G5FolderException</code> if it could not be found.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	public static H7G5Folder findByPrimaryKey(long h7g5FolderId)
		throws com.liferay.h7g5.exception.NoSuchH7G5FolderException {

		return getPersistence().findByPrimaryKey(h7g5FolderId);
	}

	/**
	 * Returns the h7g5 folder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder, or <code>null</code> if a h7g5 folder with the primary key could not be found
	 */
	public static H7G5Folder fetchByPrimaryKey(long h7g5FolderId) {
		return getPersistence().fetchByPrimaryKey(h7g5FolderId);
	}

	/**
	 * Returns all the h7g5 folders.
	 *
	 * @return the h7g5 folders
	 */
	public static List<H7G5Folder> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the h7g5 folders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5FolderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 folders
	 * @param end the upper bound of the range of h7g5 folders (not inclusive)
	 * @return the range of h7g5 folders
	 */
	public static List<H7G5Folder> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the h7g5 folders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5FolderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 folders
	 * @param end the upper bound of the range of h7g5 folders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of h7g5 folders
	 */
	public static List<H7G5Folder> findAll(
		int start, int end, OrderByComparator<H7G5Folder> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the h7g5 folders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5FolderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 folders
	 * @param end the upper bound of the range of h7g5 folders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of h7g5 folders
	 */
	public static List<H7G5Folder> findAll(
		int start, int end, OrderByComparator<H7G5Folder> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the h7g5 folders from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of h7g5 folders.
	 *
	 * @return the number of h7g5 folders
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static H7G5FolderPersistence getPersistence() {
		return _persistence;
	}

	private static volatile H7G5FolderPersistence _persistence;

}