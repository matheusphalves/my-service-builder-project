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

package com.liferay.h7g5.service.persistence.impl;

import com.liferay.h7g5.exception.NoSuchH7G5FolderException;
import com.liferay.h7g5.model.H7G5Folder;
import com.liferay.h7g5.model.H7G5FolderTable;
import com.liferay.h7g5.model.impl.H7G5FolderImpl;
import com.liferay.h7g5.model.impl.H7G5FolderModelImpl;
import com.liferay.h7g5.service.persistence.H7G5FolderPersistence;
import com.liferay.h7g5.service.persistence.H7G5FolderUtil;
import com.liferay.h7g5.service.persistence.impl.constants.OHQIWTSFHLPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the h7g5 folder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {H7G5FolderPersistence.class, BasePersistence.class})
public class H7G5FolderPersistenceImpl
	extends BasePersistenceImpl<H7G5Folder> implements H7G5FolderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>H7G5FolderUtil</code> to access the h7g5 folder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		H7G5FolderImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public H7G5FolderPersistenceImpl() {
		setModelClass(H7G5Folder.class);

		setModelImplClass(H7G5FolderImpl.class);
		setModelPKClass(long.class);

		setTable(H7G5FolderTable.INSTANCE);
	}

	/**
	 * Caches the h7g5 folder in the entity cache if it is enabled.
	 *
	 * @param h7g5Folder the h7g5 folder
	 */
	@Override
	public void cacheResult(H7G5Folder h7g5Folder) {
		entityCache.putResult(
			H7G5FolderImpl.class, h7g5Folder.getPrimaryKey(), h7g5Folder);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the h7g5 folders in the entity cache if it is enabled.
	 *
	 * @param h7g5Folders the h7g5 folders
	 */
	@Override
	public void cacheResult(List<H7G5Folder> h7g5Folders) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (h7g5Folders.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (H7G5Folder h7g5Folder : h7g5Folders) {
			if (entityCache.getResult(
					H7G5FolderImpl.class, h7g5Folder.getPrimaryKey()) == null) {

				cacheResult(h7g5Folder);
			}
		}
	}

	/**
	 * Clears the cache for all h7g5 folders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(H7G5FolderImpl.class);

		finderCache.clearCache(H7G5FolderImpl.class);
	}

	/**
	 * Clears the cache for the h7g5 folder.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(H7G5Folder h7g5Folder) {
		entityCache.removeResult(H7G5FolderImpl.class, h7g5Folder);
	}

	@Override
	public void clearCache(List<H7G5Folder> h7g5Folders) {
		for (H7G5Folder h7g5Folder : h7g5Folders) {
			entityCache.removeResult(H7G5FolderImpl.class, h7g5Folder);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(H7G5FolderImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(H7G5FolderImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new h7g5 folder with the primary key. Does not add the h7g5 folder to the database.
	 *
	 * @param h7g5FolderId the primary key for the new h7g5 folder
	 * @return the new h7g5 folder
	 */
	@Override
	public H7G5Folder create(long h7g5FolderId) {
		H7G5Folder h7g5Folder = new H7G5FolderImpl();

		h7g5Folder.setNew(true);
		h7g5Folder.setPrimaryKey(h7g5FolderId);

		h7g5Folder.setCompanyId(CompanyThreadLocal.getCompanyId());

		return h7g5Folder;
	}

	/**
	 * Removes the h7g5 folder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder that was removed
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	@Override
	public H7G5Folder remove(long h7g5FolderId)
		throws NoSuchH7G5FolderException {

		return remove((Serializable)h7g5FolderId);
	}

	/**
	 * Removes the h7g5 folder with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the h7g5 folder
	 * @return the h7g5 folder that was removed
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	@Override
	public H7G5Folder remove(Serializable primaryKey)
		throws NoSuchH7G5FolderException {

		Session session = null;

		try {
			session = openSession();

			H7G5Folder h7g5Folder = (H7G5Folder)session.get(
				H7G5FolderImpl.class, primaryKey);

			if (h7g5Folder == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchH7G5FolderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(h7g5Folder);
		}
		catch (NoSuchH7G5FolderException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected H7G5Folder removeImpl(H7G5Folder h7g5Folder) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(h7g5Folder)) {
				h7g5Folder = (H7G5Folder)session.get(
					H7G5FolderImpl.class, h7g5Folder.getPrimaryKeyObj());
			}

			if (h7g5Folder != null) {
				session.delete(h7g5Folder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (h7g5Folder != null) {
			clearCache(h7g5Folder);
		}

		return h7g5Folder;
	}

	@Override
	public H7G5Folder updateImpl(H7G5Folder h7g5Folder) {
		boolean isNew = h7g5Folder.isNew();

		if (!(h7g5Folder instanceof H7G5FolderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(h7g5Folder.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(h7g5Folder);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in h7g5Folder proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom H7G5Folder implementation " +
					h7g5Folder.getClass());
		}

		H7G5FolderModelImpl h7g5FolderModelImpl =
			(H7G5FolderModelImpl)h7g5Folder;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (h7g5Folder.getCreateDate() == null)) {
			if (serviceContext == null) {
				h7g5Folder.setCreateDate(date);
			}
			else {
				h7g5Folder.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!h7g5FolderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				h7g5Folder.setModifiedDate(date);
			}
			else {
				h7g5Folder.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(h7g5Folder);
			}
			else {
				h7g5Folder = (H7G5Folder)session.merge(h7g5Folder);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(H7G5FolderImpl.class, h7g5Folder, false, true);

		if (isNew) {
			h7g5Folder.setNew(false);
		}

		h7g5Folder.resetOriginalValues();

		return h7g5Folder;
	}

	/**
	 * Returns the h7g5 folder with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the h7g5 folder
	 * @return the h7g5 folder
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	@Override
	public H7G5Folder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchH7G5FolderException {

		H7G5Folder h7g5Folder = fetchByPrimaryKey(primaryKey);

		if (h7g5Folder == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchH7G5FolderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return h7g5Folder;
	}

	/**
	 * Returns the h7g5 folder with the primary key or throws a <code>NoSuchH7G5FolderException</code> if it could not be found.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder
	 * @throws NoSuchH7G5FolderException if a h7g5 folder with the primary key could not be found
	 */
	@Override
	public H7G5Folder findByPrimaryKey(long h7g5FolderId)
		throws NoSuchH7G5FolderException {

		return findByPrimaryKey((Serializable)h7g5FolderId);
	}

	/**
	 * Returns the h7g5 folder with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param h7g5FolderId the primary key of the h7g5 folder
	 * @return the h7g5 folder, or <code>null</code> if a h7g5 folder with the primary key could not be found
	 */
	@Override
	public H7G5Folder fetchByPrimaryKey(long h7g5FolderId) {
		return fetchByPrimaryKey((Serializable)h7g5FolderId);
	}

	/**
	 * Returns all the h7g5 folders.
	 *
	 * @return the h7g5 folders
	 */
	@Override
	public List<H7G5Folder> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<H7G5Folder> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<H7G5Folder> findAll(
		int start, int end, OrderByComparator<H7G5Folder> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<H7G5Folder> findAll(
		int start, int end, OrderByComparator<H7G5Folder> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<H7G5Folder> list = null;

		if (useFinderCache) {
			list = (List<H7G5Folder>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_H7G5FOLDER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_H7G5FOLDER;

				sql = sql.concat(H7G5FolderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<H7G5Folder>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the h7g5 folders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (H7G5Folder h7g5Folder : findAll()) {
			remove(h7g5Folder);
		}
	}

	/**
	 * Returns the number of h7g5 folders.
	 *
	 * @return the number of h7g5 folders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_H7G5FOLDER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "h7g5FolderId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_H7G5FOLDER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return H7G5FolderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the h7g5 folder persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setH7G5FolderUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setH7G5FolderUtilPersistence(null);

		entityCache.removeCache(H7G5FolderImpl.class.getName());
	}

	private void _setH7G5FolderUtilPersistence(
		H7G5FolderPersistence h7g5FolderPersistence) {

		try {
			Field field = H7G5FolderUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, h7g5FolderPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = OHQIWTSFHLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = OHQIWTSFHLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OHQIWTSFHLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_H7G5FOLDER =
		"SELECT h7g5Folder FROM H7G5Folder h7g5Folder";

	private static final String _SQL_COUNT_H7G5FOLDER =
		"SELECT COUNT(h7g5Folder) FROM H7G5Folder h7g5Folder";

	private static final String _ORDER_BY_ENTITY_ALIAS = "h7g5Folder.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No H7G5Folder exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		H7G5FolderPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private H7G5FolderModelArgumentsResolver _h7g5FolderModelArgumentsResolver;

}