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

import com.liferay.h7g5.exception.NoSuchH7G5FolderException;
import com.liferay.h7g5.model.H7G5Folder;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the h7g5 folder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see H7G5FolderUtil
 * @generated
 */
@ProviderType
public interface H7G5FolderPersistence extends BasePersistence<H7G5Folder> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link H7G5FolderUtil} to access the h7g5 folder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the h7g5 folder in the entity cache if it is enabled.
	 *
	 * @param h7g5Folder the h7g5 folder
	 */
	public void cacheResult(H7G5Folder h7g5Folder);

	/**
	 * Caches the h7g5 folders in the entity cache if it is enabled.
	 *
	 * @param h7g5Folders the h7g5 folders
	 */
	public void cacheResult(java.util.List<H7G5Folder> h7g5Folders);

	/**
	 * Creates a new h7g5 folder with the primary key. Does not add the h7g5 folder to the database.
	 *
	 * @param h7g5FolderId the primary key for the new h7g5 folder
	 * @return the new h7g5 folder
	 */
	public H7G5Folder create(long h7g5FolderId);

	/**
	 * Removes the h7g5 folder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder that was removed
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	public H7G5Folder remove(long h7g5FolderId)
		throws NoSuchH7G5FolderException;

	public H7G5Folder updateImpl(H7G5Folder h7g5Folder);

	/**
	 * Returns the h7g5 folder with the primary key or throws a <code>NoSuchH7G5FolderException</code> if it could not be found.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	public H7G5Folder findByPrimaryKey(long h7g5FolderId)
		throws NoSuchH7G5FolderException;

	/**
	 * Returns the h7g5 folder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder, or <code>null</code> if a h7g5 folder with the primary key could not be found
	 */
	public H7G5Folder fetchByPrimaryKey(long h7g5FolderId);

	/**
	 * Returns all the h7g5 folders.
	 *
	 * @return the h7g5 folders
	 */
	public java.util.List<H7G5Folder> findAll();

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
	public java.util.List<H7G5Folder> findAll(int start, int end);

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
	public java.util.List<H7G5Folder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G5Folder>
			orderByComparator);

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
	public java.util.List<H7G5Folder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<H7G5Folder>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the h7g5 folders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of h7g5 folders.
	 *
	 * @return the number of h7g5 folders
	 */
	public int countAll();

}