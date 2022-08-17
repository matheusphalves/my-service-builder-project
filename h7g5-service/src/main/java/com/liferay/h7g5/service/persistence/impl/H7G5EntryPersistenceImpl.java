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

import com.liferay.h7g5.exception.NoSuchH7G5EntryException;
import com.liferay.h7g5.model.H7G5Entry;
import com.liferay.h7g5.model.H7G5EntryTable;
import com.liferay.h7g5.model.impl.H7G5EntryImpl;
import com.liferay.h7g5.model.impl.H7G5EntryModelImpl;
import com.liferay.h7g5.service.persistence.H7G5EntryPersistence;
import com.liferay.h7g5.service.persistence.H7G5EntryUtil;
import com.liferay.h7g5.service.persistence.impl.constants.OHQIWTSFHLPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the h7g5 entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {H7G5EntryPersistence.class, BasePersistence.class})
public class H7G5EntryPersistenceImpl
	extends BasePersistenceImpl<H7G5Entry> implements H7G5EntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>H7G5EntryUtil</code> to access the h7g5 entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		H7G5EntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByH7G5FolderId;
	private FinderPath _finderPathWithoutPaginationFindByH7G5FolderId;
	private FinderPath _finderPathCountByH7G5FolderId;

	/**
	 * Returns all the h7g5 entries where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @return the matching h7g5 entries
	 */
	@Override
	public List<H7G5Entry> findByH7G5FolderId(long h7g5FolderId) {
		return findByH7G5FolderId(
			h7g5FolderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<H7G5Entry> findByH7G5FolderId(
		long h7g5FolderId, int start, int end) {

		return findByH7G5FolderId(h7g5FolderId, start, end, null);
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
	@Override
	public List<H7G5Entry> findByH7G5FolderId(
		long h7g5FolderId, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator) {

		return findByH7G5FolderId(
			h7g5FolderId, start, end, orderByComparator, true);
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
	@Override
	public List<H7G5Entry> findByH7G5FolderId(
		long h7g5FolderId, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByH7G5FolderId;
				finderArgs = new Object[] {h7g5FolderId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByH7G5FolderId;
			finderArgs = new Object[] {
				h7g5FolderId, start, end, orderByComparator
			};
		}

		List<H7G5Entry> list = null;

		if (useFinderCache) {
			list = (List<H7G5Entry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (H7G5Entry h7g5Entry : list) {
					if (h7g5FolderId != h7g5Entry.getH7g5FolderId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_H7G5ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H7G5FOLDERID_H7G5FOLDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(H7G5EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g5FolderId);

				list = (List<H7G5Entry>)QueryUtil.list(
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
	 * Returns the first h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry findByH7G5FolderId_First(
			long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = fetchByH7G5FolderId_First(
			h7g5FolderId, orderByComparator);

		if (h7g5Entry != null) {
			return h7g5Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("h7g5FolderId=");
		sb.append(h7g5FolderId);

		sb.append("}");

		throw new NoSuchH7G5EntryException(sb.toString());
	}

	/**
	 * Returns the first h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry fetchByH7G5FolderId_First(
		long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator) {

		List<H7G5Entry> list = findByH7G5FolderId(
			h7g5FolderId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry findByH7G5FolderId_Last(
			long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = fetchByH7G5FolderId_Last(
			h7g5FolderId, orderByComparator);

		if (h7g5Entry != null) {
			return h7g5Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("h7g5FolderId=");
		sb.append(h7g5FolderId);

		sb.append("}");

		throw new NoSuchH7G5EntryException(sb.toString());
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry fetchByH7G5FolderId_Last(
		long h7g5FolderId, OrderByComparator<H7G5Entry> orderByComparator) {

		int count = countByH7G5FolderId(h7g5FolderId);

		if (count == 0) {
			return null;
		}

		List<H7G5Entry> list = findByH7G5FolderId(
			h7g5FolderId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public H7G5Entry[] findByH7G5FolderId_PrevAndNext(
			long h7g5EntryId, long h7g5FolderId,
			OrderByComparator<H7G5Entry> orderByComparator)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = findByPrimaryKey(h7g5EntryId);

		Session session = null;

		try {
			session = openSession();

			H7G5Entry[] array = new H7G5EntryImpl[3];

			array[0] = getByH7G5FolderId_PrevAndNext(
				session, h7g5Entry, h7g5FolderId, orderByComparator, true);

			array[1] = h7g5Entry;

			array[2] = getByH7G5FolderId_PrevAndNext(
				session, h7g5Entry, h7g5FolderId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected H7G5Entry getByH7G5FolderId_PrevAndNext(
		Session session, H7G5Entry h7g5Entry, long h7g5FolderId,
		OrderByComparator<H7G5Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_H7G5ENTRY_WHERE);

		sb.append(_FINDER_COLUMN_H7G5FOLDERID_H7G5FOLDERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(H7G5EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(h7g5FolderId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(h7g5Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<H7G5Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the h7g5 entries where h7g5FolderId = &#63; from the database.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 */
	@Override
	public void removeByH7G5FolderId(long h7g5FolderId) {
		for (H7G5Entry h7g5Entry :
				findByH7G5FolderId(
					h7g5FolderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(h7g5Entry);
		}
	}

	/**
	 * Returns the number of h7g5 entries where h7g5FolderId = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @return the number of matching h7g5 entries
	 */
	@Override
	public int countByH7G5FolderId(long h7g5FolderId) {
		FinderPath finderPath = _finderPathCountByH7G5FolderId;

		Object[] finderArgs = new Object[] {h7g5FolderId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_H7G5ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H7G5FOLDERID_H7G5FOLDERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g5FolderId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_H7G5FOLDERID_H7G5FOLDERID_2 =
		"h7g5Entry.h7g5FolderId = ?";

	private FinderPath _finderPathFetchByKey;
	private FinderPath _finderPathCountByKey;

	/**
	 * Returns the h7g5 entry where key = &#63; or throws a <code>NoSuchH7G5EntryException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry findByKey(String key) throws NoSuchH7G5EntryException {
		H7G5Entry h7g5Entry = fetchByKey(key);

		if (h7g5Entry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("key=");
			sb.append(key);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchH7G5EntryException(sb.toString());
		}

		return h7g5Entry;
	}

	/**
	 * Returns the h7g5 entry where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry fetchByKey(String key) {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the h7g5 entry where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry fetchByKey(String key, boolean useFinderCache) {
		key = Objects.toString(key, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {key};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByKey, finderArgs);
		}

		if (result instanceof H7G5Entry) {
			H7G5Entry h7g5Entry = (H7G5Entry)result;

			if (!Objects.equals(key, h7g5Entry.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_H7G5ENTRY_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
				}

				List<H7G5Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByKey, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {key};
							}

							_log.warn(
								"H7G5EntryPersistenceImpl.fetchByKey(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					H7G5Entry h7g5Entry = list.get(0);

					result = h7g5Entry;

					cacheResult(h7g5Entry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (H7G5Entry)result;
		}
	}

	/**
	 * Removes the h7g5 entry where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the h7g5 entry that was removed
	 */
	@Override
	public H7G5Entry removeByKey(String key) throws NoSuchH7G5EntryException {
		H7G5Entry h7g5Entry = findByKey(key);

		return remove(h7g5Entry);
	}

	/**
	 * Returns the number of h7g5 entries where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching h7g5 entries
	 */
	@Override
	public int countByKey(String key) {
		key = Objects.toString(key, "");

		FinderPath finderPath = _finderPathCountByKey;

		Object[] finderArgs = new Object[] {key};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_H7G5ENTRY_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				sb.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				sb.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKey) {
					queryPos.add(key);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_KEY_KEY_2 = "h7g5Entry.key = ?";

	private static final String _FINDER_COLUMN_KEY_KEY_3 =
		"(h7g5Entry.key IS NULL OR h7g5Entry.key = '')";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the h7g5 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching h7g5 entries
	 */
	@Override
	public List<H7G5Entry> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<H7G5Entry> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
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
	@Override
	public List<H7G5Entry> findByName(
		String name, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
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
	@Override
	public List<H7G5Entry> findByName(
		String name, int start, int end,
		OrderByComparator<H7G5Entry> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<H7G5Entry> list = null;

		if (useFinderCache) {
			list = (List<H7G5Entry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (H7G5Entry h7g5Entry : list) {
					if (!name.equals(h7g5Entry.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_H7G5ENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(H7G5EntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<H7G5Entry>)QueryUtil.list(
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
	 * Returns the first h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry findByName_First(
			String name, OrderByComparator<H7G5Entry> orderByComparator)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = fetchByName_First(name, orderByComparator);

		if (h7g5Entry != null) {
			return h7g5Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchH7G5EntryException(sb.toString());
	}

	/**
	 * Returns the first h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry fetchByName_First(
		String name, OrderByComparator<H7G5Entry> orderByComparator) {

		List<H7G5Entry> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry findByName_Last(
			String name, OrderByComparator<H7G5Entry> orderByComparator)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = fetchByName_Last(name, orderByComparator);

		if (h7g5Entry != null) {
			return h7g5Entry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchH7G5EntryException(sb.toString());
	}

	/**
	 * Returns the last h7g5 entry in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry fetchByName_Last(
		String name, OrderByComparator<H7G5Entry> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<H7G5Entry> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public H7G5Entry[] findByName_PrevAndNext(
			long h7g5EntryId, String name,
			OrderByComparator<H7G5Entry> orderByComparator)
		throws NoSuchH7G5EntryException {

		name = Objects.toString(name, "");

		H7G5Entry h7g5Entry = findByPrimaryKey(h7g5EntryId);

		Session session = null;

		try {
			session = openSession();

			H7G5Entry[] array = new H7G5EntryImpl[3];

			array[0] = getByName_PrevAndNext(
				session, h7g5Entry, name, orderByComparator, true);

			array[1] = h7g5Entry;

			array[2] = getByName_PrevAndNext(
				session, h7g5Entry, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected H7G5Entry getByName_PrevAndNext(
		Session session, H7G5Entry h7g5Entry, String name,
		OrderByComparator<H7G5Entry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_H7G5ENTRY_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(H7G5EntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(h7g5Entry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<H7G5Entry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the h7g5 entries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (H7G5Entry h7g5Entry :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(h7g5Entry);
		}
	}

	/**
	 * Returns the number of h7g5 entries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching h7g5 entries
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_H7G5ENTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"h7g5Entry.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(h7g5Entry.name IS NULL OR h7g5Entry.name = '')";

	private FinderPath _finderPathFetchByH_D_N;
	private FinderPath _finderPathCountByH_D_N;

	/**
	 * Returns the h7g5 entry where h7g5FolderId = &#63; and description = &#63; and name = &#63; or throws a <code>NoSuchH7G5EntryException</code> if it could not be found.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g5 entry
	 * @throws NoSuchH7G5EntryException if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry findByH_D_N(
			long h7g5FolderId, String description, String name)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = fetchByH_D_N(h7g5FolderId, description, name);

		if (h7g5Entry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("h7g5FolderId=");
			sb.append(h7g5FolderId);

			sb.append(", description=");
			sb.append(description);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchH7G5EntryException(sb.toString());
		}

		return h7g5Entry;
	}

	/**
	 * Returns the h7g5 entry where h7g5FolderId = &#63; and description = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the matching h7g5 entry, or <code>null</code> if a matching h7g5 entry could not be found
	 */
	@Override
	public H7G5Entry fetchByH_D_N(
		long h7g5FolderId, String description, String name) {

		return fetchByH_D_N(h7g5FolderId, description, name, true);
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
	@Override
	public H7G5Entry fetchByH_D_N(
		long h7g5FolderId, String description, String name,
		boolean useFinderCache) {

		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {h7g5FolderId, description, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByH_D_N, finderArgs);
		}

		if (result instanceof H7G5Entry) {
			H7G5Entry h7g5Entry = (H7G5Entry)result;

			if ((h7g5FolderId != h7g5Entry.getH7g5FolderId()) ||
				!Objects.equals(description, h7g5Entry.getDescription()) ||
				!Objects.equals(name, h7g5Entry.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_H7G5ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H_D_N_H7G5FOLDERID_2);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_H_D_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g5FolderId);

				if (bindDescription) {
					queryPos.add(description);
				}

				if (bindName) {
					queryPos.add(name);
				}

				List<H7G5Entry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByH_D_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									h7g5FolderId, description, name
								};
							}

							_log.warn(
								"H7G5EntryPersistenceImpl.fetchByH_D_N(long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					H7G5Entry h7g5Entry = list.get(0);

					result = h7g5Entry;

					cacheResult(h7g5Entry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (H7G5Entry)result;
		}
	}

	/**
	 * Removes the h7g5 entry where h7g5FolderId = &#63; and description = &#63; and name = &#63; from the database.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the h7g5 entry that was removed
	 */
	@Override
	public H7G5Entry removeByH_D_N(
			long h7g5FolderId, String description, String name)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = findByH_D_N(h7g5FolderId, description, name);

		return remove(h7g5Entry);
	}

	/**
	 * Returns the number of h7g5 entries where h7g5FolderId = &#63; and description = &#63; and name = &#63;.
	 *
	 * @param h7g5FolderId the h7g5 folder ID
	 * @param description the description
	 * @param name the name
	 * @return the number of matching h7g5 entries
	 */
	@Override
	public int countByH_D_N(
		long h7g5FolderId, String description, String name) {

		description = Objects.toString(description, "");
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByH_D_N;

		Object[] finderArgs = new Object[] {h7g5FolderId, description, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_H7G5ENTRY_WHERE);

			sb.append(_FINDER_COLUMN_H_D_N_H7G5FOLDERID_2);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_H_D_N_DESCRIPTION_2);
			}

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_H_D_N_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_H_D_N_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(h7g5FolderId);

				if (bindDescription) {
					queryPos.add(description);
				}

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_H_D_N_H7G5FOLDERID_2 =
		"h7g5Entry.h7g5FolderId = ? AND ";

	private static final String _FINDER_COLUMN_H_D_N_DESCRIPTION_2 =
		"h7g5Entry.description = ? AND ";

	private static final String _FINDER_COLUMN_H_D_N_DESCRIPTION_3 =
		"(h7g5Entry.description IS NULL OR h7g5Entry.description = '') AND ";

	private static final String _FINDER_COLUMN_H_D_N_NAME_2 =
		"h7g5Entry.name = ?";

	private static final String _FINDER_COLUMN_H_D_N_NAME_3 =
		"(h7g5Entry.name IS NULL OR h7g5Entry.name = '')";

	public H7G5EntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(H7G5Entry.class);

		setModelImplClass(H7G5EntryImpl.class);
		setModelPKClass(long.class);

		setTable(H7G5EntryTable.INSTANCE);
	}

	/**
	 * Caches the h7g5 entry in the entity cache if it is enabled.
	 *
	 * @param h7g5Entry the h7g5 entry
	 */
	@Override
	public void cacheResult(H7G5Entry h7g5Entry) {
		entityCache.putResult(
			H7G5EntryImpl.class, h7g5Entry.getPrimaryKey(), h7g5Entry);

		finderCache.putResult(
			_finderPathFetchByKey, new Object[] {h7g5Entry.getKey()},
			h7g5Entry);

		finderCache.putResult(
			_finderPathFetchByH_D_N,
			new Object[] {
				h7g5Entry.getH7g5FolderId(), h7g5Entry.getDescription(),
				h7g5Entry.getName()
			},
			h7g5Entry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the h7g5 entries in the entity cache if it is enabled.
	 *
	 * @param h7g5Entries the h7g5 entries
	 */
	@Override
	public void cacheResult(List<H7G5Entry> h7g5Entries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (h7g5Entries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (H7G5Entry h7g5Entry : h7g5Entries) {
			if (entityCache.getResult(
					H7G5EntryImpl.class, h7g5Entry.getPrimaryKey()) == null) {

				cacheResult(h7g5Entry);
			}
		}
	}

	/**
	 * Clears the cache for all h7g5 entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(H7G5EntryImpl.class);

		finderCache.clearCache(H7G5EntryImpl.class);
	}

	/**
	 * Clears the cache for the h7g5 entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(H7G5Entry h7g5Entry) {
		entityCache.removeResult(H7G5EntryImpl.class, h7g5Entry);
	}

	@Override
	public void clearCache(List<H7G5Entry> h7g5Entries) {
		for (H7G5Entry h7g5Entry : h7g5Entries) {
			entityCache.removeResult(H7G5EntryImpl.class, h7g5Entry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(H7G5EntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(H7G5EntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		H7G5EntryModelImpl h7g5EntryModelImpl) {

		Object[] args = new Object[] {h7g5EntryModelImpl.getKey()};

		finderCache.putResult(_finderPathCountByKey, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByKey, args, h7g5EntryModelImpl);

		args = new Object[] {
			h7g5EntryModelImpl.getH7g5FolderId(),
			h7g5EntryModelImpl.getDescription(), h7g5EntryModelImpl.getName()
		};

		finderCache.putResult(_finderPathCountByH_D_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByH_D_N, args, h7g5EntryModelImpl);
	}

	/**
	 * Creates a new h7g5 entry with the primary key. Does not add the h7g5 entry to the database.
	 *
	 * @param h7g5EntryId the primary key for the new h7g5 entry
	 * @return the new h7g5 entry
	 */
	@Override
	public H7G5Entry create(long h7g5EntryId) {
		H7G5Entry h7g5Entry = new H7G5EntryImpl();

		h7g5Entry.setNew(true);
		h7g5Entry.setPrimaryKey(h7g5EntryId);

		h7g5Entry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return h7g5Entry;
	}

	/**
	 * Removes the h7g5 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry that was removed
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	@Override
	public H7G5Entry remove(long h7g5EntryId) throws NoSuchH7G5EntryException {
		return remove((Serializable)h7g5EntryId);
	}

	/**
	 * Removes the h7g5 entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the h7g5 entry
	 * @return the h7g5 entry that was removed
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	@Override
	public H7G5Entry remove(Serializable primaryKey)
		throws NoSuchH7G5EntryException {

		Session session = null;

		try {
			session = openSession();

			H7G5Entry h7g5Entry = (H7G5Entry)session.get(
				H7G5EntryImpl.class, primaryKey);

			if (h7g5Entry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchH7G5EntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(h7g5Entry);
		}
		catch (NoSuchH7G5EntryException noSuchEntityException) {
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
	protected H7G5Entry removeImpl(H7G5Entry h7g5Entry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(h7g5Entry)) {
				h7g5Entry = (H7G5Entry)session.get(
					H7G5EntryImpl.class, h7g5Entry.getPrimaryKeyObj());
			}

			if (h7g5Entry != null) {
				session.delete(h7g5Entry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (h7g5Entry != null) {
			clearCache(h7g5Entry);
		}

		return h7g5Entry;
	}

	@Override
	public H7G5Entry updateImpl(H7G5Entry h7g5Entry) {
		boolean isNew = h7g5Entry.isNew();

		if (!(h7g5Entry instanceof H7G5EntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(h7g5Entry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(h7g5Entry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in h7g5Entry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom H7G5Entry implementation " +
					h7g5Entry.getClass());
		}

		H7G5EntryModelImpl h7g5EntryModelImpl = (H7G5EntryModelImpl)h7g5Entry;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (h7g5Entry.getCreateDate() == null)) {
			if (serviceContext == null) {
				h7g5Entry.setCreateDate(date);
			}
			else {
				h7g5Entry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!h7g5EntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				h7g5Entry.setModifiedDate(date);
			}
			else {
				h7g5Entry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(h7g5Entry);
			}
			else {
				h7g5Entry = (H7G5Entry)session.merge(h7g5Entry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			H7G5EntryImpl.class, h7g5EntryModelImpl, false, true);

		cacheUniqueFindersCache(h7g5EntryModelImpl);

		if (isNew) {
			h7g5Entry.setNew(false);
		}

		h7g5Entry.resetOriginalValues();

		return h7g5Entry;
	}

	/**
	 * Returns the h7g5 entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the h7g5 entry
	 * @return the h7g5 entry
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	@Override
	public H7G5Entry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchH7G5EntryException {

		H7G5Entry h7g5Entry = fetchByPrimaryKey(primaryKey);

		if (h7g5Entry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchH7G5EntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return h7g5Entry;
	}

	/**
	 * Returns the h7g5 entry with the primary key or throws a <code>NoSuchH7G5EntryException</code> if it could not be found.
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry
	 * @throws NoSuchH7G5EntryException if a h7g5 entry with the primary key could not be found
	 */
	@Override
	public H7G5Entry findByPrimaryKey(long h7g5EntryId)
		throws NoSuchH7G5EntryException {

		return findByPrimaryKey((Serializable)h7g5EntryId);
	}

	/**
	 * Returns the h7g5 entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param h7g5EntryId the primary key of the h7g5 entry
	 * @return the h7g5 entry, or <code>null</code> if a h7g5 entry with the primary key could not be found
	 */
	@Override
	public H7G5Entry fetchByPrimaryKey(long h7g5EntryId) {
		return fetchByPrimaryKey((Serializable)h7g5EntryId);
	}

	/**
	 * Returns all the h7g5 entries.
	 *
	 * @return the h7g5 entries
	 */
	@Override
	public List<H7G5Entry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<H7G5Entry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<H7G5Entry> findAll(
		int start, int end, OrderByComparator<H7G5Entry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<H7G5Entry> findAll(
		int start, int end, OrderByComparator<H7G5Entry> orderByComparator,
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

		List<H7G5Entry> list = null;

		if (useFinderCache) {
			list = (List<H7G5Entry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_H7G5ENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_H7G5ENTRY;

				sql = sql.concat(H7G5EntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<H7G5Entry>)QueryUtil.list(
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
	 * Removes all the h7g5 entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (H7G5Entry h7g5Entry : findAll()) {
			remove(h7g5Entry);
		}
	}

	/**
	 * Returns the number of h7g5 entries.
	 *
	 * @return the number of h7g5 entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_H7G5ENTRY);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "h7g5EntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_H7G5ENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return H7G5EntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the h7g5 entry persistence.
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

		_finderPathWithPaginationFindByH7G5FolderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByH7G5FolderId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"h7g5FolderId"}, true);

		_finderPathWithoutPaginationFindByH7G5FolderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByH7G5FolderId",
			new String[] {Long.class.getName()}, new String[] {"h7g5FolderId"},
			true);

		_finderPathCountByH7G5FolderId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByH7G5FolderId",
			new String[] {Long.class.getName()}, new String[] {"h7g5FolderId"},
			false);

		_finderPathFetchByKey = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] {String.class.getName()}, new String[] {"key_"}, true);

		_finderPathCountByKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {String.class.getName()}, new String[] {"key_"},
			false);

		_finderPathWithPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathFetchByH_D_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByH_D_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"h7g5FolderId", "description", "name"}, true);

		_finderPathCountByH_D_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByH_D_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"h7g5FolderId", "description", "name"}, false);

		_setH7G5EntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setH7G5EntryUtilPersistence(null);

		entityCache.removeCache(H7G5EntryImpl.class.getName());
	}

	private void _setH7G5EntryUtilPersistence(
		H7G5EntryPersistence h7g5EntryPersistence) {

		try {
			Field field = H7G5EntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, h7g5EntryPersistence);
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

	private static final String _SQL_SELECT_H7G5ENTRY =
		"SELECT h7g5Entry FROM H7G5Entry h7g5Entry";

	private static final String _SQL_SELECT_H7G5ENTRY_WHERE =
		"SELECT h7g5Entry FROM H7G5Entry h7g5Entry WHERE ";

	private static final String _SQL_COUNT_H7G5ENTRY =
		"SELECT COUNT(h7g5Entry) FROM H7G5Entry h7g5Entry";

	private static final String _SQL_COUNT_H7G5ENTRY_WHERE =
		"SELECT COUNT(h7g5Entry) FROM H7G5Entry h7g5Entry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "h7g5Entry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No H7G5Entry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No H7G5Entry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		H7G5EntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private H7G5EntryModelArgumentsResolver _h7g5EntryModelArgumentsResolver;

}