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

import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the h7g5 entry service. This utility wraps <code>com.liferay.h7g5.service.persistence.impl.H7G5EntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see H7G5EntryPersistence
 * @generated
 */
public class H7G5EntryUtil {

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
	public static void clearCache(H7G5Entry h7g5Entry) {
		getPersistence().clearCache(h7g5Entry);
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
	public static Map<Serializable, H7G5Entry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<H7G5Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<H7G5Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<H7G5Entry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static H7G5Entry update(H7G5Entry h7g5Entry) {
		return getPersistence().update(h7g5Entry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static H7G5Entry update(
		H7G5Entry h7g5Entry, ServiceContext serviceContext) {

		return getPersistence().update(h7g5Entry, serviceContext);
	}

	/**
	 * Returns all the h7g5 entries where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @return the matching h7g5 entries
	 */
	public static List<H7G5Entry> findByH7G5FolderId(long h7g5FolderId) {
		return getPersistence().findByH7G5FolderId(h7g5FolderId);
	}

	/**
	 * Returns a range of all the h7g5 entries where h7g5FolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @return the range of matching h7g5 entries
	 */
	public static List<H7G5Entry> findByH7G5FolderId(
		long h7g5FolderId, int start, int end) {

		return getPersistence().findByH7G5FolderId(h7g5FolderId, start, end);
	}

	/**
	 * Returns an ordered range of all the h7g5 entries where h7g5FolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching h7g5 entries
	 */
	public static List<H7G5Entry> findByH7G5FolderId(
		long h7g5FolderId, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().findByH7G5FolderId(
			h7g5FolderId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the h7g5 entries where h7g5FolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching h7g5 entries
	 */
	public static List<H7G5Entry> findByH7G5FolderId(
		long h7g5FolderId, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByH7G5FolderId(
			h7g5FolderId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry findByH7G5FolderId_First(
			long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByH7G5FolderId_First(
			h7g5FolderId, orderByComparator);
	}

	/**
	 * Returns the first h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByH7G5FolderId_First(
		long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().fetchByH7G5FolderId_First(
			h7g5FolderId, orderByComparator);
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry findByH7G5FolderId_Last(
			long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByH7G5FolderId_Last(
			h7g5FolderId, orderByComparator);
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByH7G5FolderId_Last(
		long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().fetchByH7G5FolderId_Last(
			h7g5FolderId, orderByComparator);
	}

	/**
	 * Returns the h7g5 entries before and after the current h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5EntryId the primary key of the current h7g5 entry
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next h7g5 entry
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	public static H7G5Entry[] findByH7G5FolderId_PrevAndNext(
			long h7g5EntryId, long h7g5FolderId,
			OrderByComparator<H7G5Entry> orderByComparator)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByH7G5FolderId_PrevAndNext(
			h7g5EntryId, h7g5FolderId, orderByComparator);
	}

	/**
	 * Removes all the h7g5 entries where h7g5FolderId = &#63; from the database.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 */
	public static void removeByH7G5FolderId(long h7g5FolderId) {
		getPersistence().removeByH7G5FolderId(h7g5FolderId);
	}

	/**
	 * Returns the number of h7g5 entries where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @return the number of matching h7g5 entries
	 */
	public static int countByH7G5FolderId(long h7g5FolderId) {
		return getPersistence().countByH7G5FolderId(h7g5FolderId);
	}

	/**
	 * Returns the h7g5 entry where key = &#63; or throws a <code>NoSuchH7G5EntryException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry findByKey(String key)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByKey(key);
	}

	/**
	 * Returns the h7g5 entry where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByKey(String key) {
		return getPersistence().fetchByKey(key);
	}

	/**
	 * Returns the h7g5 entry where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByKey(String key, boolean useFinderCache) {
		return getPersistence().fetchByKey(key, useFinderCache);
	}

	/**
	 * Removes the h7g5 entry where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the h7g5 entry that was removed
	 */
	public static H7G5Entry removeByKey(String key)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().removeByKey(key);
	}

	/**
	 * Returns the number of h7g5 entries where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching h7g5 entries
	 */
	public static int countByKey(String key) {
		return getPersistence().countByKey(key);
	}

	/**
	 * Returns all the h7g5 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching h7g5 entries
	 */
	public static List<H7G5Entry> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the h7g5 entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @return the range of matching h7g5 entries
	 */
	public static List<H7G5Entry> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the h7g5 entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching h7g5 entries
	 */
	public static List<H7G5Entry> findByName(
		String name, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the h7g5 entries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching h7g5 entries
	 */
	public static List<H7G5Entry> findByName(
		String name, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry findByName_First(
			String name, OrderByComparator<H7G5Entry> orderByComparator)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByName_First(
		String name, OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry findByName_Last(
			String name, OrderByComparator<H7G5Entry> orderByComparator)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByName_Last(
		String name, OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the h7g5 entries before and after the current h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param h7g5EntryId the primary key of the current h7g5 entry
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next h7g5 entry
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	public static H7G5Entry[] findByName_PrevAndNext(
			long h7g5EntryId, String name,
			OrderByComparator<H7G5Entry> orderByComparator)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByName_PrevAndNext(
			h7g5EntryId, name, orderByComparator);
	}

	/**
	 * Removes all the h7g5 entries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of h7g5 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching h7g5 entries
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns the h7g5 entry where h7g5FolderId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchH7G5EntryException</code> if it could not be found.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry findByH_D_N(
			long h7g5FolderId, String description, String name)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByH_D_N(h7g5FolderId, description, name);
	}

	/**
	 * Returns the h7g5 entry where h7g5FolderId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByH_D_N(
		long h7g5FolderId, String description, String name) {

		return getPersistence().fetchByH_D_N(h7g5FolderId, description, name);
	}

	/**
	 * Returns the h7g5 entry where h7g5FolderId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	public static H7G5Entry fetchByH_D_N(
		long h7g5FolderId, String description, String name,
		boolean useFinderCache) {

		return getPersistence().fetchByH_D_N(
			h7g5FolderId, description, name, useFinderCache);
	}

	/**
	 * Removes the h7g5 entry where h7g5FolderId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the h7g5 entry that was removed
	 */
	public static H7G5Entry removeByH_D_N(
			long h7g5FolderId, String description, String name)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().removeByH_D_N(h7g5FolderId, description, name);
	}

	/**
	 * Returns the number of h7g5 entries where h7g5FolderId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching h7g5 entries
	 */
	public static int countByH_D_N(
		long h7g5FolderId, String description, String name) {

		return getPersistence().countByH_D_N(h7g5FolderId, description, name);
	}

	/**
	 * Caches the h7g5 entry in the entity cache if it is enabled.
	 *
	 * @param h7g5Entry the h7g5 entry
	 */
	public static void cacheResult(H7G5Entry h7g5Entry) {
		getPersistence().cacheResult(h7g5Entry);
	}

	/**
	 * Caches the h7g5 entries in the entity cache if it is enabled.
	 *
	 * @param h7g5Entries the h7g5 entries
	 */
	public static void cacheResult(List<H7G5Entry> h7g5Entries) {
		getPersistence().cacheResult(h7g5Entries);
	}

	/**
	 * Creates a new h7g5 entry with the primary key. Does not add the h7g5 entry to the database.
	 *
	 * @param h7g5EntryId the primary key for the new h7g5 entry
	 * @return the new h7g5 entry
	 */
	public static H7G5Entry create(long h7g5EntryId) {
		return getPersistence().create(h7g5EntryId);
	}

	/**
	 * Removes the h7g5 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry that was removed
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	public static H7G5Entry remove(long h7g5EntryId)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().remove(h7g5EntryId);
	}

	public static H7G5Entry updateImpl(H7G5Entry h7g5Entry) {
		return getPersistence().updateImpl(h7g5Entry);
	}

	/**
	 * Returns the h7g5 entry with the primary key or throws a <code>NoSuchH7G5EntryException</code> if it could not be found.
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	public static H7G5Entry findByPrimaryKey(long h7g5EntryId)
		throws com.liferay.h7g5.exception.NoSuchH7G5EntryException {

		return getPersistence().findByPrimaryKey(h7g5EntryId);
	}

	/**
	 * Returns the h7g5 entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry, or <code>null</code> if a h7g5 entry with the primary key could not be found
	 */
	public static H7G5Entry fetchByPrimaryKey(long h7g5EntryId) {
		return getPersistence().fetchByPrimaryKey(h7g5EntryId);
	}

	/**
	 * Returns all the h7g5 entries.
	 *
	 * @return the h7g5 entries
	 */
	public static List<H7G5Entry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the h7g5 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @return the range of h7g5 entries
	 */
	public static List<H7G5Entry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the h7g5 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of h7g5 entries
	 */
	public static List<H7G5Entry> findAll(
		int start, int end, OrderByComparator<H7G5Entry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the h7g5 entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>H7G5EntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of h7g5 entries
	 * @param end the upper bound of the range of h7g5 entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of h7g5 entries
	 */
	public static List<H7G5Entry> findAll(
		int start, int end, OrderByComparator<H7G5Entry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the h7g5 entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of h7g5 entries.
	 *
	 * @return the number of h7g5 entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static H7G5EntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile H7G5EntryPersistence _persistence;

}